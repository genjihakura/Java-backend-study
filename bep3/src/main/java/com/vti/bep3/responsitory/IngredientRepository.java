package com.vti.bep3.responsitory;

import com.vti.bep3.entity.IngredientStore;
import com.vti.bep3.entity.IngredientUsage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IngredientRepository extends JpaRepository<IngredientStore,Integer> {
    IngredientStore findByName(String name);
}
