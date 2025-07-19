package vn.vti.dtn2501.mall.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="order_Users")
public class OrderUser {
    @Id
    @Column(name = "Id")
    private Long Id;

    @Column(name ="user_id")
    private Long userId;

    @Column(name = "cart_id")
    private Long cartId;

    @Column(name = "total_amount")
    private BigDecimal totalAmount;

    @Column(name = "shipping_address")
    private String shippingAddress;

    @Column(name = "payment_method")
    private String paymentMethod;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private Status status;
    public enum Status {
        CREATED, DELIVERY, RELEASED, CANCELED
    }

    @Column(name = "create_date")
    private Date createAT;

    @PrePersist
    public void doCreate(){
        // Hàm này được gọi khi có sự kiện thêm mới xảy ra
        this.createAT = new Date();
    }

}
