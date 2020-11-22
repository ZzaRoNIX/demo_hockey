package com.example.demo_hockey.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

// модели
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
public class Trainer {

    // @GeneratedValue(strategy = GenerationType.AUTO)
    // int id;
    @Id
    String fullName;
    Date bornDate;
    String education;
    String profCareer;
    String workExperience;
    String description;
    // @Builder.Default
    // private Date created = new Date();
}
