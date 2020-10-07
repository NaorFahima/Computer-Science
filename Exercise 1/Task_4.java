package HomeWork; //name: Naor Fahima ; ID:315783563 ; Number of task = 4

public class Task_4 {

	public static void main(String[] args) {

		int sum, newNumber, modolo, numberOfTry;
		int num1 = 0, num2 = 0, num3 = 0, severalTimesRow = 0 ,numOfHappyNumber = 1;

		for (int num = 10;; num++) { // Loop that checking the number from 10
			sum = 0;
			newNumber = num;
			numberOfTry = 0;

			if (severalTimesRow == 3) { // start output and end the program if there are 3 times in a row
				System.out.println(num1 + " " + num2 + " " + num3);
				break;

			}

			while (newNumber != 0) {
				// start math
				modolo = newNumber % 10;
				sum = sum + modolo * modolo;

				newNumber = newNumber / 10;

				if (newNumber == 0 && sum != 1) {
					newNumber = sum;
					sum = 0;
					numberOfTry++; // Counting a few attempts until he becomes a happy number
					
					if (numberOfTry == 8) { // If it is not a happy number after 8 try go to the next number
						severalTimesRow = 0;
						break;
					}
					
				} else {

					if (sum == 1 && newNumber == 0) { // If he a happy number start output
						System.out.println(numOfHappyNumber+ ") " +num + " is a happy number :-)");
						severalTimesRow++;
						numOfHappyNumber++;

						if (severalTimesRow == 1) {
							num1 = num;

						} else {

							if (severalTimesRow == 2) {
								num2 = num;

							} else {
								num3 = num;
							}
						}
						break;
					}
				}
			}
		}
	}
}
