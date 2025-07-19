package vn.vti.dtn2501.mall.payload.request;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class UpdateProductRequest {
    private Long id;
    private String name;
    private String description;
    private BigDecimal price;
    private int inventory;
    private String brand;
}
