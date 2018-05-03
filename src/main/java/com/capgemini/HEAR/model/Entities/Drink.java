package com.capgemini.HEAR.model.Entities;

import com.capgemini.HEAR.model.MenuItem;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Drink extends MenuItem {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "subcategory_id")
    @JsonIgnore
    private SubCategory subcategory;

    public Drink() {}

    public SubCategory getSubcategory() {
        return subcategory;
    }

    public void setSubcategory(SubCategory subcategory) {
        this.subcategory = subcategory;
    }
}
