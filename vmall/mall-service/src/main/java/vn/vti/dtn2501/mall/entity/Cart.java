package vn.vti.dtn2501.mall.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="cart")
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "Status")
    @Enumerated(EnumType.STRING)
    private Status status;
    public enum Status {
        ACTIVE, IN_ACTIVE,CHECK_OUT,UNCHECKED
    }

    @Column(name = "create_at")
    private Date createAt;

    @PrePersist
    public void doCreate(){
        // Hàm này được gọi khi có sự kiện thêm mới xảy ra
        this.createAt = new Date();
    }

}
