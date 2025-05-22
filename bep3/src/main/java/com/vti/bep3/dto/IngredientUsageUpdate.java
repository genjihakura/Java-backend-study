package com.vti.bep3.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class IngredientUsageUpdate {
    private Integer menuItemId;
    private String IngredientName;
    private Integer ingredientId;
    private Double quantityUsed;
}
