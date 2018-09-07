package pl.edu.agh.tai.application.dto.client;

import lombok.Data;
import lombok.NoArgsConstructor;
import pl.edu.agh.tai.dbmodel.entity.Order;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
public class UserDTO {

    private long id;
    private String login;
    private String email;
    private List<Order> observing = new ArrayList<>();

}