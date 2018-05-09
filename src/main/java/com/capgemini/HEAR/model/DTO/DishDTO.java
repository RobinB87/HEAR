package com.capgemini.HEAR.model.DTO;

import com.capgemini.HEAR.model.Entities.Dish;
import lombok.Data;

@Data
public class DishDTO {

    private int id;
    private String title;
    private double price;
    private String subCategoryTitle;

    public DishDTO(Dish dish) {
        this.id = dish.getId();
        this.title = dish.getTitle();
        this.price = dish.getSellingPrice();
        this.subCategoryTitle = dish.getSubCategory().getTitle();
    }
}
