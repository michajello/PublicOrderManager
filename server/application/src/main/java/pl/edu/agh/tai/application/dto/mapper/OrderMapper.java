package pl.edu.agh.tai.application.dto.mapper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.jaxb.SpringDataJaxb;
import org.springframework.stereotype.Component;
import pl.edu.agh.tai.application.dto.publicorder.OrderDTO;
import pl.edu.agh.tai.application.schedule.ScheduledTasks;
import pl.edu.agh.tai.dbmodel.entity.DocumentType;
import pl.edu.agh.tai.dbmodel.entity.Order;
import pl.edu.agh.tai.dbmodel.entity.OrderKind;
import pl.edu.agh.tai.dbmodel.entity.Orderer;
import pl.edu.agh.tai.dbmodel.repository.OrdererRepository;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Optional;


@Component
public class OrderMapper extends Mapper<Order, OrderDTO> {

    private static final Logger logger = LoggerFactory.getLogger(OrderMapper.class);

    private final LocalDate missingDate = LocalDate.of(1, 1, 1);

    private final OrdererRepository ordererRepository;

    @Autowired
    public OrderMapper(OrdererRepository ordererRepository) {
        this.ordererRepository = ordererRepository;
    }

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
                .zamowieniaPubliczneId(object.getRestId().toString())
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
        Orderer orderer = getOrderer(object);
        LocalDate orderTime = null;
        try {
            orderTime = stringToLocalDate(object.getZamowieniaPubliczneCzas());
        } catch (DateTimeParseException e) {
            logger.error("Problem with parsing data: " + object.toString() + "\n" + e.toString());
//            e.printStackTrace();
        }



        return Order.innerBuilder()
                .akcept(parseBoolean(object.getZamowieniaPubliczneAkcept()))
                .aukcja(parseBoolean(object.getZamowieniaPubliczneAukcja()))
                .czas(orderTime)
                .dataPublikacji(stringToLocalDate(object.getZamowieniaPubliczneDataPublikacji()))
                .dataPublikacjiZamowienia(stringToLocalDate(object.getZamowieniaPubliczneDataPublikacjiZamowienia()))
                .dataStop(stringToLocalDate(object.getZamowieniaPubliczneDataStop()))
                .dialog(parseBoolean(object.getZamowieniaPubliczneDialog()))
                .documentType(DocumentType.get(Integer.parseInt(object.getZamowieniaPubliczneTypId())))
                .dszWww(object.getZamowieniaPubliczneDszWww())
                .dynWww(object.getZamowieniaPubliczneDynWww())
                .gminaId(Integer.parseInt(object.getZamowieniaPubliczneGminaId()))
                .restId(object.getZamowieniaPubliczneId() != null ? Long.parseLong(object.getZamowieniaPubliczneId()) : null)
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
                .orderer(orderer)
                .orderKind(OrderKind.get(object.getZamowieniaPubliczneRodzajId() != null ? Integer.parseInt(object.getZamowieniaPubliczneRodzajId()) : null))
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

    @Override
    public void mapToPersistedDAO(Order dbObject, OrderDTO dtoObject) {
        LocalDate orderTime = null;
        try {
            orderTime = stringToLocalDate(dtoObject.getZamowieniaPubliczneCzas());
        } catch (DateTimeParseException e) {
            logger.error("Problem with parsing data: " + dtoObject.toString() + "\n" + e.toString());
//            e.printStackTrace();
        }
        dbObject.setAkcept(parseBoolean(dtoObject.getZamowieniaPubliczneAkcept()));
                dbObject.setAukcja(parseBoolean(dtoObject.getZamowieniaPubliczneAukcja()));
                dbObject.setCzas(orderTime);
                dbObject.setDataPublikacji(stringToLocalDate(dtoObject.getZamowieniaPubliczneDataPublikacji()));
                dbObject.setDataPublikacjiZamowienia(stringToLocalDate(dtoObject.getZamowieniaPubliczneDataPublikacjiZamowienia()));
                dbObject.setDataStop(stringToLocalDate(dtoObject.getZamowieniaPubliczneDataStop()));
                dbObject.setDialog(parseBoolean(dtoObject.getZamowieniaPubliczneDialog()));
                dbObject.setDocumentType(DocumentType.get(Integer.parseInt(dtoObject.getZamowieniaPubliczneTypId())));
                dbObject.setDszWww(dtoObject.getZamowieniaPubliczneDszWww());
                dbObject.setDynWww(dtoObject.getZamowieniaPubliczneDynWww());
                dbObject.setGminaId(Integer.parseInt(dtoObject.getZamowieniaPubliczneGminaId()));
                dbObject.setRestId(dtoObject.getZamowieniaPubliczneId() != null ? Long.parseLong(dtoObject.getZamowieniaPubliczneId()) : null);
                dbObject.setInstytucjaId(dtoObject.getZamowieniaPubliczneInstytucjaId());
                dbObject.setKodPocztowyId(dtoObject.getZamowieniaPubliczneKodPocztowyId());
                dbObject.setKryteriumKod(dtoObject.getZamowieniaPubliczneKryteriumKod());
                dbObject.setLiczbaCzesci(dtoObject.getZamowieniaPubliczneLiczbaCzesci());
                dbObject.setLiczbaDni(Integer.parseInt(dtoObject.getZamowieniaPubliczneLiczbaDni()));
                dbObject.setLiczbaDniOferty(Integer.parseInt(dtoObject.getZamowieniaPubliczneLiczbaDniOferty()));
                dbObject.setLiczbaMiesiecy(Short.parseShort(dtoObject.getZamowieniaPubliczneLiczbaMiesiecy()));
                dbObject.setLiczbaWykonawcow(Integer.parseInt(dtoObject.getZamowieniaPubliczneLiczbaWykonawcow()));
                dbObject.setNazwa(dtoObject.getZamowieniaPubliczneNazwa());
                dbObject.setNumerBiuletynu(Integer.parseInt(dtoObject.getZamowieniaPubliczneNumerBiuletynu()));
                dbObject.setNumerZamowienia(Integer.parseInt(dtoObject.getZamowieniaPubliczneNumerZamowienia()));
                dbObject.setOfertyCzesciowe(parseBoolean(dtoObject.getZamowieniaPubliczneOfertyCzesciowe()));
                dbObject.setOfertyGodz(dtoObject.getZamowieniaPubliczneOfertyGodz());
                dbObject.setOgloszenieBzp(dtoObject.getZamowieniaPubliczneOgloszenieBzp());
//dbObject//               set .orderer(orderer)
                dbObject.setOrderKind(OrderKind.get(dtoObject.getZamowieniaPubliczneRodzajId() != null ? Integer.parseInt(dtoObject.getZamowieniaPubliczneRodzajId()) : null));
                dbObject.setPowiatId(dtoObject.getZamowieniaPublicznePowiatId());
                dbObject.setPozycja(dtoObject.getZamowieniaPublicznePozycja());
                dbObject.setProjektUe(dtoObject.getZamowieniaPubliczneProjektUe());
                dbObject.setPrzedmiot(dtoObject.getZamowieniaPublicznePrzedmiot());
                dbObject.setPublikacjaObowiazkowa(dtoObject.getZamowieniaPublicznePublikacjaObowiazkowa());
                dbObject.setSprawozdanieCalosc(parseBoolean(dtoObject.getZamowieniaPubliczneSprawozdanieCalosc()));
                dbObject.setSprawozdanieLataObrotowe(parseBoolean(dtoObject.getZamowieniaPubliczneSprawozdanieLataObrotowe()));
                dbObject.setStatusId(dtoObject.getZamowieniaPubliczneStatusId());
                dbObject.setTermin(dtoObject.getZamowieniaPubliczneTermin());
                dbObject.setTrybId(dtoObject.getZamowieniaPubliczneTrybId());
                dbObject.setTrybyId(dtoObject.getZamowieniaPubliczneTrybyId());
                dbObject.setTrybyNazwa(dtoObject.getZamowieniaPubliczneTrybyNazwa());
                dbObject.setUniewaznienie(parseBoolean(dtoObject.getZamowieniaPubliczneUniewaznienie()));
                dbObject.setUzupelniajace(parseBoolean(dtoObject.getZamowieniaPubliczneUzupelniajace()));
                dbObject.setWariant(parseBoolean(dtoObject.getZamowieniaPubliczneWariant()));
                dbObject.setWartoscCena(Long.parseLong(dtoObject.getZamowieniaPubliczneWartoscCena()));
                dbObject.setWartoscCenaMax(Long.parseLong(dtoObject.getZamowieniaPubliczneWartoscCenaMax()));
                dbObject.setWartoscCenaMin(Long.parseLong(dtoObject.getZamowieniaPubliczneWartoscCenaMin()));
                dbObject.setWartoscSzacowana(Long.parseLong(dtoObject.getZamowieniaPubliczneWartoscSzacowana()));
                dbObject.setWartoscSzacunkowa(Long.parseLong(dtoObject.getZamowieniaPubliczneWartoscSzacunkowa()));
                dbObject.setWojewodztwoId(dtoObject.getZamowieniaPubliczneWojewodztwoId());
                dbObject.setWykonawcaStr(dtoObject.getZamowieniaPubliczneWykonawcaStr());
                dbObject.setZaliczka(parseBoolean(dtoObject.getZamowieniaPubliczneZaliczka()));
                dbObject.setZamowienieUe(parseBoolean(dtoObject.getZamowieniaPubliczneZamowienieUe()));
                dbObject.setZmianaOgloszenia(parseBoolean(dtoObject.getZamowieniaPubliczneZmianaOgloszenia()));
                dbObject.setZmianaUmowy(parseBoolean(dtoObject.getZamowieniaPubliczneZmianaUmowy()));
    }

    private Orderer getOrderer(OrderDTO object) {

        Optional<Orderer> wrappedOrdered = ordererRepository.findById(Long.parseLong(object.getZamowieniaPubliczneZamawiajacyId()));
        if (wrappedOrdered.isPresent()) {
            return wrappedOrdered.get();
        }
        Orderer orderer = Orderer.builder()
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
                .build();
        ordererRepository.save(orderer);
        return orderer;

    }


    @Override
    protected String localDateToString(LocalDate date) {
        if (date == null) {
            return null;
        } else if (date.equals(missingDate)) {
            return "";
        } else {
            return date.toString();
        }
    }

    @Override
    protected LocalDate stringToLocalDate(String s) {
        //"D" is incorrect value from API :)
        if (s == null || s.equals("D") ) {
            return null;
        } else if (s.equals("")) {
            return missingDate;
        } else {

            return LocalDate.parse(s);
        }
    }
}
