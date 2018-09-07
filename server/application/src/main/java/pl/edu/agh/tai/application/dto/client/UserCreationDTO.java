package pl.edu.agh.tai.application.dto.client;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserCreationDTO {

    private String name;
    private String email;

}
