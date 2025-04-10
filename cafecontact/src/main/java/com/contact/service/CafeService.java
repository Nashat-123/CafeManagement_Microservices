package com.contact.service;

import java.util.List; // Import the correct List class

import com.contact.entity.Cafe;

public interface CafeService {
    List<Cafe> getAllEntities();
    Cafe getEntityById(Long id);
    Cafe createEntity(Cafe entity);
    Cafe updateEntity(Long id, Cafe cafe);
    void deleteEntity(Long id);
}
