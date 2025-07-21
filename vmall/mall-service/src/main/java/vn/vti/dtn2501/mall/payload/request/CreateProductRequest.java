package vn.vti.dtn2501.mall.payload.request;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class CreateProductRequest {
    private String name;
    private String description;
    private Double price;
    private String brand;
}
