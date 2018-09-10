package pl.edu.agh.tai.dbmodel.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.edu.agh.tai.dbmodel.entity.DocumentType;
import pl.edu.agh.tai.dbmodel.entity.Order;
import pl.edu.agh.tai.dbmodel.entity.OrderKind;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
     Order findFirstByRestId(Long restId);

     Page <Order> findByDataPublikacjiAfter(LocalDate startDate, Pageable pageable);

     Page <Order> findByDataPublikacjiBefore(LocalDate finishDate, Pageable pageable);

     Page <Order> findByDataPublikacjiAfterAndDataPublikacjiBefore(LocalDate startDate, LocalDate finishDate, Pageable pageable);

     @Query("select o from Order o where o.dataPublikacji > ?1 and o.dataPublikacji < ?2 and o.wojewodztwoId in ?3  " +
             "and o.trybId in ?4 and o.documentType in  ?5 and o.orderKind in ?6")
     List<Order> searchByParameters(LocalDate startDate, LocalDate finishDate, List<String> voivodshipId, List<String> orderModeId,
                                    List<DocumentType> orderType, List<OrderKind> orderKind, Pageable pageable);

}
