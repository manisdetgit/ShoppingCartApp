package com.app;

public class Product {
	private int product_id;
	private String product_name;
	private String product_category;
	private double price;
	private int availableQuantity;

	public int getProduct_id() {
		return product_id;
	}

	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}

	public String getProduct_name() {
		return product_name;
	}

	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}

	public String getProduct_category() {
		return product_category;
	}

	public void setProduct_category(String product_category) {
		this.product_category = product_category;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getAvailableQuantity() {
		return availableQuantity;
	}

	public void setAvailableQuantity(int quantity) {
		this.availableQuantity = quantity;
	}

//Constructor
	public Product(int product_id, String product_category, String product_name, double price, int availablequantity) {
		super();
		this.product_id = product_id;
		this.product_category = product_category;
		this.product_name = product_name;
		this.price = price;
		this.availableQuantity = availablequantity;
	}

	@Override
	public String toString() {
		return product_id + "\t|" + product_category + "\t\t|" + product_name + "\t\t|" + price + "\t\t|"
				+ availableQuantity;
	}

}
