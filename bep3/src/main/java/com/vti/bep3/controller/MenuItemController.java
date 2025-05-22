package com.vti.bep3.controller;

import com.vti.bep3.dto.MenuItemCreateDto;
import com.vti.bep3.dto.MenuItemUpdateDto;
import com.vti.bep3.entity.MenuItem;
import com.vti.bep3.service.MenuItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/menu")
@CrossOrigin("http://127.0.0.1:5500")
public class MenuItemController {

    @Autowired
    private MenuItemService menuItemService;

    @GetMapping("/all")
    public  ResponseEntity<List<MenuItem>> getAllMenu(){
        return ResponseEntity.ok(menuItemService.getAllMenu());
    }

    @PostMapping("/create")
    public MenuItem AddMeal(@RequestBody MenuItemCreateDto request){
        return menuItemService.create(request);
    }

    @GetMapping("/numberAvailable")
    public void numberAvailable(){
        menuItemService.numberAvailable();
    }

    @PutMapping("/update")
    public MenuItem updateMeal(@RequestBody MenuItemUpdateDto request){
        return menuItemService.update(request);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteMeal(@PathVariable int id){
        menuItemService.deleteById(id);
    }
}
