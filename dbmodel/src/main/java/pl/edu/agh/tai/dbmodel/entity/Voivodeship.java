package pl.edu.agh.tai.dbmodel.entity;

//TODO Consider whether it should be enum or entity class
public enum Voivodeship {

    LOWER_SILESIA(1, "dolnośląskie"),
    KUYAVIA_POMERANIA(2, "kujawsko-pomorskie"),
    LUBLIN(3, "lubelskie"),
    LUBUSZ(4, "lubuskie"),
    LODZ(5, "łódzkie"),
    LESSER_POLAND(6, "małopolskie"),
    MASOVIA(7, "mazowieckie"),
    OPOLE(8, "opolskie"),
    SUBCARPATHIA(9, "podkarpackie"),
    PODLASKIE(10, "podlaskie"),
    POMERANIA(11, "pomorskie"),
    SILESIA(12, "śląskie"),
    HOLY_CROSS_PROVINCE(13, "świętokrzyskie"),
    WARMIA_MASURIA(14, "warmińsko-mazurskie"),
    GREATER_POLAND(15, "wielkopolskie"),
    WEST_POMERANIA(16, "zachodniopomorskie");

    private int id;
    private String name;

    Voivodeship(int id, String name) {
        this.id = id;
        this.name = name;
    }
}
