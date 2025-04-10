package com.contact.repo;

import com.contact.entity.Cafe;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CafeRepository extends JpaRepository<Cafe, Long> {
    // You can define custom query methods here if needed
}
