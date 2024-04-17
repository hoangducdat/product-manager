package org.aibles.java.api.crud.entity;
//
import jakarta.persistence.*;
@Entity
@Table(name = "product_manager")
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "product_name")
    private String productName;
    @Column(name = "price")
    private String price;
    @Column(name = "manufacturing_country")
    private String manufacturing_country;

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

    public String getManufacturing_country() {
        return manufacturing_country;
    }

    public void setManufacturing_country(String manufacturing_country) {
        this.manufacturing_country = manufacturing_country;
    }

    @Override
    public String toString() {
        return "ProductEntity{" +
                "id='" + id + '\'' +
                ", productName='" + productName+ '\'' +
                ", price='" + price + '\'' +
                ", manufacturing_country='" + manufacturing_country + '\'' +
                '}';
    }
}
