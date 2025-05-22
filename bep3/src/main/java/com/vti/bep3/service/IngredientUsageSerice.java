package com.vti.bep3.service;

import com.vti.bep3.dto.IngredientUsageCreate;
import com.vti.bep3.entity.IngredientStore;
import com.vti.bep3.entity.IngredientUsage;
import com.vti.bep3.dto.IngredientUsageUpdate;

import java.util.List;

public interface IngredientUsageSerice {

    List<IngredientUsage> getAllIngredientUsage();
    IngredientUsage create(IngredientUsageCreate dto);
    IngredientUsage update(IngredientUsageUpdate dto);
    void deleteById(int id);
}
