import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 
 * Class for computing closest pair of points. 
 * Functionality includes calculating euclidean distance, 
 * finding the closest pair of points.
 * 
 * @author pooja nadagouda
 *
 */

public class ClosestPointsCalculator {

	DecimalFormat formatter = new DecimalFormat("#0.0000");

	
	List<Point> xSortedPoints;
	
	
	/*
	 * Constructor
	 * pre: allocates for list of points
	 * post: none
	 */
	public ClosestPointsCalculator() {
		xSortedPoints = new ArrayList<Point>();
	}

	
	/*
	 * Method to sort all points in ascending order of x coordinate value. 
	 * pre: none
	 * post: returns sorted list of points
	 */
	public void sortPointsByX(List<Point> points) {
		Collections.sort(points, new XCoordinateSorter());
	}

	
	/*
	 * Method to sort all points in ascending order of y coordinate value. 
	 * pre: none
	 * post: returns sorted list of points
	 */
	public void sortPointsByY(List<Point> points) {
		Collections.sort(points, new YCoordinateSorter());
	}

	
	/*
	 * Method to compute index of a point in list of x sorted points. 
	 * pre: none
	 * post: returns index of the point
	 */
	private int getPointIndex(Point point) {
		int index = xSortedPoints.indexOf(point);
		return index;
	}

	
	/*
	 * Calculates Euclidean Distance for 2 points. 
	 * pre: none 
	 * post: returns the distance between 2 points.
	 */
	private double calculateEuclideanDistance(Point x, Point y) {
		double a = Math.abs(x.getX() - y.getX());
		double b = Math.abs(x.getY() - y.getY());
		double distance = Math.sqrt((a * a) + (b * b));
		return distance;
	}

	
	/*
	 * Computes minimum distance between all given points i.e. 3 or less points.
	 * pre: none 
	 * post: returns the smallest eculidean distance among the points.
	 */
	private double calculateMinDistanceForPoints(List<Point> points) {
		double distance = 0;
		double minDistance = Double.MAX_VALUE;
		for (int i = 0; i < points.size() - 1; i++) {
			for (int j = i + 1; j < points.size(); j++) {
				distance = calculateEuclideanDistance(points.get(i), points.get(j));
				if (distance < minDistance) {
					minDistance = distance;
				}
			}
		}
		return minDistance;
	}

	
	/*
	 * 
	 * Method to compute minimum distance between points in left half and right half
	 * which lie within the current minimum distance (lie within strip width). 
	 * pre: none 
	 * post: returns the minimum distance for the points.
	 * 
	 */
	private double calculateMinDistanceInStrip(List<Point> points, double minDistanceOfHavles) {
		double minDistance = minDistanceOfHavles;

		for (int i = 0; i < points.size(); i++) {
			for (int j = i + 1; j < points.size()
					&& (points.get(j).getY() - points.get(i).getY()) < minDistanceOfHavles; j++) {
				double dist = calculateEuclideanDistance(points.get(i), points.get(j));
				if (dist < minDistance) {
					minDistance = dist;
				}
			}
		}

		return minDistance;
	}
	

	/*
	 * Method to calculate distance between the closest pair of points in the list
	 * of points passed. 
	 * 
	 * pre: recursively divides the list of both x-soretd and
	 * y-sorted points into 2 sets by the mid Point. 
	 * Allocates memory for 2 lists
	 * for x-sorted points and y-sorted points in left half and memory for 2 lists
	 * for x-sorted points and y-sorted points in right half. 
	 * 
	 * post: returns the distance of the closest points in list.
	 * 
	 */
	public double calculateClosestPairDistance(List<Point> px, List<Point> py, int numberOfPoints) {
		
		double minDistance;

		// calculate distance by brute force if no. of points <=3
		if (numberOfPoints <= 3) {
			return calculateMinDistanceForPoints(py);
		}

		// calculating mid point for the given list of points.
		int mid = numberOfPoints / 2;
		Point midPoint;
		if (numberOfPoints % 2 == 0) {
			mid = mid - 1;
			midPoint = px.get(mid);
		} else {
			midPoint = px.get(mid);
		}

		//list to store points divided by mid point with x-sorting and y-sorting.
		List<Point> leftXSortedPoints = new ArrayList<Point>();
		List<Point> rightXSoretdPoints = new ArrayList<Point>();
		List<Point> leftYSortedPoints = new ArrayList<Point>();
		List<Point> rightYSoretdPoints = new ArrayList<Point>();

		// dividing the y sorted points by the mid point into 2 lists - left & right.
		for (int i = 0; i < numberOfPoints; i++) {
			if (py.get(i).getX() < midPoint.getX()
					|| (py.get(i).getX() == midPoint.getX() && py.get(i).getY() <= midPoint.getY())) {
				leftYSortedPoints.add(py.get(i));
			} else {
				rightYSoretdPoints.add(py.get(i));
			}
		}

		// dividing the x sorted points by the mid point into 2 lists - left & right.
		for (int i = 0; i < numberOfPoints; i++) {
			if (px.get(i).getX() < midPoint.getX()
					|| (px.get(i).getX() == midPoint.getX() && px.get(i).getY() <= midPoint.getY())) {
				leftXSortedPoints.add(px.get(i));
			} else {
				rightXSoretdPoints.add(px.get(i));
			}
		}

		// leftMinDistance gives the closest distance of points from left list.
		double leftMinDistance = calculateClosestPairDistance(leftXSortedPoints, leftYSortedPoints,
				leftYSortedPoints.size());
		leftMinDistance = Double.parseDouble(String.format("%.4f", leftMinDistance));
		System.out.println("D[" + getPointIndex(leftXSortedPoints.get(0)) + ","
				+ getPointIndex(leftXSortedPoints.get(leftXSortedPoints.size() - 1)) + "]:" + " "
				+ formatter.format(leftMinDistance));

		// rightMinDistance gives the closest distance of points from right list.
		double rightMinDistance = calculateClosestPairDistance(rightXSoretdPoints, rightYSoretdPoints,
				rightYSoretdPoints.size());
		rightMinDistance = Double.parseDouble(String.format("%.4f", rightMinDistance));
		System.out.println("D[" + getPointIndex(rightXSoretdPoints.get(0)) + ","
				+ getPointIndex(rightXSoretdPoints.get(rightXSoretdPoints.size() - 1)) + "]:" + " "
				+ formatter.format(rightMinDistance));

		// minDistance gives the closest distance of points from left and right halves.
		minDistance = Math.min(leftMinDistance, rightMinDistance);

		// creating strip of width equal to two times of minimum distance of points from
		// left and right halves.
		// adding points to list which lie within strip width.
		List<Point> deltaStrip = new ArrayList<Point>();
		for (int i = 0; i < numberOfPoints; i++) {
			if (Math.abs(py.get(i).getX() - midPoint.getX()) <= minDistance) {
				deltaStrip.add(py.get(i));
			}
		}

		// minDistanceForPointsInStrip gives the closest distance of points lying
		// within the strip.
		double minDistanceForPointsInStrip = calculateMinDistanceInStrip(deltaStrip, minDistance);

		// minDistance gives the closest distance of points.
		minDistance = Math.min(minDistanceForPointsInStrip, minDistance);
		return minDistance;
	}

}
