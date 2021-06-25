package com.mj.acme.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mj.acme.model.ProductMaster;
import com.mj.acme.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	ProductRepository productRepository;

	public ProductServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<ProductMaster> getProductsList() {
		return productRepository.findAll();
	}

}
