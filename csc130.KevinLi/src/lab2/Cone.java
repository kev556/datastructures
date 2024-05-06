package lab2;
import java.lang.Math;

public class Cone extends Curved3DShape implements Comparable<Shape3D>{

	// height of a Cone from center of base to tip
	private double height;
	/**
	 * Constructor for Cone object 
	 * @param t	Name 
	 * @param r	Radius
	 * @param h	Height
	 */
	public Cone(String t, double r, double h) {
		//t is passed to Shape constructor, r is passed to Curved3DShape constructor
		super(t,r);
		//sets height to value of h
		height = h;
	}
	/**
	 * Accessor for height
	 * @return	height
	 */
	public double getHeight() {
		return height;
	}
	/**
	 * Formula to calculate the height of the slant of a cone
	 * @return	Slant height of a cone
	 */
	public double getSlantHeight() {
		double r = super.getRadius();
		return Math.sqrt((height * height) + (r * r));
	}
	/**
	 * Mutator for height
	 * @param h	value of h for height to be set to
	 */
	public void setHeight(double h) {
		height = h;
	}
	/**
	 * 	Calculates area of a cone via formula (SlantHeight + radius) * r * π
	 */
	public double area() {
		double r = super.getRadius();
		return Math.PI * r * (getSlantHeight() + r);
	}
	/**
	 * 	Calculates volume of a cone via formula 1/3πr^2h
	 */
	public double volume() {
		double r = super.getRadius();
		
		return ((1.0/3) * (Math.PI * (r * r))) * height;
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
		return "Shape = cone\tName = " + super.getType() + "\theight = " + height + 
				"\tradius = " + super.getRadius()+ "\tArea = " + area() +"\tVolume = " + volume();
	}
}
