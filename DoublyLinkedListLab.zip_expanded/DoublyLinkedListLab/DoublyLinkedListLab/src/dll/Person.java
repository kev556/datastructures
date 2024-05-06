package dll;

//Kevin Li N00969115

public class Person {
	private String firstName;
	private String lastName;
	private String bannerID;
	private String degreeMajor;
	
	public Person(String firstName, String lastName, String bannerID, String degreeMajor) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.bannerID = bannerID;
		this.degreeMajor = degreeMajor;
	}
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getBannerID() {
		return bannerID;
	}
	public void setBannerID(String bannerID) {
		this.bannerID = bannerID;
	}
	public String getDegreeMajor() {
		return degreeMajor;
	}
	public void setDegreeMajor(String degreeMajor) {
		this.degreeMajor = degreeMajor;
	}
	
	@Override
	public String toString() {
		return "Person [firstName=" + firstName + ", lastName=" + lastName + ", bannerID=" + bannerID + ", degreeMajor="
				+ degreeMajor + "]";
	}
	/**
	 * Equals method that returns true if the lastName and bannerID are the same, ignoring case. Returns false otherwise.
	 * @param other
	 * @return
	 */
	public boolean equals(Person other) {
		if (other.lastName.equalsIgnoreCase(this.lastName) && other.bannerID.equalsIgnoreCase(this.bannerID))
			return true;
		return false;
	}
	
	
}
