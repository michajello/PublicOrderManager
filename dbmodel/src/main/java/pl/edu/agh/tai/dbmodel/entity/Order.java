package pl.edu.agh.tai.dbmodel.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Builder(builderMethodName = "innerBuilder")
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Getter
@Setter
public class Order {

    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "order_id")
    private Long id;

    @ManyToOne
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

//    @Column(name = "id")
//    private String id;

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
    private String projektUe;
    @Column(name = "przedmiot")
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
    @Column(name = "nazwa")
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

}
