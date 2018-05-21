package pl.edu.agh.tai.dbmodel.entity;

import lombok.Getter;

@Getter
public enum OrderKind {
    CONSTRUCTION_WORKS(1, "Prace budowlane"),
    SERVICES(2, "Usługi");


    private final int id;
    private final String name;

    OrderKind(int id, String name) {
        this.id = id;
        this.name = name;
    }
}
