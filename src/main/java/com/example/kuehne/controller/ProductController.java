package com.example.kuehne.controller;

import com.example.kuehne.entity.Customer;
import com.example.kuehne.entity.Product;
import com.example.kuehne.error.CustomerNotFoundException;
import com.example.kuehne.service.CustomerService;
import com.example.kuehne.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    //tested with postman
    @PostMapping("/products")
    public Product saveProduct(@RequestBody Product product){
        return productService.saveProduct(product);

    }

    //tested with postman
    @GetMapping("/products")
    public List<Product> fetchProductList(){
        return productService.fetchProductList();
    }

    //tested with postman
    @GetMapping("/products/{id}")
    public Product fetchProductById(@PathVariable("id") Long id) {
        return productService.fetchProductById(id);
    }

    //tested with  postman
    @DeleteMapping("/products/{id}")
    public String deleteProductById(@PathVariable("id") Long id){
        productService.deleteProductById(id);
        return "Deleted";
    }

    //tested with postman
    @PutMapping("/products/{id}")
    public Product updateProduct(@PathVariable("id") Long id,
                                   @RequestBody Product product){
        return productService.updateProduct(id, product);
    }
}
