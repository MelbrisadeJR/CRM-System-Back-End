package com.melbrisade.project.entities;

import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;

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

    @Column(name = "discounts", nullable = true)
    private float discounts;

    @Column(name = "SKU", nullable = false)
    private int SKU;

    @Column(name = "product_price", nullable = false)
    private float product_price;

    @Column(name = "product_cost", nullable = false)
    private float product_cost;

    @Column(name = "category", nullable = true)
    private String category;

    @Column(name = "manufacture", nullable = true)
    private String manufacture;

    @Column(name = "image", nullable = true)
    private byte image;

}
