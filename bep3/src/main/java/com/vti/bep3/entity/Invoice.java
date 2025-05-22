package com.vti.bep3.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
// hóa đơn
@Table(name ="Invoice")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Invoice {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "order_Id")
    private Integer orderId;

    @Column(name = "total_Amount")
    private Double totalAmount;

    @Column(name = "payment_Date")
    private Date paymentDate;
}
