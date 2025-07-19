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
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="name")
    private String name;

    @Column(name="brand")
    private String brand;

    @Column(name="price")
    private BigDecimal price;

    @Column(name="inventory")
    private Long inventory;

    @Column(name="description")
    private String description;

    @Column(name="create_date")
    private Date createDate;

    @Column(name="update_date")
    private Date updateDate;

    @PrePersist
    public void doCreate(){
        // Hàm này được gọi khi có sự kiện thêm mới xảy ra
        this.createDate = new Date();
    }

    @PreUpdate
    public void doUpdate(){
        // Hàm này được gọi khi có sự kiện update xảy ra
        this.updateDate = new Date();
    }

}
