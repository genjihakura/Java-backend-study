package vn.vti.dtn2501.mall.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.vti.dtn2501.common.api.response.ApiResponse;
import vn.vti.dtn2501.mall.entity.ProductCategory;
import vn.vti.dtn2501.mall.payload.request.CreateProductCategoryRequest;
import vn.vti.dtn2501.mall.payload.request.UpdateProductCategoryRequest;
import vn.vti.dtn2501.mall.payload.response.CreateProductCategoryResponse;
import vn.vti.dtn2501.mall.payload.response.UpdateProductCategoryResponse;
import vn.vti.dtn2501.mall.service.IProductCategoryService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/categories")
@RequiredArgsConstructor
public class ProductCategoryController {

  private final IProductCategoryService productCategoryService;

  @GetMapping
  ResponseEntity<ApiResponse<List<ProductCategory>>> getAllProductCategories() {
    return new ResponseEntity<>(ApiResponse.success(productCategoryService.getAllProductCategory()), HttpStatus.OK);
  }

  @GetMapping("/id")
  ResponseEntity<ApiResponse<ProductCategory>> getProductCategoryByName(@RequestParam String name) {
    return new ResponseEntity<>(ApiResponse.success(productCategoryService.getProductCategoryByName(name)), HttpStatus.OK);
  }

  @PostMapping
  public ResponseEntity<ApiResponse<CreateProductCategoryResponse>> create(
      @RequestBody CreateProductCategoryRequest request) {
    return new ResponseEntity<>(ApiResponse.success(productCategoryService.create(request)),
        HttpStatus.CREATED);
  }

  @PutMapping
  public ResponseEntity<ApiResponse<UpdateProductCategoryResponse>> update(
          @RequestBody UpdateProductCategoryRequest request) {
    return new ResponseEntity<>(ApiResponse.success(productCategoryService.update(request)),
            HttpStatus.OK);
  }

  @DeleteMapping
  public ResponseEntity<ApiResponse<UpdateProductCategoryResponse>> delete(
          @RequestBody UpdateProductCategoryRequest request) {
    return new ResponseEntity<>(ApiResponse.success(productCategoryService.delete(request.getId())),
            HttpStatus.OK);
  }

}
