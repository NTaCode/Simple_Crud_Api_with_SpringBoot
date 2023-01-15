package com.crud.crud.controller;


import com.crud.crud.model.Product;
import com.crud.crud.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class ProductController {
    private final ProductService productService;

    @PostMapping("/create")
    public Product create(@RequestBody Product product){
        return productService.CreateProduct(product);
    }

    @GetMapping("/all")
    public List<Product> getAll(){
        return productService.getAllProduct();
    }

    @PutMapping("/update/{id}")
    public Product update(@PathVariable Long id,@RequestBody Product product){
        return productService.updateProduct(id,product);
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Long id){
        return productService.deleteProduct(id);
    }
}
