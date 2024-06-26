package org.aibles.java.api.crud.controller;
//
import org.aibles.java.api.crud.dto.ProductReponse;
import org.aibles.java.api.crud.dto.ProductRequest;

import org.aibles.java.api.crud.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
        ProductReponse productResponse = productService.updateProduct(id, productRequest);
        log.info("UPDATE PRODUCT SUCCESSFUL: {}", productResponse);
        return new ResponseEntity<>(productResponse, HttpStatus.OK);
    }
    @GetMapping
    public ResponseEntity<Page<ProductReponse>> getAllProducts(Pageable pageable) {
        log.info("Request to get all product ith paging");
        Page<ProductReponse> products = productService.getAllProducts(pageable);
        return  ResponseEntity.ok(products);
    }
    @GetMapping("/{id}")
    public ResponseEntity<ProductReponse> getProductById(@PathVariable Long id) {
        log.info("GET PRODUCT BY ID: {}",id);
        ProductReponse product = productService.getProductById(id);
        return ResponseEntity.ok(product);
    }
    @GetMapping("/api/v1/products")
    public ResponseEntity<List<ProductReponse>> getProductsByFilter(@RequestParam(required = false) String productName) {
        log.info("Request to get products by filter");
        List<ProductReponse> products = productService.getProductsByFilter(productName);
        return ResponseEntity.ok(products);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        log.info("REQUEST TO DELETE BY WITH ID: {}", id);
        productService.deleteProductById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
