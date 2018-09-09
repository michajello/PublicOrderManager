package pl.edu.agh.tai.application.service;

import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import pl.edu.agh.tai.application.dto.client.SimplifiedOrderDto;
import pl.edu.agh.tai.application.dto.mapper.mappingstruct.SimplifiedOrderMapper;
import pl.edu.agh.tai.dbmodel.entity.Order;
import pl.edu.agh.tai.dbmodel.repository.OrderRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final SimplifiedOrderMapper simplifiedOrderMapper = Mappers.getMapper(SimplifiedOrderMapper.class);


    @Autowired
    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }




    public List<SimplifiedOrderDto> getOrders(Integer page, Integer size) {
        List<Order> orders = orderRepository.findAll(PageRequest.of(page, size)).getContent();
        return orders.stream()
                .map(order -> simplifiedOrderMapper.orderToSimplifiedOrderDto(order))
                .collect(Collectors.toList());

    }

    public List<SimplifiedOrderDto> getOrders(Integer page, Integer size, LocalDate startDate, LocalDate finishDate) {
        QueryOrderExecutor queryOrderExecutor = new QueryOrderExecutor(orderRepository, page, size, startDate, finishDate);
        List<Order> orders = queryOrderExecutor.performQuery();
        return orders.stream()
                .map(order -> simplifiedOrderMapper.orderToSimplifiedOrderDto(order))
                .collect(Collectors.toList());
    }
}
