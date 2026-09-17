<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>All Products - Fashion Store</title>
    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;500;600&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="<%= request.getContextPath() %>/assets/css/style.css">
</head>
<body>

    <div class="top-nav">
        <a href="<%= request.getContextPath() %>/home">Home</a>
        <a href="<%= request.getContextPath() %>/products">Shop All</a>
        <a href="<%= request.getContextPath() %>/cart">Cart</a>
        <a href="<%= request.getContextPath() %>/profile">My Profile</a>
    </div>

    <div class="hero-section" style="padding: 40px 20px 60px 20px;">
        <h1 style="font-size: 3.5rem;">${currentCategory != null ? currentCategory : 'All Collections'}</h1>
        <p>Explore our carefully curated pieces designed to elevate your wardrobe.</p>
    </div>

    <div class="filter-nav">
        <a href="<%= request.getContextPath() %>/products" class="filter-btn ${currentCategory == 'All Collections' ? 'active' : ''}">All</a>
        <a href="<%= request.getContextPath() %>/products?category=Men" class="filter-btn ${currentCategory == 'Men' ? 'active' : ''}">Men</a>
        <a href="<%= request.getContextPath() %>/products?category=Women" class="filter-btn ${currentCategory == 'Women' ? 'active' : ''}">Women</a>
        <a href="<%= request.getContextPath() %>/products?category=Kids" class="filter-btn ${currentCategory == 'Kids' ? 'active' : ''}">Kids</a>
    </div>

    <div class="product-grid">
        <c:forEach var="product" items="${products}">
            <div class="product-card">
                
                <a href="<%= request.getContextPath() %>/product-details?id=${product.productId}" style="text-decoration: none; color: inherit; display: block;">
                    
                    <div class="product-img-wrapper">
                       <img src="${product.imageUrl}" alt="Product Image" style="width: 100%; height: 100%; object-fit: cover;">
                    </div>
                    
                    <h3>${product.productName}</h3>
                </a>
                
                <form action="<%= request.getContextPath() %>/cart/add" method="POST">
                    <input type="hidden" name="productId" value="${product.productId}">
                    <input type="hidden" name="productName" value="${product.productName}">
                    <input type="hidden" name="imageUrl" value="${product.imageUrl}">
                    <select name="sizeLabel" style="width: 100%; padding: 12px; margin-bottom: 20px; border: 1px solid #dfd6c8; border-radius: 50px; background: transparent; font-size: 14px;" required>
                        <option value="" disabled selected>Select Size</option>
                        <option value="S">Small</option>
                        <option value="M">Medium</option>
                        <option value="L">Large</option>
                    </select>

                    <button type="submit" class="btn btn-outline" style="padding: 12px 20px; font-size: 13px;">Add to Cart</button>
                </form>

            </div>
        </c:forEach>
    </div>

</body>
</html>