package vn.vti.dtn2501.mall.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.vti.dtn2501.mall.entity.Cart;
import vn.vti.dtn2501.mall.entity.OrderUser;

import java.util.Optional;

public interface CartRepository extends JpaRepository<Cart,Long> {
    Optional<Cart> findByIdAndStatus(Long id, Cart.Status  status);

    Optional<Cart> findByUserIdAndStatus(Long userId, Cart.Status  status);
}
