package com.tejas.F2B_Farmer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tejas.F2B_Farmer.model.ContactUs;
import com.tejas.F2B_Farmer.services.ContactUsService;

@RestController
@RequestMapping("/contact")
@CrossOrigin(origins ="http://localhost:4200/")
public class ContactUsController {
	
	@Autowired
	private ContactUsService contactUsService;
	
	public void contactus() {
				
	}
	
	@PostMapping("farmer")
	public String saveRequest(@RequestBody ContactUs contactUs) {
			
		return contactUsService.postContact(contactUs);		
		
	}
	
	
	@PostMapping("buyer")
	public String buyerRequest(@RequestBody ContactUs contactUs) {
			
		return contactUsService.postContact(contactUs);		
		
	}
	
	
	  @GetMapping("/farmer/{farmerid}")
	    public List<ContactUs> getContactsByFarmer(@PathVariable Long farmerid) {
	        return contactUsService.getContactByFarmer(farmerid);
	    }
	  
	  	  
	  
	  @GetMapping("/buyer/{buyerid}")
	    public List<ContactUs> getContactsByBuyer(@PathVariable Long buyerid) {
	        return contactUsService.getContactUsByBuyer(buyerid);
	    }
	

}





















