package com.vti.bep3.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

// đặt hàng của khách hàng
@Data
@Table(name = "Customer_Order")
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class CustomerOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "Create_Date")
    private Date createdAt;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private CustomerOrderStatus status;
    public enum CustomerOrderStatus {
        NEW, CONFIRMED, COOKING, READY, DELIVERED, PAID
    }

    @Column(name = "total_price")
    private Double totalPrice;

    @PrePersist
    public void doCreate(){
        // hàm này được gọi khi có sự khi create
        this.createdAt = new Date();
    }

}
