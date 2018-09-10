package pl.edu.agh.tai.application.schedule;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.MultiThreadedHttpConnectionManager;
import org.apache.commons.httpclient.methods.GetMethod;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.concurrent.ConcurrentTaskScheduler;
import org.springframework.stereotype.Component;
import pl.edu.agh.tai.application.dto.mapper.Mapper;
import pl.edu.agh.tai.dbmodel.entity.Order;

import pl.edu.agh.tai.application.dto.publicorder.Dataobject;
import pl.edu.agh.tai.application.dto.publicorder.OrderDTO;
import pl.edu.agh.tai.application.dto.publicorder.PublicOrdersWrapper;
import pl.edu.agh.tai.application.util.ApiConstants;
import pl.edu.agh.tai.dbmodel.repository.OrderRepository;
import pl.edu.agh.tai.dbmodel.util.HashComputator;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class ScheduledTasks {

    @Bean
    public TaskScheduler taskScheduler() {
        return new ConcurrentTaskScheduler(); //single threaded by default
    }

    private static final Logger logger = LoggerFactory.getLogger(ScheduledTasks.class);

    private final MultiThreadedHttpConnectionManager httpConnectionManager;
    private final ObjectMapper objectMapper;
    private final Mapper<Order, OrderDTO> orderMapper;
    private final OrderRepository orderRepository;
    private final HashComputator hashComputator;
    private final EntityManager entityManager;

    @Autowired
    public ScheduledTasks(MultiThreadedHttpConnectionManager httpConnectionManager, ObjectMapper objectMapper, Mapper<Order, OrderDTO> orderMapper,
                          HashComputator hashComputator, OrderRepository orderRepository, EntityManager entityManager) {
        this.httpConnectionManager = httpConnectionManager;
        this.objectMapper = objectMapper;
        this.orderMapper = orderMapper;
        this.hashComputator = hashComputator;
        this.orderRepository = orderRepository;
        this.entityManager = entityManager;
    }

//    @Scheduled(fixedDelay = 5000)
   @Scheduled(cron = "0 57 16 * * *")
    protected void downloadDataFromSejmometrServerAndUpdateDatabase() {
        logger.info("SEJMOMETR -  Init task -  downloading data .");

        HttpClient client = new HttpClient(httpConnectionManager);
        String res;
        GetMethod get = new GetMethod(ApiConstants.DATA_SERVER_ADDRESS);

        try {
            PublicOrdersWrapper publicOrdersWrapper;
            String nextAddress;
            logger.info("SEJMOMETR -  Downloading data from server has been started.");
            do {
                int statusCode = client.executeMethod(get);
                if (statusCode != HttpStatus.SC_OK) {
                    logger.error("Method failed: " + get.getStatusLine());
                    break;
                } else {
                    res = get.getResponseBodyAsString();
                    publicOrdersWrapper = objectMapper.readValue(res, PublicOrdersWrapper.class);
                    System.out.println(publicOrdersWrapper);
                    persistObjectToDb(publicOrdersWrapper);
                }
                nextAddress = publicOrdersWrapper.getLinks().getNext();
                logger.debug("Next link is = " + nextAddress);

                get = new GetMethod(nextAddress);
            } while (nextAddress != null);


        } catch (HttpException e) {
            logger.error("Fatal protocol violation: " + e.getMessage());
            e.printStackTrace();
        } catch (IOException e) {
            logger.error(e.getMessage());
            e.printStackTrace();
        } finally {
            get.releaseConnection();
            logger.info("SEJMOMETR -  Finished downloading data.");

        }
    }

    //    @Transactional
    private void persistObjectToDb(PublicOrdersWrapper publicOrdersWrapper) {
        List<Dataobject> dataobjects = publicOrdersWrapper.getDataobject();
        List<Order> orders = new ArrayList<>(dataobjects.size());
        for (Dataobject dato : dataobjects) {
            OrderDTO orderDTO = dato.getOrder();
            Order order = orderRepository.findFirstByRestId(Long.parseLong(orderDTO.getZamowieniaPubliczneId()));

            //If order actually does not exist in database
            if (order == null) {
                try {
                    order = orderMapper.mapToDAO(dato.getOrder());

                } catch (Exception e) {
                    logger.error("Problem with: " + dato.toString() + "\n" + e.toString());
                    e.printStackTrace();
                }
            } else {
                orderMapper.mapToPersistedDAO(order, orderDTO);
                //TODO notify users who observe order that order has been modified

            }
            orders.add(order);
//            orderRepository.save(order);

        }
        orderRepository.saveAll(orders);


//        orderRepository.saveAll(orders);

//        entityManager.flush();
//        orderRepository.flush();
    }
}
