package com.vti.bep3.responsitory;

import com.vti.bep3.entity.IngredientUsage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IngredientUsageRepository extends JpaRepository<IngredientUsage, Integer> {
    Optional<IngredientUsage> findByName(String name);
    List<IngredientUsage> findByMenuItemId (int id);
}
