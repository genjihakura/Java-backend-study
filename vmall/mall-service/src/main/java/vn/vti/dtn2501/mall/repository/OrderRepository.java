package vn.vti.dtn2501.mall.repository;

import jakarta.persistence.criteria.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import vn.vti.dtn2501.mall.entity.OrderUser;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;


public interface OrderRepository extends JpaRepository<OrderUser,Long> {
    List<OrderUser> findByUserId(Long userId);
}
