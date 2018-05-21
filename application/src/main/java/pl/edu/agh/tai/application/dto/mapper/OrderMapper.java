package pl.edu.agh.tai.application.dto.mapper;

import pl.edu.agh.tai.application.dto.publicorder.OrderDTO;
import pl.edu.agh.tai.dbmodel.entity.DocumentType;
import pl.edu.agh.tai.dbmodel.entity.Order;
import pl.edu.agh.tai.dbmodel.entity.OrderKind;
import pl.edu.agh.tai.dbmodel.entity.Orderer;

import java.time.LocalDate;

public class OrderMapper extends Mapper<Order, OrderDTO> {

    private final LocalDate missingDate = LocalDate.of(1, 1,1);
    
    @Override
    public OrderDTO mapToDTO(Order object) {
        return OrderDTO.builder()
                .zamowieniaPubliczneAkcept(booleanToString(object.getAkcept()))
                .zamowieniaPubliczneAukcja(booleanToString(object.getAukcja()))
                .zamowieniaPubliczneCzas(localDateToString(object.getCzas()))
                .zamowieniaPubliczneDataPublikacji(localDateToString(object.getDataPublikacji()))
                .zamowieniaPubliczneDataPublikacjiZamowienia(localDateToString(object.getDataPublikacjiZamowienia()))
                .zamowieniaPubliczneDataStop(localDateToString(object.getDataStop()))
                .zamowieniaPubliczneDialog(booleanToString(object.getDialog()))
                .zamowieniaPubliczneDszWww(object.getDszWww())
                .zamowieniaPubliczneDynWww(object.getDynWww())
                .zamowieniaPubliczneGminaId(object.getGminaId().toString())
                .zamowieniaPubliczneId(object.getId().toString())
                .zamowieniaPubliczneInstytucjaId(object.getInstytucjaId())
                .zamowieniaPubliczneKodPocztowyId(object.getKodPocztowyId())
                .zamowieniaPubliczneKryteriumKod(object.getKryteriumKod())
                .zamowieniaPubliczneLiczbaCzesci(object.getLiczbaCzesci())
                .zamowieniaPubliczneLiczbaDni(object.getLiczbaDni().toString())
                .zamowieniaPubliczneLiczbaDniOferty(object.getLiczbaDniOferty().toString())
                .zamowieniaPubliczneLiczbaMiesiecy(object.getLiczbaMiesiecy().toString())
                .zamowieniaPubliczneLiczbaWykonawcow(object.getLiczbaWykonawcow().toString())
                .zamowieniaPubliczneNazwa(object.getNazwa())
                .zamowieniaPubliczneNumerBiuletynu(object.getNumerBiuletynu().toString())
                .zamowieniaPubliczneNumerZamowienia(object.getNumerZamowienia().toString())
                .zamowieniaPubliczneOfertyCzesciowe(booleanToString(object.getOfertyCzesciowe()))
                .zamowieniaPubliczneOfertyGodz(object.getOfertyGodz())
                .zamowieniaPubliczneOgloszenieBzp(object.getOgloszenieBzp())
                .zamowieniaPublicznePowiatId(object.getPowiatId())
                .zamowieniaPublicznePozycja(object.getPozycja())
                .zamowieniaPubliczneProjektUe(object.getProjektUe())
                .zamowieniaPublicznePrzedmiot(object.getPrzedmiot())
                .zamowieniaPublicznePublikacjaObowiazkowa(object.getPublikacjaObowiazkowa())
                .zamowieniaPubliczneRodzajeId(String.valueOf(object.getOrderKind().getId())) //to samo co nizej
                .zamowieniaPubliczneRodzajeNazwa(object.getOrderKind().getName())
                .zamowieniaPubliczneRodzajId(String.valueOf(object.getOrderKind().getId()))  //to samo co wyzej
                .zamowieniaPubliczneSprawozdanieCalosc(booleanToString(object.getSprawozdanieCalosc()))
                .zamowieniaPubliczneSprawozdanieLataObrotowe(booleanToString(object.getSprawozdanieLataObrotowe()))
                .zamowieniaPubliczneStatusId(object.getStatusId())
                .zamowieniaPubliczneTermin(object.getTermin())
                .zamowieniaPubliczneTrybId(object.getTrybId())
                .zamowieniaPubliczneTrybyId(object.getTrybyId())
                .zamowieniaPubliczneTrybyNazwa(object.getTrybyNazwa())
                .zamowieniaPubliczneTypId(String.valueOf(object.getDocumentType().getId())) //to samo co nizej
                .zamowieniaPubliczneTypyId(String.valueOf(object.getDocumentType().getId())) //to samo co wyzej
                .zamowieniaPubliczneTypyNazwa(object.getDocumentType().getName())
                .zamowieniaPubliczneTypySymbol(object.getDocumentType().getSymbol())
                .zamowieniaPubliczneUniewaznienie(booleanToString(object.getUniewaznienie()))
                .zamowieniaPubliczneUzupelniajace(booleanToString(object.getUzupelniajace()))
                .zamowieniaPubliczneWariant(booleanToString(object.getWariant()))
                .zamowieniaPubliczneWartoscCena(object.getWartoscCena().toString())
                .zamowieniaPubliczneWartoscCenaMax(object.getWartoscCenaMax().toString())
                .zamowieniaPubliczneWartoscCenaMin(object.getWartoscCenaMin().toString())
                .zamowieniaPubliczneWartoscSzacowana(object.getWartoscSzacowana().toString())
                .zamowieniaPubliczneWartoscSzacunkowa(object.getWartoscSzacunkowa().toString())
                .zamowieniaPubliczneWojewodztwoId(object.getWojewodztwoId())
                .zamowieniaPubliczneWykonawcaStr(object.getWykonawcaStr())
                .zamowieniaPubliczneZaliczka(booleanToString(object.getZaliczka()))
                .zamowieniaPubliczneZamawiajacyEmail(object.getOrderer().getZamawiajacyEmail())
                .zamowieniaPubliczneZamawiajacyFax(object.getOrderer().getZamawiajacyFax())
                .zamowieniaPubliczneZamawiajacyId(object.getOrderer().getId().toString())
                .zamowieniaPubliczneZamawiajacyKodPoczt(object.getOrderer().getZamawiajacyKodPoczt())
                .zamowieniaPubliczneZamawiajacyKodPocztowyId(object.getOrderer().getZamawiajacyKodPocztowyId())
                .zamowieniaPubliczneZamawiajacyMiejscowosc(object.getOrderer().getZamawiajacyMiejscowosc())
                .zamowieniaPubliczneZamawiajacyNazwa(object.getOrderer().getZamawiajacyNazwa())
                .zamowieniaPubliczneZamawiajacyNrDomu(object.getOrderer().getZamawiajacyNrDomu())
                .zamowieniaPubliczneZamawiajacyNrMiesz(object.getOrderer().getZamawiajacyNrMiesz())
                .zamowieniaPubliczneZamawiajacyRegon(object.getOrderer().getZamawiajacyRegon())
                .zamowieniaPubliczneZamawiajacyRodzaj(object.getOrderer().getZamawiajacyRodzaj())
                .zamowieniaPubliczneZamawiajacyRodzajInny(object.getOrderer().getZamawiajacyRodzajInny())
                .zamowieniaPubliczneZamawiajacyTel(object.getOrderer().getZamawiajacyTel())
                .zamowieniaPubliczneZamawiajacyUlica(object.getOrderer().getZamawiajacyUlica())
                .zamowieniaPubliczneZamawiajacyWojewodztwo(object.getOrderer().getZamawiajacyWojewodztwo())
                .zamowieniaPubliczneZamawiajacyWww(object.getOrderer().getZamawiajacyWww())
                .zamowieniaPubliczneZamowienieUe(booleanToString(object.getZamowienieUe()))
                .zamowieniaPubliczneZmianaOgloszenia(booleanToString(object.getZmianaOgloszenia()))
                .zamowieniaPubliczneZmianaUmowy(booleanToString(object.getZmianaUmowy()))
                .build();
    }

    @Override
    public Order mapToDAO(OrderDTO object) {
        return Order.innerBuilder()
                .akcept(parseBoolean(object.getZamowieniaPubliczneAkcept()))
                .aukcja(parseBoolean(object.getZamowieniaPubliczneAukcja()))
                .czas(stringToLocalDate(object.getZamowieniaPubliczneCzas()))
                .dataPublikacji(stringToLocalDate(object.getZamowieniaPubliczneDataPublikacji()))
                .dataPublikacjiZamowienia(stringToLocalDate(object.getZamowieniaPubliczneDataPublikacjiZamowienia()))
                .dataStop(stringToLocalDate(object.getZamowieniaPubliczneDataStop()))
                .dialog(parseBoolean(object.getZamowieniaPubliczneDialog()))
                .documentType(DocumentType.get(Integer.parseInt(object.getZamowieniaPubliczneTypId())))
                .dszWww(object.getZamowieniaPubliczneDszWww())
                .dynWww(object.getZamowieniaPubliczneDynWww())
                .gminaId(Integer.parseInt(object.getZamowieniaPubliczneGminaId()))
                .id(Long.parseLong(object.getZamowieniaPubliczneId()))
                .instytucjaId(object.getZamowieniaPubliczneInstytucjaId())
                .kodPocztowyId(object.getZamowieniaPubliczneKodPocztowyId())
                .kryteriumKod(object.getZamowieniaPubliczneKryteriumKod())
                .liczbaCzesci(object.getZamowieniaPubliczneLiczbaCzesci())
                .liczbaDni(Integer.parseInt(object.getZamowieniaPubliczneLiczbaDni()))
                .liczbaDniOferty(Integer.parseInt(object.getZamowieniaPubliczneLiczbaDniOferty()))
                .liczbaMiesiecy(Short.parseShort(object.getZamowieniaPubliczneLiczbaMiesiecy()))
                .liczbaWykonawcow(Integer.parseInt(object.getZamowieniaPubliczneLiczbaWykonawcow()))
                .nazwa(object.getZamowieniaPubliczneNazwa())
                .numerBiuletynu(Integer.parseInt(object.getZamowieniaPubliczneNumerBiuletynu()))
                .numerZamowienia(Integer.parseInt(object.getZamowieniaPubliczneNumerZamowienia()))
                .ofertyCzesciowe(parseBoolean(object.getZamowieniaPubliczneOfertyCzesciowe()))
                .ofertyGodz(object.getZamowieniaPubliczneOfertyGodz())
                .ogloszenieBzp(object.getZamowieniaPubliczneOgloszenieBzp())
                .orderer(Orderer.builder()
                        .id(Long.parseLong(object.getZamowieniaPubliczneZamawiajacyId()))
                        .zamawiajacyEmail(object.getZamowieniaPubliczneZamawiajacyEmail())
                        .zamawiajacyFax(object.getZamowieniaPubliczneZamawiajacyFax())
                        .zamawiajacyKodPoczt(object.getZamowieniaPubliczneZamawiajacyKodPoczt())
                        .zamawiajacyKodPocztowyId(object.getZamowieniaPubliczneZamawiajacyKodPocztowyId())
                        .zamawiajacyMiejscowosc(object.getZamowieniaPubliczneZamawiajacyMiejscowosc())
                        .zamawiajacyNazwa(object.getZamowieniaPubliczneZamawiajacyNazwa())
                        .zamawiajacyNrDomu(object.getZamowieniaPubliczneZamawiajacyNrDomu())
                        .zamawiajacyNrMiesz(object.getZamowieniaPubliczneZamawiajacyNrMiesz())
                        .zamawiajacyRegon(object.getZamowieniaPubliczneZamawiajacyRegon())
                        .zamawiajacyRodzaj(object.getZamowieniaPubliczneZamawiajacyRodzaj())
                        .zamawiajacyRodzajInny(object.getZamowieniaPubliczneZamawiajacyRodzajInny())
                        .zamawiajacyTel(object.getZamowieniaPubliczneZamawiajacyTel())
                        .zamawiajacyUlica(object.getZamowieniaPubliczneZamawiajacyUlica())
                        .zamawiajacyWojewodztwo(object.getZamowieniaPubliczneZamawiajacyWojewodztwo())
                        .zamawiajacyWww(object.getZamowieniaPubliczneZamawiajacyWww())
                        .build())
                .orderKind(OrderKind.get(Integer.parseInt(object.getZamowieniaPubliczneRodzajeId())))
                .powiatId(object.getZamowieniaPublicznePowiatId())
                .pozycja(object.getZamowieniaPublicznePozycja())
                .projektUe(object.getZamowieniaPubliczneProjektUe())
                .przedmiot(object.getZamowieniaPublicznePrzedmiot())
                .publikacjaObowiazkowa(object.getZamowieniaPublicznePublikacjaObowiazkowa())
                .sprawozdanieCalosc(parseBoolean(object.getZamowieniaPubliczneSprawozdanieCalosc()))
                .sprawozdanieLataObrotowe(parseBoolean(object.getZamowieniaPubliczneSprawozdanieLataObrotowe()))
                .statusId(object.getZamowieniaPubliczneStatusId())
                .termin(object.getZamowieniaPubliczneTermin())
                .trybId(object.getZamowieniaPubliczneTrybId())
                .trybyId(object.getZamowieniaPubliczneTrybyId())
                .trybyNazwa(object.getZamowieniaPubliczneTrybyNazwa())
                .uniewaznienie(parseBoolean(object.getZamowieniaPubliczneUniewaznienie()))
                .uzupelniajace(parseBoolean(object.getZamowieniaPubliczneUzupelniajace()))
                .wariant(parseBoolean(object.getZamowieniaPubliczneWariant()))
                .wartoscCena(Long.parseLong(object.getZamowieniaPubliczneWartoscCena()))
                .wartoscCenaMax(Long.parseLong(object.getZamowieniaPubliczneWartoscCenaMax()))
                .wartoscCenaMin(Long.parseLong(object.getZamowieniaPubliczneWartoscCenaMin()))
                .wartoscSzacowana(Long.parseLong(object.getZamowieniaPubliczneWartoscSzacowana()))
                .wartoscSzacunkowa(Long.parseLong(object.getZamowieniaPubliczneWartoscSzacunkowa()))
                .wojewodztwoId(object.getZamowieniaPubliczneWojewodztwoId())
                .wykonawcaStr(object.getZamowieniaPubliczneWykonawcaStr())
                .zaliczka(parseBoolean(object.getZamowieniaPubliczneZaliczka()))
                .zamowienieUe(parseBoolean(object.getZamowieniaPubliczneZamowienieUe()))
                .zmianaOgloszenia(parseBoolean(object.getZamowieniaPubliczneZmianaOgloszenia()))
                .zmianaUmowy(parseBoolean(object.getZamowieniaPubliczneZmianaUmowy()))
                .build();
    }

    private Boolean parseBoolean(String s){
        if (s == null){
            return null;
        }
        return s.equals("1") || s.toLowerCase().equals("true");
    }

    private String booleanToString(Boolean b){
        if (b == null) {
            return null;
        }
        return b ? "1" : "0";
    }

    private String localDateToString(LocalDate date){
        if (date == null){
            return null;
        } else if (date.equals(missingDate)) {
            return "";
        } else {
            return date.toString();
        }
    }

    private LocalDate stringToLocalDate(String s){
        if (s == null){
            return null;
        } else if (s.equals("")) {
            return missingDate;
        } else {
            return LocalDate.parse(s);
        }
    }
    
}
