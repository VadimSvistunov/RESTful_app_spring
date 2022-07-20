package by.svistunovvv.restfullApp.repository;

import by.svistunovvv.restfullApp.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
