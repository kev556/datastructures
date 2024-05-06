package lab2;

public abstract class Curved3DShape extends Shape3D {

	// radius, or the length from a circle's epicenter to a point on a circle
	private double radius;
	
	
	public Curved3DShape(String t, double r) {
		// refers to Shape's constructor
		super(t);
		// assigns value of r to radius
		radius = r;
	}
	/**
	 * Accessor method for private double radius
	 * @return 
	 */
	public double getRadius(){
		return radius;
	}
	/**
	 * 	Mutator method to change value of private double radius
	 * @param d	Value for radius to be set to
	 */
	public void setRadius(double d) {
		radius = d;
	}
	public String toString() {
		return "Shape = Curved 3 Dimensional Shape, Name = " + super.getType() + "radius = " + radius;
	}

}
