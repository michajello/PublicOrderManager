package pl.edu.agh.tai.dbmodel.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;
import org.hibernate.annotations.*;
import pl.edu.agh.tai.dbmodel.util.Hashable;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Index;
import javax.persistence.Table;
import java.time.LocalDate;

@Builder(builderMethodName = "innerBuilder")
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Getter
@Setter
@DynamicUpdate
@DynamicInsert
@Table(name = "order_table", indexes = {@Index(columnList = "order_id_from_rest_server", name="rest_id_idx")})
public class Order implements Hashable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "order_id_from_rest_server")
    private Long restId;

    @JsonManagedReference
    @ManyToOne(optional = false, fetch = FetchType.LAZY)/*(cascade = {CascadeType.PERSIST})*/
    @JoinColumn(name = "orderer_id")
    private Orderer orderer;

    @Column(name = "akcept")
    private Boolean akcept;
    @Column(name = "aukcja")
    private Boolean aukcja;
    @Column(name = "czas")
    private LocalDate czas;
    @Column(name = "data_publikacji")
    private LocalDate dataPublikacji;
    @Column(name = "data_publikacji_zamowienia")
    private LocalDate dataPublikacjiZamowienia;
    @Column(name = "data_stop")
    private LocalDate dataStop;
    @Column(name = "dialog")
    private Boolean dialog;
    @Column(name = "dsz_www")
    private String dszWww;
    @Column(name = "dyn_www")
    private String dynWww;
    @Column(name = "gmina_id")
    private Integer gminaId;

//    @Column(name = "restId")
//    private String restId;

    @Column(name = "instytucja_id")
    private String instytucjaId;
    @Column(name = "kod_pocztowy_id")
    private String kodPocztowyId;
    @Column(name = "kryterium_kod")
    private String kryteriumKod;
    @Column(name = "liczba_czesci")
    private String liczbaCzesci;
    @Column(name = "liczba_dni")
    private Integer liczbaDni;
    @Column(name = "liczba_dni_oferty")
    private Integer liczbaDniOferty;
    @Column(name = "liczba_miesiecy")
    private Short liczbaMiesiecy;
    @Column(name = "liczba_wykonawcow")
    private Integer liczbaWykonawcow;
    @Column(name = "nazwa")
    @Type(type="text")
    private String nazwa;
    @Column(name = "numer_biuletynu")
    private Integer numerBiuletynu;
    @Column(name = "numer_zamowienia")
    private Integer numerZamowienia;
    @Column(name = "oferty_czesciowe")
    private Boolean ofertyCzesciowe;
    @Column(name = "oferty_godz")
    private String ofertyGodz;
    @Column(name = "ogloszenie_bzp")
    private String ogloszenieBzp;
    @Column(name = "powiat_id")
    private String powiatId;
    @Column(name = "pozycja")
    private String pozycja;
    @Column(name = "projekt_ue")
    @Type(type="text")
    private String projektUe;
    @Column(name = "przedmiot")
    @Type(type="text")
    private String przedmiot;
    @Column(name = "publikacja_obowiazkowa")
    private String publikacjaObowiazkowa;


    @Enumerated(EnumType.STRING)
    private OrderKind orderKind;
//    @Column(name = "rodzaj_id")
//    private String rodzajId;
//    @Column(name = "rodzaje_id")
//    private String rodzajeId;
//    @Column(name = "rodzaje_nazwa")
//    private String rodzajeNazwa;


    @Column(name = "sprawozdanie_calosc")
    private Boolean sprawozdanieCalosc;
    @Column(name = "sprawozdanie_lata_obrotowe")
    private Boolean sprawozdanieLataObrotowe;
    @Column(name = "status_id")
    private String statusId;
    @Column(name = "termin")
    private String termin;

    @Column(name = "tryb_id")
    private String trybId;
    @Column(name = "tryby_id")
    private String trybyId;
    @Column(name = "tryby_nazwa")
    private String trybyNazwa;

    @Enumerated(EnumType.STRING)
    private DocumentType documentType;

    // Columns Below are replaced by DocumentType enum
    //  @Column(name = "typ_id")
//    private String typId;
//    @Column(name = "typy_id")
//    private String typyId;
//    @Column(name = "typy_nazwa")
//    private String typyNazwa;
//    @Column(name = "typy_symbol")
//    private String typySymbol;


    @Column(name = "uniewaznienie")
    private Boolean uniewaznienie;
    @Column(name = "uzupelniajace")
    private Boolean uzupelniajace;
    @Column(name = "wariant")
    private Boolean wariant;

    @Column(name = "wartosc_cena")
    private Long wartoscCena;
    @Column(name = "wartosc_cena_max")
    private Long wartoscCenaMax;
    @Column(name = "wartosc_cena_min")
    private Long wartoscCenaMin;
    @Column(name = "wartosc_szacowana")
    private Long wartoscSzacowana;
    @Column(name = "wartosc_szacunkowa")
    private Long wartoscSzacunkowa;

    @Column(name = "wojewodztwo_id")
    private String wojewodztwoId;
    @Column(name = "wykonawca_str")
    private String wykonawcaStr;

    @Column(name = "zaliczka")
    private Boolean zaliczka;
    @Column(name = "zamowienie_ue")
    private Boolean zamowienieUe;
    @Column(name = "zmiana_ogloszenia")
    private Boolean zmianaOgloszenia;
    @Column(name = "zmiana_umowy")
    private Boolean zmianaUmowy;

    private String hash;


    @Override
    public String getHash() {
        return hash;
    }

    @Override
    public void setHash(String newHash) {
        this.hash = newHash;
    }


    @Override
    @JsonIgnore
    public String[] getItemsUsedInHash() {
        return new String[]{
                akcept != null ? akcept.toString(): ""
                ,aukcja != null ? aukcja.toString(): ""
                ,czas != null ? czas.toString(): ""
                ,dataPublikacji != null ? dataPublikacji.toString(): ""
                ,dataPublikacjiZamowienia != null ? dataPublikacjiZamowienia.toString(): ""
                ,dataStop != null ? dataStop.toString(): ""
                ,dialog != null ? dialog.toString(): ""
                ,dszWww != null ? dszWww.toString(): ""
                ,dynWww != null ? dynWww.toString(): ""
                ,gminaId != null ? gminaId.toString(): ""
                , restId != null ? restId.toString(): ""
                ,instytucjaId != null ? instytucjaId.toString(): ""
                ,kodPocztowyId != null ? kodPocztowyId.toString(): ""
                ,kryteriumKod != null ? kryteriumKod.toString(): ""
                ,liczbaCzesci != null ? liczbaCzesci.toString(): ""
                ,liczbaDni != null ? liczbaDni.toString(): ""
                ,liczbaDniOferty != null ? liczbaDniOferty.toString(): ""
                ,liczbaMiesiecy != null ? liczbaMiesiecy.toString(): ""
                ,liczbaWykonawcow != null ? liczbaWykonawcow.toString(): ""
                ,nazwa != null ? nazwa.toString(): ""
                ,numerBiuletynu != null ? numerBiuletynu.toString(): ""
                ,numerZamowienia != null ? numerZamowienia.toString(): ""
                ,ofertyCzesciowe != null ? ofertyCzesciowe.toString(): ""
                ,ofertyGodz != null ? ofertyGodz.toString(): ""
                ,ogloszenieBzp != null ? ogloszenieBzp.toString(): ""
                ,powiatId != null ? powiatId.toString(): ""
                ,pozycja != null ? pozycja.toString(): ""
                ,projektUe != null ? projektUe.toString(): ""
                ,przedmiot != null ? przedmiot.toString(): ""
                ,publikacjaObowiazkowa != null ? publikacjaObowiazkowa.toString(): ""
                ,orderKind != null ? orderKind.toString(): ""
                ,sprawozdanieCalosc != null ? sprawozdanieCalosc.toString(): ""
                ,sprawozdanieLataObrotowe != null ? sprawozdanieLataObrotowe.toString(): ""
                ,statusId != null ? statusId.toString(): ""
                ,termin != null ? termin.toString(): ""
                ,trybId != null ? trybId.toString(): ""
                ,trybyId != null ? trybyId.toString(): ""
                ,trybyNazwa != null ? trybyNazwa.toString(): ""
                ,documentType != null ? documentType.toString(): ""
                ,uniewaznienie != null ? uniewaznienie.toString(): ""
                ,uzupelniajace != null ? uzupelniajace.toString(): ""
                ,wariant != null ? wariant.toString(): ""
                ,wartoscCena != null ? wartoscCena.toString(): ""
                ,wartoscCenaMax != null ? wartoscCenaMax.toString(): ""
                ,wartoscCenaMin != null ? wartoscCenaMin.toString(): ""
                ,wartoscSzacowana != null ? wartoscSzacowana.toString(): ""
                ,wartoscSzacunkowa != null ? wartoscSzacunkowa.toString(): ""
                ,wojewodztwoId != null ? wojewodztwoId.toString(): ""
                ,wykonawcaStr != null ? wykonawcaStr.toString(): ""
                ,zaliczka != null ? zaliczka.toString(): ""
                ,zamowienieUe != null ? zamowienieUe.toString(): ""
                ,zmianaOgloszenia != null ? zmianaOgloszenia.toString(): ""
                ,zmianaUmowy != null ? zmianaUmowy.toString(): ""};
    }
}
