package com.fashionstore.model;

public class Category {
    
    private int categoryId;
    private String categoryName;
    private String description;
    private boolean isActive;

    // Default Constructor
    public Category() {
    }

    // Constructor for creating a new category (No categoryId)
    public Category(String categoryName, String description, boolean isActive) {
        this.categoryName = categoryName;
        this.description = description;
        this.isActive = isActive;
    }

    // Constructor for retrieving an existing category from the database
    public Category(int categoryId, String categoryName, String description, boolean isActive) {
        this.categoryId = categoryId;
        this.categoryName = categoryName;
        this.description = description;
        this.isActive = isActive;
    }

    // Getters and Setters
    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean isActive) {
        this.isActive = isActive;
    }

    // Optional: toString method for debugging
    @Override
    public String toString() {
        return "Category [categoryId=" + categoryId + ", categoryName=" + categoryName + ", isActive=" + isActive + "]";
    }
}