package com.ucbcba.taller.services;

import com.ucbcba.taller.entities.Category;

public interface CategoryService {

    Iterable<Category> listAllCategories();

    Category getCategoryById(Integer id);

    Category saveCategory(Category category);

    void deleteCategory(Integer id);

}
