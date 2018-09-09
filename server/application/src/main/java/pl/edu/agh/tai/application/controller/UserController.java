package pl.edu.agh.tai.application.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.edu.agh.tai.application.dto.client.user.UserCreationDTO;
import pl.edu.agh.tai.application.dto.client.user.UserDTO;
import pl.edu.agh.tai.application.service.UserService;
import pl.edu.agh.tai.application.util.ApiConstants;
import pl.edu.agh.tai.dbmodel.entity.User;

import java.util.List;

@RestController
@RequestMapping(ApiConstants.USERS)
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<?> getUsers() {
        List<UserDTO> users = userService.getUsers();
        return ResponseEntity.ok(users);
    }

    @PostMapping
    public ResponseEntity<?> createUser(@RequestBody UserCreationDTO userDTO) {
        User user = userService.createUser(userDTO);
        long userId = user.getId();
        return ResponseEntity.ok(userId);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<?> getUser(@PathVariable long userId){
        return ResponseEntity.ok(userService.getUser(userId));
    }

    @PutMapping("/{userId}")
    public ResponseEntity<?> updateUser(@PathVariable long userId, @RequestBody UserDTO userDTO) {
        return ResponseEntity.ok(userService.updateUser(userDTO));
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<?> deleteUser(@PathVariable long userId) {
        userService.deleteUser(userId);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{userId}/observing")
    public ResponseEntity<?> getObserving(@PathVariable long userId) {
        return ResponseEntity.ok(userService.getObserving(userId));
    }


}
