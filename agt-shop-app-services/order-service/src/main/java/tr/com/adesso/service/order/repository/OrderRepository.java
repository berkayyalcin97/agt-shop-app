package tr.com.adesso.service.order.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tr.com.adesso.service.order.model.Order;

import java.util.UUID;

public interface OrderRepository extends JpaRepository<Order, UUID> {
}
