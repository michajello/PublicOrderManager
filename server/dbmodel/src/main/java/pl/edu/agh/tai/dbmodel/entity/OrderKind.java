package pl.edu.agh.tai.dbmodel.entity;

import lombok.Getter;

@Getter
public enum OrderKind {
    CONSTRUCTION_WORKS(1, "Roboty budowlane"),
    SERVICES(2, "Usługi");


    private final int id;
    private final String name;

    public static OrderKind get(int id){
        for (OrderKind orderKind : OrderKind.values()){
            if (orderKind.id == id){
                return orderKind;
            }
        }
        return null;
    }

    OrderKind(int id, String name) {
        this.id = id;
        this.name = name;
    }
}
