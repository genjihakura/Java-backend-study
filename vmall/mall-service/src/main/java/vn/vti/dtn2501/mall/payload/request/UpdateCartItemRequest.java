package vn.vti.dtn2501.mall.payload.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateCartItemRequest {
    private Long itemId;
    private Long quantity;
}
