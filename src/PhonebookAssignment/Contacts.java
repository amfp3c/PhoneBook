package PhonebookAssignment;

public class Contacts extends Address {
	
	// Instance Fields
	private String firstName;
	private String middleName;
	private String lastName;
	private Address address;
	private String phoneNumber;
	
	
	// Default Constructor
	public Contacts() {
		
	}
	
	// Constructor Method w/Parameterized Fields
	public Contacts(String firstName, String middleName, String lastName, Address address, String phoneNumber) {
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.address = address;
		this.phoneNumber = phoneNumber;
	}
	
	
	// First Name
	public String getFirstName() {
		return this.firstName;
	}
	public void setfirstName(String firstName) {
		this.firstName = firstName;
	}
	
	// Middle Name
	public String getMiddleName() {
		return this.middleName;
	}
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	
	// Last Name
	public String getLastName() {
		return this.lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	// Address
	public Address getAddress() {
		return this.address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	
	// Phone Number
	public String getPhoneNumber() {
		return this.phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	
	@Override
	public String toString() {
		return "Contacts [firstName=" + firstName + ", middleName=" + middleName + ", lastName=" + lastName + ", address=" + address + ", phoneNumber=" + phoneNumber + "]";
	}
}