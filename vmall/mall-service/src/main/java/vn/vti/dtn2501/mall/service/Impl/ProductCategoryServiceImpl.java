package vn.vti.dtn2501.mall.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import vn.vti.dtn2501.common.api.exeption.VMallException;
import vn.vti.dtn2501.mall.entity.ProductCategory;
import vn.vti.dtn2501.mall.exception.ExceptionEnum;
import vn.vti.dtn2501.mall.payload.request.CreateProductCategoryRequest;
import vn.vti.dtn2501.mall.payload.request.UpdateProductCategoryRequest;
import vn.vti.dtn2501.mall.payload.response.CreateProductCategoryResponse;
import vn.vti.dtn2501.mall.payload.response.UpdateProductCategoryResponse;
import vn.vti.dtn2501.mall.repository.ProductCategoryRepository;
import vn.vti.dtn2501.mall.service.IProductCategoryService;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class ProductCategoryServiceImpl implements IProductCategoryService {

  private final ProductCategoryRepository categoryRepo;

  @Override
  public List<ProductCategory> getAllProductCategory() {
    return categoryRepo.findAll();
  }

  @Override
  public ProductCategory getProductCategoryByName(String name) {
    Optional<ProductCategory> optional = categoryRepo.findByCategoryName(name);
    if(optional.isPresent()) {
      throw new VMallException(ExceptionEnum.CATEGORY_NAME_MUST_NOT_NULL_OR_EMPTY);
    }
    return optional.get();
  }

  @Override
  public CreateProductCategoryResponse create(CreateProductCategoryRequest request) {
    if (request.getCategoryName() == null || request.getCategoryName().isEmpty()) {
      throw new VMallException(ExceptionEnum.CATEGORY_NAME_MUST_NOT_NULL_OR_EMPTY);
    }
    log.info("Create ProductCategory: [{}]",
        request.getCategoryName());
    //TODO Logic kiem tra tinh hop le ve thuan phong my tuc cho ten cua category
    ProductCategory newCategory = new ProductCategory();
    newCategory.setCategoryName(request.getCategoryName());
    ProductCategory savedCategory = categoryRepo.save(newCategory);
    return new CreateProductCategoryResponse(savedCategory.getCategoryName());
  }

  @Override
  public UpdateProductCategoryResponse update(UpdateProductCategoryRequest request) {
    if (request.getCategoryName() == null || request.getCategoryName().isEmpty()) {
      throw new VMallException(ExceptionEnum.CATEGORY_NAME_MUST_NOT_NULL_OR_EMPTY);
    }
    log.info("update ProductCategory: [{}]",
            request.getCategoryName());
    //TODO Logic kiem tra tinh hop le ve thuan phong my tuc cho ten cua category
    Optional<ProductCategory> optional = categoryRepo.findById(request.getId());
    if(optional.isEmpty()) {
      throw new VMallException(ExceptionEnum.CATEGORY_NAME_EXIST);
    }
    ProductCategory  category = optional.get();
    category.setCategoryName(request.getCategoryName());
    ProductCategory savedCategory = categoryRepo.save(category);
    return new UpdateProductCategoryResponse(savedCategory.getCategoryName());
  }

  @Override
  public UpdateProductCategoryResponse delete(long id) {

    log.info("delete ProductCategory: [{}]",
            id);
    //TODO Logic kiem tra tinh hop le ve thuan phong my tuc cho ten cua category
    Optional<ProductCategory> optional = categoryRepo.findById(id);
    if(optional.isEmpty()) {
      throw new VMallException(ExceptionEnum.CATEGORY_NAME_EXIST);
    }
    ProductCategory  category = optional.get();
    category.setCategoryName(category.getCategoryName());
    categoryRepo.deleteById(id);
    return new UpdateProductCategoryResponse(category.getCategoryName());
  }
}
