package uz.trading.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.trading.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
