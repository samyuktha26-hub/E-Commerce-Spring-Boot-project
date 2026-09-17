package com.fashionstore.dao;

import com.fashionstore.model.Category;
import java.util.List;

public interface CategoryDao {
    List<Category> getAllActiveCategories();
    Category getCategoryById(int categoryId);
}
