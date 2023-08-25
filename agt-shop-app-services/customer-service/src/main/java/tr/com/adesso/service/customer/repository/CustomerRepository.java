package tr.com.adesso.service.customer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tr.com.adesso.service.customer.model.Customer;
import java.util.UUID;

public interface CustomerRepository extends JpaRepository<Customer, UUID> {

}
