package com.tejas.F2B_Farmer.model;

import org.springframework.boot.autoconfigure.web.WebProperties.Resources.Chain.Strategy;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
 
public class ImageModel {
	
	
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long imageid;
	private String name ;
	private String type;
	
	
	@Column(length = 50000000)
	private byte[] picByte;
	
	
	
	

}
