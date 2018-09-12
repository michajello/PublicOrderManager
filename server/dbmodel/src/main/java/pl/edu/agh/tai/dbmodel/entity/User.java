package pl.edu.agh.tai.dbmodel.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "user_table")
public class User {

    @Id
    private long id;
    private String username;
    private String password;
    private String email;
    @ManyToMany
    @JoinTable(
        name = "observing",
        joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
        inverseJoinColumns = @JoinColumn(name = "order_id", referencedColumnName = "id")
    )
    private List<Order> observing = new ArrayList<>();

    public void update(User updated) {
        this.username = updated.username;
        this.email = updated.email;
    }

}
