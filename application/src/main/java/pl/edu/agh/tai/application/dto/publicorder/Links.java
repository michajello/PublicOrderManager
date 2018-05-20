
package pl.edu.agh.tai.application.dto.publicorder;

import lombok.*;

import javax.annotation.Generated;

@Generated("net.hexar.json2pojo")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@SuppressWarnings("unused")
public class Links {

    private String first;
    private String prev;
    private String self;

    public String getFirst() {
        return first;
    }

    public void setFirst(String first) {
        this.first = first;
    }

    public String getPrev() {
        return prev;
    }

    public void setPrev(String prev) {
        this.prev = prev;
    }

    public String getSelf() {
        return self;
    }

    public void setSelf(String self) {
        this.self = self;
    }

}
