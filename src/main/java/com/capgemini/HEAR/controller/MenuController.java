package com.capgemini.HEAR.controller;

import com.capgemini.HEAR.data.DataList;
import com.capgemini.HEAR.model.Category;
import com.capgemini.HEAR.model.Menu;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/menu")
public class MenuController {


    @GetMapping("/")
    public Menu show() {
        return new Menu();
    }


    //List van categorien (van beneden naar boven)
    @GetMapping("/categories")
    public List<Category> showCategories() {
        DataList dataList = new DataList();

        return dataList.getCategories();
    }

}
