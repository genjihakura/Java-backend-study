package vn.vti.dtn2501.mall.payload.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreatCartResponse {
    private Long id;
    private Long userId;
    private String status;
}
