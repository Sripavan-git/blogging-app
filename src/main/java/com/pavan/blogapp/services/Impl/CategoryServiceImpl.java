package com.pavan.blogapp.services.Impl;

import com.pavan.blogapp.exceptions.ResourceNotFoundException;
import com.pavan.blogapp.modals.Category;
import com.pavan.blogapp.payloads.CategoryDTO;
import com.pavan.blogapp.repositories.CategoryRepository;
import com.pavan.blogapp.services.CategorySevice;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategorySevice {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public CategoryDTO createCategory(CategoryDTO categoryDTO) {
        Category savedCategory =  categoryRepository.save(dtoToCategory(categoryDTO));
        return categoryToDto(savedCategory);
    }

    @Override
    public List<CategoryDTO> getAllCategories() {
        return categoryRepository.findAll().stream().map(category -> categoryToDto(category)).toList();

    }

    @Override
    public CategoryDTO getCategoryById(Long id) {
        Category category = categoryRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Category", "id", id));
        return categoryToDto(category);
    }

    @Override
    public CategoryDTO updateCategory(CategoryDTO categoryDTO, Long categoryId) {
        Category category = categoryRepository.findById(categoryId).orElseThrow(() -> new ResourceNotFoundException("Category", "Id", categoryId));
        category.setCategoryTitle(categoryDTO.getCategoryTitle());
        category.setCategoryDescription(categoryDTO.getCategoryDescription());
        Category savedCategory = categoryRepository.save(category);
        return categoryToDto(category);
    }

    @Override
    public void deleteCategory(Long categoryId) {
        Category category = categoryRepository.findById(categoryId).orElseThrow(() -> new ResourceNotFoundException("Category", "Id", categoryId));
        categoryRepository.delete(category);
    }

    public Category dtoToCategory(CategoryDTO categoryDTO) {
        return modelMapper.map(categoryDTO, Category.class);
    }

    public CategoryDTO categoryToDto(Category category) {
        return modelMapper.map(category, CategoryDTO.class);
    }
}
