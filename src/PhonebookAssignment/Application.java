package PhonebookAssignment;

import java.util.Arrays;
import java.util.Scanner;

public class Application {
	
	public static Contacts[] persons = new Contacts[0];

	public static void main(String[] args) {
		main();
	}
	
	public static void main() {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Choose an option 1-6" +
			"\n" + "1. Add Contact" +
			"\n" + "2. Display All" +
			"\n" + "3. Search" +
			"\n" + "4. Delete" +
			"\n" + "5. Update" +
			"\n" + "6. Exit");
		
		int choice = scanner.nextInt();
		
		switch(choice) {
		case 1: 
			addContact();
			main();
			break;
		case 2:
			displayAll();
			main();
			break;
		case 3:
			searchContacts();
			main();
			break;
		case 4:
			deleteContact();
			main();
			break;
		case 5:
			updateEntry();
			main();
			break;
		case 6:
			exitPhoneBook();
			main();
			break;
		}
	}
	
	public static void displayAll() {
		try {
			for(Contacts person: persons) {
				if(persons != null) {
					System.out.println(person);
				}
			}
		} catch(NullPointerException e) {
			System.out.println("EMPTY CONTACT");
		}
	}

// Add new entries
	public static void addContact() {
		Scanner input = new Scanner(System.in);
		
		System.out.println("Contact: ");
		String info = input.nextLine();
		
		String[] myArray = info.split(",");	
		String fullName = myArray[0];
		String street = myArray[1];
		String city = myArray[2];
		String state = myArray[3];
		String zip = myArray[4];
		String phoneNumber = myArray[5];
		
		// Assign variables
		String firstName = "";
		String middleName = "";
		String lastName = "";
		
		String[] newArray = fullName.split(" ");
		
		// Loop through array
		if(newArray.length > 2) {
			firstName = newArray[0];
			
			for(int i = 1; i < newArray.length - 1; i++) {
				middleName = middleName + " " + newArray[i];
			}
			lastName = newArray[newArray.length - 1];
		} else {
			firstName = newArray[0];
			lastName = newArray[1];
		}
		
		Address address = new Address(street, city, state, zip);
		Contacts contact = new Contacts(firstName, middleName, lastName, address, phoneNumber);
			
		// expandArray(contact);
		add(persons, contact);
	}
	
	public static Contacts[] add(Contacts[] originalContacts, Contacts person) {
		if(persons.length == 0) {
			persons = new Contacts[1];
			persons[0] = person;
		} else {
			persons = new Contacts[persons.length + 1];
			for(int i = 0; i < originalContacts.length; i++) {
				persons[i] = originalContacts[i];
			}
			persons[persons.length - 1] = person;
		}
		return persons;
	}
	
// Search by first name, last name, phone number, city, or state
	public static void searchContacts() {
		Scanner in = new Scanner(System.in);
			
		System.out.println("How would you like to search 1-5" +
			"\n" + "1. By first name" +
			"\n" + "2. By last name" +
			"\n" + "3. By phone number" +
			"\n" + "4. By city" +
			"\n" + "5. By state");
		
		int option = in.nextInt();
				
		switch(option) {
		case 1:
			System.out.println("Enter First Name:");
			String firstName = in.nextLine();
			searchByFirstName();
			break;
		case 2:
			System.out.println("Enter Last Name: ");
			String lastName = in.nextLine();
			searchByLastName();
			break;
		case 3:
			System.out.println("Enter Phone Number: ");
			String phoneNumber = in.nextLine();
			searchByPhoneNumber();
			break;
		case 4:
			System.out.println("Enter City: ");
			String city = in.nextLine();
			searchByCity();
			break;
		case 5:
			System.out.println("Enter State: ");
			String state = in.nextLine();
			searchByState();
			break;
		default:
			System.out.println("Enter an option between 1 and 5.");
		}
	}
	
	public static void searchByFirstName() {
		Scanner in = new Scanner(System.in);
		String firstName = in.nextLine();
		
		for(Contacts person : persons) {
			try {
				if(person.getFirstName().equals(firstName)) {
				System.out.println(person);
				}
			} catch(NullPointerException e) {
				System.out.println("EMPTY");
			}
		} 
	}
	
	public static void searchByLastName() {
		Scanner in = new Scanner(System.in);
		String lastName = in.nextLine();
		
		for(Contacts person : persons) {
			try {
				if(person.getLastName().equals(lastName)) {
				System.out.println(person);
				}
			} catch(NullPointerException e) {
				System.out.println("EMPTY");
			}
		} 
	}
	
	public static void searchByPhoneNumber() {
		Scanner in = new Scanner(System.in);
		String phoneNumber = in.nextLine();
		
		for(Contacts person : persons) {
			try {
				if(person.getPhoneNumber().trim().equals(phoneNumber)) {
				System.out.println(person);
				}
			} catch(NullPointerException e) {
				System.out.println("EMPTY");
			}
		}
	}
	
	public static void searchByCity() {
		Scanner in = new Scanner(System.in);
		String city = in.nextLine();
		
		for(Contacts person : persons) {
			try {
				if(person.getAddress().getCity().trim().equals(city)) {
				System.out.println(person);
				}
			} catch(NullPointerException e) {
				System.out.println("EMPTY");
			}
		}
	}
	
	public static void searchByState() {
		Scanner in = new Scanner(System.in);
		String state = in.nextLine();
		
		for(Contacts person : persons) {
			try {
				if(person.getAddress().getState().trim().equals(state)) {
				System.out.println(person);
				}
			} catch(NullPointerException e) {
				System.out.println("EMPTY");
			}
		} 
	}
	
// Delete record for given phone number
	public static Contacts[] deleteContact() {
		Scanner input = new Scanner(System.in);
		Contacts[] temp = new Contacts[0];
		
		System.out.println("Enter phone number in order to delete contact: ");
		String deleteEntry = input.nextLine();
		
		for(int i = 0; i < persons.length; i++) {
			if(!persons[i].getPhoneNumber().trim().equals(deleteEntry));
			
		}
		if(temp.length < persons.length) {
			System.out.println("Contact deleted.");
		} else {
			System.out.println("Contact does not exist.");
		}
		return temp;
	}
	
	public static void updateEntry(){
		Scanner in = new Scanner(System.in);
		System.out.println("Enter Phone Number: ");
		String userInput = in.nextLine();
			
		String fullName, street, city, state, zip, phoneNumber;
		System.out.println("Enter New Entry Information \n"
				+ "(Format: Full Name,"
				+ " Street Address, City, State, Zip Code, Phone Number): ");
		
		String info = in.nextLine();
		
		String[] userInfo = info.split(",");
		fullName = userInfo[0];
		street = userInfo[1];
		city = userInfo[2];
		state = userInfo[3];
		zip = userInfo[4];
		phoneNumber = userInfo[5];
		
		String firstName = "";
		String middleName = "";
		String lastName = "";
		
		String[] userWhole = fullName.split(" ");
		
		if(userWhole.length > 2) {
			firstName = userWhole[0];
			
			for(int i = 1; i < userWhole.length - 1; i++) {
				middleName = middleName + " " + userWhole[i];
			}
			lastName = userWhole[userWhole.length - 1];
		} else {
			firstName = userWhole[0];
			lastName = userWhole[1];
		}
		
		Address address = new Address(street, city, state, zip);
		Contacts contact = new Contacts(firstName, middleName, lastName, address, phoneNumber);
		
		for(int i = 0; i < persons.length; i++) {
			if(persons[i].getPhoneNumber().trim().equals(userInput)) {
				persons[i] = contact;
			}
		}
	}

// Option to exit program
	public static void exitPhoneBook() {
		System.out.println("Exiting phone book.");
		System.exit(0);
	}
}
