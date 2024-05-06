package lab2;

public final class Square extends Rectangle implements Comparable<Shape2D>{
	
	private double sidelength;

	/**
	 *
	 * @param t	Name of the square
	 * @param d	Side length used to create all four sides of a square
	 */
	public Square(String t, double d) {
		/*  All squares are rectangles. Square's constructor will refer to 
			Rectangle's constructor completely 
		*/
		super(t,d,d);
		sidelength = d;
	}
}
