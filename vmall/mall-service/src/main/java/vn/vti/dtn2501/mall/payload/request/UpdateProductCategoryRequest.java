package vn.vti.dtn2501.mall.payload.request;

import lombok.Data;

@Data
public class UpdateProductCategoryRequest {
    private Long id;
    private String CategoryName;
}