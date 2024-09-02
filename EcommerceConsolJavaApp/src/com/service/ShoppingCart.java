package com.service;

import java.util.ArrayList;
import java.util.List;

import com.app.Product;
import com.data.Inventory;

public class ShoppingCart {

	private List<Integer> quantities;
	private List<Product> products;
	Inventory inv = new Inventory();

	public List<Integer> getquantities() {
		return quantities;
	}

	public void setQuantity(List<Integer> quantities) {
		this.quantities = quantities;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public void addProduct(Product product, int quantity) {
		products.add(product);
		quantities.add(quantity);
	}

	public ShoppingCart() {
		super();
		this.quantities = new ArrayList<>();
		this.products = new ArrayList<>();
	}

}
