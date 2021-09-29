package com.raulmelo.finansysapi.services;

import com.raulmelo.finansysapi.exceptions.ObjectNotFoundException;
import com.raulmelo.finansysapi.util.Convertible;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.data.jpa.repository.JpaRepository;


public interface GenericService<T extends Convertible<DTO>, DTO, ID> {
    
    JpaRepository<T, ID> getRepository();
    
    default DTO findById(ID id){
        
        return findEntity(id).convertToDTO();
    }
    
    default List<DTO> findAll(){
        
        List<T> list = getRepository().findAll();
        
        return list.stream().map(entity -> entity.convertToDTO()).collect(Collectors.toList());
    }
    
    default DTO create(T entity){
        
        getRepository().save(entity);
        
        return entity.convertToDTO();
    }
    
    default DTO update(T entity, ID id){
        
        T objDB = findEntity(id);
        
        objDB = entity;
        
        getRepository().save(objDB);
        
        return objDB.convertToDTO();
    }
    
    default void delete(ID id){
        
        findEntity(id);
        
        getRepository().deleteById(id);
    }
    
    default T findEntity(ID id){
        
        Optional<T> entity = getRepository().findById(id);
        
        if(entity.isPresent()) return entity.get();
        
        throw new ObjectNotFoundException("Objeto não encontrado. ID: " + id);
    }
    
}
