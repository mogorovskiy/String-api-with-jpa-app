package com.mogorovskiy.Stringjpaapp.model;

import jakarta.persistence.*;
import lombok.*;

@Entity // table in DB
@Getter
@Setter
public class Lamp {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;

    @Column(nullable = false)
    private Long power;

    @Column(nullable = false)
    private String manufacturer;
}
