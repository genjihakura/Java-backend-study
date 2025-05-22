package com.vti.bep3.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
// dùng cho chế biến và trừ trong kho
@Table(name ="IngredientUsage")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class IngredientUsage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "menu_Item_Id")
    private Integer menuItemId;

    @Column(name = "Ingredient_name")
    private String name;

    @Column(name = "ingredient_Id")
    private Integer ingredientId;

    @Column(name = "quantity_Used")
    private Double quantityUsed;
}
