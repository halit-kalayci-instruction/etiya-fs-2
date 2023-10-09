package com.etiya.fullstack.services.concretes;

import com.etiya.fullstack.entities.responses.category.GetAllCategoryResponse;
import com.etiya.fullstack.repositories.CategoryRepository;
import com.etiya.fullstack.services.abstracts.CategoryService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    private CategoryRepository categoryRepository;
    private ModelMapper modelMapper;

    public CategoryServiceImpl(CategoryRepository categoryRepository, ModelMapper modelMapper) {
        this.categoryRepository = categoryRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<GetAllCategoryResponse> getAll() {
        return categoryRepository.getAllForListing();
    }
}
