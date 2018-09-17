package pl.edu.agh.tai.application.dto.mapper.mappingstruct;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import pl.edu.agh.tai.application.dto.client.user.UserCreationDTO;
import pl.edu.agh.tai.application.dto.client.user.UserDTO;
import pl.edu.agh.tai.dbmodel.entity.Order;
import pl.edu.agh.tai.dbmodel.entity.User;
import pl.edu.agh.tai.dbmodel.repository.UserRepository;

import java.util.List;
import java.util.stream.Collectors;

@Mapper
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    UserDTO userToUserDTO(User user);

    User userCreationDTOToUser(UserCreationDTO userCreationDTO);

    default List<Long> observingToLongList(List<Order> observing) {
        return observing.stream().
            map(Order::getRestId).
            collect(Collectors.toList());
    }

}
