package com.tejas.F2B_Farmer.services;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tejas.F2B_Farmer.model.Buyer;
import com.tejas.F2B_Farmer.repositories.BuyerRepository;
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
     public String updatebuyer(Long id, Buyer newbuyerData) {
        if (buyerRepository.existsById(id)) {
            newbuyerData.setBuyerid(id);  
            buyerRepository.save(newbuyerData); 
            return "Farmer updated successfully";
        } else {
            return "Farmer not found";
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
     
     
    
    
}





