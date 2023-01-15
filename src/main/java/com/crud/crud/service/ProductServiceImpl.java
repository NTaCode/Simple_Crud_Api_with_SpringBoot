package com.crud.crud.service;

import com.crud.crud.model.Product;
import com.crud.crud.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService{

    private final ProductRepository productRepository;


    @Override
    public Product CreateProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public List<Product> getAllProduct() {
        return productRepository.findAll();
    }

    @Override
    public Product updateProduct(Long id,Product product) {
        return productRepository.findById(id)
                .map(p->{
                    p.setName(product.getName());
                    p.setDescription(product.getDescription());
                    p.setPrice(product.getPrice());
                    return productRepository.save(p);
                }).orElseThrow(()->new RuntimeException("Product not found"));
    }

    @Override
    public String deleteProduct(Long id) {
        productRepository.deleteById(id);
        return "product deleted";
    }
}
