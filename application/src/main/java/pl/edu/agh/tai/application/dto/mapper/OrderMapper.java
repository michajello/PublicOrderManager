package pl.edu.agh.tai.application.dto.mapper;

import pl.edu.agh.tai.application.dto.publicorder.OrderDTO;
import pl.edu.agh.tai.dbmodel.entity.Order;

public class OrderMapper extends Mapper<Order, OrderDTO> {

    @Override
    public OrderDTO mapToDTO(Order object) {
        return null;
    }

    @Override
    public Order mapToDAO(OrderDTO object) {
        return null;
    }
}
