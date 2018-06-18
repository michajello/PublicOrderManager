package pl.edu.agh.tai.dbmodel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.edu.agh.tai.dbmodel.entity.Orderer;

@Repository
public interface OrdererRepository extends JpaRepository<Orderer, Long> {

}
