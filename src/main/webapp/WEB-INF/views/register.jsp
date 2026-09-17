<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Create Account - Fashion Store</title>
    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;500;600&display=swap" rel="stylesheet">
    
    <link rel="stylesheet" href="<%= request.getContextPath() %>/assets/css/style.css">
</head>
<body>

    <div class="top-nav">
        <a href="<%= request.getContextPath() %>/home">Home</a>
        <a href="<%= request.getContextPath() %>/products">Shop All</a>
        <a href="<%= request.getContextPath() %>/login">Sign In</a>
    </div>

    <!-- The Compact Form Container (Slightly wider at 500px to fit the extra fields beautifully) -->
    <div class="form-container" style="max-width: 500px; margin: 60px auto; padding: 50px 40px; background: transparent; border: 1px solid #dfd6c8;">
        
        <div style="text-align: center; margin-bottom: 40px;">
            <h2 style="margin-bottom: 10px;">Become a Member</h2>
            <p style="color: #888; font-size: 13px; text-transform: uppercase; letter-spacing: 1px;">Create your exclusive account</p>
        </div>

        <form action="<%= request.getContextPath() %>/register" method="POST">
            
            <div class="form-group" style="margin-bottom: 20px;">
                <label>Full Name</label>
                <input type="text" name="fullName" required placeholder="Enter your full name" style="width: 100%; padding: 12px; border: 1px solid #ccc; border-radius: 4px;">
            </div>

            <div class="form-group" style="margin-bottom: 20px;">
                <label>Email Address</label>
                <input type="email" name="email" required placeholder="Enter your email" style="width: 100%; padding: 12px; border: 1px solid #ccc; border-radius: 4px;">
            </div>

            <div style="display: flex; gap: 20px; margin-bottom: 20px;">
                <div class="form-group" style="flex: 1;">
                    <label>Phone Number</label>
                    <input type="text" name="phone" placeholder="(555) 000-0000" style="width: 100%; padding: 12px; border: 1px solid #ccc; border-radius: 4px;">
                </div>
                
                <div class="form-group" style="flex: 1;">
                    <label>Gender</label>
                    <select name="gender" style="width: 100%; padding: 12px; border: 1px solid #ccc; border-radius: 4px; background: white;">
                        <option value="unspecified">Prefer not to say</option>
                        <option value="female">Female</option>
                        <option value="male">Male</option>
                        <option value="non-binary">Non-binary</option>
                    </select>
                </div>
            </div>

            <div class="form-group" style="margin-bottom: 20px;">
                <label>Shipping Address</label>
                <!-- Using a textarea for the address so they have room to type -->
                <textarea name="address" placeholder="Enter your full shipping address" rows="3" style="width: 100%; padding: 12px; border: 1px solid #ccc; border-radius: 4px; resize: none; font-family: inherit;"></textarea>
            </div>
            
            <div class="form-group" style="margin-bottom: 30px;">
                <label>Password</label>
                <input type="password" name="password" required placeholder="Create a secure password" style="width: 100%; padding: 12px; border: 1px solid #ccc; border-radius: 4px;">
            </div>
            
            <button type="submit" class="btn btn-primary" style="width: 100%; padding: 15px; background-color: #1a1a1a; color: white; border: none; font-size: 16px; cursor: pointer;">Create Account</button>
            
        </form>

        <div style="text-align: center; margin-top: 25px; font-size: 14px;">
            <p style="color: #555;">Already have an account? <a href="<%= request.getContextPath() %>/login" style="color: #c45b34; font-weight: 500;">Sign in here</a></p>
        </div>
        
    </div>

</body>
</html>