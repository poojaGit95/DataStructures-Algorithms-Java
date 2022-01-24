import java.util.Comparator;

/**
 * Class is a comparator. 
 * Functionality is to compares points by y coordinate value. 
 * Returns 0,-1 or 1 if equal, less than or greater than respectively.
 * 
 * @author pooja nadagouda
 */
public class YCoordinateSorter implements Comparator<Point> {

	
	/*
	 * comparator for y coordinate. 
	 * pre: takes in 2 points which are to be compared.
	 * post: returns 0,-1 or 1 if p1==p2, p1<p2  or p1>p2 respectively.
	 */
	@Override
	public int compare(Point p1, Point p2) {
		return Double.compare(p1.getY(), p2.getY());
	}

}
