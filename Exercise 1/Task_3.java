package HomeWork; //name: Naor Fahima ; ID:315783563 ; Number of task = 3 

import java.util.Scanner;

public class Task_3 {

	public static void main(String[] args) {

		// definition variable
		int number, tastNumber, largeNumber, lowestNumber, countZero = 1;

		Scanner scanner = new Scanner(System.in);

		// start input
		System.out.println("Input number:");

		number = scanner.nextInt();

		scanner.close(); // close scanner

		if (number > 0) {

			System.out.print("The largest number is:");
			for (int i = 9; i >= 0; i--) {

				largeNumber = number;

				while (largeNumber != 0) { // Calculates the high number

					tastNumber = largeNumber % 10;
					largeNumber = largeNumber / 10;

					if (tastNumber == i) {
						System.out.print(tastNumber);
					}
				}
			}

			System.out.println(" ");

			System.out.print("The lowest number is:");

			for (int i = 1; i <= 9; i++) {

				lowestNumber = number;

				while (i == 1 && lowestNumber != 0) { // count zero

					tastNumber = lowestNumber % 10;
					lowestNumber = lowestNumber / 10;

					if (tastNumber == 0) {
						countZero = countZero * 10;
					}
				}

				lowestNumber = number;

				while (lowestNumber != 0) { // Calculates the low number

					tastNumber = lowestNumber % 10;
					lowestNumber = lowestNumber / 10;

					if (tastNumber == i) {

						if (countZero != 1) {
							System.out.print(tastNumber * countZero);
							countZero = 1;

						} else {
							System.out.print(tastNumber);
						}
					}
				}
			}

		} else {
			System.out.println("Error \nPlease enter positive numbers");
		}
	}
}
