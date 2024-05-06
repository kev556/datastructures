package ht;

/**
 * 	Kevin Li N00969115
 */

public class Lastname {
	private String lastname;

	public Lastname(String lastname) {
		this.lastname = lastname;
	}
	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	
	/**
	 * 	Returns the hashcode of the lastname. The algorithm used:
	 * 
	 * 	ASCII value * prime^(length - i) 
	 * 			 (31 in this case) (i starts at 1)
	 * 
	 * 	Performed for each character, then summed up
	 * 
	 * 	Returns the total of each hashed character
	 */
	@Override
	public int hashCode() {
		int code = 0;
		int len = lastname.length();
		
		// Performs the algorithm on each character, then adds the result to a total
		for (int i = 0; i < len; i++) {
			code += lastname.charAt(i) * (int)Math.pow(31, len - i + 1);
		}
		return code;
	}
	@Override
	public String toString() {
		return lastname;
	}
	
	
}
