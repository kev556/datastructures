package lab2;

public abstract class Shape3D extends Shape implements Comparable<Shape3D>{

	// Refers to constructor of Shape
	public Shape3D(String t) {
		super(t);
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
	/**
	 * 	Defines a method area() for children to inherit, returns the volume, or 
	 * 	amount of space contained in a 3 dimensional shape
	 */
	public abstract double volume();
}
