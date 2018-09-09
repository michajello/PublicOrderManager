package pl.edu.agh.tai.application.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.edu.agh.tai.application.dto.client.order.SimplifiedOrderDto;
import pl.edu.agh.tai.application.service.OrderService;
import pl.edu.agh.tai.application.util.ApiConstants;

import java.util.List;

@RestController
public class OrderController {

    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }


    @CrossOrigin("*")
    @GetMapping(ApiConstants.ORDERS)
    public ResponseEntity<?> getOrders(@RequestParam(value = ApiConstants.PAGE_VAR) Integer page, @RequestParam(value = ApiConstants.SIZE_VAR) Integer size){
        List<SimplifiedOrderDto> orders = orderService.getOrders(page, size);
        return orders != null ? ResponseEntity.ok(orders):ResponseEntity.noContent().build();
    }

}
