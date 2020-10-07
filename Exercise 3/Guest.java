package Task_3;  //name: Naor Fahima ; ID:315783563 ; Number of task = 2

public class Guest {

	private String name;
	private int passportNumber;
	
	public Guest(String name , int passportNumber) {
		setName(name);
		setPassportNumber(passportNumber);
	}
	
	public String toString() {
		return "Guest: Name = " + name + ", passport number = " + passportNumber;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPassportNumber() {
		return passportNumber;
	}
	public void setPassportNumber(int passportNumber) {
		if (passportNumber>0) {
			this.passportNumber = passportNumber;
		}	
	}	
	
}
