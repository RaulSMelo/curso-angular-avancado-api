package com.raulmelo.finansysapi.controlers;

import com.raulmelo.finansysapi.dtos.CategoryDto;
import com.raulmelo.finansysapi.entities.CategoryEntity;
import com.raulmelo.finansysapi.services.CategoryService;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/categories")
public class CategoryController {
    
    @Autowired
    CategoryService service;
    
    @GetMapping
    public ResponseEntity<List<CategoryDto>> findAll(){

        return ResponseEntity.status(HttpStatus.OK).body(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoryDto> findById(@PathVariable Long id){

       return ResponseEntity.status(HttpStatus.OK).body(service.findById(id));

    }

    @PostMapping("/new")
    public ResponseEntity<CategoryDto> create(@Valid @RequestBody CategoryEntity category){
        
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(category));
    }
    
    @PutMapping("/{id}/edit")
    public ResponseEntity<CategoryDto> update(@Valid @RequestBody CategoryEntity category, @PathVariable Long id){
        
        return ResponseEntity.status(HttpStatus.OK).body(service.update(category, id));
    }
    
    @DeleteMapping("/{id}/delete")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        
        service.delete(id);
        
        return ResponseEntity.status(HttpStatus.OK).build();          
    }
}
