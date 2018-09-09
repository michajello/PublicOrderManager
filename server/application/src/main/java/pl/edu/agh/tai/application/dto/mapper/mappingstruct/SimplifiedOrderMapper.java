package pl.edu.agh.tai.application.dto.mapper.mappingstruct;

import org.mapstruct.Mapper;
import pl.edu.agh.tai.application.dto.client.order.SimplifiedOrderDto;
import pl.edu.agh.tai.dbmodel.entity.Order;
import pl.edu.agh.tai.dbmodel.entity.OrderKind;

@Mapper
public interface SimplifiedOrderMapper {

    default String map(OrderKind orderKind){
        return orderKind == null ? null:orderKind.getName();
    }

    SimplifiedOrderDto orderToSimplifiedOrderDto(Order order);
}
