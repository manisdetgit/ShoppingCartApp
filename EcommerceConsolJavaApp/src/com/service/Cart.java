package com.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.app.Product;
import com.data.Inventory;

public class Cart {

	Inventory inventory = new Inventory();
	ShoppingCart scart = new ShoppingCart();
	Scanner scan = new Scanner(System.in);

	// search products by product name
	public List<Product> searchListByProductName(Inventory inventory, Scanner scan) {
		System.out.print("Enter the product Name: ");
		String product_name = scan.nextLine();
		List<Product> result = new ArrayList<>();
		for (Product product : inventory.getProducts()) {
			if (product.getProduct_name().equalsIgnoreCase(product_name)) {
				result.add(product);
				System.out.println("Product ID \t|" + "Product Category\t" + "|Product Name\t" + "|Product Price\t"
						+ "|Available Quantity");
				System.out.println(
						"----------------------------------------------------------------------------------------------------");
				System.out.println(product.getProduct_id() + "\t|" + product.getProduct_category() + "\t\t|"
						+ product.getProduct_name() + "\t\t|" + product.getPrice() + "\t\t|"
						+ product.getAvailableQuantity());
				System.out.println(
						"----------------------------------------------------------------------------------------------------");
				return result;
			}
		}
		return null;

	}

	// search products by product ID
	public Product searchProductByID(Inventory inventory, int product_id) {
		for (Product product : inventory.getProducts()) {
			if (product.getProduct_id() == product_id) {
				return product;
			}
		}
		return null;
	}

	// display all products
	public void displayProducts(Inventory inventory) {
		System.out.println("Product ID \t|" + "Product Category\t" + "|Product Name\t" + "|Product Price\t"
				+ "|Available Quantity");
		for (Product product : inventory.getProducts()) {
			System.out
					.println("---------------------------------------------------------------------------------------");
			System.out.println(product);
		}
	}

	// method to add the product the cart
	public void addProductToCart(Inventory inventory, ShoppingCart scart, Scanner scan) {
		System.out.println("\nEnter product ID: ");
		int productID = scan.nextInt();
		scan.nextLine();
		Product product = searchProductByID(inventory, productID);
		if (product != null) {
			System.out.println("\nEnter quantity: ");
			int quantity = scan.nextInt();
			scan.nextLine();
			if (quantity <= product.getAvailableQuantity()) {
				scart.addProduct(product, quantity);
				product.setAvailableQuantity(product.getAvailableQuantity() - quantity);
				System.out.println("\n***Product added to cart successfully***");
			} else {
				System.out.println("\n***Insufficient quantity available.***");
				// System.out.println("Selected quantity is not available. Please select within
				// available quantity: "+product.getAvailableQuantity());
			}
		} else {
			System.out.println("\n***Product not found***");
		}

	}

	// method to display the cart details
	public void displayCartDetails(ShoppingCart scart) {
		System.out.println("\n***********Cart Details***********");
		double totalCost = 0;
		System.out.println("S.No \t|" + "Product ID \t|" + "Product Category\t" + "|Product Name\t" + "|Product Qty\t"
				+ "|Product Price\t" + "|Cost");
		System.out.println(
				"----------------------------------------------------------------------------------------------------");
		for (int i = 0; i < scart.getProducts().size(); i++) {
			Product product = scart.getProducts().get(i);
			int quantity = scart.getquantities().get(i);
			double cost = product.getPrice() * quantity;
			System.out.println((i + 1) + "\t|" + product.getProduct_id() + "\t|" + product.getProduct_category()
					+ "\t\t|" + product.getProduct_name() + "\t\t|" + quantity + "\t\t|" + product.getPrice() + "\t\t|"
					+ cost);
			System.out.println(
					"----------------------------------------------------------------------------------------------------");
			totalCost += cost;

		}
		System.out.println("Total Cost: " + totalCost);
		System.out.println(
				"----------------------------------------------------------------------------------------------------");

	}

}
