package com.vti.bep3.service.Impl;

import com.vti.bep3.dto.IngredientStoreCreate;
import com.vti.bep3.dto.IngredientStoreUpdate;
import com.vti.bep3.entity.IngredientStore;
import com.vti.bep3.entity.MenuItem;
import com.vti.bep3.exception.LogicCustomException;
import com.vti.bep3.responsitory.IngredientRepository;
import com.vti.bep3.responsitory.IngredientUsageRepository;
import com.vti.bep3.responsitory.MenuItemRepository;
import com.vti.bep3.service.IngredientStoreService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

// kho hàng
@Service
@AllArgsConstructor
public class IngredientStoreServiceImpl implements IngredientStoreService {

    final IngredientRepository ingredientRepository;
    final MenuItemRepository menuItemRepository;
    final IngredientUsageRepository ingredientUsageRepository;

    @Override
    public List<IngredientStore> getAllIngredientStore(){
        return ingredientRepository.findAll();
    }

    @Override
    public IngredientStore create(IngredientStoreCreate ingredient) {

        if(findByName(ingredient.getName()) == null){
            IngredientStore entity = new IngredientStore();
            entity.setName(ingredient.getName());
            entity.setQuantityInStock(ingredient.getQuantityInStock());
            entity.setUnit(ingredient.getUnit());

            ingredientRepository.save(entity);
            return entity;
        }
        return null;
    }

    @Override
    public IngredientStore update(IngredientStoreUpdate ingredient) {
        IngredientStore entity = findByName(ingredient.getName());
        if(entity == null){
            System.err.println("Ten Hang khong ton tai");
            LogicCustomException exception = new LogicCustomException();
            exception.setCode(500);
            exception.setMessage("Ten Hang khong ton tai");
            throw exception;
        }
        IngredientStore dto = new IngredientStore();
        dto.setId(entity.getId());
        dto.setName(ingredient.getName());
        dto.setUnit(ingredient.getUnit());
        dto.setQuantityInStock(ingredient.getQuantityInStock());
        ingredientRepository.save(dto);
        return null;
    }

    @Override
    public void deleteById(int id) {
        ingredientRepository.deleteById(id);
    }


    public IngredientStore findByName(String name){
        IngredientStore optional = ingredientRepository.findByName(name);
        if(optional==null){
            return null;
        }
        return optional;
    }

}
