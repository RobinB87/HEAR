package com.capgemini.HEAR.controller;

import com.capgemini.HEAR.model.Menu;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/menu")
public class MenuController {


    @GetMapping("/")
    public Menu show() {
        return new Menu();
    }

}
