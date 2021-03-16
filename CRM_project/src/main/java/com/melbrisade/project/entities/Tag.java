package com.melbrisade.project.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name="tag")
public class Tag {
    @Id
    @GeneratedValue
    private int tag_id;

    @Column(name = "tag_type")
    private String tag;
}
