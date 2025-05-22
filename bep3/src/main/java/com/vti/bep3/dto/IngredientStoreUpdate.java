package com.vti.bep3.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class IngredientStoreUpdate {
    private Integer id;
    private String name;
    private Double quantityInStock;
    private String unit;
}
