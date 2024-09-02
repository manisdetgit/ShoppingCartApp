package com.main;

import java.util.List;
import java.util.Scanner;

import com.app.Product;
import com.data.Inventory;
import com.service.Cart;
import com.service.Feedback;
import com.service.ShoppingCart;

public class ProgramRunner {

	static String product;

	public void searchProducts() {

	}

	public static void main(String[] args) {
		Cart cart = new Cart();
		Inventory inventory = new Inventory();
		ShoppingCart scart = new ShoppingCart();
		Scanner scanner = new Scanner(System.in);
		boolean continueShopping = true;

		while (continueShopping) {
			System.out.println("*****************************************");
			System.out.println("       Welcome to UST Shopping Cart");
			System.out.println("*****************************************");
			System.out.println("Please select the option");
			System.out.println("1. Search Products");
			System.out.println("2. List All Products");
			System.out.println("3. Add Products To Cart");
			System.out.println("4. Display Cart Details");
			System.out.println("5. Share your thoughts");
			System.out.println("   a. Share your feedback");
			System.out.println("   b. Register Complaints");
			System.out.println("6. Exit");
			System.out.println("\nPlease Enter your option: ");

			String option = scanner.nextLine();

			switch (option) {
			case "1":
				List<Product> products = cart.searchListByProductName(inventory, scanner);
				if (products != null) {

					System.out.print("\nDo you want to add this product to Cart? (yes/no): ");
					String response = scanner.nextLine();
					if (response.equalsIgnoreCase("yes")) {
						cart.addProductToCart(inventory, scart, scanner);
					}
				} else {
					System.out.println("\n***Product not found***");
				}
				break;
			case "2":
				cart.displayProducts(inventory);
				break;
			case "3":
				cart.addProductToCart(inventory, scart, scanner);
				break;
			case "4":
				cart.displayCartDetails(scart);
				break;
			case "5":
				Feedback fb = new Feedback();
				fb.feedbackandcomplaints();
				break;
			case "6":
				continueShopping = false;
				System.out.println("\n***Thank you for visiting UST Shopping Cart. Goodbye!***");
				break;
			default:
				System.out.println("\nInvalid option");
				break;
			}

			if (continueShopping) {
				System.out.print("\nDo you want to return to the shopping Cart? (yes/no): ");
				String response = scanner.nextLine();
				if (!response.equalsIgnoreCase("yes")) {
					continueShopping = false;
					System.out.println("\n***Thank you for visiting UST Shopping Cart. Goodbye!***");
				}
			}
		}

		scanner.close();
	}

}
