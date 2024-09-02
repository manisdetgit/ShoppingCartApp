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

				System.out.printf("| %11s | %-20s | %-20s | %-15s | %19s |\n", "Product ID", "Product Category",
						"Product Name", "Product Price", "Available Quantity");

				System.out.println(
						"----------------------------------------------------------------------------------------------------");

				System.out.printf("| %-11d | %-20s | %-20s | %-15.2f | %19d |\n", product.getProduct_id(),
						product.getProduct_category(), product.getProduct_name(), product.getPrice(),
						product.getAvailableQuantity());
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

	// display all the products
	public void displayProducts(Inventory inventory) {

		System.out.printf("| %11s | %-20s | %-20s | %-15s | %19s |\n", "Product ID", "Product Category", "Product Name",
				"Product Price", "Available Quantity");
		System.out.println(
				"---------------------------------------------------------------------------------------------------------");
		for (Product product : inventory.getProducts()) {
			System.out.println(
					"---------------------------------------------------------------------------------------------------------");
			System.out.printf("| %-11d | %-20s | %-20s | %-15.2f | %19d |\n", product.getProduct_id(),
					product.getProduct_category(), product.getProduct_name(), product.getPrice(),
					product.getAvailableQuantity());

		}
	}

	// method to add the product the cart
	public void addProductToCart(Inventory inventory, ShoppingCart scart, Scanner scan) {
		System.out.println("\nEnter product ID: ");
		int productID = scan.nextInt();
		Product product = searchProductByID(inventory, productID);
		if (product != null) {
			System.out.println("\nEnter quantity: ");
			int quantity = scan.nextInt();
			if (quantity <= product.getAvailableQuantity()) {
				scart.addProduct(product, quantity);
				product.setAvailableQuantity(product.getAvailableQuantity() - quantity);
				System.out.println("\n***Product added to cart successfully***");
			} else {
				System.out.println("\n***Insufficient quantity available.***");

			}
		} else {
			System.out.println("\n***Product not found***");
		}

	}

	// method to display the cart details
	public void displayCartDetails(ShoppingCart scart) {
		System.out.println("\n***********Cart Details***********");
		double totalCost = 0;
		System.out.printf("| %-9s | %11s | %-20s | %-20s | %-9s | %-15s | %-10s |\n", "S.No", "Product ID",
				"Product Category", "Product Name", "Quantity", "Product Price", "Cost");
		System.out.println(
				"-------------------------------------------------------------------------------------------------------------------");
		for (int i = 0; i < scart.getProducts().size(); i++) {
			Product product = scart.getProducts().get(i);
			int quantity = scart.getquantities().get(i);
			double cost = product.getPrice() * quantity;

			System.out.printf("| %-9d | %-11d | %-20s | %-20s | %-9d | %-15.2f | %10.2f |\n", (i + 1),
					product.getProduct_id(), product.getProduct_category(), product.getProduct_name(), quantity,
					product.getPrice(), cost);
			System.out.println(
					"-------------------------------------------------------------------------------------------------------------------");
			totalCost += cost;

		}
		System.out.println("Total Cost: " + totalCost);
		System.out.println(
				"-------------------------------------------------------------------------------------------------------------------");

	}

}
