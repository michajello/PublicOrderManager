
package pl.edu.agh.tai.application.dto.publicorder;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.annotation.Generated;
import java.util.Objects;

@Generated("net.hexar.json2pojo")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString

public class OrderDTO {

    @JsonProperty("zamowienia_publiczne.akcept")
    private String zamowieniaPubliczneAkcept;
    @JsonProperty("zamowienia_publiczne.aukcja")
    private String zamowieniaPubliczneAukcja;
    @JsonProperty("zamowienia_publiczne.czas")
    private String zamowieniaPubliczneCzas;
    @JsonProperty("zamowienia_publiczne.data_publikacji")
    private String zamowieniaPubliczneDataPublikacji;
    @JsonProperty("zamowienia_publiczne.data_publikacji_zamowienia")
    private String zamowieniaPubliczneDataPublikacjiZamowienia;
    @JsonProperty("zamowienia_publiczne.data_stop")
    private String zamowieniaPubliczneDataStop;
    @JsonProperty("zamowienia_publiczne.dialog")
    private String zamowieniaPubliczneDialog;
    @JsonProperty("zamowienia_publiczne.dsz_www")
    private String zamowieniaPubliczneDszWww;
    @JsonProperty("zamowienia_publiczne.dyn_www")
    private String zamowieniaPubliczneDynWww;
    @JsonProperty("zamowienia_publiczne.gmina_id")
    private String zamowieniaPubliczneGminaId;
    @JsonProperty("zamowienia_publiczne.id")
    private String zamowieniaPubliczneId;
    @JsonProperty("zamowienia_publiczne.instytucja_id")
    private String zamowieniaPubliczneInstytucjaId;
    @JsonProperty("zamowienia_publiczne.kod_pocztowy_id")
    private String zamowieniaPubliczneKodPocztowyId;
    @JsonProperty("zamowienia_publiczne.kryterium_kod")
    private String zamowieniaPubliczneKryteriumKod;
    @JsonProperty("zamowienia_publiczne.liczba_czesci")
    private String zamowieniaPubliczneLiczbaCzesci;
    @JsonProperty("zamowienia_publiczne.liczba_dni")
    private String zamowieniaPubliczneLiczbaDni;
    @JsonProperty("zamowienia_publiczne.liczba_dni_oferty")
    private String zamowieniaPubliczneLiczbaDniOferty;
    @JsonProperty("zamowienia_publiczne.liczba_miesiecy")
    private String zamowieniaPubliczneLiczbaMiesiecy;
    @JsonProperty("zamowienia_publiczne.liczba_wykonawcow")
    private String zamowieniaPubliczneLiczbaWykonawcow;
    @JsonProperty("zamowienia_publiczne.nazwa")
    private String zamowieniaPubliczneNazwa;
    @JsonProperty("zamowienia_publiczne.numer_biuletynu")
    private String zamowieniaPubliczneNumerBiuletynu;
    @JsonProperty("zamowienia_publiczne.numer_zamowienia")
    private String zamowieniaPubliczneNumerZamowienia;
    @JsonProperty("zamowienia_publiczne.oferty_czesciowe")
    private String zamowieniaPubliczneOfertyCzesciowe;
    @JsonProperty("zamowienia_publiczne.oferty_godz")
    private String zamowieniaPubliczneOfertyGodz;
    @JsonProperty("zamowienia_publiczne.ogloszenie_bzp")
    private String zamowieniaPubliczneOgloszenieBzp;
    @JsonProperty("zamowienia_publiczne.powiat_id")
    private String zamowieniaPublicznePowiatId;
    @JsonProperty("zamowienia_publiczne.pozycja")
    private String zamowieniaPublicznePozycja;
    @JsonProperty("zamowienia_publiczne.projekt_ue")
    private String zamowieniaPubliczneProjektUe;
    @JsonProperty("zamowienia_publiczne.przedmiot")
    private String zamowieniaPublicznePrzedmiot;
    @JsonProperty("zamowienia_publiczne.publikacja_obowiazkowa")
    private String zamowieniaPublicznePublikacjaObowiazkowa;
    @JsonProperty("zamowienia_publiczne.rodzaj_id")
    private String zamowieniaPubliczneRodzajId;
    @JsonProperty("zamowienia_publiczne_rodzaje.id")
    private String zamowieniaPubliczneRodzajeId;
    @JsonProperty("zamowienia_publiczne_rodzaje.nazwa")
    private String zamowieniaPubliczneRodzajeNazwa;
    @JsonProperty("zamowienia_publiczne.sprawozdanie_calosc")
    private String zamowieniaPubliczneSprawozdanieCalosc;
    @JsonProperty("zamowienia_publiczne.sprawozdanie_lata_obrotowe")
    private String zamowieniaPubliczneSprawozdanieLataObrotowe;
    @JsonProperty("zamowienia_publiczne.status_id")
    private String zamowieniaPubliczneStatusId;
    @JsonProperty("zamowienia_publiczne.termin")
    private String zamowieniaPubliczneTermin;
    @JsonProperty("zamowienia_publiczne.tryb_id")
    private String zamowieniaPubliczneTrybId;
    @JsonProperty("zamowienia_publiczne_tryby.id")
    private String zamowieniaPubliczneTrybyId;
    @JsonProperty("zamowienia_publiczne_tryby.nazwa")
    private String zamowieniaPubliczneTrybyNazwa;
    @JsonProperty("zamowienia_publiczne.typ_id")
    private String zamowieniaPubliczneTypId;
    @JsonProperty("zamowienia_publiczne_typy.id")
    private String zamowieniaPubliczneTypyId;
    @JsonProperty("zamowienia_publiczne_typy.nazwa")
    private String zamowieniaPubliczneTypyNazwa;
    @JsonProperty("zamowienia_publiczne_typy.symbol")
    private String zamowieniaPubliczneTypySymbol;
    @JsonProperty("zamowienia_publiczne.uniewaznienie")
    private String zamowieniaPubliczneUniewaznienie;
    @JsonProperty("zamowienia_publiczne.uzupelniajace")
    private String zamowieniaPubliczneUzupelniajace;
    @JsonProperty("zamowienia_publiczne.wariant")
    private String zamowieniaPubliczneWariant;
    @JsonProperty("zamowienia_publiczne.wartosc_cena")
    private String zamowieniaPubliczneWartoscCena;
    @JsonProperty("zamowienia_publiczne.wartosc_cena_max")
    private String zamowieniaPubliczneWartoscCenaMax;
    @JsonProperty("zamowienia_publiczne.wartosc_cena_min")
    private String zamowieniaPubliczneWartoscCenaMin;
    @JsonProperty("zamowienia_publiczne.wartosc_szacowana")
    private String zamowieniaPubliczneWartoscSzacowana;
    @JsonProperty("zamowienia_publiczne.wartosc_szacunkowa")
    private String zamowieniaPubliczneWartoscSzacunkowa;
    @JsonProperty("zamowienia_publiczne.wojewodztwo_id")
    private String zamowieniaPubliczneWojewodztwoId;
    @JsonProperty("zamowienia_publiczne.wykonawca_str")
    private String zamowieniaPubliczneWykonawcaStr;
    @JsonProperty("zamowienia_publiczne.zaliczka")
    private String zamowieniaPubliczneZaliczka;
    @JsonProperty("zamowienia_publiczne.zamawiajacy_email")
    private String zamowieniaPubliczneZamawiajacyEmail;
    @JsonProperty("zamowienia_publiczne.zamawiajacy_fax")
    private String zamowieniaPubliczneZamawiajacyFax;
    @JsonProperty("zamowienia_publiczne.zamawiajacy_id")
    private String zamowieniaPubliczneZamawiajacyId;
    @JsonProperty("zamowienia_publiczne.zamawiajacy_kod_poczt")
    private String zamowieniaPubliczneZamawiajacyKodPoczt;
    @JsonProperty("zamowienia_publiczne_zamawiajacy.kod_pocztowy_id")
    private String zamowieniaPubliczneZamawiajacyKodPocztowyId;
    @JsonProperty("zamowienia_publiczne.zamawiajacy_miejscowosc")
    private String zamowieniaPubliczneZamawiajacyMiejscowosc;
    @JsonProperty("zamowienia_publiczne.zamawiajacy_nazwa")
    private String zamowieniaPubliczneZamawiajacyNazwa;
    @JsonProperty("zamowienia_publiczne.zamawiajacy_nr_domu")
    private String zamowieniaPubliczneZamawiajacyNrDomu;
    @JsonProperty("zamowienia_publiczne.zamawiajacy_nr_miesz")
    private String zamowieniaPubliczneZamawiajacyNrMiesz;
    @JsonProperty("zamowienia_publiczne.zamawiajacy_regon")
    private String zamowieniaPubliczneZamawiajacyRegon;
    @JsonProperty("zamowienia_publiczne.zamawiajacy_rodzaj")
    private String zamowieniaPubliczneZamawiajacyRodzaj;
    @JsonProperty("zamowienia_publiczne.zamawiajacy_rodzaj_inny")
    private String zamowieniaPubliczneZamawiajacyRodzajInny;
    @JsonProperty("zamowienia_publiczne.zamawiajacy_tel")
    private String zamowieniaPubliczneZamawiajacyTel;
    @JsonProperty("zamowienia_publiczne.zamawiajacy_ulica")
    private String zamowieniaPubliczneZamawiajacyUlica;
    @JsonProperty("zamowienia_publiczne.zamawiajacy_wojewodztwo")
    private String zamowieniaPubliczneZamawiajacyWojewodztwo;
    @JsonProperty("zamowienia_publiczne.zamawiajacy_www")
    private String zamowieniaPubliczneZamawiajacyWww;
    @JsonProperty("zamowienia_publiczne.zamowienie_ue")
    private String zamowieniaPubliczneZamowienieUe;
    @JsonProperty("zamowienia_publiczne.zmiana_ogloszenia")
    private String zamowieniaPubliczneZmianaOgloszenia;
    @JsonProperty("zamowienia_publiczne.zmiana_umowy")
    private String zamowieniaPubliczneZmianaUmowy;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof OrderDTO)) return false;
        OrderDTO orderDTO = (OrderDTO) o;
        return Objects.equals(getZamowieniaPubliczneAkcept(), orderDTO.getZamowieniaPubliczneAkcept()) &&
                Objects.equals(getZamowieniaPubliczneAukcja(), orderDTO.getZamowieniaPubliczneAukcja()) &&
                Objects.equals(getZamowieniaPubliczneCzas(), orderDTO.getZamowieniaPubliczneCzas()) &&
                Objects.equals(getZamowieniaPubliczneDataPublikacji(), orderDTO.getZamowieniaPubliczneDataPublikacji()) &&
                Objects.equals(getZamowieniaPubliczneDataPublikacjiZamowienia(), orderDTO.getZamowieniaPubliczneDataPublikacjiZamowienia()) &&
                Objects.equals(getZamowieniaPubliczneDataStop(), orderDTO.getZamowieniaPubliczneDataStop()) &&
                Objects.equals(getZamowieniaPubliczneDialog(), orderDTO.getZamowieniaPubliczneDialog()) &&
                Objects.equals(getZamowieniaPubliczneDszWww(), orderDTO.getZamowieniaPubliczneDszWww()) &&
                Objects.equals(getZamowieniaPubliczneDynWww(), orderDTO.getZamowieniaPubliczneDynWww()) &&
                Objects.equals(getZamowieniaPubliczneGminaId(), orderDTO.getZamowieniaPubliczneGminaId()) &&
                Objects.equals(getZamowieniaPubliczneId(), orderDTO.getZamowieniaPubliczneId()) &&
                Objects.equals(getZamowieniaPubliczneInstytucjaId(), orderDTO.getZamowieniaPubliczneInstytucjaId()) &&
                Objects.equals(getZamowieniaPubliczneKodPocztowyId(), orderDTO.getZamowieniaPubliczneKodPocztowyId()) &&
                Objects.equals(getZamowieniaPubliczneKryteriumKod(), orderDTO.getZamowieniaPubliczneKryteriumKod()) &&
                Objects.equals(getZamowieniaPubliczneLiczbaCzesci(), orderDTO.getZamowieniaPubliczneLiczbaCzesci()) &&
                Objects.equals(getZamowieniaPubliczneLiczbaDni(), orderDTO.getZamowieniaPubliczneLiczbaDni()) &&
                Objects.equals(getZamowieniaPubliczneLiczbaDniOferty(), orderDTO.getZamowieniaPubliczneLiczbaDniOferty()) &&
                Objects.equals(getZamowieniaPubliczneLiczbaMiesiecy(), orderDTO.getZamowieniaPubliczneLiczbaMiesiecy()) &&
                Objects.equals(getZamowieniaPubliczneLiczbaWykonawcow(), orderDTO.getZamowieniaPubliczneLiczbaWykonawcow()) &&
                Objects.equals(getZamowieniaPubliczneNazwa(), orderDTO.getZamowieniaPubliczneNazwa()) &&
                Objects.equals(getZamowieniaPubliczneNumerBiuletynu(), orderDTO.getZamowieniaPubliczneNumerBiuletynu()) &&
                Objects.equals(getZamowieniaPubliczneNumerZamowienia(), orderDTO.getZamowieniaPubliczneNumerZamowienia()) &&
                Objects.equals(getZamowieniaPubliczneOfertyCzesciowe(), orderDTO.getZamowieniaPubliczneOfertyCzesciowe()) &&
                Objects.equals(getZamowieniaPubliczneOfertyGodz(), orderDTO.getZamowieniaPubliczneOfertyGodz()) &&
                Objects.equals(getZamowieniaPubliczneOgloszenieBzp(), orderDTO.getZamowieniaPubliczneOgloszenieBzp()) &&
                Objects.equals(getZamowieniaPublicznePowiatId(), orderDTO.getZamowieniaPublicznePowiatId()) &&
                Objects.equals(getZamowieniaPublicznePozycja(), orderDTO.getZamowieniaPublicznePozycja()) &&
                Objects.equals(getZamowieniaPubliczneProjektUe(), orderDTO.getZamowieniaPubliczneProjektUe()) &&
                Objects.equals(getZamowieniaPublicznePrzedmiot(), orderDTO.getZamowieniaPublicznePrzedmiot()) &&
                Objects.equals(getZamowieniaPublicznePublikacjaObowiazkowa(), orderDTO.getZamowieniaPublicznePublikacjaObowiazkowa()) &&
                Objects.equals(getZamowieniaPubliczneRodzajId(), orderDTO.getZamowieniaPubliczneRodzajId()) &&
                Objects.equals(getZamowieniaPubliczneRodzajeId(), orderDTO.getZamowieniaPubliczneRodzajeId()) &&
                Objects.equals(getZamowieniaPubliczneRodzajeNazwa(), orderDTO.getZamowieniaPubliczneRodzajeNazwa()) &&
                Objects.equals(getZamowieniaPubliczneSprawozdanieCalosc(), orderDTO.getZamowieniaPubliczneSprawozdanieCalosc()) &&
                Objects.equals(getZamowieniaPubliczneSprawozdanieLataObrotowe(), orderDTO.getZamowieniaPubliczneSprawozdanieLataObrotowe()) &&
                Objects.equals(getZamowieniaPubliczneStatusId(), orderDTO.getZamowieniaPubliczneStatusId()) &&
                Objects.equals(getZamowieniaPubliczneTermin(), orderDTO.getZamowieniaPubliczneTermin()) &&
                Objects.equals(getZamowieniaPubliczneTrybId(), orderDTO.getZamowieniaPubliczneTrybId()) &&
                Objects.equals(getZamowieniaPubliczneTrybyId(), orderDTO.getZamowieniaPubliczneTrybyId()) &&
                Objects.equals(getZamowieniaPubliczneTrybyNazwa(), orderDTO.getZamowieniaPubliczneTrybyNazwa()) &&
                Objects.equals(getZamowieniaPubliczneTypId(), orderDTO.getZamowieniaPubliczneTypId()) &&
                Objects.equals(getZamowieniaPubliczneTypyId(), orderDTO.getZamowieniaPubliczneTypyId()) &&
                Objects.equals(getZamowieniaPubliczneTypyNazwa(), orderDTO.getZamowieniaPubliczneTypyNazwa()) &&
                Objects.equals(getZamowieniaPubliczneTypySymbol(), orderDTO.getZamowieniaPubliczneTypySymbol()) &&
                Objects.equals(getZamowieniaPubliczneUniewaznienie(), orderDTO.getZamowieniaPubliczneUniewaznienie()) &&
                Objects.equals(getZamowieniaPubliczneUzupelniajace(), orderDTO.getZamowieniaPubliczneUzupelniajace()) &&
                Objects.equals(getZamowieniaPubliczneWariant(), orderDTO.getZamowieniaPubliczneWariant()) &&
                Objects.equals(getZamowieniaPubliczneWartoscCena(), orderDTO.getZamowieniaPubliczneWartoscCena()) &&
                Objects.equals(getZamowieniaPubliczneWartoscCenaMax(), orderDTO.getZamowieniaPubliczneWartoscCenaMax()) &&
                Objects.equals(getZamowieniaPubliczneWartoscCenaMin(), orderDTO.getZamowieniaPubliczneWartoscCenaMin()) &&
                Objects.equals(getZamowieniaPubliczneWartoscSzacowana(), orderDTO.getZamowieniaPubliczneWartoscSzacowana()) &&
                Objects.equals(getZamowieniaPubliczneWartoscSzacunkowa(), orderDTO.getZamowieniaPubliczneWartoscSzacunkowa()) &&
                Objects.equals(getZamowieniaPubliczneWojewodztwoId(), orderDTO.getZamowieniaPubliczneWojewodztwoId()) &&
                Objects.equals(getZamowieniaPubliczneWykonawcaStr(), orderDTO.getZamowieniaPubliczneWykonawcaStr()) &&
                Objects.equals(getZamowieniaPubliczneZaliczka(), orderDTO.getZamowieniaPubliczneZaliczka()) &&
                Objects.equals(getZamowieniaPubliczneZamawiajacyEmail(), orderDTO.getZamowieniaPubliczneZamawiajacyEmail()) &&
                Objects.equals(getZamowieniaPubliczneZamawiajacyFax(), orderDTO.getZamowieniaPubliczneZamawiajacyFax()) &&
                Objects.equals(getZamowieniaPubliczneZamawiajacyId(), orderDTO.getZamowieniaPubliczneZamawiajacyId()) &&
                Objects.equals(getZamowieniaPubliczneZamawiajacyKodPoczt(), orderDTO.getZamowieniaPubliczneZamawiajacyKodPoczt()) &&
                Objects.equals(getZamowieniaPubliczneZamawiajacyKodPocztowyId(), orderDTO.getZamowieniaPubliczneZamawiajacyKodPocztowyId()) &&
                Objects.equals(getZamowieniaPubliczneZamawiajacyMiejscowosc(), orderDTO.getZamowieniaPubliczneZamawiajacyMiejscowosc()) &&
                Objects.equals(getZamowieniaPubliczneZamawiajacyNazwa(), orderDTO.getZamowieniaPubliczneZamawiajacyNazwa()) &&
                Objects.equals(getZamowieniaPubliczneZamawiajacyNrDomu(), orderDTO.getZamowieniaPubliczneZamawiajacyNrDomu()) &&
                Objects.equals(getZamowieniaPubliczneZamawiajacyNrMiesz(), orderDTO.getZamowieniaPubliczneZamawiajacyNrMiesz()) &&
                Objects.equals(getZamowieniaPubliczneZamawiajacyRegon(), orderDTO.getZamowieniaPubliczneZamawiajacyRegon()) &&
                Objects.equals(getZamowieniaPubliczneZamawiajacyRodzaj(), orderDTO.getZamowieniaPubliczneZamawiajacyRodzaj()) &&
                Objects.equals(getZamowieniaPubliczneZamawiajacyRodzajInny(), orderDTO.getZamowieniaPubliczneZamawiajacyRodzajInny()) &&
                Objects.equals(getZamowieniaPubliczneZamawiajacyTel(), orderDTO.getZamowieniaPubliczneZamawiajacyTel()) &&
                Objects.equals(getZamowieniaPubliczneZamawiajacyUlica(), orderDTO.getZamowieniaPubliczneZamawiajacyUlica()) &&
                Objects.equals(getZamowieniaPubliczneZamawiajacyWojewodztwo(), orderDTO.getZamowieniaPubliczneZamawiajacyWojewodztwo()) &&
                Objects.equals(getZamowieniaPubliczneZamawiajacyWww(), orderDTO.getZamowieniaPubliczneZamawiajacyWww()) &&
                Objects.equals(getZamowieniaPubliczneZamowienieUe(), orderDTO.getZamowieniaPubliczneZamowienieUe()) &&
                Objects.equals(getZamowieniaPubliczneZmianaOgloszenia(), orderDTO.getZamowieniaPubliczneZmianaOgloszenia()) &&
                Objects.equals(getZamowieniaPubliczneZmianaUmowy(), orderDTO.getZamowieniaPubliczneZmianaUmowy());
    }

}
