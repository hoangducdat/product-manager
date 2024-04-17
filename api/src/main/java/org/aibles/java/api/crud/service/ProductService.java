package org.aibles.java.api.crud.service;

import org.aibles.java.api.crud.dto.ProductReponse;
import org.aibles.java.api.crud.dto.ProductRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProductService {
    ProductReponse createProduct(ProductRequest productRequest);
    //List<ProductReponse> getAllProducts();
    ProductReponse getProductById(Long id) ;
    ProductReponse updateProduct(Long id, ProductRequest productRequest) ;
    void deleteProductById(Long id) ;
    Page<ProductReponse> getAllProducts(Pageable pageable);
    List<ProductReponse> getProductsByFilter(String productName);
}
