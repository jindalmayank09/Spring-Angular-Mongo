/**
 * 
 */
package com.mj.acme.queries;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.TextCriteria;
import org.springframework.data.mongodb.core.query.TextQuery;
import org.springframework.stereotype.Service;

import com.mj.acme.model.ProductMaster;
import com.mj.acme.repository.ProductRepository;

/**
 * @author mayankjindal
 *
 */
@Service
public class ProductDetailsQueries {
	private MongoTemplate mongoTemplate;
	
	@Autowired
	private ProductRepository productRepository;
	
	

	/**
	 * 
	 */
	public ProductDetailsQueries(MongoTemplate mongoTemplate) {
		this.mongoTemplate = mongoTemplate;
	}
	
	public List<ProductMaster> findAll(String field,int pageNb,int pageSize){
		Query allPagedAndOrdered = new Query()
				.with(Sort.by(Sort.Direction.ASC,field))
				.with(PageRequest.of(pageNb,pageSize));
		return this.mongoTemplate.find(allPagedAndOrdered, ProductMaster.class);
		
	}
	
	public ProductMaster findByProductId(int productId) {
		return productRepository.findByProductId(productId);
	}
	
	public List<ProductMaster> findByFreeText(String text) {
		TextCriteria textCriteria = TextCriteria.forDefaultLanguage()
				.matching(text);
		
		Query byFreeText = TextQuery.queryText(textCriteria)
				.sortByScore().with(PageRequest.of(0, 3));
		
		return this.mongoTemplate.find(byFreeText, ProductMaster.class);
				
	}

}
