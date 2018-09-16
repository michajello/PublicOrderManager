package pl.edu.agh.tai.application.dto.client.user;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
public class ObservingDTO {
    private List<Long> observing = new ArrayList<>();
}
