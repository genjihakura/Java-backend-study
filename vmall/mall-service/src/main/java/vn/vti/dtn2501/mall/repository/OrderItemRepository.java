package vn.vti.dtn2501.mall.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.vti.dtn2501.mall.entity.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
}
