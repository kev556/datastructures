package lab2;
import java.lang.Math;

public final class Triangle extends Shape2D implements Comparable<Shape2D>{

	/**
	 *  Sides of the triangle
	 */
	private double a;
	private double b;
	private double c;
	
	/**
	 * 
	 * @param t	 				The name of the Shape
	 * @param side1				Length of side 1
	 * @param side2				Length of side 2
	 * @param side3 			Length of side 3
	 * @throws RuntimeException	Throws exception when the 3 parameters together do not 
	 * 							make a valid triangle
	 */
	public Triangle(String t, double side1, double side2, double side3) throws RuntimeException{

		super(t);
		
		if (isValid(side1, side2, side3) == false) {
			throw new RuntimeException("InvalidTriangleException");
		}
		
		a = side1;
		b = side2;
		c = side3;
	}
	/**
	 * Accessor
	 * @return a
	 */
	public double getSide1() {
		return a;
	}
	/**
	 * Accessor
	 * @return b
	 */
	public double getSide2() {
		return b;
	}
	/**
	 * Accessor
	 * @return c
	 */
	public double getSide3() {
		return c;
	}
	/**
	 * 	Returns the value equivalent to all three side lengths added together
	 */
	public double perimeter() {
		return a + b + c;
	}
	/**
	 * 	Mathematically calculates the area of a triangle.
	 * 	s is the semi-perimeter of a triangle, 
	 *	where the formula sqrt(s * ((s - a) * (s - b) * (s - c))) gives the area.
	 */
	public double area() {
		double s = (a + b + c) / 2.0;
		return Math.sqrt(s * ((s - a) * (s - b) * (s - c)));
	}
	/**
	 * 
	 * @param a	Side 1 
	 * @param b	Side 2
	 * @param c	Side 3
	 * @return	If the first and second side lengths add up to a number greater than
	 * 			the length of the third side length, then the triangle is valid.
	 * 			Returns false otherwise
	 */
	public boolean isValid(double a, double b, double c) {
		return (a + b > c);
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
		return "Shape = triangle\tName = " + super.getType() + 
		"\tSide 1 = " + a + "\tSide 2 = " + b + "\tSide 3 = " + c
		+ "\tPerimeter = " + perimeter() +"\tArea = " + area();
		
	}
	

}
