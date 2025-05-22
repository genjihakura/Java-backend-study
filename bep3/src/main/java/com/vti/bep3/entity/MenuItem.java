package com.vti.bep3.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

// thực đơn của tiệm
@Table(name ="Menu_Item")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MenuItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "price")
    private Double price;

    @Column(name = "Description",length = 10000, nullable = false, unique = true)
    private String description;

    @Column(name = "ImageMenu",length = 1000)
    private String imageMenu;

    @Column(name = "create_Date")
    private Date createDate;

    @Column(name = "update_Date")
    private Date updateDate;

    @Column(name = "number_Available")
    private Integer numberAvailable;

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
