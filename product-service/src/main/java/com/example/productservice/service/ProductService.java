package com.example.productservice.service;

import com.example.productservice.dto.ProductRequest;
import com.example.productservice.dto.ProductResponse;
import com.example.productservice.model.Product;
import com.example.productservice.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor //will create the constructor for us
@Slf4j
public class ProductService {
    private  final ProductRepository productRepository;

    public void createProduct(ProductRequest productRequest) {
        Product product = Product.builder()
                .name(productRequest.getName())
                .description(productRequest.getDescription())
                .price(productRequest.getPrice())
                .build(); // build the product

        productRepository.save(product); // save product to database;
        log.info("Product {} is saved", product.getId()); //logging informational log message
    }

    public List<ProductResponse> getAllProducts() {
        List<Product> products = productRepository.findAll(); //get all the list of products

        return products.stream().map(this::mapToProductResponse).toList(); // return all the list using map method
    }

    private ProductResponse mapToProductResponse(Product product) {
        return ProductResponse.builder()
                .id(product.getId())
                .name(product.getName())
                .description(product.getDescription())
                .price(product.getPrice())
                .build();
    }
}
