package com.vti.bep3.controller;

import com.vti.bep3.dto.IngredientUsageCreate;
import com.vti.bep3.dto.IngredientUsageUpdate;
import com.vti.bep3.service.IngredientUsageSerice;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/IngredientUsage")
@RequiredArgsConstructor
public class IngredientUsageController {
    @Autowired
    final IngredientUsageSerice ingredientUsageSerice;

    @GetMapping("/all")
    public ResponseEntity<?> getAllIngredientUsage(){
        return ResponseEntity.ok(ingredientUsageSerice.getAllIngredientUsage());
    }

    @PostMapping("/create")
    public ResponseEntity<?> creat(@RequestBody IngredientUsageCreate request){
        return ResponseEntity.ok(ingredientUsageSerice.create(request));
    }

    @PutMapping("/update")
    public ResponseEntity<?> update(@RequestBody IngredientUsageUpdate request){
        return ResponseEntity.ok(ingredientUsageSerice.update(request));
    }
    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable int id){
        ingredientUsageSerice.deleteById(id);
    }
}

