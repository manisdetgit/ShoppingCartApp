package com.service;

import java.util.Scanner;

public class Feedback {

	private String feed;
	private String comp;

	Scanner scan = new Scanner(System.in);

	// to get the feedback
	public void getfeedback() {
		System.out.println("Thank you for visiting our page.. Please share your valuable feedback");
		feed = scan.next();
		System.out.println("Thank you for your feedback. Have a nice day!!");
	}

	// to get complaints
	public void getcomplaint() {
		System.out.println("Sorry for any inconvience.. Please share your complaints");
		comp = scan.next();
		System.out.println(
				"Your complaints reported to concerned team and we will work for it. Thank you for your patience!!");
	}

	// to get the feedback and complaints as per options. so call this method in
	// main class
	public void feedbackandcomplaints() {

		System.out.println("*************************************************************************");
		System.out.println("                          Share your thoughts                            ");
		System.out.println("*************************************************************************");
		System.out.println("***Enter 1 for FEEDBACK***\n***Enter 2 for COMPLAINTS***");
		System.out.print("Please select an option: ");
		String subOption = scan.nextLine();

		switch (subOption) {
		case "1":
			getfeedback();
			break;
		case "2":
			getcomplaint();
			break;
		default:
			System.out.println("Invalid option");
			break;
		}
	}
}
