package com.capgemini.HEAR.controller;

import com.capgemini.HEAR.model.Entities.SubCategory;
import com.capgemini.HEAR.repository.ICategoryRepository;
import com.capgemini.HEAR.repository.ISubCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/add")
    public SubCategory addSubCategory(SubCategory subcategory) {
        return subCategoryRepository.save(subcategory);
    }

    //return one subcategory by an id
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
    public Iterable<SubCategory> subCategories() {
        return subCategoryRepository.findAll();
    }

    //edit subcategories
    @GetMapping("/edit/v2/{id}/{title}/{categoryid}")
    public SubCategory editSubCategoryv2(@PathVariable int id, @PathVariable String title, @PathVariable int categoryid) {

        if (subCategoryRepository.findById(id).isPresent()) {
            SubCategory subCategory = subCategoryRepository.findById(id).get();
            subCategory.setTitle(title);
            subCategory.setCategory(categoryRepository.findById(categoryid).get());

            return subCategoryRepository.save(subCategory);
        }
        return null;
    }

    //postmapping voor edit subcategories -> dan kan de bovenstaande edit getmapping weg.
    @PostMapping("/edit")
    public SubCategory editSubcategory(SubCategory subCategory){
        return subCategoryRepository.save(subCategory);
    }

    //delete subcategories
    @GetMapping("/delete/{id}")
    public SubCategory deleteSubCategory(@PathVariable int id) {
        if (subCategoryRepository.findById(id).isPresent()) {
            subCategoryRepository.deleteById(id);
        }
        return null;
    }
}
