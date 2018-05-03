package com.capgemini.HEAR.controller;

import com.capgemini.HEAR.repository.ISubCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/subcategory")
public class SubCategoryController {

    @Autowired
    private ISubCategoryRepository subCategoryRepository;
}
