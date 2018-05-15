package com.capgemini.HEAR.model.DTO;

import com.capgemini.HEAR.model.Entities.SubCategory;
import lombok.Data;

@Data
public class SubCategoryDTO {

    private int id;
    private String title;
    private String categoryTitle;
    private int categoryId;

    public SubCategoryDTO(SubCategory subCategory) {
        this.id = subCategory.getId();
        this.title = subCategory.getTitle();
        this.categoryTitle = subCategory.getCategory().getTitle();
        this.categoryId = subCategory.getCategory().getId();
    }
}
