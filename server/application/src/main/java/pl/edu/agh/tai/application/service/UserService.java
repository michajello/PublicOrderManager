package pl.edu.agh.tai.application.service;

import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import pl.edu.agh.tai.application.dto.client.order.SimplifiedOrderDto;
import pl.edu.agh.tai.application.dto.client.user.ObservingDTO;
import pl.edu.agh.tai.application.dto.client.user.UserCreationDTO;
import pl.edu.agh.tai.application.dto.client.user.UserDTO;
import pl.edu.agh.tai.application.dto.mapper.mappingstruct.SimplifiedOrderMapper;
import pl.edu.agh.tai.application.dto.mapper.mappingstruct.UserMapper;
import pl.edu.agh.tai.application.exception.MissingDataException;
import pl.edu.agh.tai.dbmodel.entity.Order;
import pl.edu.agh.tai.dbmodel.entity.User;
import pl.edu.agh.tai.dbmodel.repository.OrderRepository;
import pl.edu.agh.tai.dbmodel.repository.UserRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    private UserRepository userRepository;
    private UserMapper userMapper = UserMapper.INSTANCE;
    private SimplifiedOrderMapper orderMapper = Mappers.getMapper(SimplifiedOrderMapper.class);
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    private OrderRepository orderRepository;

    @Autowired
    public UserService(UserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder, OrderRepository orderRepository) {
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.orderRepository = orderRepository;
    }

    public List<UserDTO> getUsers() {
        return userRepository.findAll().stream()
            .map(userMapper::userToUserDTO)
            .collect(Collectors.toList());
    }

    public UserDTO getUser(long userId) {
        User user = findUser(userId);
        return userMapper.userToUserDTO(user);
    }

    public User createUser(UserCreationDTO userDTO) {
        userDTO.setPassword(bCryptPasswordEncoder.encode(userDTO.getPassword()));
        return userRepository.save(userMapper.userCreationDTOToUser(userDTO));
    }

    public void deleteUser(long userId) {
        User user = findUser(userId);
        userRepository.delete(user);
    }

    public UserDTO updateUser(long userId, UserDTO userDTO){
        User user = findUser(userId);
        user.update(userMapper.userDTOToUser(userDTO));
        return userMapper.userToUserDTO(userRepository.save(user));
    }

    public List<SimplifiedOrderDto> getObserving(long userId) {
        User user = findUser(userId);
        return user.getObserving().stream().
                map(orderMapper::orderToSimplifiedOrderDto).
                collect(Collectors.toList());
    }

    private User findUser(long userId) {
        return userRepository.findById(userId).orElseThrow(() -> new MissingDataException("No user with id" + userId));
    }

    public void updateObserving(long userId, ObservingDTO observingDTO) {
        User user = findUser(userId);
        System.out.println("finding " + observingDTO.getObserving().toString());
        List<Order> observing = observingDTO.getObserving().stream()
                .map(id -> orderRepository.findFirstByRestId(id))
                .collect(Collectors.toList());
        user.setObserving(observing);
        userRepository.save(user);
    }
}
