package pl.edu.agh.tai.application.dto.mapper;

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
}
