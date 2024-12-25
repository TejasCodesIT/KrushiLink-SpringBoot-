package com.tejas.F2B_Farmer.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.val;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Farmer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long farmerid; // Ensure this matches in ContactUsRepo

    private String firstName;
    private String lastName;

    @Column(unique = true)
    private String email;

    @Column(unique = true)
    private Long phone;

    private String address;

   
    private String password;

    @OneToMany(mappedBy = "farmer",cascade = CascadeType.ALL)
    @JsonManagedReference(value = "farmercontact")
    
    private List<ContactUs> queries;
    
    
    
}


















