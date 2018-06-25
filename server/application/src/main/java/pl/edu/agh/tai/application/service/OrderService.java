package pl.edu.agh.tai.application.service;

import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import pl.edu.agh.tai.application.dto.client.SimplifiedOrderDto;
import pl.edu.agh.tai.application.dto.mapper.mappingstruct.SimplifiedOrderMapper;
import pl.edu.agh.tai.dbmodel.entity.Order;
import pl.edu.agh.tai.dbmodel.repository.OrderRepository;

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
        List<Order> orders = orderRepository.findAll(new PageRequest(page, size)).getContent();
        return orders.stream()
                .map(order -> simplifiedOrderMapper.orderToSimplifiedOrderDto(order))
                .collect(Collectors.toList());
    }
}
