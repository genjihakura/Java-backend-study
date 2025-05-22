package com.vti.bep3.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
// giở hàng: món ăn và số lượng
@Data
@Table(name = "OrderItem")
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "order_Id")
    private Integer orderId;

    @Column(name = "menu_item_id")
    private Integer menuItemId;

    @Column(name = "quantity")
    private Integer quantity;
}
