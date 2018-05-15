package com.capgemini.HEAR.model.DTO;

import com.capgemini.HEAR.model.Entities.Dish;
import com.capgemini.HEAR.model.Entities.Ingredient;
import lombok.Data;

import java.util.List;

@Data
public class DishDTO {

    private int id;
    private String title;
    private double price;
    private String subCategoryTitle;
    private List<Ingredient> ingredients;

    public DishDTO() {

    }

    public DishDTO(Dish dish) {
        this.id = dish.getId();
        this.title = dish.getTitle();
        this.price = dish.getSellingPrice();
        this.subCategoryTitle = dish.getSubCategory().getTitle();
        this.ingredients = dish.getIngredients();
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public String getSubCategoryTitle() {
        return subCategoryTitle;
    }

    public void setSubCategoryTitle(String subCategoryTitle) {
        this.subCategoryTitle = subCategoryTitle;
    }
}
