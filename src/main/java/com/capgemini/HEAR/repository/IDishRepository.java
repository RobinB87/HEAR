package com.capgemini.HEAR.repository;

import com.capgemini.HEAR.model.Entities.Dish;
import org.springframework.data.repository.CrudRepository;

public interface IDishRepository extends CrudRepository<Dish, Integer> {
}
