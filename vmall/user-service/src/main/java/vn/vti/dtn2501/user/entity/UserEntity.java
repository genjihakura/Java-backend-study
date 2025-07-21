package vn.vti.dtn2501.user.entity;


import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "user")
public class UserEntity extends BaseEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "name")
  private String name;
  @Column(name = "username")
  private String username;
  @Column(name = "password")
  private String password;
  @Column(name = "email")
  private String email;
  @Column(name = "phone")
  private String phone;
  @Column(name = "address")
  private String address;

}
