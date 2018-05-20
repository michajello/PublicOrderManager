package pl.edu.agh.tai.dbmodel.entity;

public enum OrderType {
    ANNOUNCEMENT_ABOUT_ORDER("ZP-400", 1, "Ogłoszenie o zamówieniu");

    private String symbol;
    private int id;
    private String name;

    private OrderType(String symbol, int id, String name) {
        this.symbol = symbol;
        this.id = id;
        this.name = name;
    }
}
