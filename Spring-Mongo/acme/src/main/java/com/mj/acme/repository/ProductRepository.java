/**
 * 
 */
package com.mj.acme.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.mj.acme.model.ProductMaster;

/**
 * @author mayankjindal
 *
 */
@Repository
public interface ProductRepository extends MongoRepository<ProductMaster, String> {
	
	ProductMaster findByProductId(int productId);
	
	List<ProductMaster> findByPriceAndStarRating(double price,String starRating);
	
	@Query("{'price' : {$gt:?0}}")
	List<ProductMaster> findByPrice(double price);
	

}
