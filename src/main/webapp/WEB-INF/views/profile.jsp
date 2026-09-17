<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>My Profile - Fashion Store</title>
    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;500;600&display=swap" rel="stylesheet">
   <link rel="stylesheet" href="<%= request.getContextPath() %>/assets/css/style.css">
</head>
<body>

    <!-- Unified Navigation Bar -->
    <div class="top-nav">
        <a href="<%= request.getContextPath() %>/home">Home</a>
        <a href="<%= request.getContextPath() %>/products">Shop All</a>
        <a href="<%= request.getContextPath() %>/cart">Cart</a>
        <a href="<%= request.getContextPath() %>/profile" style="border-bottom: 2px solid #000; padding-bottom: 4px;">My Profile</a>
        <a href="<%= request.getContextPath() %>/logout" class="logout-btn">Logout</a>
    </div>

    <div class="dashboard-container">
        
        <!-- Left Side: Account Details -->
      <div class="card user-info">
            <h2>Account Details</h2>
            
            <div class="info-group">
                <label>Full Name</label>
                <p>${sessionScope.loggedInUser.fullName}</p>
            </div>
            
            <div class="info-group">
                <label>Email Address</label>
                <p>${sessionScope.loggedInUser.email}</p>
            </div>
            
            <div class="info-group">
                <label>Phone Number</label>
                <p>${sessionScope.loggedInUser.phone != null ? sessionScope.loggedInUser.phone : 'Not provided'}</p>
            </div>
            
            <div class="info-group">
                <label>Gender</label>
                <p style="text-transform: capitalize;">${sessionScope.loggedInUser.gender != null ? sessionScope.loggedInUser.gender : 'Not specified'}</p>
            </div>
            
            <div class="info-group">
                <label>Shipping Address</label>
                <p>${sessionScope.loggedInUser.address != null ? sessionScope.loggedInUser.address : 'Not provided'}</p>
            </div>
            
            <div class="info-group">
                <label>Account Status</label>
                <p style="color: #28a745; font-weight: 600;">Active</p>
            </div>
            
        </div>

        <!-- Right Side: Order History -->
        <div class="card order-history">
            <h2>Your Order History</h2>
            
            <c:if test="${not empty errorMessage}">
                <p class="error-msg">${errorMessage}</p>
            </c:if>

            <c:if test="${empty orders}">
                <div class="empty-state">
                    <p>You haven't placed any orders yet.</p>
                    <a href="<%= request.getContextPath() %>/products" style="display: inline-block; margin-top: 15px; padding: 10px 20px; background: #000; color: white; text-decoration: none; border-radius: 4px;">Start Shopping</a>
                </div>
            </c:if>

            <c:if test="${not empty orders}">
                <table>
                    <thead>
                        <tr>
                            <th>Order ID</th>
                            <th>Date</th>
                            <th>Payment</th>
                            <th>Total Amount</th>
                            <th>Status</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="order" items="${orders}">
                            <tr>
                                <td>#${order.orderId}</td>
                                
                                <!-- These now perfectly match your Order.java getters! -->
                                <td>${order.orderDate}</td>
                                <td>${order.paymentMethod}</td>
                                <td>$${order.totalAmount}</td>
                                <td>
                                    <span class="status-badge status-completed">${order.orderStatus}</span>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </c:if>
        </div>

    </div>

</body>
</html>