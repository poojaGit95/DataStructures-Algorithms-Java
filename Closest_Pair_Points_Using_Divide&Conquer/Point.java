/**
 * Class to represent a xy point. 
 * Point is represented by x and y coordinates.
 * Functionality includes setter and getter for of x and y values.
 * 
 * @author poojanadagouda
 */
public class Point {

	double x;
	double y;

	/**
     * copy constructor
     * pre: none
     * post: Student s is copied into this object
     */
	/*
	 * constructor
     * pre: allocates memory to coordinates of a point(x,y). 
	 * post: none
	 */
	public Point(double a, double b) {
		this.x = a;
		this.y = b;

	}

	/*
	 * Accessor for x coordinate.
	 * pre: none
	 * post: returns x coordinate value of a point.
	 */
	public double getX() {
		return x;
	}

	/*
	 * Setter for x coordinate.
	 * pre: allocates memory to x coordinate
	 * post: sets the x coordinate value of a point.
	 */
	private void setX(double a) {
		this.x = a;
	}

	/*
	 * Accessor for y coordinate.
	 * pre: none
	 * post: returns the y coordinate value of a point.
	 */
	public double getY() {
		return y;
	}

	/*
	 * Setter for y coordinate.
	 * pre: allocates memory to y coordinate
	 * post: sets the y coordinate value of a point.
	 */
	private void setY(double b) {
		this.y = b;
	}

	
	/*
	 * toString
	 * pre: x and y has been allocated memory.
	 * post: The x and y coordinates are concatenated in a string
	 * and returned
	 */
	@Override
	public String toString() {
		return "Point [x=" + x + ", y=" + y + "]";
	}

}
