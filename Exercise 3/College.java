package Task_3;  //name: Naor Fahima ; ID:315783563 ; Number of task = 1

public class College {
	
	private int numOfLecturer;
	private int maxLecturer;
	private Lecturer[] allLecturer;
	private String nameCollege;
	
	public College(String nameCollege ,int maxLecturer) {
		setNameCollege(nameCollege);
		setMaxLecturer(maxLecturer);
		allLecturer = new Lecturer[maxLecturer];
		numOfLecturer = 0;
	}
	
	public boolean addLecturer(Lecturer Lecturer) {
		
		if (numOfLecturer<maxLecturer) {
			allLecturer[numOfLecturer] = Lecturer;
			numOfLecturer++;
			return true;	 
		} else {
			 return false;
		}
	}
	
	public void sortingTheLecturers() { // Sorts the lecturers by the number of times they have dropped the pen

		
		for (int i = 1; i < allLecturer.length-1; i++) {
			for (int j = i; j>0; j--) {
				if (allLecturer[j] == null) {
					break;
				}
				if (allLecturer[j-1].getNumOfTimesMarkerFalls() > allLecturer[j].getNumOfTimesMarkerFalls()) {
				Lecturer tempLecturer;
				tempLecturer = allLecturer[j];
				allLecturer[j] = allLecturer[j-1];
				allLecturer[j-1] = tempLecturer;
				
				}
			}
		}
	}
	
	public String toString() {
		
		String show = "College Name = " + nameCollege + "\nNumber of lecturer = "+ numOfLecturer + "\nMaxLecturer = "
				+ maxLecturer+ "\n";
		
		for (int i = 0; i < numOfLecturer; i++) {
			show = show + allLecturer[i].toString();
		}
		
		return show;
	}


	public int getNumOfLecturer() {
		return numOfLecturer;
	}

	public void setNumOfLecturer(int numOfLecturer) {
		this.numOfLecturer = numOfLecturer;
	}

	public Lecturer[] getAllLecturer() {
		return allLecturer;
	}

	public void setAllLecturer(Lecturer[] allLecturer) {
		this.allLecturer = allLecturer;
	}

	public int getMaxLecturer() {
		return maxLecturer;
	}

	public void setMaxLecturer(int maxLecturer) {
		this.maxLecturer = maxLecturer;
	}

	public String getNameCollege() {
		return nameCollege;
	}

	public void setNameCollege(String numCollege) {
		this.nameCollege = numCollege;
	}

}
