package Task_3;   //name: Naor Fahima ; ID:315783563 ; Number of task = 1

import java.util.Scanner;

public class mainCollege {

	public static void main(String[] args) {

		String nameCollege ,nameLecturer , favoriteIceCream;
		int maxLecturer , numOfTimesMarkerFalls , numOfLecturer;

		Scanner sca = new Scanner(System.in);

		System.out.println("What the name of the college?");
		nameCollege = sca.next();
		System.out.println("How many lecturers can teach there?");
		maxLecturer = sca.nextInt();
		College college1 = new College(nameCollege, maxLecturer);

		System.out.println("How many lecturers do you want to put in college?");
		numOfLecturer = sca.nextInt();

		for (int i = 0; i < numOfLecturer; i++) {
			System.out.println("The name of the lecturer " + (i+1) + "?");
			nameLecturer = sca.next();
			System.out.println("The favorite ice cream of the lecturer? ");
			favoriteIceCream = sca.next();
			System.out.println("The number of times his marker falls?");
			numOfTimesMarkerFalls = sca.nextInt();

			Lecturer lecturer = new Lecturer(nameLecturer, favoriteIceCream, numOfTimesMarkerFalls);
			college1.addLecturer(lecturer);
		}
		
		sca.close();

		System.out.println(college1);
		college1.sortingTheLecturers();
		System.out.println(college1);

	}
}
