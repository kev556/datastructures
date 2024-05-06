package lab2;

public abstract class Shape2D extends Shape implements Comparable<Shape2D> {

	public Shape2D(String t) {
		super(t);
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
	/**
	 * 	Defines a method perimeter() for children to inherit, returns the side lengths of a 
	 * 	2 dimensional shape
	 */
	public abstract double perimeter();
}
