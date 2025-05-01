package com.vti.hello_world.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "DEPARTMENT")
@Entity
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @Column(name ="DEPARTMENT_NAME", length = 50, nullable = false)
    String departmentName;

    @Column(name = "CREATE_DATE")
    private Date createDate;

    @Column(name = "UPDATE_DATE")
    private Date updatDate;

    @PrePersist
    public void doCreate(){
        // hàm này được gọi khi có sự khi create
        this.createDate = new Date();
    }

    @PreUpdate
    public void deUpdate(){
        // hàm này được gọi khi có sự khi update
        this.updatDate = new Date();
    }
}
