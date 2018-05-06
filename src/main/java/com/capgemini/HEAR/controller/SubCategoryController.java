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
     */

    @PostMapping("/add/")
    public SubCategory addSubCategory(SubCategory subcategory){
        return subCategoryRepository.save(subcategory);
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

    //edit subcategories -> moet postmapping worden
    @GetMapping("/edit/{id}/{title}/{categoryid}")
    public SubCategory editSubCategory(@PathVariable int id, @PathVariable String title, @PathVariable int categoryid){

        SubCategory subCategory = subCategoryRepository.findById(id).get();
        subCategory.setTitle(title);
        subCategory.setCategory(categoryRepository.findById(categoryid).get());

        return subCategoryRepository.save(subCategory);
    }


    //delete subcategories
    @GetMapping("/delete/{id}")
    public void deleteSubCategory(@PathVariable int id){
        if(subCategoryRepository.findById(id).isPresent()) {
            subCategoryRepository.deleteById(id);
        }
    }



    //validatie if isPresent() else null. Dit moet elke find / .get doen!

}
