package com.mj.acme.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mj.acme.model.ProductMaster;
import com.mj.acme.service.ProductService;

/**
 * @author mayankjindal
 *
 */
@RestController
public class ProductController {
	
	@Autowired
	ProductService productService; 

	@CrossOrigin(origins = "*")
	@GetMapping(value="/getProductsList")
	public List<ProductMaster> getAllProducts(){
		
		return productService.getProductsList();
		
	}
	
	public ProductController() {
		// TODO Auto-generated constructor stub
	}

}
