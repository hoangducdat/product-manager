package org.aibles.java.api.crud.controller;

import org.aibles.java.api.crud.dto.ProductReponse;
import org.aibles.java.api.crud.dto.ProductRequest;
import org.aibles.java.api.crud.exception.ProductNotFoundException;
import org.aibles.java.api.crud.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {
    private static final Logger log = LoggerFactory.getLogger(ProductController.class);
    @Autowired
    private ProductService productService;
    @PostMapping
    public ResponseEntity<ProductReponse> createProduct(@RequestBody ProductRequest productRequest) {
        log.info("REQUEST TO CREATE PRODUCT");
        ProductReponse productReponse = productService.createProduct(productRequest);
        log.info("CREATE PRODUCT SUCCESSFUL: {}", productReponse);
        return new ResponseEntity<>(productReponse, HttpStatus.CREATED);

    }
    @PutMapping("/{id}")
    public ResponseEntity<ProductReponse> updateProduct(@PathVariable Long id, @RequestBody ProductRequest productRequest) {
        log.info("REQUEST TO UPDATE PRODUCT WITH ID: {}", id);
        try {
            ProductReponse productResponse = productService.updateProduct(id, productRequest);
            log.info("UPDATE PRODUCT SUCCESSFUL: {}", productResponse);
            return new ResponseEntity<>(productResponse, HttpStatus.OK);
        } catch (ProductNotFoundException e) {
            log.error("UPDATE FAILED: {}", e.getMessage());
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping
    public ResponseEntity<List<ProductReponse>> getAllProducts() {
        log.info("Request to get all product");
        List<ProductReponse> products = productService.getAllProducts();
        return  ResponseEntity.ok(products);
    }
    @GetMapping("/{id}")
    public ResponseEntity<ProductReponse> getProductById(@PathVariable Long id) {
        log.info("GET PRODUCT BY ID: {}",id);
        try {


            ProductReponse product = productService.getProductById(id);
            return ResponseEntity.ok(product);
        } catch (ProductNotFoundException e) {
            log.error("GET PRODUCT BY ID FAILED: {}", e.getMessage());
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        log.info("REQUEST TO DELETE BO WITH ID: {}", id);
        try {
            productService.deleteProductById(id);
        } catch (ProductNotFoundException e) {
            log.error("DELETE PRODUCT BY ID FAILED: {}", e.getMessage());
            throw new RuntimeException(e);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
