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
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import pl.edu.agh.tai.application.dto.publicorder.PublicOrdersWrapper;
import pl.edu.agh.tai.application.util.ApiConstants;

import java.io.IOException;

@Component
public class ScheduledTasks {

    private static final Logger logger = LoggerFactory.getLogger(ScheduledTasks.class);

    private final MultiThreadedHttpConnectionManager httpConnectionManager;
    private final ObjectMapper objectMapper;

    @Autowired
    public ScheduledTasks(MultiThreadedHttpConnectionManager httpConnectionManager, ObjectMapper objectMapper) {
        this.httpConnectionManager = httpConnectionManager;
        this.objectMapper = objectMapper;
    }

    @Scheduled(fixedDelay = 5000)
    protected void downloadDataFromSejmometrServerAndUpdateDatabase() {
        logger.info("SEJMOMETR -  Init task -  downloading data .");

        HttpClient client = new HttpClient(httpConnectionManager);
        String res;
        GetMethod get = new GetMethod(ApiConstants.DATA_SERVER_ADDRESS);

        try {
            logger.info("SEJMOMETR -  Downloading data from server has been started.");

            int statusCode = client.executeMethod(get);

            if (statusCode != HttpStatus.SC_OK) {
                logger.error("Method failed: " + get.getStatusLine());
            } else {
                res = get.getResponseBodyAsString();
                PublicOrdersWrapper publicOrdersWrapper = objectMapper.readValue(res, PublicOrdersWrapper.class);
                System.out.println(publicOrdersWrapper);
            }

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
}
