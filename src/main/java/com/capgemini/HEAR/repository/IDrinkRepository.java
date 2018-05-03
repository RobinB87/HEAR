package com.capgemini.HEAR.repository;

import com.capgemini.HEAR.model.Entities.Drink;
import org.springframework.data.repository.CrudRepository;

public interface IDrinkRepository extends CrudRepository<Drink, Integer> {
}
