package vn.vti.dtn2501.mall.service;

import vn.vti.dtn2501.mall.entity.Cart;
import vn.vti.dtn2501.mall.payload.request.CreateCartRequest;
import vn.vti.dtn2501.mall.payload.request.UpdateCartRequest;
import vn.vti.dtn2501.mall.payload.response.CreateCartResponse;
import vn.vti.dtn2501.mall.payload.response.UpdateCartResponse;

import java.math.BigDecimal;

public interface ICartService {
    Cart getActiveCart(Long id);
    CreateCartResponse createCart(CreateCartRequest cart);
    void markCartAsCheckedOut(Long id);
    void markCartAsUnCheckedOut(Long id);
    BigDecimal getTotalPrice(Long id);
    UpdateCartResponse updateCart(UpdateCartRequest request);
    UpdateCartResponse deleteCart(Long id);
}
