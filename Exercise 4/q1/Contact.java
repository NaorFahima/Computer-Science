package q1;   //name: Naor Fahima ; ID:315783563 ; Number of task = 1

import java.io.PrintWriter;
import java.util.Scanner;

public class Contact {
	public enum ePhoneNumberStatus {OK, PREFIX_INVALID_LEN, PREFIX_NOT_START_WITH_0, NUMBER_INVALID_LEN, NOT_ALL_DIGITS} 
	
	private String name;
	private String phoneNumber;
	
	public Contact(Scanner sca) {
		name = sca.next();
		phoneNumber = sca.next();
	}
	
	public Contact(String name, String phoneNumber) {
		setName(name);
		setPhoneNumber(phoneNumber);
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getPhoneNumber() {
		return phoneNumber;
	}
	
	public ePhoneNumberStatus setPhoneNumber(String phoneNumber) {
		ePhoneNumberStatus res = checkIfPhoneNumberIsValid(phoneNumber);
		if (res == ePhoneNumberStatus.OK)
			this.phoneNumber = phoneNumber;
		
		return res;
	}
	// check if phone number is valid
	public static ePhoneNumberStatus checkIfPhoneNumberIsValid(String phoneNumber) { 
		 
		char[] digits = phoneNumber.toCharArray();
		if (digits[0] != '0') {
			return Contact.ePhoneNumberStatus.PREFIX_NOT_START_WITH_0;
		}
		if (digits[3] != '-') {
			return Contact.ePhoneNumberStatus.NUMBER_INVALID_LEN;
		}
		if (digits.length!=11) {
			return Contact.ePhoneNumberStatus.NOT_ALL_DIGITS;
		}
		
		for (int i = 0; i < 11; i++) {
			if (i == 3) {
				continue;
			}
			if (digits[i]<'0' && digits[i]>'9') {
				return Contact.ePhoneNumberStatus.PREFIX_INVALID_LEN;
			}
		}
		return Contact.ePhoneNumberStatus.OK;
	}
	
	public static char getFirstLetterAsCapital(String name) {
		return name.toUpperCase().charAt(0);
	}
	
	public String toString() {
		return name + "\t-->\t" + phoneNumber;
	}

	public void save(PrintWriter pw) {
		pw.println(name);
		pw.println(phoneNumber);
	}
}