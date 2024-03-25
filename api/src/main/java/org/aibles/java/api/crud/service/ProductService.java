package org.aibles.java.api.crud.service;


import org.aibles.java.api.crud.dto.ProductReponse;
import org.aibles.java.api.crud.dto.ProductRequest;
import org.aibles.java.api.crud.exception.ProductNotFound;

import java.util.List;

public interface ProductService {
    ProductReponse createProduct(ProductRequest productRequest);
    List<ProductReponse> getAllProducts();
    ProductReponse getProductById(Long id) throws ProductNotFound;
    ProductReponse updateProduct(Long id, ProductRequest productRequest) throws ProductNotFound;
    void deleteProductById(Long id) throws ProductNotFound;

}
