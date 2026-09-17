<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Fashion Store - Home</title>
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

    <div class="editorial-hero">
        <div class="hero-content">
            <h1>The Summer Edit.</h1>
            <p>Discover our newest collection of lightweight, meticulously crafted essentials.</p>
            <a href="<%= request.getContextPath() %>/products" class="btn btn-outline" style="color: white; border-color: white;">Explore Collection</a>
        </div>
    </div>

    <div class="brand-ethos">
        <h2>Uncompromising Quality. Designed for Life.</h2>
        <p>We believe that true style is timeless. Every piece in our collection is crafted with an obsessive attention to detail, using only the finest sustainable materials. We don't just make clothes; we curate the foundation of your personal aesthetic.</p>
    </div>

    <div class="spotlight-section" style="margin-top: 40px;">
        <div class="spotlight-grid">
            <a href="<%= request.getContextPath() %>/products?category=Men" class="spotlight-card">
                <img src="https://images.unsplash.com/photo-1617137968427-85924c800a22?w=600&q=80" alt="Men's Collection">
                <div class="spotlight-label">Shop Men</div>
            </a>
            <a href="<%= request.getContextPath() %>/products?category=Women" class="spotlight-card">
                <img src="https://images.unsplash.com/photo-1483985988355-763728e1935b?w=600&q=80" alt="Women's Collection">
                <div class="spotlight-label">Shop Women</div>
            </a>
            <a href="<%= request.getContextPath() %>/products?category=Kids" class="spotlight-card">
                <img src="https://images.unsplash.com/photo-1519238263530-99bdd11df2ea?w=600&q=80" alt="Kids' Collection">
                <div class="spotlight-label">Shop Kids</div>
            </a>
        </div>
    </div>

    <div class="newsletter-section">
        <h3>Join The Inner Circle</h3>
        <p>Sign up for exclusive access to new arrivals and private sales.</p>
        <form class="newsletter-form" onsubmit="event.preventDefault(); alert('Thank you for subscribing!');">
            <input type="email" placeholder="Email Address" required>
            <button type="submit">Subscribe</button>
        </form>
    </div>

    <footer class="site-footer">
        <div class="footer-links">
            <a href="<%= request.getContextPath() %>/products">Shop</a>
            <a href="#">About Us</a>
            <a href="#">Shipping & Returns</a>
            <a href="#">Contact</a>
        </div>
        <p>&copy; 2026 The Fashion Store. All Rights Reserved.</p>
    </footer>

</body>
</html>