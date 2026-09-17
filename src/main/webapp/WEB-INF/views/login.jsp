<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login - Fashion Store</title>
    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;500;600&display=swap" rel="stylesheet">
    
   <link rel="stylesheet" href="<%= request.getContextPath() %>/assets/css/style.css">
</head>
<body>

    <div class="top-nav">
        <a href="<%= request.getContextPath() %>/home">Home</a>
        <a href="<%= request.getContextPath() %>/products">Shop All</a>
    </div>

    <div class="form-container" style="max-width: 400px; margin: 80px auto; padding: 50px 40px; background: transparent; border: 1px solid #dfd6c8;">
        
        <div style="text-align: center; margin-bottom: 40px;">
            <h2 style="margin-bottom: 10px;">Welcome Back</h2>
            <p style="color: #888; font-size: 13px; text-transform: uppercase; letter-spacing: 1px;">Sign in to your account</p>
        </div>

        <form action="<%= request.getContextPath() %>/login" method="POST">
            
            <div class="form-group">
                <label>Email Address</label>
                <input type="email" name="email" required placeholder="Enter your email">
            </div>
            
            <div class="form-group" style="margin-bottom: 30px;">
                <label>Password</label>
                <input type="password" name="password" required placeholder="Enter your password">
            </div>
            
            <button type="submit" class="btn btn-primary">Sign In</button>
            
        </form>

        <div style="text-align: center; margin-top: 25px; font-size: 14px;">
            <p style="color: #555;">Don't have an account? <a href="<%= request.getContextPath() %>/register" style="color: #c45b34; font-weight: 500;">Register here</a></p>
        </div>
        
    </div>

</body>
</html>