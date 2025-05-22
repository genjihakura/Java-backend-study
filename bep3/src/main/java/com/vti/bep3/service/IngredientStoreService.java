package com.vti.bep3.service;

import com.vti.bep3.dto.IngredientStoreCreate;
import com.vti.bep3.dto.IngredientStoreUpdate;
import com.vti.bep3.entity.IngredientStore;

import java.util.List;

public interface IngredientStoreService {

    List<IngredientStore> getAllIngredientStore();

    IngredientStore create(IngredientStoreCreate ingredient);

    IngredientStore update(IngredientStoreUpdate ingredient);
    void deleteById(int id);
}
