package lab2;
import java.lang.Math;

public class Sphere extends Curved3DShape implements Comparable<Shape3D>{
	
	/**
	 * 	Constructor for Sphere object
	 * @param t	Name
	 * @param r	Radius
	 */
	public Sphere(String t, double r) {
		super(t, r);
	}
	/**
	 * 	Calculates area of a cone via formula 4πr^2
	 */
	public double area() {
		double r = super.getRadius();
		return 4.0 * Math.PI * (r * r);
	}
	/**
	 * 	Calculates volume of a sphere via formula 4/3πr^3
	 */
	public double volume() {
		double r = super.getRadius();
		return Math.pow(r, 3) * Math.PI * (4.0/3);
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
		return "Shape = sphere\tName = " + getType() + "\tradius = " + super.getRadius() 
		+ "\tArea = " + area() +"\tVolume = " + volume();
	}
}
