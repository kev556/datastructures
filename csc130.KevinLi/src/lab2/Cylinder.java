package lab2;
import java.lang.Math;

public class Cylinder extends Curved3DShape implements Comparable<Shape3D>{

	// height of a cylinder from center of base to center of top
	private double height;
	
	/**
	 * 	Constructor for Cylinder object
	 * @param t	Name
	 * @param r	Radius
	 * @param h Height
	 */
	public Cylinder(String t, double r, double h) {
		super(t, r);
		// TODO Auto-generated constructor stub
		height = h;
	}
	/**
	 * 	Accessor for private double height
	 * @return height
	 */
	public double getHeight() {
		return height;
	}
	/**
	 * 	Mutator for private double height
	 * @param h height
	 */
	public void setHeight(double h) {
		height = h;
	}
	/**
	 * 	Returns area of Cylinder calculated by formula 2πr*(r+h)
	 */
	public double area() {
		double r = super.getRadius();
		
		return 2.0 * Math.PI * r * (r + height);
	}
	/**
	 * 	Returns volume of Cylinder calculated by formula 2πr^2
	 */
	public double volume() {
		double r = super.getRadius();
		
		return Math.PI * (r * r) * height;
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
		return "Shape = cylinder\tName = " + super.getType() + "\theight = " + 
		height + "\tradius = " + super.getRadius()
		+ "\tArea = " + area() +"\tVolume = " + volume();
	}
}
