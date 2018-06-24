package pl.edu.agh.tai.application.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.edu.agh.tai.application.service.OrderService;
import pl.edu.agh.tai.application.util.ApiConstants;
import pl.edu.agh.tai.dbmodel.repository.OrderRepository;

import java.io.IOException;

@RestController
public class OrderController {

    private final OrderRepository orderRepository;
    private final OrderService orderService;

    @Autowired
    public OrderController(OrderRepository orderRepository, OrderService orderService) {
        this.orderRepository = orderRepository;
        this.orderService = orderService;
    }


    @GetMapping(ApiConstants.ORDERS_PAGE_SIZE)
    public ResponseEntity<?> getOrders(@RequestParam(value = ApiConstants.PAGE_VAR) Integer page, @RequestParam(value = ApiConstants.SIZE_VAR) Integer size){

        return new ResponseEntity<>(orderService.getOrders(page, size), HttpStatus.OK);
    }

}
