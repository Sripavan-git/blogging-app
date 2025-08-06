package com.pavan.blogapp.services;

import com.pavan.blogapp.modals.Category;
import com.pavan.blogapp.payloads.CategoryDTO;

import java.util.List;

public interface CategorySevice {

    // Create Category
    public CategoryDTO createCategory(CategoryDTO categoryDTO);

    // Get All Categories
    public List<CategoryDTO> getAllCategories();

    // Get Single Category
    public CategoryDTO getCategoryById(Long id);

    // Update Category
    public CategoryDTO updateCategory(CategoryDTO categoryDTO, Long  categoryId);

    // Delete Category
    public void deleteCategory(Long categoryId);
}
