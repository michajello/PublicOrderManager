package pl.edu.agh.tai.dbmodel.entity;

import lombok.Getter;

@Getter
public enum OrderType {
    ANNOUNCEMENT_ABOUT_ORDER("ZP-400", 1, "Ogłoszenie o zamówieniu"),
    SIMPLIFIED_ANNOUNCEMENT("ZP-401", 2, "Uproszczone ogłoszenie"),
    AWARD_OF_THE_CONTRACT(null, 3, "Udzielenie zamówienia"),
    ANNOUNCEMENT_OF_THE_COMPETITION(null, 4, "Ogłoszenie konkursu"),
    ANNOUNCEMENT_OF_THE_COMPETITION_RESULTS(null, 5, "Ogłoszenie wyników konkursu"),
    CHANGE_OF_THE_ANNOUNCEMENT(null, 6, "Zmiana ogłoszenia"),
    INTENTION_TO_AWARD_A_CONTRACT("ZP-408", 7, "Zamiar zawarcia umowy");


    private final String symbol;
    private final int id;
    private final String name;

    OrderType(String symbol, int id, String name) {
        this.symbol = symbol;
        this.id = id;
        this.name = name;
    }
}
