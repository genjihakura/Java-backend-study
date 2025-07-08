package vn.vti.dtn2501.mall.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.vti.dtn2501.mall.entity.ProductCategory;

import java.util.Optional;

public interface ProductCategoryRepository extends JpaRepository<ProductCategory,Long> {
    Optional<ProductCategory> findByCategoryName(String name);
}
