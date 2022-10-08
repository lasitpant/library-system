package com.hertz.assignment.librarysystem.controller;

import com.hertz.assignment.librarysystem.entity.Category;
import com.hertz.assignment.librarysystem.service.CategoryService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/category")
public class CategoryController {

    private CategoryService categoryService;

    private CategoryController(CategoryService categoryService){
        this.categoryService = categoryService;
    }

    @GetMapping("/categories")
    public ResponseEntity<?> getAllCategories(){
        return new ResponseEntity<>(categoryService.getAllCategories(), HttpStatus.OK);
    }

    @PostMapping("/add-categories")
    public ResponseEntity<?> createCategory(@RequestBody Category category){
        return new ResponseEntity<>(categoryService.addCategory(category), HttpStatus.OK);
    }

    @DeleteMapping("/delete-category/{id}")
    public ResponseEntity<?> deleteCategory(@PathVariable Long id){
        categoryService.removeCategory(id);
        return new ResponseEntity<>("Category Removed",HttpStatus.NO_CONTENT);
    }
}
