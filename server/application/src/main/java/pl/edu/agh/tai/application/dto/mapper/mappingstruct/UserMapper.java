package pl.edu.agh.tai.application.dto.mapper.mappingstruct;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import pl.edu.agh.tai.application.dto.client.user.UserCreationDTO;
import pl.edu.agh.tai.application.dto.client.user.UserDTO;
import pl.edu.agh.tai.dbmodel.entity.User;

@Mapper
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    UserDTO userToUserDTO(User user);

    User userDTOToUser(UserDTO userDTO);

    User userCreationDTOToUser(UserCreationDTO userCreationDTO);
}
