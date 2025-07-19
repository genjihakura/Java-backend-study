package vn.vti.dtn2501.user.entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@MappedSuperclass
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Setter
public class BaseEntity {

  //  private Instant createdAt;
//  private Instant updatedAt;
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
}
