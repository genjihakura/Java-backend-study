package vn.vti.dtn2501.mall.service;

import vn.vti.dtn2501.mall.entity.CartItem;
import vn.vti.dtn2501.mall.payload.request.CreateCartItemRequest;
import vn.vti.dtn2501.mall.payload.request.UpdateCartItemRequest;
import vn.vti.dtn2501.mall.payload.response.CreateCartItemResponse;

import java.util.List;

public interface ICartItemService {
    CreateCartItemResponse addItemToCart(CreateCartItemRequest request);
    void removeItem(Long itemId);
    List<CartItem> getItemsByCartId(Long cartId);
    CartItem updateQuantity(UpdateCartItemRequest request);
    void clearCart(Long cartId);
}
