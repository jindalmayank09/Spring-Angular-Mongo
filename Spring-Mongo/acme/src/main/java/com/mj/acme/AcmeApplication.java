package com.mj.acme;

import java.util.Arrays;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

import com.mj.acme.model.ProductMaster;
import com.mj.acme.queries.ProductDetailsQueries;

@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class })
public class AcmeApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(AcmeApplication.class, args);
	}

	private ProductDetailsQueries productDetailsQueries;

	public AcmeApplication(ProductDetailsQueries productDetailsQueries) {
		super();
		this.productDetailsQueries = productDetailsQueries;
	}

	@Override
	public void run(String... args) throws Exception {

		System.out.println("----\n QUERY:All Products Details");
		List<ProductMaster> allProductMasters = this.productDetailsQueries.findAll("productId", 1, 100);  
		ProductPrinter.print(allProductMasters);

		System.out.println("----\n QUERY:Get Product Details By Id");
		ProductMaster productMaster = this.productDetailsQueries.findByProductId(1);
		if (productMaster != null)
			ProductPrinter.print(Arrays.asList(productMaster));

	}

}
