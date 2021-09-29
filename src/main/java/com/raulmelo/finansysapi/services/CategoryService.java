package com.raulmelo.finansysapi.services;

import com.raulmelo.finansysapi.dtos.CategoryDto;
import com.raulmelo.finansysapi.entities.CategoryEntity;
import com.raulmelo.finansysapi.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class CategoryService implements GenericService<CategoryEntity, CategoryDto, Long>{

    @Autowired
    CategoryRepository repository;
    
    @Override
    public JpaRepository<CategoryEntity, Long> getRepository() {
        
        return repository;
    }
}
