package csc130.KevinLi.lab7;

/**
* <b>Title:</b> Lab 7:<br>
* <b>Filename:</b> CovidCase.java<br>
* <b>Date Written:</b> November 30, 2023<br>
* <b>Due Date:</b> December 2, 2023<br>
* <p>
* <b>Description:</b><br>
* Defines a CovidCase object, an object with fields containing a country's COVID 
* statistics to include Date reported, country, country code, cases and deaths.
* </p>
* <p>
*</p>
*@author Kevin Li
*/

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class CovidCase implements Comparable<CovidCase>{
	private LocalDate dateReported;
	private String countryCode; 
	private String country;
	private int newCases;
	private int cumulativeCases;
	private int newDeaths;
	private int cumulativeDeaths;
	
	public CovidCase() {
		super();
	}

	public CovidCase(LocalDate dateReported, String countryCode, String country, int newCases, int cumulativeCases,
			int newDeaths, int cumulativeDeaths) {
		super();
		this.dateReported = dateReported;
		this.countryCode = countryCode;
		this.country = country;
		this.newCases = newCases;
		this.cumulativeCases = cumulativeCases;
		this.newDeaths = newDeaths;
		this.cumulativeDeaths = cumulativeDeaths;
	}
	/**
	 * Constructor taking in a string array and instantiating each field with 
	 * the value at the respective index in the array
	 * @param fields
	 */
	public CovidCase(String[] fields) {
		try {
			// attempts to parse the date at fields[0] into a LocalDate Object
			dateReported = LocalDate.parse(fields[0]);
		}
		catch (DateTimeParseException dte) {
			// sets date to 1/1/1900 if invalid date is passed
			dateReported = LocalDate.parse("1/1/1900");
		}
		
		countryCode = fields[1];
		country = fields[2];
		
		/**
		 * All integer values default to 0 if a number does not result from parseInt
		 */
		try {
			newCases = Integer.parseInt(fields[3]);
		}
		catch (NumberFormatException dte) {
			newCases = 0;
		}
		try {
			cumulativeCases = Integer.parseInt(fields[4]);
		}
		catch (NumberFormatException dte) {
			cumulativeCases = 0;
		}
		try {
			newDeaths = Integer.parseInt(fields[5]);
		}
		catch (NumberFormatException dte) {
			newDeaths = 0;
		}
		try {
			cumulativeDeaths = Integer.parseInt(fields[6]);
		}
		catch (NumberFormatException dte) {
			cumulativeDeaths = 0;
		}
	}

	public LocalDate getDateReported() {
		return dateReported;
	}

	public void setDateReported(LocalDate dateReported) {
		this.dateReported = dateReported;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public int getNewCases() {
		return newCases;
	}

	public void setNewCases(int newCases) {
		this.newCases = newCases;
	}

	public int getCumulativeCases() {
		return cumulativeCases;
	}

	public void setCumulativeCases(int cumulativeCases) {
		this.cumulativeCases = cumulativeCases;
	}

	public int getNewDeaths() {
		return newDeaths;
	}

	public void setNewDeaths(int newDeaths) {
		this.newDeaths = newDeaths;
	}

	public int getCumulativeDeaths() {
		return cumulativeDeaths;
	}

	public void setCumulativeDeaths(int cumulativeDeaths) {
		this.cumulativeDeaths = cumulativeDeaths;
	}

	@Override
	public String toString() {
		return "CovidCase [dateReported=" + dateReported + ", countryCode=" + countryCode + ", country=" + country
				+ ", newCases=" + newCases + ", cumulativeCases=" + cumulativeCases + ", newDeaths=" + newDeaths
				+ ", cumulativeDeaths=" + cumulativeDeaths + "]";
	}
	/**
	 * Compares a CovidCase object to another by comparing dates. If dates are equal, compares via country code instead.
	 */
	public int compareTo(CovidCase other) {
		if (this.countryCode.equals(other.countryCode)) {
			if (this.dateReported.compareTo(other.getDateReported()) > 0)
				return 1;
			else if (this.dateReported.compareTo(other.getDateReported()) < 0)
				return -1;
			else
				return 0;
		}
		else {
			if (this.countryCode.compareTo(other.getCountryCode()) > 0)
				return 1;
			else
				return -1;
		}
	}
	/**
	 * Determines whether this CovidCase is equivalent to another by determining if either 
	 * the country code or country strings are equivalent
	 */
	public boolean equals(Object other) {
		if(other.getClass().getSimpleName().equalsIgnoreCase("CovidCase")) {
			CovidCase occ = (CovidCase)other;
			if (this.countryCode.equals(occ.getCountryCode()) || this.country.equals(occ.getCountry()))
				return true;
			else
				return false;
		}
		else 
			return false;
		
	}
	
	
}
