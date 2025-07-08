package vn.vti.dtn2501.mall.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vn.vti.dtn2501.mall.entity.ProductCategory;
import vn.vti.dtn2501.mall.service.IProductCategoryService;

@RestController
@RequestMapping("/api/v1/categories")
@RequiredArgsConstructor
public class ProductCategoryController {

    private final IProductCategoryService productCategoryService;

    @PostMapping()
    public ResponseEntity<ProductCategory> create(@RequestBody ProductCategory productCategory){
        return new ResponseEntity<ProductCategory>(productCategoryService.create(productCategory), HttpStatus.CREATED);
    }
}
