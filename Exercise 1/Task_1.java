package HomeWork; //name: Naor Fahima ; ID:315783563 ; Number of task = 1

import java.util.Scanner;

public class Task_1 {

	public static void main(String[] args) {

		// definition variable
		int costManufacturer = 0, price = 0, highestPrice = 0, lowestPrice = 0;
		int costOfPackaging, costOfMarketing, averageManufacturerCost, NumberOfZeros = 0;
		double totalPrice = 0;
		final int NUMBER_OF_PRODUCTS = 5;

		Scanner Scanner = new Scanner(System.in);

		System.out.println("Please enter 3 to 5 manufacture prices \nIf a manufacture is missing enter 0");

		// start loop and input
		for (int i = 0; i < NUMBER_OF_PRODUCTS; i++) {

			price = Scanner.nextInt();

			if (price >= 0) {

				if (price == 0) { // counts the number of 0
					NumberOfZeros++;

				} else {

					costManufacturer = costManufacturer + price;

					if (lowestPrice == 0) { // Determines the lowest price variable first time
						lowestPrice = price;
					}
					if (highestPrice < price) { //Checking who is the highest number
						highestPrice = price;
					}
					if (lowestPrice > price) { //Checking who is the lowest number
						lowestPrice = price;
					}
				}

			} else {

				System.out.println("Error \nPlease enter positive numbers!!");
				break;
			}
		}

		costManufacturer = costManufacturer - highestPrice - lowestPrice;

		if (NumberOfZeros >= 2) { // Calculates the average of cost manufacturer

			averageManufacturerCost = costManufacturer;

		} else {

			averageManufacturerCost = costManufacturer / (NUMBER_OF_PRODUCTS - NumberOfZeros - 2);
		}

		if (NumberOfZeros > 2) { // Checks the number of zeros if it is large start output

			System.out.println("Error in input, You should enter minimum 3 prices");

		} else {

			if (NumberOfZeros <= 2 && price >= 0) { // Checks the number of zeros if it is low start input

				System.out.println("Please enter marketing price and packaging price \nEnter 0 if it is free");

				costOfMarketing = Scanner.nextInt();
				costOfPackaging = Scanner.nextInt();

				Scanner.close(); // close scanner, input ends

				// start math and output
				if (costOfMarketing >= 0 && costOfPackaging >= 0) {

					if (costOfPackaging == 0 && costOfMarketing == 0) {
						totalPrice = averageManufacturerCost;

					} else {

						if (costOfPackaging == 0) {
							totalPrice = averageManufacturerCost * 0.85 + costOfMarketing * 0.15;

						} else {

							if (costOfMarketing == 0) {
								totalPrice = averageManufacturerCost * 0.95 + costOfPackaging * 0.05;

							} else {
								totalPrice = averageManufacturerCost * 0.8 + costOfMarketing * 0.15
										+ costOfPackaging * 0.05;
							}
						}
					}
					System.out.printf("Total price is %.2f", totalPrice);
					
				} else {
					System.out.println("Error \nEnter positive numbers!!");
				}
			}
		}
	}
}
