package pl.edu.agh.tai.application.service;

import org.springframework.data.domain.PageRequest;
import pl.edu.agh.tai.dbmodel.repository.OrderRepository;
import pl.edu.agh.tai.dbmodel.entity.Order;

import java.time.LocalDate;
import java.util.List;

public class QueryOrderExecutor {

    private final OrderRepository orderRepository;

    private final int page;
    private final int size;
    private final LocalDate startDate;
    private final LocalDate finishDate;


    public QueryOrderExecutor(OrderRepository orderRepository, int page, int size, LocalDate startDate, LocalDate finishDate) {
        this.orderRepository = orderRepository;
        this.page = page;
        this.size = size;
        this.startDate = startDate;
        this.finishDate = finishDate;
    }

    public List<Order> performQuery(){
        if (startDate == null && finishDate == null){
            return orderRepository.findAll(PageRequest.of(page, size)).getContent();
        }
        else if(startDate == null){
            return orderRepository.findByDataPublikacjiBefore(finishDate, PageRequest.of(page, size)).getContent();
        }else if(finishDate == null) {
            return orderRepository.findByDataPublikacjiAfter(startDate, PageRequest.of(page, size)).getContent();
        }
        return orderRepository.findByDataPublikacjiAfterAndDataPublikacjiBefore(startDate,finishDate, PageRequest.of(page, size)).getContent();
    }
}
