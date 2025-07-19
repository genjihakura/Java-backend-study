package vn.vti.dtn2501.mall.payload.request;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class CreateProductRequest {
    private String name;
    private String description;
    private BigDecimal price;
    private String brand;
}
