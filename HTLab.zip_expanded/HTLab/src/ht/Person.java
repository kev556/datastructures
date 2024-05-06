package ht;

/**
 * 	Kevin Li N00969115
 */
public class Person {
	// Objects of Person will be used as the value in the SimpleEntry
	
	// will need instance vars for first name, last name, email
	// gets and sets for all, param constructor methods as well
	private String firstName;
	private String email;
	private Lastname lastname;
	
	public Person(String firstName, String email, Lastname lastname) {
		this.firstName = firstName;
		this.email = email;
		this.lastname = lastname;
	}
	public Person() {
		this.firstName = "Johnny";
		this.email = "jj@jmail.com";
		this.lastname = new Lastname("Appleseed");
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String toString() {
		StringBuilder sb = new StringBuilder();
		
		sb.append("firstname = " + firstName);
		sb.append(" lastname = " + lastname.toString());
		sb.append(" email = " + email);
		
		return sb.toString();
	}
	
}
