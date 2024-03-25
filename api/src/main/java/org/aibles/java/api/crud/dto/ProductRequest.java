package org.aibles.java.api.crud.dto;
//
public class ProductRequest {
    private String product_name;
    private String price;
    public ProductRequest(String product_name, String price) {
        this.product_name = product_name;
        this.price = price;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String productName) {
        this.product_name = productName;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
