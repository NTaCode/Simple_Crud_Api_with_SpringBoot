package com.crud.crud.service;

import com.crud.crud.model.Product;

import java.util.List;

public interface ProductService {
    Product CreateProduct(Product product);
    List<Product> getAllProduct();
    Product updateProduct(Long id,Product product);
    String deleteProduct(Long id);
}
