package com.melbrisade.project.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name="product")
public class Product{
    @Id
    @GeneratedValue
    @Column(name = "product_id", nullable = false)
    private Long product_id;

    @Column(name = "product_name", nullable = false)
    private String product_name;

    @Column(name = "stock", nullable = false)
    private int stock;

    @Column(name = "discounts", nullable = true, precision=2, scale=0)
    private float discounts;

    @Column(name = "SKU", nullable = false)
    private int SKU;

    @Column(name = "product_price", nullable = false, precision=2, scale=0)
    private float product_price;

    @Column(name = "product_cost", nullable = false, precision=2, scale=0)
    private float product_cost;

    @Column(name = "category", nullable = true)
    private String category;

    @Column(name = "manufacture", nullable = true)
    private String manufacture;

    @Column(name = "image", nullable = true)
    private byte image;

}

public Product() {
}

public Product(String product_name, int stock,  float discounts, int SKU, float product_price, float product_cost, String category, String manufacture, byte image){
    this.product_name = product_name;
    this.stock = stock;
    this.discounts = discounts;
    this.SKU = SKU;
    this.product_price = product_price;
    this.product_cost = product_cost;
    this.category = category;
    this.manufacture = manufacture;
    this.image = image;
}

public Long getProduct_id(){
    return product_id;
}

public void setProduct_id(Long product_id){
    this.product_id = product_id;
}

public int getStock(){
    return stock;
}

public void setStock(int stock){
    this.stock = stock;
}

public float getDiscounts(){
    return discounts;
}

public void setDiscounts(float discounts){
    this.discounts = discounts;
}

public int getSKU(){
    return SKU;
}

public void setSKU(int SKU){
    this.SKU = SKU;
}

public float getProduct_price(){
    return product_price;
}

public void setProduct_price(float product_price){
    this.product_price = product_price;
}

public float getProduct_cost(){
    return product_cost;
}

public void setProduct_cost(float product_cost){
    this.product_cost = product_cost;
}

public String getCategory(){
    return category;
}

public void setCategory(String category){
    this.category = category;
}

public String getManufacture(){
    return manufacture;
}

public void setManufacture(String manufacture){
    this.manufacture = manufacture;
}

public String getProduct_name(){
    return product_name;
}

public void setProduct_name(String product_name){
    this.product_name = product_name;
}

public byte getImage(){
    return image;
}

public void setImage(byte image){
    this.image = image;
}
