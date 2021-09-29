package com.raulmelo.finansysapi.controlers;

import com.raulmelo.finansysapi.dtos.EntryDto;
import com.raulmelo.finansysapi.entities.EntryEntity;
import com.raulmelo.finansysapi.services.EntryService;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/entries")
public class EntryController {
    
    @Autowired
    EntryService service;
    
    @GetMapping
    public ResponseEntity<List<EntryDto>> findAll(){

        return ResponseEntity.status(HttpStatus.OK).body(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<EntryDto> findById(@PathVariable Long id){

       return ResponseEntity.status(HttpStatus.OK).body(service.findById(id));

    }

    @PostMapping("/new")
    public ResponseEntity<EntryDto> create(@Valid @RequestBody EntryEntity entry){
        
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(entry));
    }
    
    @PutMapping("/{id}/edit")
    public ResponseEntity<EntryDto> update(@Valid @RequestBody EntryEntity entry, @PathVariable Long id){
        
        return ResponseEntity.status(HttpStatus.OK).body(service.update(entry, id));
    }
    
    @DeleteMapping("/{id}/delete")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        
        service.delete(id);
        
        return ResponseEntity.status(HttpStatus.OK).build();          
    }
}
