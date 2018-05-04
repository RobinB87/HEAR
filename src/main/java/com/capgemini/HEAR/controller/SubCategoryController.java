package com.capgemini.HEAR.controller;

import com.capgemini.HEAR.model.Entities.SubCategory;
import com.capgemini.HEAR.repository.ICategoryRepository;
import com.capgemini.HEAR.repository.ISubCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
     * @param title
     * @param categoryid
     * @return
     */
    @GetMapping("/add/{title}/{categoryid}")
    public SubCategory addSubCategory(@PathVariable String title, @PathVariable int categoryid){
        SubCategory subCategory = new SubCategory();
        subCategory.setCategory(categoryRepository.findById(categoryid).isPresent() ? categoryRepository.findById(categoryid).get() : null);
        subCategory.setTitle(title);

        return subCategoryRepository.save(subCategory);
    }

    @GetMapping("/get/{id}")
    public SubCategory getSubCategory(@PathVariable int id){
        SubCategory subCategory = subCategoryRepository.findById(id).get();

        return subCategory;
    }

    //return all subcategories
    @GetMapping("/all")
    public Iterable<SubCategory> subCategories(){
        return subCategoryRepository.findAll();
    }

    //edit subcategories
    @GetMapping("/edit/{id}/{title}/{categoryid}")
    public SubCategory editSubCategory(@PathVariable int id, @PathVariable String title, @PathVariable int categoryid){

        SubCategory subCategory = subCategoryRepository.findById(id).get();
        subCategory.setTitle(title);
        subCategory.setCategory(categoryRepository.findById(categoryid).get());

        return subCategoryRepository.save(subCategory);
    }


    //delete subcategories

    //validatie if isPresent() else null. Dit moet elke find / .get doen!

}
