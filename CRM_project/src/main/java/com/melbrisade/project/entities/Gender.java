package com.melbrisade.project.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name="gender")
public class Gender {
    @Id
    @GeneratedValue
    private int gender_id;

    @Column(name = "gender_type")
    private String gender;
}
