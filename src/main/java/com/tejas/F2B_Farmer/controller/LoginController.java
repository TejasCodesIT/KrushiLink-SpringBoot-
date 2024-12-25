package com.tejas.F2B_Farmer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.tejas.F2B_Farmer.model.Buyer;
import com.tejas.F2B_Farmer.model.Farmer;
import com.tejas.F2B_Farmer.request.ChangePassword;
import com.tejas.F2B_Farmer.request.LoginRequest;
import com.tejas.F2B_Farmer.services.BuyerServices;
import com.tejas.F2B_Farmer.services.FarmerServices;

import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("/login")
@CrossOrigin(origins = "http://localhost:4200/")
public class LoginController {
	
	private Farmer dbfarmer;
	
	private Buyer dbbuyer;

    @Autowired
   private FarmerServices farmerServices;

    @Autowired
   private BuyerServices buyerServices;
    
    
  

    // Farmer login request
    @CrossOrigin(origins = "http://localhost:4200/")
    @PostMapping("farmer")
    public Farmer farmerCredentials(@RequestBody LoginRequest loginRequest, HttpSession session) {
    	

        
        Farmer farmer = farmerServices.loginRequest(loginRequest);

    System.out.println(farmer+"farmer object retrive from database");
      
        if (farmer != null) {
        
           
            dbfarmer = farmer;
            
            System.out.println(dbfarmer);
            
           return dbfarmer;
            
           
        } else {
        	
        	System.out.println("db farme validation get wroing");
            return null;
        }

 
    }

    // Buyer login request
    @PostMapping("buyer")
    public Buyer buyerCredentials(@RequestBody LoginRequest loginRequest, HttpSession session) {
      
        Buyer dbBuyer = buyerServices.buyerlogin(loginRequest);

     
        if (dbBuyer != null) {
            session.setAttribute("Buyer", dbBuyer);
        } else {
            session.setAttribute("Buyer", null);
        }

        return dbBuyer; 
    }

   
    @GetMapping("currentFarmer")
    public Farmer getCurrentFarmer(HttpSession session) {
      
    	
    	
        Farmer currentFarmer = (Farmer) session.getAttribute("Farmer");
        
        System.out.println("Current Farmer in session: " + dbfarmer);
        
        
        
        return dbfarmer; 
    }

    
    @GetMapping("currentBuyer")
    public Buyer getCurrentBuyer(HttpSession session) {
 
    	
        Buyer currentBuyer = (Buyer) session.getAttribute("Buyer");
        return currentBuyer; 
    }
    
    
    
    @CrossOrigin(origins = "http://localhost:4200/")
    @PostMapping("changepassword")
    public boolean changePassword(@RequestBody ChangePassword changePassword) {
    	
    	
    	Long farmerid = dbfarmer.getFarmerid();
    	//System.err.println(farmerServices.changePassword(changePassword, farmerid)+" from change pasword frm login");
    	
      return farmerServices.changePassword(changePassword, farmerid);
    
    	
    	
    }
    
    
    
    
    
}
	