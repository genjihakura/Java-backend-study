package vn.vti.dtn2501.mall.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.vti.dtn2501.common.api.response.ApiResponse;
import vn.vti.dtn2501.mall.entity.Cart;
import vn.vti.dtn2501.mall.payload.request.UpdateCartRequest;
import vn.vti.dtn2501.mall.payload.response.CreatCartResponse;
import vn.vti.dtn2501.mall.payload.response.CreateCartResponse;
import vn.vti.dtn2501.mall.payload.response.UpdateCartResponse;
import vn.vti.dtn2501.mall.service.ICartService;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/carts")
public class CartController {

    private final ICartService cartService;

    @GetMapping("/user/{userId}")
    public ResponseEntity<ApiResponse<CreateCartResponse>> getCartByUserId(@PathVariable Long userId){
        Cart cart = cartService.getActiveCart(userId);
        CreateCartResponse createCartResponse = new CreateCartResponse();
        createCartResponse.setUserId(userId);
        createCartResponse.setStatus(cart.getStatus());
        return new ResponseEntity<>(ApiResponse.success(createCartResponse), HttpStatus.CREATED);
    }

    @DeleteMapping("/{cartId}")
    public ResponseEntity<ApiResponse> clearCart( @PathVariable Long cartId){
        return null;
    }

    @PutMapping("/{cartId}/status")
    public ResponseEntity<ApiResponse<UpdateCartResponse>> updateCartStatus(@RequestBody UpdateCartRequest request) {
        UpdateCartResponse updated = cartService.updateCart(request);
        return new ResponseEntity<>(ApiResponse.success(updated), HttpStatus.OK);
    }
}
