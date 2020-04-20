package PhonebookAssignment;

public class Address {
	
	// Instance Fields
	private String street;
	private String city;
	private String state;
	private String zip;
	

	// Default Constructor
	public Address() {
		
	}
	
	// Constructor Method w/Parameterized Fields
	public Address(String street, String city, String state, String zip) {
		this.street = street;
		this.city = city;
		this.state = state;
		this.zip = zip;
	}
	
		
	// Street
	public String getStreet() {
		return this.street;
	}

	public void setStreet(String street) {
		this.street = street;
	}
	
	// City
	public String getCity() {
		return this.city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
	// State
	public String getState() {
		return this.state;
	}
	public void setState(String state) {
		this.state = state;
	}
	
	// Zip
	public String getZip() {
		return this.zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}

	
	@Override
	public String toString() {
		return "Address [street=" + street + ", city=" + city + ", state=" + state + ", zip=" + zip + "]";
	}
}