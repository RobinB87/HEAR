package com.capgemini.HEAR.repository;

import com.capgemini.HEAR.model.Entities.SubCategory;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ISubCategoryRepository extends CrudRepository<SubCategory, Integer> {

}
