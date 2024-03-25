package org.aibles.java.api.crud.dto;
//
public class ProductReponse {
    private Long id;
    private String product_name;
    private String price;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public ProductReponse(Long id, String product_name, String price) {
        this.id = id;
        this.product_name = product_name;
        this.price = price;
    }

    public ProductReponse() {
    }
}
