package com.capgemini.HEAR.model.Entities;

import com.capgemini.HEAR.model.DTO.DishDTO;
import com.capgemini.HEAR.model.MenuItem;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Dish extends MenuItem {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String title;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "dish_ingredient", joinColumns = @JoinColumn(name = "dish_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "ingredient_id", referencedColumnName = "id"))
    private List<Ingredient> ingredients;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "subcategory_id")
    @JsonIgnore
    private SubCategory subcategory;

    public Dish() {
    }

    public Dish(DishDTO dto) {
        this.id = dto.getId();
        this.title = dto.getTitle();
        this.ingredients = dto.getIngredients();
    }

    public SubCategory getSubCategory() {
        return subcategory;
    }

    public void setSubCategory(SubCategory subCategory) {
        this.subcategory = subCategory;
    }


    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }
}
