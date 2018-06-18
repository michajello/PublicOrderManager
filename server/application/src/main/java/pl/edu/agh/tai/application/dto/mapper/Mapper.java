package pl.edu.agh.tai.application.dto.mapper;

import java.time.LocalDate;

public abstract class Mapper<D, T> {

    /**
     * Maps data access object to data transfer object.
     *
     * @param object
     * @return Mapped data transfer object
     */
    public abstract T mapToDTO(D object);


    /**
     * Maps data transfer object to data access object.
     *
     * @param object
     * @return Mapped data access object
     */
    public abstract D mapToDAO(T object);

    public abstract void mapToPersistedDAO(D dbObject, T dtoObject);


    protected Boolean parseBoolean(String s) {
        return s == null ? null : (s.equals("1") || s.toLowerCase().equals("true"));
    }

    protected String booleanToString(Boolean b) {
        if (b == null) {
            return null;
        }
        return b ? "1" : "0";
    }

    protected String localDateToString(LocalDate date) {
        return date == null ? null : date.toString();
    }

    protected LocalDate stringToLocalDate(String s) {
        if (s == null || s.equals("")) {
            return null;
        } else {
            return LocalDate.parse(s);
        }
    }
}
