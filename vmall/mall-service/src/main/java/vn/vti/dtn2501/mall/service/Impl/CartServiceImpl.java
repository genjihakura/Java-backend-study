package vn.vti.dtn2501.mall.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import vn.vti.dtn2501.common.api.exeption.VMallException;
import vn.vti.dtn2501.mall.entity.Cart;
import vn.vti.dtn2501.mall.exception.ExceptionEnum;
import vn.vti.dtn2501.mall.payload.request.CreateCartRequest;
import vn.vti.dtn2501.mall.payload.request.UpdateCartRequest;
import vn.vti.dtn2501.mall.payload.response.CreateCartResponse;
import vn.vti.dtn2501.mall.payload.response.UpdateCartResponse;
import vn.vti.dtn2501.mall.repository.CartRepository;
import vn.vti.dtn2501.mall.service.ICartService;

import java.math.BigDecimal;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CartServiceImpl implements ICartService {

    private final CartRepository cartRepository;

    @Override
    public Cart getActiveCart(Long id ) {
       Optional<Cart> optional = cartRepository.findByIdAndStatus(id,Cart.Status.ACTIVE);

       if(optional.isEmpty()){
           throw new VMallException(ExceptionEnum.CART_NO_EXISTS);
       }
       return optional.get();
    }

    @Override
    public CreateCartResponse createCart(CreateCartRequest request ) {
        Optional<Cart> optional = cartRepository.findByUserIdAndStatus(request.getUserId(),Cart.Status.ACTIVE);

        if(optional.isPresent()){
            throw new VMallException(ExceptionEnum.CART_EXISTS);
        }

        Cart cart = new Cart();
        cart.setUserId(request.getUserId());
        cart.setStatus(Cart.Status.ACTIVE);
        Cart saveCart = cartRepository.save(cart);
        return new CreateCartResponse(saveCart.getId(),saveCart.getStatus());
    }

    @Override
    public void markCartAsCheckedOut(Long id) {
        Optional<Cart> optional = cartRepository.findByUserIdAndStatus(id,Cart.Status.ACTIVE);

        if(optional.isEmpty()){
            throw new VMallException(ExceptionEnum.CART_NO_EXISTS);
        }

        Cart cart = optional.get();
        cart.setStatus(Cart.Status.CHECK_OUT);
        cartRepository.save(cart);
    }

    @Override
    public void markCartAsUnCheckedOut(Long id) {
        Optional<Cart> optional = cartRepository.findByUserIdAndStatus(id,Cart.Status.ACTIVE);

        if(optional.isEmpty()){
            throw new VMallException(ExceptionEnum.CART_NO_EXISTS);
        }

        Cart cart = optional.get();
        cart.setStatus(Cart.Status.UNCHECKED);
        cartRepository.save(cart);
    }

    @Override
    public BigDecimal getTotalPrice(Long id) {
        return null;
    }

    @Override
    public UpdateCartResponse updateCart(UpdateCartRequest request) {
        return null;
    }

    @Override
    public UpdateCartResponse deleteCart(Long id) {
        return null;
    }
}
