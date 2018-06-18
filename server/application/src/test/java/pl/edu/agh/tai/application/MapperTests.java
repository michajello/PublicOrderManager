package pl.edu.agh.tai.application;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.BeforeClass;
import org.junit.Test;
import pl.edu.agh.tai.application.dto.mapper.Mapper;
import pl.edu.agh.tai.application.dto.mapper.OrderMapper;
import pl.edu.agh.tai.application.dto.publicorder.OrderDTO;
import pl.edu.agh.tai.dbmodel.entity.Order;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

public class MapperTests {

    private static Mapper<Order, OrderDTO> orderMapper;
    private static OrderDTO orderDTO;

    @BeforeClass
    public static void init() throws IOException {
//        orderMapper = new OrderMapper(ordererRepository);
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonObject = "{\"zamowienia_publiczne.akcept\":\"1\", \"zamowienia_publiczne.aukcja\":\"0\", \"zamowienia_publiczne.czas\":\"\", \"zamowienia_publiczne.data_publikacji_zamowienia\":\"2016-11-30\", \"zamowienia_publiczne.data_publikacji\":\"2016-11-30\", \"zamowienia_publiczne.dialog\":\"0\", \"zamowienia_publiczne.dsz_www\":\"\", \"zamowienia_publiczne.dyn_www\":\"\", \"zamowienia_publiczne.gmina_id\":\"1575\", \"zamowienia_publiczne.restId\":\"2886904\", \"zamowienia_publiczne.instytucja_id\":\"0\", \"zamowienia_publiczne.kod_pocztowy_id\":\"20206\", \"zamowienia_publiczne.kryterium_kod\":\"\", \"zamowienia_publiczne.liczba_czesci\":1, \"zamowienia_publiczne.liczba_dni_oferty\":0, \"zamowienia_publiczne.liczba_dni\":0, \"zamowienia_publiczne.liczba_miesiecy\":0, \"zamowienia_publiczne.liczba_wykonawcow\":1, \"zamowienia_publiczne.nazwa\":\"Rozbudowa Zespo\u0142u Szk\u00f3\u0142 Mistrzostwa Sportowego o sal\u0119 gimnastyczn\u0105 z zapleczem sanitarno-technicznym, komunikacj\u0105 z miejscami parkingowymi, o\u015bwietleniem terenu), budow\u0105 instalacji zewn\u0119trznej kanalizacji deszczowej oraz przebudow\u0105 istniej\u0105cych  urz\u0105dze\u0144 podziemnych (zewn\u0119trzna instalacja wody, zewn\u0119trzna instalacja kanalizacji sanitarnej, kable energetyczne) koliduj\u0105cych z projektowan\u0105 rozbudow\u0105 oraz rozbi\u00f3rk\u0105 obiekt\u00f3w budowlanych ( budynek gospodarczy, wiatro\u0142ap, zaplecze gospodarcze przy istniej\u0105cym budynku) koliduj\u0105cych z projektowan\u0105 rozbi\u00f3rk\u0105.\", \"zamowienia_publiczne.numer_biuletynu\":1, \"zamowienia_publiczne.numer_zamowienia\":0, \"zamowienia_publiczne.oferty_czesciowe\":\"0\", \"zamowienia_publiczne.oferty_godz\":\"\", \"zamowienia_publiczne.ogloszenie_bzp\":\"0\", \"zamowienia_publiczne.powiat_id\":\"322\", \"zamowienia_publiczne.pozycja\":153996, \"zamowienia_publiczne.projekt_ue\":\"\", \"zamowienia_publiczne.przedmiot\":\"Wykonanie rob\u00f3t zamiennych i uzupe\u0142niaj\u0105cychna budowie wg protoko\u0142u konieczno\u015bci nr 3 2016 z dnia 05-09-2016\", \"zamowienia_publiczne.publikacja_obowiazkowa\":\"1\", \"zamowienia_publiczne.rodzaj_id\":\"1\", \"zamowienia_publiczne_rodzaje.restId\":\"1\", \"zamowienia_publiczne_rodzaje.nazwa\":\"Roboty budowlane\", \"zamowienia_publiczne_tryby.restId\":\"2\", \"zamowienia_publiczne_tryby.nazwa\":\"Zam\u00f3wienie z wolnej r\u0119ki\", \"zamowienia_publiczne_typy.restId\":\"3\", \"zamowienia_publiczne_typy.nazwa\":\"Og\u0142oszenie o udzieleniu zam\u00f3wienia\", \"zamowienia_publiczne_typy.symbol\":\"ZP-403\", \"zamowienia_publiczne.sprawozdanie_calosc\":\"0\", \"zamowienia_publiczne.sprawozdanie_lata_obrotowe\":\"0\", \"zamowienia_publiczne.status_id\":\"2\", \"zamowienia_publiczne.termin\":\"\", \"zamowienia_publiczne.tryb_id\":\"2\", \"zamowienia_publiczne.typ_id\":\"3\", \"zamowienia_publiczne.uniewaznienie\":\"0\", \"zamowienia_publiczne.uzupelniajace\":\"0\", \"zamowienia_publiczne.wariant\":\"0\", \"zamowienia_publiczne.wartosc_cena_max\":0, \"zamowienia_publiczne.wartosc_cena_min\":80076, \"zamowienia_publiczne.wartosc_cena\":80076, \"zamowienia_publiczne.wartosc_szacowana\":88000, \"zamowienia_publiczne.wartosc_szacunkowa\":0, \"zamowienia_publiczne.wojewodztwo_id\":\"6\", \"zamowienia_publiczne.wykonawca_str\":\"Zak\u0142ad Remontowo-Budowlany Marian Sikora\", \"zamowienia_publiczne.zaliczka\":\"0\", \"zamowienia_publiczne.zamawiajacy_email\":\"nowaks@neostrada.pl\", \"zamowienia_publiczne.zamawiajacy_fax\":\"018 2013152\", \"zamowienia_publiczne.zamawiajacy_id\":\"16159\", \"zamowienia_publiczne.zamawiajacy_kod_poczt\":\"34-500\", \"zamowienia_publiczne.zamawiajacy_miejscowosc\":\"Zakopane\", \"zamowienia_publiczne.zamawiajacy_nazwa\":\"Zesp\u00f3\u0142 Szk\u00f3\u0142 Mistrzostwa Sportowego\", \"zamowienia_publiczne.zamawiajacy_nr_domu\":\"26\", \"zamowienia_publiczne.zamawiajacy_nr_miesz\":\"\", \"zamowienia_publiczne.zamawiajacy_regon\":\"49204000100000\", \"zamowienia_publiczne.zamawiajacy_rodzaj_inny\":\"szko\u0142a\", \"zamowienia_publiczne.zamawiajacy_rodzaj\":\"Inny: szko\u0142a\", \"zamowienia_publiczne.zamawiajacy_tel\":\"018 2061202\", \"zamowienia_publiczne.zamawiajacy_ulica\":\"ul. Droga do Olczy 26\", \"zamowienia_publiczne.zamawiajacy_wojewodztwo\":\"ma\u0142opolskie\", \"zamowienia_publiczne.zamawiajacy_www\":\"\", \"zamowienia_publiczne.zamowienie_ue\":\"0\", \"zamowienia_publiczne.zmiana_ogloszenia\":\"0\", \"zamowienia_publiczne.zmiana_umowy\":\"0\"}";
        orderDTO = objectMapper.readValue(jsonObject, OrderDTO.class);
    }

    // TDD :)
    @Test
    public void mappingFromDtoToDaoAndBackShouldGiveObjectWithTheSameValues() {
        Order order = orderMapper.mapToDAO(orderDTO);

        OrderDTO mappedAgainObject = orderMapper.mapToDTO(order);

        assertThat(orderDTO).isEqualToComparingFieldByField(mappedAgainObject);
    }
}