<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Checkout Review - Fashion Store</title>
    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;500;600&display=swap" rel="stylesheet">
   <link rel="stylesheet" href="<%= request.getContextPath() %>/assets/css/style.css">
</head>
<body>

    <div class="checkout-container">
        
        <!-- Left Side: Shipping & User Details -->
        <div class="card">
            <h2>Shipping Details</h2>
            
            <c:if test="${not empty errorMessage}">
                <p class="error-msg">${errorMessage}</p>
            </c:if>

            <div class="info-group">
                <label>Deliver To</label>
                <p>${sessionScope.loggedInUser.fullName}</p>
            </div>
            <div class="info-group">
                <label>Contact Number</label>
                <p>${sessionScope.loggedInUser.phone}</p>
            </div>
            <div class="info-group">
                <label>Shipping Address</label>
                <p>${sessionScope.loggedInUser.address}</p>
            </div>
            <div class="info-group">
                <label>Payment Method</label>
                <p>Cash on Delivery (Default)</p>
            </div>
        </div>

        <!-- Right Side: Order Summary -->
        <div class="card">
            <h2>Order Summary</h2>
            
            <c:forEach var="item" items="${sessionScope.cart}">
                <div class="cart-summary-item">
                    <span>Product #${item.productId} (Size: ${item.sizeLabel})</span>
                    <span>Qty: ${item.quantity}</span>
                </div>
            </c:forEach>
            
            <div class="total-row">
                <span>Estimated Total:</span>
                <!-- Temporary $0.00 display since prices are disabled right now -->
                <span>$${checkoutTotal}</span> 
            </div>

            <!-- The Form that triggers the Database Insert -->
            <form action="<%= request.getContextPath() %>/checkout" method="POST">
                <button type="submit" class="btn-confirm">Confirm & Place Order</button>
            </form>
            
            <a href="<%= request.getContextPath() %>/cart" style="display: block; text-align: center; margin-top: 15px; color: #666; text-decoration: none;">← Back to Cart</a>
        </div>

    </div>

</body>
</html>