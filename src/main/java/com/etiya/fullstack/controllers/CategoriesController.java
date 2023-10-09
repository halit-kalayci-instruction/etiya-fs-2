package com.etiya.fullstack.controllers;

import com.etiya.fullstack.entities.responses.category.GetAllCategoryResponse;
import com.etiya.fullstack.services.abstracts.CategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/categories")
@CrossOrigin
public class CategoriesController {
    private final CategoryService categoryService;

    public CategoriesController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
    public ResponseEntity<List<GetAllCategoryResponse>> getAll(){
        return new ResponseEntity<>(categoryService.getAll(), HttpStatus.OK);
    }

    @GetMapping("{id}")
    public void getById(@PathVariable int id){

    }

    @PostMapping
    public void add(){

    }

    @PutMapping()
    public void update(){

    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable int id){

    }
}
