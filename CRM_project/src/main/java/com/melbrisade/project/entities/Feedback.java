package com.melbrisade.project.entities;


import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
public class Feedback {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank(message = "Description Required")
    private String description;
    @NotNull(message = "Rating Required")
    @Column(scale = 1)
    private Float rating;

    private String productName;

    private String OrderRef;

    @CreatedDate
    @JsonFormat(pattern = "dd/MM/yyyy")
    @Column(updatable = false)
    private Date create_At;

    @LastModifiedDate
    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date update_At;

    // Map Customer Required (ManyToOne)
    // Map Order Required (ManyToOne)
    // Map Product Required (ManyToOne)
//    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.REFRESH)
//    @JoinColumn(name = "productID", updatable = false, nullable = false)
//    @JsonIgnore
//    private Product product;

    public Feedback() {
    }

    @PrePersist
    protected void onCreate() {
        this.create_At = new Date();

    }
//
    @PreUpdate
    protected void onUpdate() {
        this.update_At = new Date();
    }

    @Override
    public String toString() {
        return "Feedback{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", rate=" + rating +
                ", projectName='" + productName + '\'' +
                ", OrderSequence=" + OrderRef +
                ", create_At=" + create_At +
                ", update_At=" + update_At +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Float getRating() {
        return rating;
    }

    public void setRating(Float rating) {
        this.rating = rating;
    }

    public Date getCreate_At() {
        return create_At;
    }

    public void setCreate_At(Date create_At) {
        this.create_At = create_At;
    }

    public Date getUpdate_At() {
        return update_At;
    }

    public void setUpdate_At(Date update_At) {
        this.update_At = update_At;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String projectName) {
        this.productName = projectName;
    }

    public String getOrderRef() {
        return OrderRef;
    }

    public void setOrderRef(String orderRef) {
        OrderRef = orderRef;
    }
}
