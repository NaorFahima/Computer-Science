package Task_3;  //name: Naor Fahima ; ID:315783563 ; Number of task = 2

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class Hotel {
	
	private int numOfUsedRooms;
	private Room[][] allRooms;
	private static String lastReservation;
	
	
	public Hotel(int numOfFloors ,int numOfRoom) {
		allRooms = new Room[numOfFloors][numOfRoom];
		for (int i = 0; i < numOfFloors; i++) {
			for (int j = 0; j < numOfRoom; j++) {
				allRooms[i][j] = new Room((int) (Math.random()*4+1));
			}
		}
	}
	
	
	public String toString() {
		System.out.println("Hotel: num of used rooms = " + numOfUsedRooms + " \nDetails guest room:");;
		for (int i = 0; i < allRooms.length; i++) {
			for (int j = 0; j < allRooms[i].length; j++) {
				if (allRooms[i][j].getAllGuests()[0] != null) {
					System.out.println("Room number:" +(i+1)+""+(j+1));
						System.out.println(allRooms[i][j].toString());
					
					System.out.println();
				}
			}
		}
		return "";	
	}



	private String date() {
		  LocalDateTime localDate = LocalDateTime.now();
		  DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yy  HH:mm:ss");
		  return dtf.format(localDate);
	}

	public String findGuest(int passportNumber) {
		for (int i = 0; i < allRooms.length; i++) {
			for (int j = 0; j < allRooms[i].length; j++) {
				if (allRooms[i][j].getAllGuests()[0] != null) {
					for (int j2 = 0; j2 < allRooms[i][j].getAllGuests().length; j2++) {
						if (allRooms[i][j].getAllGuests()[j2].getPassportNumber() == passportNumber) {	
							return "The guest in the room: "+(i+1)+""+(1+j);
						}	
					}
				}
			}
		}
		return "-1";
	}
	
	public int mostEmptyFloor() {  //Checking how many empty rooms are on each floor
		int contEmptyRoom , biggestEmptyFloor;
		int[] floorEmptyRoom = new int[allRooms.length];
		for (int i = 0; i < allRooms.length; i++) {
			contEmptyRoom = 0;
			for (int j = 0; j < allRooms[i].length; j++) {
				if (allRooms[i][j].getAllGuests()[0] == null) {
					contEmptyRoom++;
				}
			}
			floorEmptyRoom[i] = contEmptyRoom;
			}
		biggestEmptyFloor = biggestEmptyFloor(floorEmptyRoom);
		return biggestEmptyFloor;
		
	}
	
	private int biggestEmptyFloor(int[] floorEmptyRoom ) {  //Checking which floor has the most empty rooms
		int biggestEmptyFloor = 0;
		for (int i = 0; i < floorEmptyRoom.length; i++) {
			if (floorEmptyRoom[i]>0) {
				biggestEmptyFloor = i+1;
			}
		}
		return biggestEmptyFloor;
	}
	
	public boolean addGuest(Guest[] Guest){
		for (int i = 0; i < allRooms.length; i++) {		
			for (int j = 0; j < allRooms[i].length; j++) {
				if (Guest.length <= allRooms[i][j].getNumOfBeds() ) {
					if (allRooms[i][j].getAllGuests()[0] == null) {
						for (int j2 = 0; j2 < Guest.length; j2++) {
							allRooms[i][j].getAllGuests()[j2] = Guest[j2];
						}
						numOfUsedRooms++;
						System.out.println("Your room: " + (i+1)+""+(j+1));	
						lastReservation = date();
						return true;
					}
				}
			}
		}
		System.out.println("No available rooms");
		return false;
	}
	
	public int getNumOfUsedRooms() {
		return numOfUsedRooms;
	}
	public void setNumOfUsedRooms(int numOfUsedRooms) {
		this.numOfUsedRooms = numOfUsedRooms;
	}
	public Room[][] getAllRooms() {
		return allRooms;
	}
	public void setAllRooms(Room[][] allRooms) {
		this.allRooms = allRooms;
	}
	public static String getLastReservation() {
		System.out.println("Last invitation: "+lastReservation);
		return lastReservation;
	}
	
	
	

}
