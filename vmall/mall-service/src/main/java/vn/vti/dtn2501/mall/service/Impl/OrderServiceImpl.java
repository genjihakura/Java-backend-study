package vn.vti.dtn2501.mall.service.impl;


import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import vn.vti.dtn2501.common.api.exeption.VMallException;
import vn.vti.dtn2501.mall.client.NotificationClient;
import vn.vti.dtn2501.mall.entity.Cart;
import vn.vti.dtn2501.mall.entity.CartItem;
import vn.vti.dtn2501.mall.entity.OrderItem;
import vn.vti.dtn2501.mall.entity.OrderUser;
import vn.vti.dtn2501.mall.entity.users.UserDto;
import vn.vti.dtn2501.mall.exception.ExceptionEnum;
import vn.vti.dtn2501.mall.payload.request.CreateOrderRequest;
import vn.vti.dtn2501.mall.payload.request.SendNotificationRequest;
import vn.vti.dtn2501.mall.payload.response.CreateOrderResponse;
import vn.vti.dtn2501.mall.repository.CartRepository;
import vn.vti.dtn2501.mall.repository.OrderItemRepository;
import vn.vti.dtn2501.mall.repository.OrderRepository;
import vn.vti.dtn2501.mall.service.ICartItemService;
import vn.vti.dtn2501.mall.service.ICartService;
import vn.vti.dtn2501.mall.service.IOrderService;
import vn.vti.dtn2501.mall.service.IProductService;
import vn.vti.dtn2501.queue.common.Producer;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements IOrderService {

    private final OrderRepository orderRepository;
    private final ICartService cartService;
    private final ICartItemService cartItemService;
    private final IProductService productService;
    private final OrderItemRepository orderItemRepository;
    private final CartRepository cartRepository;
    private final NotificationClient notificationClient;
    private final Producer<SendNotificationRequest> producer;
    @Value("${discountAmount}")
    private double discountAmount = 1;

    @Transactional
    @Override
    public CreateOrderResponse createOrder(CreateOrderRequest request) {
        Cart cart = cartService.getActiveCart(request.getUserId());
        if(cart == null){
            throw new VMallException(ExceptionEnum.CART_NO_EXISTS);
        }

        if (cart.getId() != request.getCartId()) {
            throw new VMallException(ExceptionEnum.INVALID_CART_ID);
        }

        // Lấy danh sách sản phẩm trong giỏ hàng request
        List<CartItem> cartItems = cartItemService.getItemsByCartId(request.getCartId());
        if (cartItems.isEmpty()) {
            throw new VMallException(ExceptionEnum.CART_ITEM_IS_EMPTY);
        }

//        // Tính tổng tiền cho đơn hàng
        Double totalAmount = 0.0;

        // Tạo đơn hàng mới
        OrderUser orderUser = new OrderUser();


        orderRepository.save(orderUser);

        // Lưu các sản phẩm vào order_items
        for (CartItem cartItem : cartItems) {
            OrderItem orderItem = new OrderItem();
            orderItem.setOrderId(orderUser.getId());
            orderItem.setProductId(cartItem.getProductId());
            orderItem.setProductName(cartItem.getProductName());
            orderItem.setProductPrice(cartItem.getProductPrice());
            orderItem.setQuantity(cartItem.getQuantity());
            // Lưu OrderItem
            orderItemRepository.save(orderItem);

            // Giảm stock của sản phẩm
            productService.decreaseStock(cartItem.getProductId(), cartItem.getQuantity());
            totalAmount = totalAmount +  cartItem.getProductPrice() * cartItem.getQuantity();
        }

        totalAmount = totalAmount * discountAmount;

        orderUser.setUserId(request.getUserId());
        orderUser.setCartId(request.getCartId());
        orderUser.setTotalAmount(totalAmount);
        orderUser.setPaymentMethod(request.getPaymentMethod());
        orderUser.setShippingAddress(request.getShippingAddress());
        orderUser.setStatus(OrderUser.Status.CREATED);

        // Sau khi tạo đơn hàng, xoá giỏ hàng (hoặc đánh dấu giỏ hàng là đã thanh toán)
        // cartService.markCartAsCheckedOut(request.getUserId());

        CreateOrderResponse createOrder = new CreateOrderResponse();
        createOrder.setCartId(orderUser.getCartId());
        createOrder.setUserId(orderUser.getUserId());
        createOrder.setTotalAmount(totalAmount);
        createOrder.setStatus(OrderUser.Status.CREATED);
        createOrder.setPaymentMethod(request.getPaymentMethod());
        createOrder.setShippingAddress(request.getShippingAddress());

        SendNotificationRequest sendNotificationRequest = new SendNotificationRequest();
        sendNotificationRequest.setTo(orderUser.getUserId().toString());
        sendNotificationRequest.setContent("!!!Dat hang thanh cong!!!");
        //notificationClient.sendNotification(sendNotificationRequest);
        producer.fire(sendNotificationRequest);
        return  createOrder;
    }

    @Override
    public OrderUser getOrderById(Long orderId) {
        return orderRepository.findById(orderId)
                .orElseThrow(() -> new RuntimeException("Order not found with id = " + orderId));
    }

    public List<OrderUser> getOrdersByUser(Long userId) {
        List<OrderUser> optional = orderRepository.findByUserId(userId);
        if(optional.isEmpty()){
            throw new VMallException(ExceptionEnum.ORDER_USER_EXISTS);
        }
        return optional;
    }

    @Override
    public OrderUser updateOrderStatus(Long orderId, String status) {
        OrderUser order = getOrderById(orderId);
        OrderUser.Status orderStatus = OrderUser.Status.valueOf(status);
        order.setStatus(orderStatus);
        return orderRepository.save(order);
    }
}
