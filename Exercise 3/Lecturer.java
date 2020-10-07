package Task_3; //name: Naor Fahima ; ID:315783563 ; Number of task = 1

public class Lecturer {
	
	private String name;
	private String favoriteIceCream;
	private int numOfTimesMarkerFalls;
	private int lecturerIdNumber;
	private static int idNumber = 1000;
	
	
	public Lecturer(String name , String favoriteIceCream,int numOfTimesMarkerFalls) {
		setName(name);
		setFavoriteIceCream(favoriteIceCream);
		setNumOfTimesMarkerFalls(numOfTimesMarkerFalls);
		this.lecturerIdNumber = idNumber;
		idNumber++;
	}
	
	public String toString() {
		return "Lecturer: Name = " + name + "     Favorite ice cream = " + favoriteIceCream + "     Num of times marker falls = " 
				+ numOfTimesMarkerFalls + "     Lecturer id number = "+ lecturerIdNumber + "\n";
		
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getFavoriteIceCream() {
		return favoriteIceCream;
	}
	public void setFavoriteIceCream(String favoriteIceCream) {
		this.favoriteIceCream = favoriteIceCream;
	}
	public int getNumOfTimesMarkerFalls() {
		return numOfTimesMarkerFalls;
	}
	public void setNumOfTimesMarkerFalls(int numOfTimesMarkerFalls) {
		if (numOfTimesMarkerFalls>0) {
			this.numOfTimesMarkerFalls = numOfTimesMarkerFalls;
		}
	}
	public int getLecturerIdNumber() {
		return lecturerIdNumber;
	}
	

	
	
}
