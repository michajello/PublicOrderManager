package pl.edu.agh.tai.application.dto.client;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class SimplifiedOrderDto {

    @JsonProperty("zamowienia_publiczne.data_publikacji_zamowienia")
    private LocalDate dataPublikacjiZamowienia;
    @JsonProperty("zamowienia_publiczne.nazwa")
    private String nazwa;
    @JsonProperty("zamowienia_publiczne.termin")
    private String termin;
    @JsonProperty("zamowienia_publiczne_tryby.id")
    private String trybyId;
    @JsonProperty("zamowienia_publiczne_tryby.nazwa")
    private String trybyNazwa;
    @JsonProperty("zamowienia_publiczne_typy.id")
    private String typyId;
    @JsonProperty("zamowienia_publiczne_typy.nazwa")
    private String typyNazwa;
    @JsonProperty("zamowienia_publiczne_typy.symbol")
    private String typySymbol;
    @JsonProperty("zamowienia_publiczne.wartosc_cena_max")
    private Long wartoscCenaMax;
    @JsonProperty("zamowienia_publiczne.wartosc_cena_min")
    private Long wartoscCenaMin;
    @JsonProperty("zamowienia_publiczne.wartosc_szacowana")
    private Long wartoscSzacowana;

}
