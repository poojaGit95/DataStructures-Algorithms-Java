/**
 * @author Pooja Nadagouda
 *	
 */

public class Main {
	public static void main(String[] args) {
		//reading the data from text file.
		FileParser fileParser = new FileParser();
		String[] fileData = fileParser.readDataFromFile("program1data.txt");
		
		//storing the data into appropriate variables.
		DataTransformer dataTransformer = new DataTransformer();
		int numberOfMatches = dataTransformer.getNumberOfMatches(fileData);
		String[] person_list = dataTransformer.getPersonsList(fileData, numberOfMatches);
		int[][] personPref_list = dataTransformer.getAllPersonPerferences(fileData, numberOfMatches);
		String[] pet_list = dataTransformer.getPetsList(fileData, numberOfMatches);
		int[][] petPref_list = dataTransformer.getAllPetPreferences(fileData, numberOfMatches);
		
		//executing the gale shapely algorithm.
		GaleShapelyAlgoImpl gsAlgo = new GaleShapelyAlgoImpl();
		gsAlgo.performStableMatching(numberOfMatches, person_list, pet_list, personPref_list, petPref_list);
		
	}
}
