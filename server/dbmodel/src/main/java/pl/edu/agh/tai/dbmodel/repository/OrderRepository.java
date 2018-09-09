package pl.edu.agh.tai.dbmodel.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.edu.agh.tai.dbmodel.entity.Order;

import java.time.LocalDate;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
     Order findFirstByRestId(Long restId);

     Page <Order> findByDataPublikacjiAfter(LocalDate startDate, Pageable pageable);

     Page <Order> findByDataPublikacjiBefore(LocalDate finishDate, Pageable pageable);

     Page <Order> findByDataPublikacjiAfterAndDataPublikacjiBefore(LocalDate startDate, LocalDate finishDate, Pageable pageable);
}
