package pl.edu.agh.tai.application.util;

public class ApiConstants {

public static final String DATA_SERVER_ADDRESS = "https://api-v3.mojepanstwo.pl/dane/zamowienia_publiczne.json?page=1&limit=1000";

    public static final String ORDERS = "/orders";

    public static final String PAGE_VAR = "page";

    public static final String SIZE_VAR = "size";

    public static final String START_DATE_VAR = "startDate";

    public static final String FINISH_DATE_VAR = "finishDate";

    public static final String VOIVODESHIP_VAR = "voivodeshipID";

    public static final String ORDER_MODE_VAR = "orderMode";

    public static final String ORDER_TYPE_VAR = "orderType" ;

    public static final String ORDER_KIND_VAR = "orderKind";

    public static final String MIN_ESTIMATED_PRICE_VAR = "minEstPrice";

    public static final String MAX_ESTIMATED_PRICE_VAR = "maxEstPrice";

    public static final int DEFAULT_ORDERS_PAGE_SIZE =  20;

    private ApiConstants() {}

}
