package vn.vti.dtn2501.mall.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import vn.vti.dtn2501.common.api.exeption.VMallException;
import vn.vti.dtn2501.mall.entity.CartItem;
import vn.vti.dtn2501.mall.entity.Product;
import vn.vti.dtn2501.mall.exception.ExceptionEnum;
import vn.vti.dtn2501.mall.payload.request.CreateCartItemRequest;
import vn.vti.dtn2501.mall.payload.request.UpdateCartItemRequest;
import vn.vti.dtn2501.mall.payload.response.CreateCartItemResponse;
import vn.vti.dtn2501.mall.repository.CartItemRepository;
import vn.vti.dtn2501.mall.repository.ProductRepository;
import vn.vti.dtn2501.mall.service.ICartItemService;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CartItemServiceImpl implements ICartItemService {
    private final CartItemRepository cartItemRepository;
    private final ProductRepository productRepository;

    @Override
    public CreateCartItemResponse addItemToCart(CreateCartItemRequest request) {
        Optional<Product> opProduct = productRepository.findById(request.getProductId());
        if(opProduct.isEmpty()){
            throw new VMallException(ExceptionEnum.PRODUCT_NAME_NOT_FIND);
        }
        Product product = opProduct.get();
        Optional<CartItem> opCartItem = cartItemRepository.findByCartIdAndProductId(request.getCartId(),
                request.getProductId());

        if(opCartItem.isPresent()){
            CartItem cartItem = opCartItem.get();
            cartItem.setQuantity(cartItem.getQuantity() + request.getQuantity());
            CartItem saveCartItem = cartItemRepository.save(cartItem);
            return new CreateCartItemResponse(saveCartItem.getCartId(),saveCartItem.getProductId(),
                    saveCartItem.getProductName(),
            saveCartItem.getProductPrice(), saveCartItem.getQuantity());

        }
        CartItem cartItem = new CartItem();
        cartItem.setCartId(request.getCartId());
        cartItem.setProductId(request.getProductId());
        cartItem.setProductName(product.getName());
        cartItem.setProductPrice(product.getPrice());
        cartItem.setQuantity(request.getQuantity());
        CartItem saveCartItem = cartItemRepository.save(cartItem);

        return new CreateCartItemResponse(saveCartItem.getCartId(),saveCartItem.getProductId(),
                saveCartItem.getProductName(),
                saveCartItem.getProductPrice(), saveCartItem.getQuantity());
    }

    @Override
    public void removeItem(Long itemId) {
        cartItemRepository.deleteById(itemId);
    }

    @Override
    public List<CartItem> getItemsByCartId(Long cartId) {
        return cartItemRepository.findAllByCartId(cartId);
    }

    @Override
    public CartItem updateQuantity(UpdateCartItemRequest request) {
        CartItem item = cartItemRepository.findById(request.getItemId())
                .orElseThrow(() -> new RuntimeException("Cart item not found"));
        item.setQuantity(request.getQuantity());
        return cartItemRepository.save(item);
    }

    @Override
    public void clearCart(Long cartId) {
        cartItemRepository.deleteAllByCartId(cartId);
    }
}
