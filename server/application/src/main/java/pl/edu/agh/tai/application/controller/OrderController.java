package pl.edu.agh.tai.application.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.edu.agh.tai.application.dto.client.SimplifiedOrderDto;
import pl.edu.agh.tai.application.service.OrderService;
import pl.edu.agh.tai.application.util.ApiConstants;

import java.time.LocalDate;
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
    public ResponseEntity<?> getOrders(@RequestParam(value = ApiConstants.PAGE_VAR) Integer page,
                                       @RequestParam(value = ApiConstants.SIZE_VAR) Integer size,
                                       @RequestParam(value = ApiConstants.START_DATE_VAR, required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
                                       @RequestParam(value = ApiConstants.FINISH_DATE_VAR, required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate finishDate,
                                       @RequestParam(value = ApiConstants.VOIVODESHIP_VAR, required = false) Integer voivodshipId,
                                       @RequestParam(value = ApiConstants.ORDER_MODE_VAR, required = false) Integer orderModeId,
                                       @RequestParam(value = ApiConstants.ORDER_TYPE_VAR, required = false) Integer orderTypeId,
                                       @RequestParam(value = ApiConstants.ORDER_KIND_VAR, required = false) Integer orderKindId,
                                       @RequestParam(value = ApiConstants.MIN_ESTIMATED_PRICE_VAR, required = false) Long minEstimatedPrice,
                                       @RequestParam(value = ApiConstants.MAX_ESTIMATED_PRICE_VAR, required = false) Long maxEstimatedPrice
                                       ){

        List<SimplifiedOrderDto> orders = orderService.getOrders(page > 0 ? page: ApiConstants.DEFAULT_ORDERS_PAGE_SIZE, size > 0 ? size : 20, startDate, finishDate,
                voivodshipId, orderModeId, orderTypeId, orderKindId, minEstimatedPrice, maxEstimatedPrice);
            return orders != null ? ResponseEntity.ok(orders):ResponseEntity.noContent().build();
    }

}
