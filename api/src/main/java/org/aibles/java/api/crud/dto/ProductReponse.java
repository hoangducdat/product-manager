package org.aibles.java.api.crud.dto;
//
public class ProductReponse {
    private Long id;
    private String productName;
    private String price;
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getProductName() {
        return productName;
    }
    public void setProductName(String productName) {
        this.productName = productName;
    }
    public String getPrice() {
        return price;
    }
    public void setPrice(String price) {
        this.price = price;
    }
    public ProductReponse() {
    }
    public ProductReponse(Long id, String productName, String price) {
        this.id = id;
        this.productName = productName;
        this.price = price;
    }

}
