<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Order Successful - Fashion Store</title>
    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;500;600&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="<%= request.getContextPath() %>/assets/css/style.css">
</head>
<body>

    <div class="success-card">
        <div class="icon">✅</div>
        <h1>Order Confirmed!</h1>
        <p>Thank you for shopping with us! Your order has been successfully placed and is now processing.</p>
        
        <div class="btn-group">
            <!-- Sends them to their profile to see the digital receipt -->
            <a href="<%= request.getContextPath() %>/profile" class="btn btn-outline">View Receipt</a>
            
            <!-- Sends them back to the store -->
            <a href="<%= request.getContextPath() %>/products" class="btn btn-primary">Continue Shopping</a>
        </div>
    </div>

</body>
</html>