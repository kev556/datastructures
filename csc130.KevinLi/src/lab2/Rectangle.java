package lab2;

public class Rectangle extends Shape2D implements Comparable<Shape2D>{
	
	// the length and width of a rectangle, having 2 lengths and 2 widths
	private double length;
	private double width;
	
	public Rectangle(String t, double l, double w) {
		// refers to Shape's constructor to assign name of Rectangle
		super(t);
		
		// defines length and width as l and w respectively
		length = l;
		width = w;
		
	}
	/**
	 * Accessor
	 * @return length
	 */
	public double getLength() {
		return length;
	}
	/**
	 * Accessor
	 * @return width
	 */
	public double getWidth() {
		return width;
	}
	/**
	 *  @return all sides of a rectangle added up
	 */
	public double perimeter() {
		//adds 2 lengths and 2 widths to get the perimeter
		return (2 * length) + (2 * width);
	}
	/**
	 *  returns the area of a rectangle
	 */
	public double area() {
		//Formula of a rectangle = length x width
		return length * width;
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
		return "Shape = rectangle\tName = " + super.getType() + "\tlength = " + length + "\twidth = " + width
				+ "\tPerimeter = " + perimeter() +"\tArea = " + area();
	}

}
