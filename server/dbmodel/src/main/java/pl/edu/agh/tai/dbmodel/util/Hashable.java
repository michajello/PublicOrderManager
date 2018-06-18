package pl.edu.agh.tai.dbmodel.util;


public interface Hashable {

    String [] getItemsUsedInHash();

    String getHash();

    void setHash(String newHash);

}
