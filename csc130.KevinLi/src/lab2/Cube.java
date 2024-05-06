package lab2;
import java.lang.Math;

public class Cube extends Shape3D implements Comparable<Shape3D>{

	/**
	 * 	Side length of all sides of a cube
	 */
	private double side;
	
	/**
	 * 	Constructor for a Cube object
	 * @param t	Name
	 * @param s	Side length for all sides of a cube
	 */
	public Cube(String t, double s) {
		super(t);
		// TODO Auto-generated constructor stub
		side = s;
	}
	/**
	 * 	Accessor for private double side
	 * @return	side
	 */
	public double getSide() {
		return side;
	}
	/**
	 * 	Mutator for private double side
	 * @param s	side
	 */
	public void setSide(double s) {
		side = s;
	}
	/**
	 * 	Returns area given by formula 6*s^2
	 */
	public double area() {
		return 6 * (side * side);
	}
	/**
	 * 	Returns volume given by formula side^3
	 */
	public double volume() {
		return Math.pow(side, 3);
	}
	/**
	 * 	Compares the current Shape3D to another Shape3D o, 
	 * 	returns 0 if the volumes are the same,
	 * 	returns 1 if the caller of the method has a larger volume than o, and
	 * 	returns -1 if the caller of the method has a smaller volume than o
	 * 	
	 */
	public int compareTo(Shape3D o) {
		if (this.volume() == o.volume()) {
			return 0;
		}
		else if (this.volume() > o.volume()) {
			return 1;
		}
		else {
			return -1;
		}
	}
	public String toString() {
		return "Shape = cube\tName = " + super.getType() + "\tsidelength = " + side 
				+ "\tArea = " + area() +"\tVolume = " + volume();
	}
}
