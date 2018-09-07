package pl.edu.agh.tai.application.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.edu.agh.tai.application.dto.client.UserCreationDTO;
import pl.edu.agh.tai.application.dto.client.UserDTO;
import pl.edu.agh.tai.application.dto.mapper.mappingstruct.UserMapper;
import pl.edu.agh.tai.application.exception.MissingDataException;
import pl.edu.agh.tai.dbmodel.entity.User;
import pl.edu.agh.tai.dbmodel.repository.UserRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    private UserRepository userRepository;
    private UserMapper mapper = UserMapper.INSTANCE;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<UserDTO> getUsers() {
        return userRepository.findAll().stream()
            .map(mapper::userToUserDTO)
            .collect(Collectors.toList());
    }

    public UserDTO getUser(long userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new MissingDataException("No user with id" + userId));
        return mapper.userToUserDTO(user);
    }

    public User createUser(UserCreationDTO userDTO) {
        return userRepository.save(mapper.userCreationDTOToUser(userDTO));
    }

    public void deleteUser(long userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new MissingDataException("No user with id" + userId));
        userRepository.delete(user);
    }
}
