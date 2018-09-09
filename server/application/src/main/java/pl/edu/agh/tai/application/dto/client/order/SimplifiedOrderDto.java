package pl.edu.agh.tai.application.dto.client.order;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class SimplifiedOrderDto {

    @JsonProperty("id")
    private Long restId;
    @JsonProperty("data_publikacji_zamowienia")
    private LocalDate dataPublikacjiZamowienia;
    @JsonProperty("nazwa")
    private String nazwa;
    @JsonProperty("termin")
    private String termin;
    @JsonProperty("zamowienia_publiczne_tryby.nazwa")
    private String trybyNazwa;
    @JsonProperty("zamowienia_publiczne_typy.nazwa")
    private String typyNazwa;
    @JsonProperty("wartosc_cena_max")
    private Long wartoscCenaMax;
    @JsonProperty("wartosc_cena_min")
    private Long wartoscCenaMin;
    @JsonProperty("wartosc_szacowana")
    private Long wartoscSzacowana;
    @JsonProperty("rodzaje_nazwa")
    private String orderKind;

}
