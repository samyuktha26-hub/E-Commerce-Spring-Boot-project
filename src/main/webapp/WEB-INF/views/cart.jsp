<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Your Cart - Fashion Store</title>
    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;500;600&display=swap" rel="stylesheet">
  <link rel="stylesheet" href="<%= request.getContextPath() %>/assets/css/style.css">
</head>
<body>

    <div class="top-nav">
        <a href="<%= request.getContextPath() %>/home">Home</a>
        <a href="<%= request.getContextPath() %>/products">Shop All</a>
        <a href="<%= request.getContextPath() %>/profile">My Profile</a>
    </div>

   <div class="cart-container" style="max-width: 800px; margin: 60px auto; background: transparent; border: none; padding: 0 20px;">
        
        <h1 style="font-size: 2.5rem; text-align: center; margin-bottom: 40px;">Your Bag</h1>

        <c:choose>
            <c:when test="${empty sessionScope.cart}">
                <div style="text-align: center; padding: 60px; border: 1px solid #dfd6c8;">
                    <p style="font-size: 18px; color: #555; margin-bottom: 20px;">Your shopping bag is empty.</p>
                    <a href="<%= request.getContextPath() %>/products" class="btn btn-outline" style="width: auto;">Continue Shopping</a>
                </div>
            </c:when>
            
            <c:otherwise>
                <div style="border-top: 1px solid #dfd6c8;">
                    <c:forEach var="item" items="${sessionScope.cart}">
                        
                        <div class="cart-item-row">
                            <img src="${item.imageUrl}" class="cart-img-thumb" onerror="this.style.display='none'">
                            
                            <div class="cart-item-details">
                                <h3>${item.productName}</h3>
                                <p style="color: #888; font-size: 13px; text-transform: uppercase; letter-spacing: 1px;">Size: ${item.sizeLabel}</p>
                            </div>
                            
                            <div style="display: flex; align-items: center; gap: 30px;">
                                <span style="font-size: 16px; font-weight: 500;">Qty: ${item.quantity}</span>
                                
                                <form action="<%= request.getContextPath() %>/cart/remove" method="POST" style="margin: 0;">
                                    <input type="hidden" name="productId" value="${item.productId}">
                                    <input type="hidden" name="sizeLabel" value="${item.sizeLabel}">
                                    <button type="submit" style="background: none; border: none; color: #1a1a1a; cursor: pointer; font-size: 14px; text-decoration: underline;">Remove</button>
                                </form>
                            </div>
                        </div>

                    </c:forEach>
                </div>

                <div class="cart-summary-box">
                    <h3 style="margin-bottom: 20px;">Order Summary</h3>
                    
                    <form action="<%= request.getContextPath() %>/checkout" method="POST">
                        <button type="submit" class="btn btn-primary" style="width: 250px;">Proceed to Checkout</button>
                    </form>
                </div>

            </c:otherwise>
        </c:choose>

    </div>

</body>
</html>