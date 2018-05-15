package com.capgemini.HEAR.model.DTO;

import com.capgemini.HEAR.model.Entities.Drink;
import lombok.Data;

@Data
public class DrinkDTO {

    private int id;
    private String title;
    private double costPrice;
    private double sellingPrice;
    private String subCategoryTitle;
    private int subCategoryId;

    public DrinkDTO(Drink drink){
        this.id = drink.getId();
        this.title = drink.getTitle();
        this.costPrice = drink.getCostPrice();
        this.sellingPrice = drink.getSellingPrice();
        this.subCategoryTitle = drink.getSubcategory().getTitle();
        this.subCategoryId = drink.getSubcategory().getId();
    }
}
