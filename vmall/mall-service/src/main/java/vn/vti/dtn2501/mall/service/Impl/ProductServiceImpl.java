package vn.vti.dtn2501.mall.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import vn.vti.dtn2501.common.api.exeption.VMallException;
import vn.vti.dtn2501.mall.entity.Product;
import vn.vti.dtn2501.mall.payload.request.CreateProductRequest;
import vn.vti.dtn2501.mall.payload.request.UpdateProductRequest;
import vn.vti.dtn2501.mall.exception.ExceptionEnum;
import vn.vti.dtn2501.mall.payload.response.CreateProductResponse;
import vn.vti.dtn2501.mall.payload.response.UpdateProductResponse;
import vn.vti.dtn2501.mall.repository.ProductRepository;
import vn.vti.dtn2501.mall.service.IProductService;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class ProductServiceImpl implements IProductService {

    private final ProductRepository productRepository;

    @Override
    public CreateProductResponse addProduct(CreateProductRequest request) {
        Optional<Product> optional = productRepository.findByName(request.getName());
        if(optional.isPresent()){
            throw new VMallException(ExceptionEnum.PRODUCT_NAME_EXISTS);
        }
        Product product = new Product();
        product.setName(request.getName());
        product.setDescription(request.getDescription());
        product.setPrice(request.getPrice());
        product.setBrand(request.getBrand());

        Product productSave = productRepository.save(product);
        return new CreateProductResponse(productSave.getName());
    }

    @Override
    public UpdateProductResponse updateProduct(UpdateProductRequest request) {
        Optional<Product> optional = productRepository.findById(request.getId());
        if(optional.isEmpty()){
            throw new VMallException(ExceptionEnum.PRODUCT_NAME_NOT_FIND);
        }
        Product enity = optional.get();
        enity.setName(request.getName());
        enity.setDescription(request.getDescription());
        enity.setPrice(request.getPrice());
        enity.setBrand(request.getBrand());
        Product productSave = productRepository.save(enity);
        return new UpdateProductResponse(productSave.getName(),productSave.getPrice(),productSave.getBrand());
    }

    @Override
    public Product getProductById(Long id) {
       Optional<Product> optional = productRepository.findById(id);
       if(optional.isEmpty()){
           throw new VMallException(ExceptionEnum.PRODUCT_NAME_NOT_FIND);
       }
       return optional.get();
    }

    @Override
    public UpdateProductResponse deleteProductById(Long id) {
        Optional<Product> optional = productRepository.findById(id);
        if(optional.isEmpty()){
            throw new VMallException(ExceptionEnum.PRODUCT_NAME_NOT_FIND);
        }
        Product enity = optional.get();
        Product deleteEnity = new Product();
        deleteEnity.setName(enity.getName());
        deleteEnity.setPrice(enity.getPrice());
        deleteEnity.setBrand(enity.getBrand());
        productRepository.deleteById(enity.getId());
        return new UpdateProductResponse(deleteEnity.getName(),deleteEnity.getPrice(),deleteEnity.getBrand());
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }


    @Override
    public List<Product> getProductsByBrand(String brand) {
        return productRepository.findByBrand(brand);
    }

    @Override
    public Product getProductsByName(String name) {
        Optional<Product> optional = productRepository.findByName(name);
        if(optional.isEmpty()){
            throw new VMallException(ExceptionEnum.PRODUCT_NAME_NOT_FIND);
        }
        return optional.get();
    }

    @Override
    public Product decreaseStock(Long productId, Long quantity){
        Product product = getProductById(productId);
        if (product.getInventory() < quantity) {
            throw new VMallException((ExceptionEnum.INVENTORY_IS_NOT_ENOUGH));
        }
        product.setInventory(product.getInventory() - quantity);
        return productRepository.save(product);
    }
}
