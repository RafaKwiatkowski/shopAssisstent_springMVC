package rafal.kwiatkowski.shopasssistent_springmvc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rafal.kwiatkowski.shopasssistent_springmvc.model.OrderTbl;

@Repository
public interface OrderRepository extends JpaRepository<OrderTbl, Integer> {
}
