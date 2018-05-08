package com.capgemini.HEAR.model.DTO;

import lombok.Data;

@Data
public class IngredientDTO {

    private int id;
    private String title;
    private double price;
    private double costPrice;
    private String menuItemTitle;
}
