import java.util.ArrayList;
import java.util.List;

/**
 * Class to reprsent main method. .
 * Functionality is to start of execution of main method. 
 * 
 * @author pooja nadagouda
 *
 */
public class Main {
	
	/* Main class to begin execution.
	 * pre: allocates memory for list of x-sorted points and list 
	 * of y-sorted points.
	 * post: displays the distance of closest pair of points.
	 */
	public static void main(String[] args) {
		
		FileParser file = new FileParser();
		String[] dataPoints = file.readDataFromFile("program2data.txt");
		
		DataTransformer transform = new DataTransformer();
		List<Point> points = transform.getPoints(dataPoints);
		
		ClosestPointsCalculator closestPointCalculator = new ClosestPointsCalculator();
		List<Point> pX = new ArrayList<Point>();
		List<Point> pY = new ArrayList<Point>();
		
		for(int i=0; i<points.size(); i++) {
			pX.add(points.get(i));
			pY.add(points.get(i));
		}
		
		//Sorting points by their x and y coordinates values.
		closestPointCalculator.sortPointsByX(pX);
		closestPointCalculator.sortPointsByY(pY);
		closestPointCalculator.xSortedPoints.addAll(pX);
		
		//distance between the closest pair of points.
		double minDistance = closestPointCalculator.calculateClosestPairDistance(pX,pY, points.size());
		System.out.println("D[0,"+ (pX.size()-1) + "]:" + " " + closestPointCalculator.formatter.format(minDistance));
		
	}

}
