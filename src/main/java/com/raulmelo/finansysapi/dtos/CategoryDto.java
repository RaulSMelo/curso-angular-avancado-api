package com.raulmelo.finansysapi.dtos;

import com.raulmelo.finansysapi.entities.CategoryEntity;
import java.io.Serializable;

public class CategoryDto implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    private Long id;
    private String name;
    private String description;

    public CategoryDto() {}

    public CategoryDto(Long id, String name, String description) {
        this.id = id;
        this.name = name.trim();
        this.description = description.trim();
    }

    public CategoryDto(CategoryEntity category) {
        this.id = category.getId();
        this.name = category.getName();
        this.description = category.getDescription();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description.trim();
    }   
}
