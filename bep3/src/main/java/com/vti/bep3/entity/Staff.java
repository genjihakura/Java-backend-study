package com.vti.bep3.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.Date;

// nhân viên
@Data
@Table(name = "Staff")
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Staff {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "Fullname")
    private String Fullname;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "Role")
    @Enumerated(EnumType.STRING)
    private Role role;
    public enum Role implements GrantedAuthority {
        ADMIN, EMPLOYEE;

        @Override
        public String getAuthority() {
            return null;
        }
    }

    @Column(name = "Status")
    @Enumerated(EnumType.STRING)
    private Status Status;
    public enum Status {
        ACTIVE, IN_ACTIVE
    }

    @Column(name = "NOTE")
    private String note;

    @Column(name = "userName")
    private String userName;

    @Column(name = "password")
    private String password;

    @Column(name = "Create_Date")
    private Date createDate;

    @Column(name = "Update_Date")
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
