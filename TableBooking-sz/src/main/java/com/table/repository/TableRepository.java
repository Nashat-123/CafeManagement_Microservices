package com.table.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.table.entites.Tables;

public interface TableRepository extends JpaRepository<Tables, String> {
    List<Tables> findByUserId(String userId);
    List<Tables> findByMenuId(String menu_id); // Update the method name here
}
