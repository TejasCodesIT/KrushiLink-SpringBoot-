package com.tejas.F2B_Farmer.services;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tejas.F2B_Farmer.model.Buyer;
import com.tejas.F2B_Farmer.model.Farmer;
import com.tejas.F2B_Farmer.repositories.BuyerRepository;
import com.tejas.F2B_Farmer.request.ChangePassword;
import com.tejas.F2B_Farmer.request.LoginRequest;




@Service
public class BuyerServices {

     @Autowired
    private BuyerRepository buyerRepository ;

    
    public List<Buyer> getallbuyerdata(){

        return buyerRepository.findAll();
    }

     // Add a new buyer
     public boolean addbuyer(Buyer buyer) {
    	 buyerRepository.save(buyer);
     return true;
    }
     
     
     
     

     // Find a buyer by ID
     public Optional<Buyer> findbuyerById(Long id) {
        return buyerRepository.findById(id); 
    }

    public String deletebuyerById(Long id) {
    	buyerRepository.deleteById(id); 
         return "buyer data is deleted"; 
    }
    
    
    
    

     // Update a buyer by ID
     public Buyer updatebuyer(Long id, Buyer newbuyerData) {
    	 
    	 
    	Buyer dbBuyer = buyerRepository.findById(id).get();
    	 
    	 
        if (dbBuyer!=null) {
        	
            newbuyerData.setBuyerid(id);  
            newbuyerData.setPassword(dbBuyer.getPassword());
            
            buyerRepository.save(newbuyerData); 
            
            return newbuyerData;
            
        } else {
        	
            return null;
            
        }
    }
     
     
     public Buyer buyerlogin(LoginRequest loginRequest) {
    	 
    	 
    	 Buyer dbbuyer =buyerRepository.findByEmail(loginRequest.getUsername());
    	 
    	 
    	 if(dbbuyer==null) {
    		 
    		 return null;
    		 
    		 
    	 }
    	 else if(dbbuyer.getPassword().equals(loginRequest.getPassword())) {
    		 
    		 
    		 return dbbuyer;
    		 
    	 }
    	 
    	 
    	 
    	 return null;
    	 
    	 
    	 
     }
     
     
     
     
     public boolean changePassword(ChangePassword changePass,Long id) {
    	 
    	 
     	Buyer buyer =  findbuyerById(id).get();
     	
     	String dbpassword = buyer.getPassword();
     	
     	String oldpass = changePass.getOldPassword();
     	
     	String newpassword = changePass.getNewPassword();
     	
     	System.err.println(newpassword+" new password");

     	// Use .equals() to compare the strings
     	if (dbpassword.equals(oldpass)) {
     		
     		buyer.setPassword(newpassword);
     	    
     	    System.err.println("From if statement");
     	    
     	    System.err.println("From farmer " + buyer.getPassword() );
     	    
     	    
     	    addbuyer(buyer);
     	    
     	    
     	    return true;
     	} else {
     	    return false;
     	 
     
     
 }}
     
     
    
    
}






