package pl.edu.agh.tai.dbmodel.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Builder(builderMethodName = "innerBuilder")
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Order {

    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "order_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "orderer_id")
    private Orderer orderer;

    @Column(name = "akcept")
    private String akcept;
    @Column(name = "aukcja")
    private String aukcja;
    @Column(name = "czas")
    private String czas;
    @Column(name = "data_publikacji")
    private String dataPublikacji;
    @Column(name = "data_publikacji_zamowienia")
    private String dataPublikacjiZamowienia;
    @Column(name = "data_stop")
    private String dataStop;
    @Column(name = "dialog")
    private String dialog;
    @Column(name = "dsz_www")
    private String dszWww;
    @Column(name = "dyn_www")
    private String dynWww;
    @Column(name = "gmina_id")
    private String gminaId;

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
    private String liczbaDni;
    @Column(name = "liczba_dni_oferty")
    private String liczbaDniOferty;
    @Column(name = "liczba_miesiecy")
    private String liczbaMiesiecy;
    @Column(name = "liczba_wykonawcow")
    private String liczbaWykonawcow;
    @Column(name = "nazwa")
    private String nazwa;
    @Column(name = "numer_biuletynu")
    private String numerBiuletynu;
    @Column(name = "numer_zamowienia")
    private String numerZamowienia;
    @Column(name = "oferty_czesciowe")
    private String ofertyCzesciowe;
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
    @Column(name = "rodzaj_id")
    private String rodzajId;
    @Column(name = "id")
    private String rodzajeId;
    @Column(name = "nazwa")
    private String rodzajeNazwa;
    @Column(name = "sprawozdanie_calosc")
    private String sprawozdanieCalosc;
    @Column(name = "sprawozdanie_lata_obrotowe")
    private String sprawozdanieLataObrotowe;
    @Column(name = "status_id")
    private String statusId;
    @Column(name = "termin")
    private String termin;
    @Column(name = "tryb_id")
    private String trybId;
    @Column(name = "id")
    private String trybyId;
    @Column(name = "nazwa")
    private String trybyNazwa;
    @Column(name = "typ_id")
    private String typId;
    @Column(name = "id")
    private String typyId;
    @Column(name = "nazwa")
    private String typyNazwa;
    @Column(name = "symbol")
    private String typySymbol;
    @Column(name = "uniewaznienie")
    private String uniewaznienie;
    @Column(name = "uzupelniajace")
    private String uzupelniajace;
    @Column(name = "wariant")
    private String wariant;
    @Column(name = "wartosc_cena")
    private String wartoscCena;
    @Column(name = "wartosc_cena_max")
    private String wartoscCenaMax;
    @Column(name = "wartosc_cena_min")
    private String wartoscCenaMin;
    @Column(name = "wartosc_szacowana")
    private String wartoscSzacowana;
    @Column(name = "wartosc_szacunkowa")
    private String wartoscSzacunkowa;
    @Column(name = "wojewodztwo_id")
    private String wojewodztwoId;
    @Column(name = "wykonawca_str")
    private String wykonawcaStr;
    @Column(name = "zaliczka")
    private String zaliczka;
    @Column(name = "zamowienie_ue")
    private String zamowienieUe;
    @Column(name = "zmiana_ogloszenia")
    private String zmianaOgloszenia;
    @Column(name = "zmiana_umowy")
    private String zmianaUmowy;

}
