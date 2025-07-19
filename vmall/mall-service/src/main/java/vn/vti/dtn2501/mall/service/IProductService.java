package vn.vti.dtn2501.mall.service;

import vn.vti.dtn2501.mall.entity.Product;
import vn.vti.dtn2501.mall.payload.request.CreateProductRequest;
import vn.vti.dtn2501.mall.payload.request.UpdateProductRequest;
import vn.vti.dtn2501.mall.payload.response.CreateProductResponse;
import vn.vti.dtn2501.mall.payload.response.UpdateProductResponse;

import java.util.List;

public interface IProductService {
    CreateProductResponse addProduct(CreateProductRequest request );
    Product getProductById(Long id);
    UpdateProductResponse deleteProductById(Long id);
    UpdateProductResponse updateProduct(UpdateProductRequest request);
    List<Product> getAllProducts();
    List<Product> getProductsByBrand(String brand);
    Product getProductsByName(String name);
    Product decreaseStock(Long productId, Long quantity);
}
