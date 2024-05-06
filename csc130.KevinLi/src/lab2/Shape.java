package lab2;

public abstract class Shape {

	/**
	 * 	Defines a String name that will hold a Shape's name
	 */
	private String name;
	
	/**
	 * 	Constructor for object Shape
	 * @param t	name
	 */
	public Shape(String t) {
		name = t;
	}
	/**
	 * 	Accessor for private String name
	 * @return name
	 */
	public String getType() {
		return name;
	}
	public String toString() {
		return "Shape: a shape";
	}
	/**
	 * 	Defines an abstract method area for children to inherit 
	 * @return	Returns area of a 2D or 3D shape
	 */
	public abstract double area();

}
