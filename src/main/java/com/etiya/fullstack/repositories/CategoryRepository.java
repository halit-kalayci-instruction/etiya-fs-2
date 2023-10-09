package com.etiya.fullstack.repositories;

import com.etiya.fullstack.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository
        extends JpaRepository<Category,Integer> {
}
