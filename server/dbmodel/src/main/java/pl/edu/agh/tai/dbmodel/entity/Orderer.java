package pl.edu.agh.tai.dbmodel.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;


@Builder
@Getter
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Orderer {

    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "orderer_id")
    private Long id;

    @OneToMany(mappedBy = "orderer")
    @JsonBackReference
    private List<Order> orders;

    @Column(name = "zamawiajacy_email")
    private String zamawiajacyEmail;
    @Column(name = "zamawiajacy_fax")
    private String zamawiajacyFax;
    //    @Column(name = "zamawiajacy_id")
//    private String zamawiajacyId;
    @Column(name = "zamawiajacy_kod_poczt")
    private String zamawiajacyKodPoczt;
    @Column(name = "kod_pocztowy_id")
    private String zamawiajacyKodPocztowyId;
    @Column(name = "zamawiajacy_miejscowosc")
    private String zamawiajacyMiejscowosc;
    @Column(name = "zamawiajacy_nazwa")
    private String zamawiajacyNazwa;
    @Column(name = "zamawiajacy_nr_domu")
    private String zamawiajacyNrDomu;
    @Column(name = "zamawiajacy_nr_miesz")
    private String zamawiajacyNrMiesz;
    @Column(name = "zamawiajacy_regon")
    private String zamawiajacyRegon;
    @Column(name = "zamawiajacy_rodzaj")
    private String zamawiajacyRodzaj;
    @Column(name = "zamawiajacy_rodzaj_inny")
    private String zamawiajacyRodzajInny;
    @Column(name = "zamawiajacy_tel")
    private String zamawiajacyTel;
    @Column(name = "zamawiajacy_ulica")
    private String zamawiajacyUlica;
    @Column(name = "zamawiajacy_wojewodztwo")
    private String zamawiajacyWojewodztwo;
    @Column(name = "zamawiajacy_www")
    private String zamawiajacyWww;

}
