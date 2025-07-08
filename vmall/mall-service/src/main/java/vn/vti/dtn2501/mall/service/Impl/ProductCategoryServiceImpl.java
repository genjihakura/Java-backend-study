package vn.vti.dtn2501.mall.service.Impl;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import vn.vti.dtn2501.mall.entity.ProductCategory;
import vn.vti.dtn2501.mall.repository.ProductCategoryRepository;
import vn.vti.dtn2501.mall.service.IProductCategoryService;

import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class ProductCategoryServiceImpl implements IProductCategoryService {
    private final ProductCategoryRepository categoryRepo;

    @Override
    public ProductCategory create(ProductCategory productCategory) {
        log.info("create ProductCategory: [{}]", productCategory);
        //TODO logic kiem tra tinh hop le ve thuan phong my tuc cho ten cua category
        Optional<ProductCategory> entity = categoryRepo.findByCategoryName(productCategory.getCategoryName());
        if(entity.isPresent()){
            throw new RuntimeException();
        }
        categoryRepo.save(productCategory);
        return productCategory;
    }
}
