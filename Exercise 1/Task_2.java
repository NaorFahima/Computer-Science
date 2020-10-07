package HomeWork;  //name: Naor Fahima ; ID:315783563 ; Number of task = 2

import java.util.Scanner;

public class Task_2 {


	public static void main(String[] args) {
		
		// definition variable
		int num1, num2, numberOfTimes, number , focter = 1, newNumber = 0;

		Scanner Scanner = new Scanner(System.in);

		//start input
		System.out.println("Enter 2 numbers with the same number if digits:");
		num1 = Scanner.nextInt();
		num2 = Scanner.nextInt();
		
		//close scanner	
		Scanner.close();

		if (num1 >= 0 && num2 >= 0) {
			
			while (num1 != 0) { 
				
			numberOfTimes = num1%10; //Takes the last number from the first
			number = num2%10; //Takes the last number from the second
			num1 = num1/10;
			num2 = num2/10;
			
				for (int j = 0; j != numberOfTimes; j++) { //start calculate the new number
					if (newNumber>100000000) { // stop after 9 digit
						break;
					}   
						newNumber = number * focter + newNumber; //math the new number
					focter = focter * 10;
					
		
				}
			} System.out.println("res = " + newNumber); // Start output
			
		} else {
			System.out.println("Error /nPlease enter positive numbers"); //Error message if input is incorrect
		}
	}
}
