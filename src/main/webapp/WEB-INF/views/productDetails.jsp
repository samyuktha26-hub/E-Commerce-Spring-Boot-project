<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>${product.productName} - Fashion Store</title>
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

    <div class="product-container">
        <!-- Left Side: Image -->
        <div class="product-image">
            <img src="${product.imageUrl}" onerror="this.style.display='none'">
        </div>

        <!-- Right Side: Details & Cart Form -->
        <div class="product-info">
            <h1 class="product-title">${product.productName}</h1>
            
            <!-- Assuming your Product.java has getPrice() and getDescription(). If not, just put placeholders! -->
            <p class="product-price">$${product.price != null ? product.price : "0.00"}</p>
            <p class="product-desc">
                ${product.description != null ? product.description : "This is a premium piece from our latest collection. Designed for comfort and styled for the modern aesthetic."}
            </p>

            <!-- Hooked straight into your working CartServlet with the fix we just made! -->
            <form action="<%= request.getContextPath() %>/cart/add" method="POST">
                <input type="hidden" name="productId" value="${product.productId}">
                <input type="hidden" name="productName" value="${product.productName}">
                <input type="hidden" name="imageUrl" value="${product.imageUrl}">
                <select name="sizeLabel" class="size-select" required>
                    <option value="" disabled selected>Select Your Size</option>
                    <option value="S">Small (S)</option>
                    <option value="M">Medium (M)</option>
                    <option value="L">Large (L)</option>
                    <option value="XL">Extra Large (XL)</option>
                </select>

                <button type="submit" class="btn-cart">Add to Cart</button>
            </form>
            
            <a href="<%= request.getContextPath() %>/products" class="back-link">← Continue Shopping</a>
        </div>
    </div>

</body>
</html>