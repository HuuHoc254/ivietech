package repository;

import entity.Order;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order,Long> {
    @Query(value = "select * from orders where Month(orderDate) = Month(current_date());", nativeQuery = true)
    List<Order> findByCurrentMonth();
}
