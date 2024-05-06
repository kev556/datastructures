package csc130.KevinLi.lab3;

import java.util.Calendar;
/**
* <b>Title:</b> Lab 3<br>
* <b>Filename:</b> Date.java<br>
* <b>Date Written:</b> October 3, 2023<br>
* <b>Due Date:</b> October 7, 2023<br>
* </p>
*/

/**
 * <p>
 * Title: Date.java
 * </p>
 *
 * <p>
 * Description: A class defined by three numbers representing a date on a calendar,
 * Month, Day and Year.
 * </p>
 *
 * <p>
 * Copyright: Copyright (c) 2016
 * </p>
 *
 * <p>
 * Company: Nassau Community College
 * </p>
 *
 * @author not attributable
 * @version 1.0
 */
public class Date {
	
	private int dMonth; // variable to store the month
	private int dDay; // variable to store the day
	private int dYear; // variable to store the year

	/**
	 * default constructor - sets dMonth, dDay, and dYear to today's date
	 */
	public Date() {
		dMonth = Calendar.getInstance().get(2)+1;
		dDay = Calendar.getInstance().get(5);
		dYear = Calendar.getInstance().get(1);
	}

	/**
	 * parameterized constructor - sets dMonth, dDay, and dYear to user
	 * specified values
	 * 
	 * @param month
	 *            value to be stored in dMonth
	 * @param day
	 *            value to be stored in dDay
	 * @param year
	 *            value to be stored in dYear
	 */
	public Date(int month, int day, int year) throws DateException{
		try {
			setMonth(month);
			setDay(day);
			setYear(year);
		}
		catch (DateException de) {
			System.out.println("Date Exception: " + de.getMessage());
		}
	}

	/**
	 * setDate - stores month, day, and year in dMonth, dDay, and dYear
	 * respectively be calling each of the setMethods defined
	 * 
	 * @param month
	 *            value to be stored in dMonth
	 * @param day
	 *            value to be stored in dDay
	 * @param year
	 *            value to be stored in dYear
	 */
	public void setDate(int month, int day, int year) {
		try {
			setMonth(month);
			setDay(day);
			setYear(year);
		}
		catch (DateException de) {
			System.out.println("Date Exception: " + de.getMessage());
			
		}
	}

	/**
	 * setMonth - stores month in dMonth
	 * 
	 * @param month
	 *            the value to be stored in dMonth
	 */
	public void setMonth(int month) throws DateException {
		
			if (month >= 1 && month <= 12)
				dMonth = month;
			else
				throw new DateException("Invalid Month: Month out of range");
	}

	/**
	 * setDay - stores day in dDay
	 * 
	 * @param day
	 *            the value to be stored in dDay
	 */
	public void setDay(int day) throws DateException {
		if (dYear == 2 && day >= 1 && day <= 29)
			dDay = day;
		else if (day >= 1 && day <= 31) 
			dDay = day;
		else 
			throw new DateException("Invalid Day: Day out of range");
	}

	/**
	 * setYear - stores year in dYear
	 * 
	 * @param year
	 *            the value to be stored in dYear
	 */
	public void setYear(int year) throws DateException {
		if (year >= 1752 && dMonth == 2 && dDay == 29 && !isLeapYear(year))
			throw new DateException("Invalid Day: No February 29 on year " + year);
		else if (year >= 1752)
			dYear = year;
		else 
			throw new DateException("Invalid Day: Enter year larger than or equal to 1752");
	}
	public boolean isLeapYear(int year) {
		return (year % 400 == 0 || (year % 4 == 0 && year % 100 != 0));
	}
	/**
	 * getMonth - accessor for dMonth
	 * 
	 * @return returns the value stored in dMonth
	 */
	public int getMonth() {
		return dMonth;
	}

	/**
	 * getDay - accessor for dDay
	 * 
	 * @return returns the value stored in dDay
	 */
	public int getDay() {
		return dDay;
	}

	/**
	 * getYear - accessor for dYear
	 * 
	 * @return returns the value stored in dYear
	 */
	public int getYear() {
		return dYear;
	}

	/**
	 * toString - returns the month, day, and year in the format: mm-dd-yyyy;
	 * leading zeros are NOT contained within the string
	 * 
	 * @return a String containing the date in month-day-year format
	 */
	public String toString() {
		return (dMonth + "-" + dDay + "-" + dYear);
	}
}