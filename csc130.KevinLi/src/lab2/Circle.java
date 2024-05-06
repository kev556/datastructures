package lab2;
import java.lang.Math;

public class Circle extends Shape2D{
	/**
	 *  radius, or the length from a circle's epicenter to a point on a circle
	 */
	private double radius;
	
	/**
	 * Constructor for Circle object
	 * @param t	Name of the Circle
	 * @param r Value to become the radius of the Circle
	 */
	public Circle(String t, double r) {
		// refers to Shape's constructor to define name
		super(t);
		// assigns value of r to radius
		radius = r;
	}
	/**
	 * Accessor
	 * @return radius
	 */
	public double getRadius() {
		return radius;
	}
	/**
	 * Mutator
	 * @param r Value for radius to be set to 
	 */
	public void setRadius(double r) {
		// sets radius to value of r
		radius = r;
	}
	/**
	 * 	Calculates circumference of a circle via formula 2πr
	 */
	public double perimeter() {
		return Math.PI * radius * 2;
	}
	/**
	 * 	Calculates area of a circle via formula πr^2
	 */
	public double area() {
		return Math.PI * (radius * radius);
	}
	/**
	 * 	Compares the current Shape2D to another Shape2D o, 
	 * 	returns 0 if the areas are the same,
	 * 	returns 1 if the caller of the method has a larger area than o, and
	 * 	returns -1 if the caller of the method has a smaller area than o
	 * 	
	 */
	public int compareTo(Shape2D o) {
		if (this.area() == o.area()) {
			return 0;
		}
		else if (this.area() > o.area()) {
			return 1;
		}
		else {
			return -1;
		}
	}
	public String toString() {
		return "Shape = circle\tName = " + super.getType() + "\tRadius = " + radius 
				+ "\tPerimeter = " + perimeter() +"\tArea = " + area();
	}
}
