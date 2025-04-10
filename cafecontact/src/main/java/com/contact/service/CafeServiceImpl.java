package com.contact.service;

import com.contact.entity.Cafe;
import com.contact.repo.CafeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CafeServiceImpl implements CafeService {

    private final CafeRepository cafeRepository;

    @Autowired
    public CafeServiceImpl(CafeRepository cafeRepository) {
        this.cafeRepository = cafeRepository;
    }

    @Override
    public List<Cafe> getAllEntities() {
        return cafeRepository.findAll();
    }

    @Override
    public Cafe getEntityById(Long id) {
        Optional<Cafe> cafe = cafeRepository.findById(id);
        return cafe.orElse(null);
    }

    @Override
    public Cafe createEntity(Cafe entity) {
        return cafeRepository.save(entity);
    }

    @Override
    public Cafe updateEntity(Long id, Cafe cafe) {
        if (cafeRepository.existsById(id)) {
            cafe.setId(id);
            return cafeRepository.save(cafe);
        }
        return null;
    }

    @Override
    public void deleteEntity(Long id) {
        cafeRepository.deleteById(id);
    }
}
