package vn.vti.dtn2501.mall.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.vti.dtn2501.mall.entity.CartItem;

import java.util.List;
import java.util.Optional;

public interface CartItemRepository extends JpaRepository<CartItem, Long> {
    List<CartItem> findAllByCartId(Long cartId);
    Optional<CartItem> findByCartIdAndProductId(Long cartId, Long productId);
    void deleteAllByCartId(Long cartId);
}
