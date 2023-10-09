package com.etiya.fullstack.repositories;

import com.etiya.fullstack.entities.Category;
import com.etiya.fullstack.entities.responses.category.GetAllCategoryResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category,Integer> {
    @Query("Select new com.etiya.fullstack.entities.responses.category.GetAllCategoryResponse(c.id,c.name)" +
            " From Category c")
    List<GetAllCategoryResponse> getAllForListing();
}
