
package pl.edu.agh.tai.application.dto.publicorder;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.annotation.Generated;

@Generated("net.hexar.json2pojo")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class Dataobject {

    @JsonProperty("data")
    private OrderDTO order;
    private String dataset;
    @JsonProperty("global_id")
    private String globalId;
    private String id;
    @JsonProperty("mp_url")
    private String mpUrl;
    @JsonProperty("schema_url")
    private String schemaUrl;
    private Object score;
    private String slug;
    private String url;

}
