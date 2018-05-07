package com.capgemini.HEAR.model.DTO;

import com.capgemini.HEAR.model.Entities.SubCategory;

public class SubCategoryDTO {

    private int id;
    private String title;
    private String categoryTitle;

    public SubCategoryDTO(SubCategory subCategory) {
        this.id = subCategory.getId();
        this.title = subCategory.getTitle();
        this.categoryTitle = subCategory.getCategory().getTitle();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategoryTitle() {
        return categoryTitle;
    }

    public void setCategoryTitle(String categoryTitle) {
        this.categoryTitle = categoryTitle;
    }
}
