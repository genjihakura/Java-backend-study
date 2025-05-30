package com.vti.bep3.service.Impl;

import com.vti.bep3.dto.IngredientStoreCreate;
import com.vti.bep3.dto.IngredientUsageCreate;
import com.vti.bep3.entity.IngredientStore;
import com.vti.bep3.entity.IngredientUsage;
import com.vti.bep3.dto.IngredientUsageUpdate;
import com.vti.bep3.entity.MenuItem;
import com.vti.bep3.exception.LogicCustomException;
import com.vti.bep3.responsitory.IngredientRepository;
import com.vti.bep3.responsitory.IngredientUsageRepository;
import com.vti.bep3.responsitory.MenuItemRepository;
import com.vti.bep3.service.IngredientUsageSerice;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

// nguyen cho tung mon an
@Service
@AllArgsConstructor
public class IngredientUsageServiceImpl implements IngredientUsageSerice {
    final IngredientUsageRepository ingredientUsageRepository;
    final MenuItemRepository menuItemRepository;
    final IngredientRepository ingredientStoreRepository;

    @Override
    public List<IngredientUsage> getAllIngredientUsage() {
        return ingredientUsageRepository.findAll();
    }

    @Override
    public IngredientUsage create(IngredientUsageCreate dto) {
        IngredientUsage optional = findByName(dto.getName());

        if(optional != null){
            System.err.println("Ten nguyen lieu da ton tai");
            LogicCustomException exception = new LogicCustomException();
            exception.setCode(500);
            exception.setMessage("Ten nguyen lieu da ton tai");
            throw exception;
        }

        IngredientStore inStore = ingredientStoreRepository.findByName(dto.getName());

        if(inStore != null){
            int id = inStore.getId();
            double quantityUsed = dto.getQuantityUsed();
            IngredientUsage entity = new IngredientUsage();
            entity.setName(dto.getName());
            entity.setIngredientId(id);
            entity.setMenuItemId(dto.getMenuItemId());
            entity.setQuantityUsed(quantityUsed);

            ingredientUsageRepository.save(entity);
            return entity;
        }
        return null;
    }

    @Override
    public IngredientUsage update(IngredientUsageUpdate dto) {
        IngredientUsage entity = new IngredientUsage();

        IngredientUsage optional = findByName(dto.getIngredientName());
        if(optional == null){
            System.err.println("khong tim thay ten nguyen lieu trong mon an");;
            LogicCustomException exception = new LogicCustomException();
            exception.setCode(500);
            exception.setMessage("khong tim thay ten nguyen lieu trong mon an");
            throw exception;
        }
        optional.setIngredientId(dto.getIngredientId());
        optional.setMenuItemId(dto.getMenuItemId());
        optional.setQuantityUsed(dto.getQuantityUsed());
        ingredientUsageRepository.save(entity);
        return entity;
    }

    @Override
    public void deleteById(int id) {
        ingredientUsageRepository.deleteById(id);
    }

    private IngredientUsage findByName(String name){
        Optional <IngredientUsage> optional = ingredientUsageRepository.findByName(name);
        if(optional.isEmpty()){
            return null;
        }
        return optional.get();
    }

}
