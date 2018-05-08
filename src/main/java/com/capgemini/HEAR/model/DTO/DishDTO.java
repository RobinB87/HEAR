package com.capgemini.HEAR.model.DTO;

import lombok.Data;

@Data
public class DishDTO {

    private int id;
    private String title;
    private double price;
    private String subCategoryTitle;
}
