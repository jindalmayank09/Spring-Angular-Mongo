package com.mj.acme.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mj.acme.model.ProductMaster;

@Service
public interface ProductService {
	
	public List<ProductMaster> getProductsList();

}
