package com.etiya.fullstack.services.abstracts;

import com.etiya.fullstack.entities.responses.category.GetAllCategoryResponse;

import java.util.List;

public interface CategoryService {
    List<GetAllCategoryResponse> getAll();
}
