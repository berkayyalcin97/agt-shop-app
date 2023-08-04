package tr.com.adesso.service.product.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import tr.com.adesso.service.product.model.Product;

import java.util.UUID;

public interface ProductRepository extends JpaRepository<Product, UUID> {
}
