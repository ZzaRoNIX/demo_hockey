package com.example.demo_hockey.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Additional {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;
    String info;
    String value;
    @ManyToOne
    Arena arena;
}
