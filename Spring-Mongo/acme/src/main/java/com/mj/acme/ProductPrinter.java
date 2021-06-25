/**
 * 
 */
package com.mj.acme;

import java.util.List;

import com.mj.acme.model.ProductMaster;

/**
 * @author mayankjindal
 *
 */
public class ProductPrinter {

	public static void print(List<ProductMaster> productMaster) {

		String header = String.format("%-15s %-20s %-15s %-40s %-45s %-20s %-20s %-20s", "Product Id", "Product Name",
				"Product Code", "Release Date", "Description", "Price", "StarRating", "ImageUrl");
		System.out.println(header);
		for (ProductMaster pm : productMaster) {
			String data = String.format("%-15s %-20s %-15s %-40s %-45s %-20s %-20s %-20s", pm.getProductId(),
					pm.getProductName(), pm.getProductCode(), pm.getReleaseDate(), pm.getDescription(), pm.getPrice(),
					pm.getStarRating(), pm.getImageUrl());
			System.out.println(data);
		}
		System.out.println("");
	}

	/**
	 * 
	 */
	public ProductPrinter() {
		// TODO Auto-generated constructor stub
	}

}
