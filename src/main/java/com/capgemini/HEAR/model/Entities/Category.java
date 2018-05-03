package com.capgemini.HEAR.model.Entities;

import com.capgemini.HEAR.model.Base;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Category extends Base {

       @OneToMany(mappedBy = "category", cascade = CascadeType.ALL )
    private List<SubCategory> subCategories;

    public Category() {}

    public List<SubCategory> getSubCategories() {
        return subCategories;
    }

    public void setSubCategories(List<SubCategory> subCategories) {
        this.subCategories = subCategories;
    }
}
