package com.fashionstore.model;

public class Product {

    private int productId;
    private int categoryId;
    private String productName;
    private String description;
    private double discountPercent;
    private String imageUrl;
    private boolean isActive;
    private String category; // Add this to the top
    private double price;

    // Default Constructor
    public Product() {
    }

    // Constructor for creating a new product (No productId)
    public Product(int categoryId, String productName, String description, double discountPercent, String imageUrl, boolean isActive) {
        this.categoryId = categoryId;
        this.productName = productName;
        this.description = description;
        this.discountPercent = discountPercent;
        this.imageUrl = imageUrl;
        this.isActive = isActive;
    }

    // Constructor for retrieving an existing product from the database
    public Product(int productId, int categoryId, String productName, String description, double discountPercent, String imageUrl, boolean isActive) {
        this.productId = productId;
        this.categoryId = categoryId;
        this.productName = productName;
        this.description = description;
        this.discountPercent = discountPercent;
        this.imageUrl = imageUrl;
        this.isActive = isActive;
    }

    // Getters and Setters
    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getDiscountPercent() {
        return discountPercent;
    }

    public void setDiscountPercent(double discountPercent) {
        this.discountPercent = discountPercent;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean isActive) {
        this.isActive = isActive;
    }

    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }

    public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
    // Optional: toString method for debugging
    @Override
    public String toString() {
        return "Product [productId=" + productId + ", categoryId=" + categoryId + ", productName=" + productName
                + ", discountPercent=" + discountPercent + ", isActive=" + isActive + "]";
    }

	
}
