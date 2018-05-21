package pl.edu.agh.tai.dbmodel.entity;

import lombok.Getter;

@Getter
public enum DocumentType {
    ANNOUNCEMENT_ABOUT_ORDER("ZP-400", 1, "Ogłoszenie o zamówieniu"),
    SIMPLIFIED_ANNOUNCEMENT("ZP-401", 2, "Uproszczone ogłoszenie"),
    AWARD_OF_THE_CONTRACT("ZP-403", 3, "Ogłoszenie o udzieleniu zamówienia"),
    ANNOUNCEMENT_OF_THE_COMPETITION(null, 4, "Ogłoszenie konkursu"),
    ANNOUNCEMENT_OF_THE_COMPETITION_RESULTS(null, 5, "Ogłoszenie wyników konkursu"),
    CHANGE_OF_THE_ANNOUNCEMENT(null, 6, "Zmiana ogłoszenia"),
    INTENTION_TO_AWARD_A_CONTRACT("ZP-408", 7, "Zamiar zawarcia umowy");

    public static DocumentType get(int id){
        for(DocumentType documentType : DocumentType.values()){
            if(documentType.id == id){
                return documentType;
            }
        }
        return null;
    }

    private final String symbol;
    private final int id;
    private final String name;

    DocumentType(String symbol, int id, String name) {
        this.symbol = symbol;
        this.id = id;
        this.name = name;
    }
}
