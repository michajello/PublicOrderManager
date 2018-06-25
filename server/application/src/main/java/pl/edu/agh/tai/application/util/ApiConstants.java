package pl.edu.agh.tai.application.util;

public class ApiConstants {

    public static final String DATA_SERVER_ADDRESS = "https://api-v3.mojepanstwo.pl/dane/zamowienia_publiczne.json?page=1&limit=1000";

    public static final String ORDERS = "/orders";

    public static final String PAGE_VAR = "page";

    public static final String SIZE_VAR = "size";

//    public static final String PAGE_SIZE_PARAMS =  String.format("?/{%s}/{%s}",  PAGE_VAR , SIZE_VAR ) ;

    public static final String ORDERS_PAGE_SIZE =  ORDERS;

    private ApiConstants() {}

}
