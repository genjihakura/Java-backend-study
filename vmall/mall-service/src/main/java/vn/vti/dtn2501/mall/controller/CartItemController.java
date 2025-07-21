package vn.vti.dtn2501.mall.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.vti.dtn2501.common.api.response.ApiResponse;
import vn.vti.dtn2501.mall.entity.CartItem;
import vn.vti.dtn2501.mall.payload.request.CreateCartItemRequest;
import vn.vti.dtn2501.mall.payload.request.UpdateCartItemRequest;
import vn.vti.dtn2501.mall.payload.response.CreateCartItemResponse;
import vn.vti.dtn2501.mall.payload.response.UpdateCartItemResponse;
import vn.vti.dtn2501.mall.service.ICartItemService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/cartItems")
public class CartItemController {
    private  final ICartItemService cartItemService;

    @GetMapping("/{cartId}")
    public ResponseEntity<ApiResponse<List<CartItem>>>  getCartItemById(@PathVariable Long cartId){
        return new ResponseEntity<>(ApiResponse.success(cartItemService.getItemsByCartId(cartId)),HttpStatus.OK);
    }

    @PostMapping("/item/add")
    public ResponseEntity<ApiResponse<CreateCartItemResponse>> addItemToCart(@RequestBody CreateCartItemRequest createCartItemRequest) {
        return new ResponseEntity<>(ApiResponse.success(cartItemService.addItemToCart(createCartItemRequest)), HttpStatus.CREATED);
    }

    @DeleteMapping("/cart/{cartId}/remove")
    public ResponseEntity<Void> removeItemFromCart(@PathVariable Long cartId){
        cartItemService.removeItem(cartId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/cart/{cartId}/item/{itemId}/update")
    public  ResponseEntity<ApiResponse<UpdateCartItemResponse>> updateItemQuantity(@RequestBody UpdateCartItemRequest request){
        return new ResponseEntity<>(ApiResponse.success(cartItemService.updateQuantity(request)),HttpStatus.OK) ;
    }
}
