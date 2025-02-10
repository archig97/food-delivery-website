package com.java.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.java.dto.RestaurantDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.ArrayList;
import java.util.List;

@Entity
@Data  //getters,setters,toString methods can be generated quick with this lombok annotation
@AllArgsConstructor
@NoArgsConstructor //required for it to be a entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String email;
    private String password;
    private USER_ROLE role;

    @JsonIgnore  //since we will be creating API to fetch orders we don;t need full list here
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "customer")//no separate table required for this mapping
    private List<Order> orders = new ArrayList<>();

    @ElementCollection
    private List<RestaurantDto> favorites = new ArrayList<>();
    @OneToMany(cascade = CascadeType.ALL,orphanRemoval = true)//when we delete user, all address info automatically deleted
    private List<Address> addresses = new ArrayList<>();
    private String status;

}
