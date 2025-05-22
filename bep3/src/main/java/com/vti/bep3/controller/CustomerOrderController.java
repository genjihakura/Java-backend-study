package com.vti.bep3.controller;

import com.vti.bep3.dto.CustomerOrderCreateDto;
import com.vti.bep3.dto.CustomerOrderUpdateDto;
import com.vti.bep3.entity.CustomerOrder;
import com.vti.bep3.service.CustomerOrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/orders")
@RequiredArgsConstructor
public class CustomerOrderController {

    @Autowired
    private CustomerOrderService customerOrderService;

    @GetMapping("/all")
    public ResponseEntity<List<CustomerOrder>> getAllOrders() {
        return ResponseEntity.ok(customerOrderService.getAllOrders());
    }

    @PostMapping("/create")
    public ResponseEntity<CustomerOrder> createOrder(@RequestBody CustomerOrderCreateDto request) {
        return ResponseEntity.ok(customerOrderService.create(request));
    }
    @PutMapping("/update")
    public ResponseEntity<CustomerOrder> updateOrder(@RequestBody CustomerOrderUpdateDto request) {
        return ResponseEntity.ok(customerOrderService.update(request));
    }

    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable int id){
        customerOrderService.deleteById(id);
    }
}
