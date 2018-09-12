export interface SimplifiedOrder {
  'id': number;
  'data_publikacji_zamowienia': Date;
  'nazwa': String;
  'termin': String;
  'zamowienia_publiczne_tryby.nazwa': String;
  'zamowienia_publiczne_typy.nazwa': String;
  'wartosc_cena_max': number;
  'wartosc_cena_min': number;
  'wartosc_szacowana': number;
  'rodzaje_nazwa': String;
}
