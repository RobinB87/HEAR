package com.capgemini.HEAR.repository;

import com.capgemini.HEAR.model.Entities.Category;
import org.springframework.data.repository.CrudRepository;

public interface ICategoryRepository extends CrudRepository<Category, Integer> {

}
