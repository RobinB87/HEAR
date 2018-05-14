package com.capgemini.HEAR.model.Entities;

import com.capgemini.HEAR.model.Price;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class Ingredient extends Price {

   @ManyToMany(mappedBy = "ingredients")
   @JsonIgnore
    private List<Dish> dishes;

    public Ingredient() {}

    public List<Dish> getDishes() {
        return dishes;
    }

    public void setDishes(List<Dish> dishes) {
        this.dishes = dishes;
    }
}
