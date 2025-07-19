package vn.vti.dtn2501.mall.service;

import vn.vti.dtn2501.mall.entity.ProductCategory;
import vn.vti.dtn2501.mall.payload.request.CreateProductCategoryRequest;
import vn.vti.dtn2501.mall.payload.request.UpdateProductCategoryRequest;
import vn.vti.dtn2501.mall.payload.response.CreateProductCategoryResponse;
import vn.vti.dtn2501.mall.payload.response.UpdateProductCategoryResponse;

import java.util.List;

public interface IProductCategoryService {
  List<ProductCategory> getAllProductCategory();
  ProductCategory getProductCategoryByName(String name);
  CreateProductCategoryResponse create(CreateProductCategoryRequest request);
  UpdateProductCategoryResponse update(UpdateProductCategoryRequest request);
  UpdateProductCategoryResponse delete(long id);
}
