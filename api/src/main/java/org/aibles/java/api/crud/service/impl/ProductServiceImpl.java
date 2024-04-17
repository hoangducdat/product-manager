package org.aibles.java.api.crud.service.impl;

import org.aibles.java.api.crud.dto.ProductReponse;
import org.aibles.java.api.crud.dto.ProductRequest;
import org.aibles.java.api.crud.entity.ProductEntity;
import org.aibles.java.api.crud.reponsitory.ProductRepository;
import org.aibles.java.api.crud.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
//

@Service
public class ProductServiceImpl implements ProductService {
    private static final Logger log = LoggerFactory.getLogger(ProductServiceImpl.class);
    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
    @Override
    public ProductReponse createProduct(ProductRequest productRequest) {
        log.info("(===CREATE PRODUCT===) productRequest: {}", productRequest);
        ProductEntity product = new ProductEntity();
        product.setProductName(productRequest.getProductName());
        product.setPrice(productRequest.getPrice());
        ProductEntity savedProduct = productRepository.save(product);
        return new ProductReponse(savedProduct.getId(), savedProduct.getProductName(), savedProduct.getPrice());
    }

    @Override
    public Page<ProductReponse> getAllProducts(Pageable pageable) {
        log.info("GET ALL PRODUCT");
        List<ProductEntity> products = productRepository.findAll();
        return productRepository.findAll(pageable)
                .map(product -> new ProductReponse(product.getId(), product.getProductName(), product.getPrice()));
    }

    @Override
    public ProductReponse getProductById(Long id) {
        log.info("GET PRODUCT WITH ID: {}",id);
        Optional<ProductEntity> optionalProduct = productRepository.findById(id);
        if (optionalProduct.isPresent()) {
            ProductEntity product = optionalProduct.get();
            return new ProductReponse(product.getId(), product.getProductName(), product.getPrice());
        } else {
            throw new RuntimeException("Product not found with id: " + id);
        }
    }

    @Override
    public ProductReponse updateProduct(Long id, ProductRequest productRequest)  {
        log.info("UPDATE PRODUCT WITH ID: {}", id);
        Optional<ProductEntity> optionalProduct = productRepository.findById(id);
        if (optionalProduct.isPresent()) {
            ProductEntity product = optionalProduct.get();
            product.setProductName(productRequest.getProductName());
            product.setPrice(productRequest.getPrice());
            ProductEntity updatedProduct = productRepository.save(product);
            return new ProductReponse(updatedProduct.getId(), updatedProduct.getProductName(), updatedProduct.getPrice());
        } else {
            throw new RuntimeException("Product not found with id: " + id);
        }
    }

    @Override
    public void deleteProductById(Long id) {
        log.info("DELETE PRODUCT BY ID: {}",id);
        productRepository.deleteById(id);
    }
    @Override
    public List<ProductReponse> getProductsByFilter(String productName) {
        log.info("Request to get products by filter");
        List<ProductEntity> products;
        if (productName != null && !productName.isEmpty()) {
            products = productRepository.findByProductNameContainingIgnoreCase(productName);
        } else {
            products = productRepository.findAll();
        }
        return products.stream()
                .map(product -> new ProductReponse(product.getId(), product.getProductName(), product.getPrice()))
                .collect(Collectors.toList());
    }
}
