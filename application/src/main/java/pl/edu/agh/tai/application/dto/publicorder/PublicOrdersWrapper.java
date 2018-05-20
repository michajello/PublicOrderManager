
package pl.edu.agh.tai.application.dto.publicorder;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.annotation.Generated;
import java.util.List;

@Generated("net.hexar.json2pojo")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class PublicOrdersWrapper {

    @JsonProperty("Count")
    private Long count;
    @JsonProperty("Dataobject")
    private List<Dataobject> dataobject;
    @JsonProperty("Links")
    private Links links;
    @JsonProperty("Took")
    private Long took;

}
