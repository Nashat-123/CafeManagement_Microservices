package com.contact.contoller;



import com.contact.entity.Cafe;
import com.contact.service.CafeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cafes")
public class CafeController {

    private final CafeService cafeService;

    @Autowired
    public CafeController(CafeService cafeService) {
        this.cafeService = cafeService;
    }

    @GetMapping
    public List<Cafe> getAllEntities() {
        return cafeService.getAllEntities();
    }

    @GetMapping("/{id}")
    public Cafe getEntityById(@PathVariable Long id) {
        return cafeService.getEntityById(id);
    }

    @PostMapping
    public Cafe createEntity(@RequestBody Cafe entity) {
        return cafeService.createEntity(entity);
    }

    @PutMapping("/{id}")
    public Cafe updateEntity(@PathVariable Long id, @RequestBody Cafe cafe) {
        return cafeService.updateEntity(id, cafe);
    }

    @DeleteMapping("/{id}")
    public void deleteEntity(@PathVariable Long id) {
        cafeService.deleteEntity(id);
    }
}
