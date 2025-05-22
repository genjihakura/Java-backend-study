package com.vti.bep3.service.Impl;

import com.vti.bep3.dto.CustomerOrderCreateDto;
import com.vti.bep3.dto.CustomerOrderUpdateDto;
import com.vti.bep3.entity.*;
import com.vti.bep3.exception.LogicCustomException;
import com.vti.bep3.responsitory.*;
import com.vti.bep3.service.CustomerOrderService;
import lombok.AllArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CustomerOrderServiceImpl implements CustomerOrderService {

    private final CustomerOrderRepository customerOrderRepository;
    private final OrderItemRepository orderItemRepository;
    private final MenuItemRepository menuItemRepository;
    private final IngredientRepository inStoreRepository;
    private final IngredientUsageRepository ingredientUsage;

    @Override
    public List<CustomerOrder> getAllOrders() {
        return customerOrderRepository.findAll();
    }

    @Override
    public CustomerOrder create(CustomerOrderCreateDto  dto) {
        // Tạo mới đơn hàng
        CustomerOrder order = new CustomerOrder();
        order.setStatus(CustomerOrder.CustomerOrderStatus.NEW);
        CustomerOrder savedOrder = customerOrderRepository.save(order);
        double total_price = 0;
        return getCustomerOrder(dto, savedOrder, total_price);
    }

    @NotNull
    private CustomerOrder getCustomerOrder(CustomerOrderCreateDto dto, CustomerOrder savedOrder, double total_price) {
        for (CustomerOrderCreateDto.OrderItemDto itemDto : dto.getItems()) {
            // Kiểm tra món ăn có tồn tại không (optional)
            MenuItem menuItem = menuItemRepository.findById(itemDto.getMenuItemId())
                    .orElseThrow(() -> new RuntimeException("Menu item not found"));

            OrderItem orderItem = new OrderItem();
            orderItem.setOrderId(savedOrder.getId());
            orderItem.setMenuItemId(itemDto.getMenuItemId());
            orderItem.setQuantity(itemDto.getQuantity());
            total_price += itemDto.getQuantity() * menuItem.getPrice();

            Optional<MenuItem> optional = menuItemRepository.findById(menuItem.getId());
            if(optional.isEmpty()){
                throw new RuntimeException("Không tìm thấy món ăn có id: " + menuItem.getId());
            }
            MenuItem item = optional.get();
            Integer numberAvailable = item.getNumberAvailable();
            numberAvailable = numberAvailable != null ? (numberAvailable - itemDto.getQuantity()): null;
            // trừ đồ trong kho
                // lấy id món ăn và số lượng dùng trong bảng nguyên liệu dùng
                // lấy số lượng mua hàng nhân số lượng dùng cho 1 món.
                // trừ số lượng đó trong kho.
            updateNumAvailable(item, itemDto.getQuantity() );
            item.setNumberAvailable(numberAvailable);
            menuItemRepository.save(item);
            orderItemRepository.save(orderItem);
        }
        savedOrder.setTotalPrice(total_price);
        customerOrderRepository.save(savedOrder);

        return savedOrder;
    }

    private void updateNumAvailable(MenuItem menuItem, Integer quantity) {
        List<IngredientUsage> LsingreUsages = ingredientUsage.findByMenuItemId(menuItem.getId());
        // Món ăn có bao nhiêu nguyên liệu trong LsingreUsages
        // lấy sô liệu trong ingreUsage nhân với số lượng đơn hàng rồi trừ ra và cập nhật lại vô kho
        if(LsingreUsages != null){
            double minNum = 1e6;
            for (IngredientUsage ingre :  LsingreUsages) {

                IngredientStore ItemInStore = inStoreRepository.findByName(ingre.getName());
                if(ItemInStore != null) {
                    Double updateIteminStore = ItemInStore.getQuantityInStock() - (Double)(quantity * ingre.getQuantityUsed());
                    ItemInStore.setQuantityInStock(updateIteminStore);
                    Double scaleItem = updateIteminStore /  ingre.getQuantityUsed();
                    minNum = Math.min(minNum, scaleItem);
                    inStoreRepository.save(ItemInStore);
                }
                //  System.out.println(min);
            }
            if (minNum != 1e6) {
                menuItem.setNumberAvailable((int)minNum);
                menuItemRepository.save(menuItem);
            }
        }
    }

    @Override
    public CustomerOrder update(CustomerOrderUpdateDto dto) {
        int id = dto.getId();
        CustomerOrder entity = findById(id);
        entity.setStatus(dto.getStatus());
        customerOrderRepository.save(entity);
        return entity;
    }

    @Override
    public CustomerOrder updateOrder(int id, CustomerOrderCreateDto dto) {

        CustomerOrder order = findById(id);
        double total_price = order.getTotalPrice();
        return getCustomerOrder(dto, order, total_price);
    }

    @Override
    public void deleteById(int id) {
        customerOrderRepository.deleteById(id);
    }

    private CustomerOrder findById(int id) {
        Optional<CustomerOrder> optional = customerOrderRepository.findById(id);

        if(optional.isEmpty()){
            System.err.println("không tim thấy đơn hàng");
            LogicCustomException exception = new LogicCustomException();
            exception.setCode(500);
            exception.setMessage("không tim thấy đơn hàng");
            throw exception;
        }
        return optional.get();
    }

}
