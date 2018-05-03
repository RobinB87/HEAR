package com.capgemini.HEAR.model.Entities;

import com.capgemini.HEAR.model.Base;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name = "subcategory")
public class SubCategory extends Base {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    @JsonIgnore
    private Category category;

    @OneToMany(mappedBy = "subcategory", cascade = CascadeType.ALL )
    private List<Dish> dishes;

    @OneToMany(mappedBy = "subcategory", cascade = CascadeType.ALL )
    private List<Drink> drinks;

    public SubCategory() {}

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public List<Dish> getDishes() {
        return dishes;
    }

    public void setDishes(List<Dish> dishes) {
        this.dishes = dishes;
    }

    public List<Drink> getDrinks() {
        return drinks;
    }

    public void setDrinks(List<Drink> drinks) {
        this.drinks = drinks;
    }
}
