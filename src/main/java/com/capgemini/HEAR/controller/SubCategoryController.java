package com.capgemini.HEAR.controller;

import com.capgemini.HEAR.model.DTO.SubCategoryDTO;
import com.capgemini.HEAR.model.Entities.Category;
import com.capgemini.HEAR.model.Entities.SubCategory;
import com.capgemini.HEAR.repository.ICategoryRepository;
import com.capgemini.HEAR.repository.ISubCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/subcategory")
public class SubCategoryController {

    @Autowired
    private ISubCategoryRepository subCategoryRepository;

    @Autowired
    private ICategoryRepository categoryRepository;

    /**
     * Add a subcategory in the webpage
     */

    //add a subcategory and match to category id
    @PostMapping("/add/{categoryId}")
    public SubCategory addSubCategory(@PathVariable int categoryId, SubCategory subcategory) {

        Category category = categoryRepository.findById(categoryId).isPresent() ? categoryRepository.findById(categoryId).get() : null;
        subcategory.setCategory(category);
        category.addSubCategory(subcategory);
        categoryRepository.save(category);

        return subcategory;
    }

    //return a subcategory by an id
    @GetMapping("/get/{id}")
    public SubCategory getSubCategory(@PathVariable int id) {

        if (subCategoryRepository.findById(id).isPresent()) {
            SubCategory subCategory = subCategoryRepository.findById(id).get();
            return subCategory;
        }
        return null;
    }

    //return all subcategories
    @GetMapping("/all")
    public Iterable<SubCategory> getAll() {
        return subCategoryRepository.findAll();
    }


    //
    @GetMapping("/formatted/get/{id}")
    public SubCategoryDTO getSubCategoryDTO(@PathVariable int id) {
        SubCategory subCategory = subCategoryRepository.findById(id).isPresent() ? subCategoryRepository.findById(id).get() : null;

        SubCategoryDTO dto = new SubCategoryDTO(subCategory);
        return dto;
    }

    //data transformatie - presentatie model - die vul je met data model
    @GetMapping("/formatted/all")
    public List<SubCategoryDTO> subCategories() {

        List<SubCategoryDTO> subCategoryList = new ArrayList<>();
        for(SubCategory subCategory : subCategoryRepository.findAll()) {
            SubCategoryDTO dto = new SubCategoryDTO(subCategory);
            subCategoryList.add(dto);
        }

            return subCategoryList;
    }

    //edit one subcategory
    @PostMapping("/edit/{categoryId}")
    public SubCategory editSubcategory(@PathVariable int categoryId, SubCategory subCategory){

        Category category = new Category();

        if(subCategoryRepository.findById(categoryId).isPresent()){
            category = categoryRepository.findById(categoryId).get();
        } else {
            category = null;
        }

            subCategory.setCategory(category);

            return subCategoryRepository.save(subCategory);

    }

    //delete one subcategory by id
    @GetMapping("/delete/{id}")
    public SubCategory deleteSubCategory(@PathVariable int id) {
        if (subCategoryRepository.findById(id).isPresent()) {
            subCategoryRepository.deleteById(id);
        }
        return null;
    }
}
