package com.capgemini.HEAR.controller;

import com.capgemini.HEAR.repository.IDishRepository;
import com.capgemini.HEAR.repository.IDrinkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/menuitem")
public class MenuItemController {

    @Autowired
    private IDishRepository dishRepository;

    @Autowired
    private IDrinkRepository drinkRepository;
}
