package q1;    //name: Naor Fahima ; ID:315783563 ; Number of task = 1

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class ContactsPage {

	private char letter;
	private Contact[] listContact;
	private final int  MAX_NUM_OF_CONTOCT;
	private int numOfContact; 
	
	public ContactsPage(char ch ,int maxOfListContact ) {
		this.letter = ch; 
		this.MAX_NUM_OF_CONTOCT = maxOfListContact;
		listContact = new Contact[MAX_NUM_OF_CONTOCT];
	}
	
	public boolean addContact(Contact contact) { //add new contact
		if (listContact.length > numOfContact) {
			listContact[numOfContact] = contact;
			numOfContact++;
			return true;
		}
		return false;
	}
	
	public ContactsPage(Scanner sca) { // read from file
		this.letter =  sca.next().charAt(0);
		this.MAX_NUM_OF_CONTOCT = sca.nextInt();
		listContact = new Contact[MAX_NUM_OF_CONTOCT];
		this.numOfContact =  sca.nextInt();
		for (int i = 0; i < numOfContact; i++) {
			listContact[i] = new Contact(sca);
		}
	}
	
	public void save(PrintWriter pw) throws FileNotFoundException { // print to file
		pw.println(letter);
		pw.println(MAX_NUM_OF_CONTOCT);
		pw.println(numOfContact);
		for (int i = 0; i < listContact.length; i++) {
			if (listContact[i] != null) {
				listContact[i].save(pw);
			}
		}
	}
	
	public Contact getContactByName(String name) {  // Search contact by name
		for (int i = 0; i < listContact.length; i++) {
			if (listContact[i] != null) {
				if (listContact[i].getName().equalsIgnoreCase(name)) {
					return listContact[i];
				}
			}
		}
		return null;
	}
	
	
	public String toString() {
		String str = letter +":\n";
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < numOfContact; i++) {
			sb.append(listContact[i].toString()+"\n");
		}
		str = str + sb;
		return str;
	}

	public char getLetter() {
		return letter;
	}

	public void setLetter(char letter) {
		this.letter = letter;
	}

	public int getNumOfContact() {
		return numOfContact;
	}

	public void setNumOfContact(int numOfContact) {
		this.numOfContact = numOfContact;
	}

	public int getMaxNumOfContact() {
		return MAX_NUM_OF_CONTOCT;
	}
	

	public Contact[] getListContact() {
		return listContact;
	}

	public void setListContact(Contact[] listContact) {
		this.listContact = listContact;
	}

}
