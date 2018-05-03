package com.capgemini.HEAR.repository;

import com.capgemini.HEAR.model.Entities.Ingredient;
import org.springframework.data.repository.CrudRepository;

public interface IIngredientRepository extends CrudRepository<Ingredient, Integer> {
}
