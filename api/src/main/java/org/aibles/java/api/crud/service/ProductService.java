package org.aibles.java.api.crud.service;

import org.aibles.java.api.crud.dto.ProductReponse;
import org.aibles.java.api.crud.dto.ProductRequest;
import org.aibles.java.api.crud.exception.ProductNotFoundException;
import java.util.List;

public interface ProductService {
    ProductReponse createProduct(ProductRequest productRequest);
    List<ProductReponse> getAllProducts();
    ProductReponse getProductById(Long id) throws ProductNotFoundException;
    ProductReponse updateProduct(Long id, ProductRequest productRequest) throws ProductNotFoundException;
    void deleteProductById(Long id) throws ProductNotFoundException;

}
