package com.melbrisade.project.entities;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Getter
@Setter
@Table(name="order")
public class Order {
    @Column(name = "adjustment_price")
    private String adjustment_price;

    @Column(name = "discount")
    private String discount;

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    private UUID order_id;

    @Column(name = "promotion")
    private String promotion;

    @Column(name = "purchase_date")
    private String purchase_date;

    @Column(name = "purchase_number")
    private int purchase_number;

    @Column(name = "shipment_price")
    private String shipment_price;

    @Column(name = "total_price")
    private String total_price;

    @Column(name = "GST")
    private String GST;

    @Column(name = "customer_id")
    private UUID customer_id;


}
