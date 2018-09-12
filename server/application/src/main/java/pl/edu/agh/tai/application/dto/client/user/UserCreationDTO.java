package pl.edu.agh.tai.application.dto.client.user;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserCreationDTO {

    private String username;
    private String password;
    private String email;

}
