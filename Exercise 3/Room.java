package Task_3;  //name: Naor Fahima ; ID:315783563 ; Number of task = 2

import java.util.Arrays;

public class Room {
	
	private int  numOfBeds;
	private Guest[] allGuests;
	
	public Room(int numOfBeds) {
	   setNumOfBeds(numOfBeds);
	   allGuests = new Guest[numOfBeds];
	}
	

	public String toString() {
		return "Room [numOfBeds=" + numOfBeds + ", allGuests=" + Arrays.toString(allGuests) + "]";
	}


	public int getNumOfBeds() {
		return numOfBeds;
	}
	public void setNumOfBeds(int numOfBeds) {
		this.numOfBeds = numOfBeds;
	}
	public Guest[] getAllGuests() {
		return allGuests;
	}
	public void setAllGuests(Guest[] allGuests) {
		this.allGuests = allGuests;
	}
	

}
