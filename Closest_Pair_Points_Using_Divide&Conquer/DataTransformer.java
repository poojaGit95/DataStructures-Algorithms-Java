import java.util.ArrayList;
import java.util.List;

/**
 * Class to parse the string array data. 
 * Its functionality is to parse array of string data
 * into coordinate points (x,y). 
 * Return list of x-y points.
 * 
 * @author pooja nadagouda
 *
 */
public class DataTransformer {

	/*
	 * Parses array of string data to point(x,y) coordinates. 
	 * pre: allocates memory for x and
	 * y coordinates for the list of points. 
	 * post: returns list of points.
	 * 
	 */
	public List<Point> getPoints(String[] XYpoints) {
		List<Point> points = new ArrayList<Point>();
		for (int i = 1; i < XYpoints.length; i++) {
			String str = XYpoints[i];
			String[] point = str.split(" ");
			double x = Double.parseDouble(point[0]);
			double y = Double.parseDouble(point[1]);
			points.add(new Point(x, y));
		}
		return points;
	}

}
