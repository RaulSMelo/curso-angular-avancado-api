package com.raulmelo.finansysapi.services;

import com.raulmelo.finansysapi.dtos.EntryDto;
import com.raulmelo.finansysapi.entities.EntryEntity;
import com.raulmelo.finansysapi.repositories.EntryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class EntryService implements GenericService<EntryEntity, EntryDto, Long>{

    @Autowired
    EntryRepository repository;
    
    @Override
    public JpaRepository<EntryEntity, Long> getRepository() {
        
        return repository;
    }
}
