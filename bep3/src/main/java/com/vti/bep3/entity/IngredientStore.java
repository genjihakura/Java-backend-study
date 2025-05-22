package com.vti.bep3.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

// kho hàng
@Data
@Table(name = "Ingredient")
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class IngredientStore {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "create_date")
    private Date createDate;

    @Column(name = "update_date")
    private Date updateDate;

    @Column(name = "name")
    private String name;

    @Column(name = "quantity_In_Stock", columnDefinition = "DOUBLE", precision = 10 , scale = 2)
    private Double quantityInStock;

    @Column(name = "unit")
    private String unit;

    @PrePersist
    public void doCreate(){
        // hàm này được gọi khi có sự khi create
        this.createDate = new Date();
    }

    @PreUpdate
    public void deUpdate(){
        // hàm này được gọi khi có sự khi update
        this.updateDate = new Date();
    }

}
