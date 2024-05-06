/**
* 
* <b>Title:</b> Lab 2:<br>
* <b>Filename:</b> Lab2App.java <br>
* <b>Date Written:</b> September 26, 2023<br>
* <b>Due Date:</b> September 30, 2023<br>
* <p>
* <b>Description:</b><br>
* Displays the Java Programming Language's Object Oriented capacity using various 2D and 3D 
* shapes as a model.
* </p>
* <p>
* Shapes such as Rectangles, Squares, Spheres, and Cones are created, with their characteristics
* and behaviors modeled by the program, such as radiuses, heights, areas, and volumes.
* Classes that inherit characteristics from other objects, for example how all squares are 
* rectangles, will become children of the classes whose characteristics they inherit.
* 2D Shapes will have the capacity to be compared to other 2D Shapes, and the same is true for
* 3D Shapes. 
* </p>
*@author Kevin Li
 */
package lab2;

public class Lab2App {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		/*Shape shape = new Shape("t");
		 * 
		 * Does not work, abstract classes cannot be instantiated
		 *
		 */
		
		Cube cube = new Cube("cube", 3.0);
		System.out.println(cube);
		
		Cone cone = new Cone("cone", 3.0, 2.0);
		System.out.println(cone);
		
		Cylinder cylinder = new Cylinder("cylinder", 2.0, 3.0);
		System.out.println(cylinder);
		
		Sphere sphere = new Sphere("sphere", 2.0);
		System.out.println(sphere);
		
		Circle circle = new Circle("circle", 3.0);
		System.out.println(circle);
		
		Rectangle rectangle = new Rectangle("rectangle", 2.0, 3.0);
		System.out.println(rectangle);
		
		Triangle triangle = new Triangle("triangle", 7.0, 10.0 ,5.0);
		System.out.println(triangle);
		
		Square square = new Square("square", 3.0);
		System.out.println(square + "\n");
		
		Shape[] shape = new Shape[8];
		
		/*
		 * Works because all shapes extend Shape2D or Shape3D 
		 * which in turn extends Shape, thus allowing them to be 
		 * stored in an array of Shapes.
		 */
		shape[0] = cube;
		shape[1] = cone;
		shape[2] = cylinder;
		shape[3] = sphere;
		shape[4] = circle;
		shape[5] = rectangle;
		shape[6] = triangle;
		shape[7] = square;
		
		/*
		 * 7. Output is the same as above
		 */
		for (Shape ashape : shape) {
			System.out.println(ashape);
		}
		
		int cr1 = cone.compareTo(sphere);
		int cr2 = rectangle.compareTo(triangle);
		
		if (cr1 == 0) {
			System.out.println("\nThe cone has the same volume as the sphere.");
		}
		else if (cr1 == 1) {
			System.out.println("\nThe cone has a larger volume than the sphere.");
		}
		else {
			System.out.println("\nThe cone has a smaller volume than the sphere.");
		}
		
		if (cr2 == 0) {
			System.out.println("\nThe rectangle has the same volume as the triangle.");
		}
		else if (cr2 == 1) {
			System.out.println("\nThe rectangle has a larger volume than the triangle.");
		}
		else {
			System.out.println("\nThe rectangle has a smaller volume than the triangle.");
		}
	}

}
