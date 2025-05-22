package com.vti.bep3.controller;

import com.vti.bep3.dto.IngredientStoreCreate;
import com.vti.bep3.dto.IngredientStoreUpdate;
import com.vti.bep3.entity.IngredientStore;
import com.vti.bep3.service.Impl.IngredientStoreServiceImpl;
import com.vti.bep3.service.IngredientStoreService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/IngredientStore")
@RequiredArgsConstructor
public class IngredientStoreController {
    @Autowired
    private IngredientStoreService ingredientStoreService;

    @GetMapping("/all")
    public ResponseEntity<List<IngredientStore>> getAllIngredientStore(){
        return ResponseEntity.ok(ingredientStoreService.getAllIngredientStore());
    }

    @PostMapping("/create")
    public ResponseEntity<IngredientStore> create(@RequestBody IngredientStoreCreate request){
        return ResponseEntity.ok(ingredientStoreService.create(request));
    }

    @PutMapping("/update")
    public ResponseEntity<IngredientStore> update(@RequestBody IngredientStoreUpdate request){
        return ResponseEntity.ok(ingredientStoreService.update(request));
    }

    @DeleteMapping("/delete/{id}")
    public  void    deleteById(@PathVariable int id){
        ingredientStoreService.deleteById(id);
    }

}
