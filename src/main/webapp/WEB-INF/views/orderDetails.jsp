<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Order Details - Fashion Store</title>
    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;500;600&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="<%= request.getContextPath() %>/assets/css/style.css">
</head>
<body>

    <div class="receipt-container">
        
        <div class="header">
            <h2>Order #${order.orderId}</h2>
            <span class="status-badge">${order.orderStatus}</span>
        </div>

        <div class="order-info">
            <div>
                <label style="color: #888; font-size: 12px; text-transform: uppercase;">Order Date</label>
                <p>${order.orderDate}</p>
            </div>
            <div>
                <label style="color: #888; font-size: 12px; text-transform: uppercase;">Payment Method</label>
                <p>${order.paymentMethod}</p>
            </div>
            <div style="text-align: right; max-width: 250px;">
                <label style="color: #888; font-size: 12px; text-transform: uppercase;">Delivered To</label>
                <p>${order.deliveryAddress}</p>
            </div>
        </div>

        <table>
            <thead>
                <tr>
                    <th>Product</th>
                    <th>Size</th>
                    <th>Price</th>
                    <th>Qty</th>
                    <th style="text-align: right;">Subtotal</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="item" items="${orderItems}">
                    <tr>
                        <td style="font-weight: 500;">${item.productName}</td>
                        <td>${item.sizeLabel}</td>
                        <td>$${item.unitPrice}</td>
                        <td>${item.quantity}</td>
                        <td style="text-align: right;">$${item.subtotal}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>

        <div class="totals">
            <p class="grand-total">Total Amount: $${order.totalAmount}</p>
        </div>

        <a href="<%= request.getContextPath() %>/profile" class="btn-back">← Back to Profile</a>

    </div>

</body>
</html>
```</OrderItem>