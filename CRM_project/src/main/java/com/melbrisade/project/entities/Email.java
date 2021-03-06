package com.melbrisade.project.entities;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Getter
@Setter
@Table(name = "email" )
public class Email {
    @Id
    @GeneratedValue
    @Column(name = "email_id")
    private Long email_id;

    @Column(name = "subject")
    private String subject;

    @Column(name = "template")
    private String template;

    @Column(name = "status")
    private int status;

    @Column(name = "attachment_url")
    private String attachment_url;

    @Column(name = "content")
    private String content;

    @Column(name = "recipient")
    private String recipient;

    @Column(name = "sent_time")
    private LocalDate sent_time;
}
