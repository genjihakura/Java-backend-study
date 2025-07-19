package vn.vti.dtn2501.mall.repository;

import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.vti.dtn2501.mall.entity.Product;

import java.util.List;
import java.util.Optional;

@Repository

public interface ProductRepository extends JpaRepository<Product,Long> {
    Optional<Product> findById(Long id);
    List<Product> findByBrand(String brand);
    Optional<Product> findByName(String name);
    List<Product> findByBrandAndName(String brand, String name);
    Long countByBrandAndName(String brand, String name);
}
