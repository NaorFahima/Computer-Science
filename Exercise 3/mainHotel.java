package Task_3;  //name: Naor Fahima ; ID:315783563 ; Number of task = 2

import java.util.Scanner;

public class mainHotel {

	public static void main(String[] args) {

		int passportNumber , numOfFloors , numOfRoom , numOfGuests , menuSelect , biggestEmptyFloor;
		String nameGuest , findGuest;
		Guest[] guests;
		
		Scanner sca = new Scanner(System.in);
		
		System.out.println("Welcome to Hotel Management");
		
		System.out.println("How many floors does the hotel have?");
		numOfFloors = sca.nextInt();
		System.out.println("How many room does the hotel have?");
		numOfRoom = sca.nextInt();
		
		Hotel hotel1 = new Hotel(numOfFloors, numOfRoom);
		
		System.out.println();

		do {
			System.out.println("Select one of the following options:");
			System.out.println("(1) Enter new guests \n(2) Find guest by passport \n(3) Show all guests");
			System.out.println("(4) Chack which floor is the most empty? \n(5) Show date of last reservation \n(6) Exit");
			menuSelect = sca.nextInt();
			
			if (menuSelect == 1) { // add guests
				System.out.println("How many guests do you want to put in the hotel");
				numOfGuests = sca.nextInt();
				guests = new Guest[numOfGuests];
				if (numOfGuests<=4) {
					for (int i = 0; i < numOfGuests; i++) {
						System.out.println("The name of the guest " +(i+1)+"?");
						nameGuest = sca.next();
						System.out.println("The passport number?");
						passportNumber = sca.nextInt();

						Guest guest = new Guest(nameGuest, passportNumber);
						guests[i] = guest;
					}
					hotel1.addGuest(guests);
				} else {
					System.out.println("No available rooms \nWe have room up to 4 people");
				}
			}
			
			if (menuSelect == 2) {  // find a guest by passport
				System.out.println("Find a guest by passport:");
				passportNumber = sca.nextInt();
				findGuest = hotel1.findGuest(passportNumber);
				if (findGuest != "-1") {
					System.out.println(findGuest);
				}else {
					System.out.println("The guest does not stay at the hotel");
				}
			}
			if (menuSelect == 3 ) {  //show hotel details
				System.out.println(hotel1);
			}
			
			if (menuSelect == 4) {  //check which floor is the most empty
				biggestEmptyFloor = hotel1.mostEmptyFloor();
				System.out.println("The floor with the most rooms available: "+biggestEmptyFloor);
			}
			if (menuSelect == 5) { //show date of last reservation
				Hotel.getLastReservation();
			}
			
			System.out.println();
		
		} while (menuSelect != 6);
		
		sca.close();
		System.out.println("Thank you for using our hotel management system\nby by");
	}
}
