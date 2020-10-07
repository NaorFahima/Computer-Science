package q1;    //name: Naor Fahima ; ID:315783563 ; Number of task = 1

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class PhoneBook {
	private final static int NUM_OF_LETTERS = 'z'-'a'+1;
	
	private ContactsPage[] allPages;
	
	public PhoneBook(int maxNumOfContactInPage) {
		char letter = 'A';
		allPages = new ContactsPage[NUM_OF_LETTERS];
		for (int i = 0; i < allPages.length; i++) {
				allPages[i] = new ContactsPage(letter++ , maxNumOfContactInPage); 
		   }
		}  
	
	//print to file
	public void save(String fileName) throws FileNotFoundException {
		File file = new File(fileName);
		PrintWriter pw = new PrintWriter(file);
		for (int i = 0; i < allPages.length; i++) {
			allPages[i].save(pw);
		}
		pw.close();
	}
	
	//read from file
	public PhoneBook(String fileName) throws FileNotFoundException {
		Scanner sca = new Scanner(new File(fileName));
		allPages = new ContactsPage[NUM_OF_LETTERS];
		for (int i = 0; i < allPages.length; i++) {
			allPages[i]= new ContactsPage(sca);
		}
		sca.close();
	}
	
	
	//Search contact by name
	public Contact getContactByName(String name) {
		int firstChar = name.toUpperCase().charAt(0);
		return allPages[firstChar-'A'].getContactByName(name);
	}
	

	public Contact.ePhoneNumberStatus addContact(String name, String phoneNumber) {
		Contact.ePhoneNumberStatus res = Contact.checkIfPhoneNumberIsValid(phoneNumber);
		if (res == Contact.ePhoneNumberStatus.OK)
			allPages[Contact.getFirstLetterAsCapital(name)-'A'].addContact(new Contact(name, phoneNumber));
		
		return res;
	}
	
	public String toString() {
		String str = "My phone book:\n";
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < allPages.length; i++) {
			if (allPages[i].getNumOfContact()>0) {
				sb.append(allPages[i].toString() +"\n");
			}	
		}
		str = str + sb;
		return str;
	}

	//get that checke who is the fullest page
	public ContactsPage getFullestPage() {
		int induxOfBiggestPage = 0;
		int temp = 0;
		for (int i = 0; i < allPages.length; i++) {
		if ( temp  < allPages[i].getNumOfContact() ) {
		     temp = allPages[i].getNumOfContact();
		     induxOfBiggestPage = i;
		}
	}
		return  allPages[induxOfBiggestPage];
		
	}
	
}
