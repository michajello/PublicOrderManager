package pl.edu.agh.tai.dbmodel.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class User {

    @Id
    private long id;
    private String login;
    private String email;
    private List<Order> observing = new ArrayList<>();

}
