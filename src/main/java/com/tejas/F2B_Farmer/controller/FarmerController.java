package com.tejas.F2B_Farmer.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tejas.F2B_Farmer.model.Farmer;
import com.tejas.F2B_Farmer.request.LoginRequest;
import com.tejas.F2B_Farmer.services.FarmerServices;


@CrossOrigin(origins ="http://localhost:4200/")
@RestController
@RequestMapping("/farmer")
public class FarmerController {

    @Autowired
    private FarmerServices farmerServices;
    
   
    @GetMapping()
    
    public List<Farmer> getallfarmerdata() {
        return farmerServices.getallfarmerdata();
    
    }
    
   
    @PostMapping("login")
    public Farmer loginRequest(@RequestBody LoginRequest loginRequest) {
    	
    	return farmerServices.loginRequest(loginRequest);  	
    	
    }

    @PostMapping("insert")
    public boolean addFarmer(@RequestBody Farmer farmer) {
    	System.out.println("working");
    	farmerServices.addFarmer(farmer);
         return true;
    }
     
  
    @DeleteMapping("/{id}")    
    public boolean deletefarmerById(@PathVariable Long id) {
    	
    	
    	farmerServices.deleteFarmerById(id);
    	
    	
     return true;
    }
    

     @PutMapping("/{id}")
    
    public boolean updateFarmer(@PathVariable Long id, @RequestBody Farmer updatedFarmer) {
    	 
    	 farmerServices.updateFarmer(id, updatedFarmer);

     return true;
    }
    
}
















