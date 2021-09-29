package com.raulmelo.finansysapi.entities;

import com.raulmelo.finansysapi.dtos.CategoryDto;
import com.raulmelo.finansysapi.util.Convertible;
import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;


@Entity
@Table(name = "tb_categories")
public class CategoryEntity implements Serializable, Convertible<CategoryDto>{
    
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotNull
    @NotEmpty(message = "Nome da categoria não pode ser vazio")
    private String name;

    private String description;

    public CategoryEntity() {}

    public CategoryEntity(Long id, String name, String description) {
        this.id = id;
        this.name = name.trim();
        this.description = description.trim();
    }
    
    public CategoryEntity(CategoryEntity category) {
        
        this.setName(category.getName());
        this.setDescription(category.getDescription());
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

    @Override
    public CategoryDto convertToDTO() {
        
        return new CategoryDto(this);
    }

}
