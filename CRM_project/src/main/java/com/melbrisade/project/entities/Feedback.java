package com.melbrisade.project.entities;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Date;

@Entity
@Getter
@Setter
public class Feedback {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank(message = "Feedback Sequence Required")
    @Column(updatable = false, unique = true)
    private String feedbackSequenceNum;

    @NotBlank(message = "Description Required")
    private String description;
    private String feedback_status;
    private Integer priority;

    @JsonFormat(pattern = "yyyy-mm-dd")
    private Date create_At;
    @JsonFormat(pattern = "yyyy-mm-dd")
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

    @PreUpdate
    protected void onUpdate() {
        this.update_At = new Date();
    }

    @Override
    public String toString() {
        return "Feedback{" +
                "id=" + id +
                ", feedbackSequenceNum='" + feedbackSequenceNum + '\'' +
                ", description='" + description + '\'' +
                ", feedback_status='" + feedback_status + '\'' +
                ", priority=" + priority +
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

    public String getFeedbackSequenceNum() {
        return feedbackSequenceNum;
    }

    public void setFeedbackSequenceNum(String feedbackSequenceNum) {
        this.feedbackSequenceNum = feedbackSequenceNum;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFeedback_status() {
        return feedback_status;
    }

    public void setFeedback_status(String feedback_status) {
        this.feedback_status = feedback_status;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
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
}
