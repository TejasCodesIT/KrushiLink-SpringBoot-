package com.tejas.F2B_Farmer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*; // Import RestController annotations
import com.tejas.F2B_Farmer.model.Buyer;
import com.tejas.F2B_Farmer.services.BuyerServices;


@CrossOrigin(origins ="http://localhost:4200/")
@RestController // Changed from @Controller to @RestController
@RequestMapping("buyer")
public class BuyerController {

    @Autowired
    private BuyerServices buyerServices;

    
    @CrossOrigin(origins ="http://localhost:4200/")
    @GetMapping() // Add a forward slash for consistency
    public List<Buyer> getallbuyerdata() {
        return buyerServices.getallbuyerdata();
    }
    
    
    

    // Add a new buyer
    @CrossOrigin(origins ="http://localhost:4200/")
    @PostMapping()
    public boolean addBuyer(@RequestBody Buyer buyer) {
    	
    	
    	 return buyerServices.addbuyer(buyer);
       
    }
    
    
    
    
    @CrossOrigin(origins ="http://localhost:4200/")
    @DeleteMapping("/{id}")
    public boolean deleteBuyerById(@PathVariable Long id) {
    	buyerServices.deletebuyerById(id);
        return true;
    }
    
    
    
    
    
    @CrossOrigin(origins ="http://localhost:4200/")
    @PutMapping("/{id}") 
    public boolean updateBuyer(@PathVariable Long id, @RequestBody Buyer updatedbuyer) {
    	buyerServices.updatebuyer(id, updatedbuyer);
        return true;
    }
     
}















