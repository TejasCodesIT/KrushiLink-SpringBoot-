package com.tejas.F2B_Farmer.model;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
//import jakarta.persistence.Lob;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long postid;
    private String name;
    private String description;
    private Double price;
    
    //** ** Image Logic to store in database
    @ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinTable(name="post_images",
    	joinColumns = {
    			@JoinColumn(name="postid"),
    			
    	},
    	
    	inverseJoinColumns = {
    			@JoinColumn (name="imageid")
})
    
    
    private Set<ImageModel> postImages; 

 
    
    @ManyToOne
    @JoinColumn(name="farmerid")
    @JsonBackReference(value="farmerpost")
    private Farmer farmer;
    
    
    
}