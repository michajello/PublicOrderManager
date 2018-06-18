package pl.edu.agh.tai.dbmodel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.edu.agh.tai.dbmodel.entity.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
     Order findFirstByRestId(Long restId);
}
