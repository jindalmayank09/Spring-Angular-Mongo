/**
 * 
 */
package com.mj.acme.model;

import java.util.Date;

import javax.persistence.Id;

import org.springframework.data.mongodb.core.index.TextIndexed;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author mayankjindal
 *
 */
@Document("product")
public class ProductMaster {
	
	@Id
	private String id;
	
	private int productId;
	
	private String productName;
	
	private String productCode;
	
	private Date releaseDate;
	
	@TextIndexed(weight = 2)
	private String description;
	
	@TextIndexed
	private double price;
	
	private String starRating;
	
	private String imageUrl;
	
	
	
	

	
	public ProductMaster() {
		
	}






	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}






	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}






	/**
	 * @return the productId
	 */
	public int getProductId() {
		return productId;
	}






	/**
	 * @param productId the productId to set
	 */
	public void setProductId(int productId) {
		this.productId = productId;
	}






	/**
	 * @return the productName
	 */
	public String getProductName() {
		return productName;
	}






	/**
	 * @param productName the productName to set
	 */
	public void setProductName(String productName) {
		this.productName = productName;
	}






	/**
	 * @return the productCode
	 */
	public String getProductCode() {
		return productCode;
	}






	/**
	 * @param productCode the productCode to set
	 */
	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}






	/**
	 * @return the releaseDate
	 */
	public Date getReleaseDate() {
		return releaseDate;
	}






	/**
	 * @param releaseDate the releaseDate to set
	 */
	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}






	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}






	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}






	/**
	 * @return the price
	 */
	public double getPrice() {
		return price;
	}






	/**
	 * @param d the price to set
	 */
	public void setPrice(double d) {
		this.price = d;
	}






	/**
	 * @return the starRating
	 */
	public String getStarRating() {
		return starRating;
	}






	/**
	 * @param starRating the starRating to set
	 */
	public void setStarRating(String starRating) {
		this.starRating = starRating;
	}






	/**
	 * @return the imageUrl
	 */
	public String getImageUrl() {
		return imageUrl;
	}






	/**
	 * @param imageUrl the imageUrl to set
	 */
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}






	@Override
	public String toString() {
		return "ProductMaster [id=" + id + ", productId=" + productId + ", productName=" + productName
				+ ", productCode=" + productCode + ", releaseDate=" + releaseDate + ", description=" + description
				+ ", price=" + price + ", starRating=" + starRating + ", imageUrl=" + imageUrl + "]";
	}

}
