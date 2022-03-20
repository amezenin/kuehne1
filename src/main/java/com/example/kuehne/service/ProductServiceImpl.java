package com.example.kuehne.service;

import com.example.kuehne.entity.Customer;
import com.example.kuehne.entity.Product;
import com.example.kuehne.repository.CustomerRepository;
import com.example.kuehne.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public List<Product> fetchProductList() {
        return productRepository.findAll();
    }

    @Override
    public Product fetchProductById(Long id) {
        return productRepository.findById(id).get();
    }

    @Override
    public void deleteProductById(Long id) {
         productRepository.deleteById(id);

    }

    @Override
    public Product updateProduct(Long id, Product product) {
        Product productDB = productRepository.findById(id).get();

        if(Objects.nonNull(product.getName()) &&
                !"".equalsIgnoreCase(product.getName())){
            productDB.setName(product.getName());
        }

        if(Objects.nonNull(product.getSkuCode()) &&
                !"".equalsIgnoreCase(product.getSkuCode())) {
            productDB.setSkuCode(product.getSkuCode());
        }

        if(Objects.nonNull(product.getUnitPrice())) {
            productDB.setUnitPrice(product.getUnitPrice());
        }


        return productRepository.save(productDB);
    }
}
