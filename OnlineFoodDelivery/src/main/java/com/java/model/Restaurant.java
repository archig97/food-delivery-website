package com.java.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Restaurant {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @OneToOne //assumption for easier design
    private User owner;

    private String name;

    private String description;

    private String cuisineType;
    @OneToOne
    private Address address;

    private ContactInformation contactInfo;
}
