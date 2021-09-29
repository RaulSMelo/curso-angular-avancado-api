package com.raulmelo.finansysapi.repositories;

import com.raulmelo.finansysapi.entities.EntryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EntryRepository extends JpaRepository<EntryEntity, Long> {}
