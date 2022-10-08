package com.hertz.assignment.librarysystem.service;

import com.hertz.assignment.librarysystem.entity.Category;
import com.hertz.assignment.librarysystem.exceptions.NotFoundException;
import com.hertz.assignment.librarysystem.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    private CategoryRepository categoryRepository;

    CategoryService(CategoryRepository categoryRepository){
        this.categoryRepository = categoryRepository;
    }

    public List<Category> getAllCategories(){
        return categoryRepository.findAll();
    }

    public Category addCategory(Category category){
        return categoryRepository.save(category);
    }

    public void removeCategory(Long id){
        final var itemToBeDeleted = categoryRepository.findById(id)
                .orElseThrow(()-> new NotFoundException("Category record not found."));
        categoryRepository.delete(itemToBeDeleted);
    }
}
