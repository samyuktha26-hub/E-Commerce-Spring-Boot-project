package com.fashionstore.dao;

import com.fashionstore.model.ProductSize;
import java.util.List;

public interface ProductSizeDao {
    List<ProductSize> getSizesForProduct(int productId);
    boolean updateStockQuantity(int productSizeId, int newQuantity);
    ProductSize getProductSizeById(int productSizeId);
}