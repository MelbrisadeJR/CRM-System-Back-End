package com.melbrisade.project.entities;


import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Date;

@Entity
public class Feedback {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(updatable = false)
    private String feedbackSequence;

    @NotBlank()
    private String description;
    private String feedback_status;
    private String priority;

    private Date create_At;
    private Date update_At;

    // Map Customer
    // Map Order
    // Map Product

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
                ", feedbackSequence='" + feedbackSequence + '\'' +
                ", description='" + description + '\'' +
                ", feedback_status='" + feedback_status + '\'' +
                ", priority='" + priority + '\'' +
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

    public String getFeedbackSequence() {
        return feedbackSequence;
    }

    public void setFeedbackSequence(String feedbackSequence) {
        this.feedbackSequence = feedbackSequence;
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

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
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
