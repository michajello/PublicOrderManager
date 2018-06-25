package pl.edu.agh.tai.application.dto.mapper.mappingstruct;

import org.mapstruct.Mapper;
import pl.edu.agh.tai.application.dto.client.SimplifiedOrderDto;
import pl.edu.agh.tai.dbmodel.entity.Order;

@Mapper
public interface SimplifiedOrderMapper {

    SimplifiedOrderDto orderToSimplifiedOrderDto(Order order);
}
