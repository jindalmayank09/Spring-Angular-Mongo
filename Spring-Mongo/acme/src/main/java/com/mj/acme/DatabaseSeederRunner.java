package com.mj.acme;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

import com.mj.acme.model.ProductMaster;
import com.mj.acme.repository.ProductRepository;

@Component
@Order(1)
public class DatabaseSeederRunner implements CommandLineRunner {

	private ProductRepository productRepository;

	public DatabaseSeederRunner(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}

	@Override
	public void run(String... args) throws Exception {
		empty();
		seed();

	}

	private void seed() {
		ProductMaster productMaster = new ProductMaster();
		productMaster.setProductId(1);
		productMaster.setProductName("Leaf Rake");
		productMaster.setProductCode("GDN-0011");
		productMaster.setReleaseDate(new Date());
		productMaster.setDescription("Leaf rake with 48-inch wooden handle.");
		productMaster.setPrice(19.95);
		productMaster.setStarRating("3.2");
		productMaster.setImageUrl("assets/images/leaf_rake.png");

		ProductMaster productMaster2 = new ProductMaster();
		productMaster2.setProductId(2);
		productMaster2.setProductName("Garden Cart");
		productMaster2.setProductCode("GDN-0023");
		productMaster2.setReleaseDate(new Date());
		productMaster2.setDescription("15 gallon capacity rolling garden cart");
		productMaster2.setPrice(32.99);
		productMaster2.setStarRating("4.2");
		productMaster2.setImageUrl("assets/images/garden_cart.png");

		ProductMaster productMaster3 = new ProductMaster();
		productMaster3.setProductId(3);
		productMaster3.setProductName("Hammer");
		productMaster3.setProductCode("TBX-0048");
		productMaster3.setReleaseDate(new Date());
		productMaster3.setDescription("Curved claw steel hammer");
		productMaster3.setPrice(8.9);
		productMaster3.setStarRating("4.8");
		productMaster3.setImageUrl("assets/images/hammer.png");

		ProductMaster productMaster4 = new ProductMaster();
		productMaster4.setProductId(4);
		productMaster4.setProductName("Saw");
		productMaster4.setProductCode("TBX-0022");
		productMaster4.setReleaseDate(new Date());
		productMaster4.setDescription("15-inch steel blade hand saw");
		productMaster4.setPrice(11.55);
		productMaster4.setStarRating("3.7");
		productMaster4.setImageUrl("assets/images/saw.png");

		ProductMaster productMaster5 = new ProductMaster();
		productMaster5.setProductId(5);
		productMaster5.setProductName("Video Game Controller");
		productMaster5.setProductCode("GMG-0042");
		productMaster5.setReleaseDate(new Date());
		productMaster5.setDescription("Standard two-button video game controller");
		productMaster5.setPrice(35.95);
		productMaster5.setStarRating("4.6");
		productMaster5.setImageUrl("assets/images/xbox-controller.png");

		List<ProductMaster> productMasterList = Arrays.asList(productMaster, productMaster2, productMaster3,
				productMaster4, productMaster5);
		this.productRepository.insert(productMasterList);
		
		long noOfProducts = this.productRepository.count();
		System.out.println("Total no of Products in DB:::"+noOfProducts);
		//this.productRepository.insertAll(productMasterList);
		/*
		 * this.mongoTemplate.insert(productMaster);
		 * this.mongoTemplate.insert(productMaster2);
		 * this.mongoTemplate.insert(productMaster3);
		 * this.mongoTemplate.insert(productMaster4);
		 * this.mongoTemplate.insert(productMaster5);
		 */

	}

	private void empty() {
		this.productRepository.deleteAll();
		//this.productRepository.remove(new Query(), ProductMaster.class);

	}

}
