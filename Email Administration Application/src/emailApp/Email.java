package emailApp;

import java.util.Scanner;

public class Email {

	private String firstName;
	private String lastName;
	private String password;
	private String email;
	private String department;
	private String Company = "abz";
	private int mailBoxCapacity = 500;
	private String alternateEmail;

	// Constructor to receive firstname and lastname

	public Email(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;

		// call a method asking for department - returns a department
		department = setDepartment();

		// call a method asking to generate pasword - returns a password
		this.password = randomPassword(this.firstName.length());
		System.out.println("Auto-genearted password is " + this.password);

		// combine elements to generate email
		email = this.firstName.toLowerCase() + "." + this.lastName.toLowerCase() + "@" + department + "." + Company
				+ ".com";

	}

	// Ask for Department
	private String setDepartment() {
		System.out.println("New Employee " + firstName + ".\n"
				+ "DEPARTMENT CODES\n 1 for Sales\n 2 for Development\n 3 for Accounting\n 0 for none\n Enter your department");

		Scanner sc = new Scanner(System.in);

		int depChoice = sc.nextInt();

		sc.close();

		switch (depChoice) {
		case 1:
			return "sales";
		case 2:
			return "Development";
		case 3:
			return "Accounting";
		default:
			return "";
		}

	}

	// Generate a random password

	private String randomPassword(int length) {
		String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz!@#$";
		char[] randompassword = new char[length];

		// iterate over the password char array
		for (int i = 0; i < randompassword.length; i++) {
			int random = (int) (Math.random() * passwordSet.length());
			randompassword[i] = passwordSet.charAt(random);
		}

		// return password char array in string format
		return new String(randompassword);
	}

	// Set the mail box capacity
	public void setMailBoxCapacity(int capacity) {
		this.mailBoxCapacity = capacity;
	}

	// set the alternate email address
	public void setAlternateEmailAddress(String email) {
		this.alternateEmail = email;
	}

	// change the password
	public void changePassword(String password) {
		this.password = password;
	}

	public int getMailBoxCapacity() {
		return this.mailBoxCapacity;
	}

	public String getAlternateEmailAddress() {
		return this.alternateEmail;
	}

	public String getPassword() {
		return this.password;
	}

	// get All Info
	public String getInfo() {
		return "DISPLAY NAME: " + firstName + " " + lastName + "\n" + "COMPANY EMAIL ADDRESS: " + email + "\n"
				+ "MAILBOX CAPACITY: " + mailBoxCapacity + "\n" + "PASSWORD: " + password;
	}

}
