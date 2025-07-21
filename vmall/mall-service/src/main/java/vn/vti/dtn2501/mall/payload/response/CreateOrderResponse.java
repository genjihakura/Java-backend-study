package vn.vti.dtn2501.mall.payload.response;

import jakarta.persistence.PrePersist;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import vn.vti.dtn2501.mall.entity.OrderUser;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateOrderResponse {
    private Long userId;
    private Long cartId;
    private Double totalAmount;
    private String shippingAddress;
    private String paymentMethod;
    private OrderUser.Status status;
    private Date createdAt;

    @PrePersist
    public void doCreateDate(){
        this.createdAt = new Date();
    }
}
