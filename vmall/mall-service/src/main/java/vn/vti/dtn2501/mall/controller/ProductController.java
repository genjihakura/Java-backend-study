package vn.vti.dtn2501.mall.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.vti.dtn2501.common.api.response.ApiResponse;
import vn.vti.dtn2501.mall.entity.Product;
import vn.vti.dtn2501.mall.payload.request.CreateProductRequest;
import vn.vti.dtn2501.mall.payload.request.UpdateProductRequest;
import vn.vti.dtn2501.mall.payload.response.CreateProductResponse;
import vn.vti.dtn2501.mall.payload.response.UpdateProductResponse;
import vn.vti.dtn2501.mall.service.IProductService;

import java.util.List;

@RestController
@RequestMapping("api/v1/products")
@RequiredArgsConstructor
public class ProductController {
    private final IProductService productService;

    @PostMapping
    public ResponseEntity<ApiResponse<CreateProductResponse>> createProduct(@RequestBody CreateProductRequest request){
        return new ResponseEntity<>(ApiResponse.success(productService.addProduct(request)),
                HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<Product>>> getAllProduct(){
        return new ResponseEntity<>(ApiResponse.success(productService.getAllProducts()), HttpStatus.OK);
    }

    @GetMapping("/id")
    public ResponseEntity<ApiResponse<Product>> getProductById(@RequestBody Long id){
        return new ResponseEntity<>(ApiResponse.success(productService.getProductById(id)), HttpStatus.OK);
    }

    @GetMapping("/name")
    public ResponseEntity<ApiResponse<Product>> getProductByName(@RequestParam String name){
        return new ResponseEntity<>(ApiResponse.success(productService.getProductsByName(name)), HttpStatus.OK);
    }

    @GetMapping("/brand")
    public ResponseEntity<ApiResponse<List<Product>>> getProductByBrand(@RequestBody String brandName){
        return new ResponseEntity<>(ApiResponse.success(productService.getProductsByBrand(brandName)), HttpStatus.OK);
    }
    @PutMapping
    public ResponseEntity<ApiResponse<UpdateProductResponse>> updateProduct(UpdateProductRequest request){
        return new ResponseEntity<>(ApiResponse.success(productService.updateProduct(request)), HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<ApiResponse<UpdateProductResponse>> deleteProductById(@RequestBody Long id){
        return new ResponseEntity<>(ApiResponse.success(productService.deleteProductById(id)),HttpStatus.OK);
    }
}
