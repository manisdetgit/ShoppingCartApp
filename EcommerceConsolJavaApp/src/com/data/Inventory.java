package com.data;

import java.util.ArrayList;
import java.util.List;

import com.app.Product;

public class Inventory {
	List<Product> lproducts;

	// constructor
	public Inventory(List<Product> lproducts) {
		super();
		this.lproducts = lproducts;
	}

	public List<Product> getLproducts() {
		return lproducts;
	}

	public void setLproducts(List<Product> lproducts) {
		this.lproducts = lproducts;
	}

	// list of products initialized in constructor, so that products are initialized
	// when inventory class object is created.
	public Inventory() {
		lproducts = new ArrayList<>();
		lproducts.add(new Product(1, "Mobile Phone", "Iphone-15", 50000.00, 10));
		lproducts.add(new Product(2, "Toys", "Car", 567, 8));
		lproducts.add(new Product(3, "Electronics", "Charger", 249.9, 9));
		lproducts.add(new Product(4, "Dress", "Churidhar", 700, 9));
		lproducts.add(new Product(5, "Accessories", "Necklace", 1500, 9));
		lproducts.add(new Product(6, "Dress", "Kurta", 350, 10));
		lproducts.add(new Product(7, "Electronics", "Adapter", 450, 8));
		lproducts.add(new Product(8, "Toys", "Bus", 399.99, 7));
	}

	// method to add a product to the product list
	public void addProduct(Product product) {
		lproducts.add(product);
	}

	// method to get the list of products
	public List<Product> getProducts() {
		return lproducts;
	}

}
