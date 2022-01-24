import java.util.Stack;

/**
 * @author Pooja Nadagouda
 * 
 * This class is implementation of gale-shapely algorithm displaying an
 * output of stable matching pairs.
 *
 */
public class GaleShapelyAlgoImpl {

	/*
	 * This method carries out stable matching by following Gale-shapely algorithm.
	 * 
	 * @param numberOfMatches - number of persons/pets/matches
	 * @param person_list - persons list
	 * @param pet_list - pets list
	 * @param personPref_list - all persons preference list
	 * @param petPref_list - all pets preference list
	 * 
	 */
	public void performStableMatching(int numberOfMatches, String[] person_list, String[] pet_list,
			int[][] personPref_list, int[][] petPref_list) {

		Stack<Integer> free_Person = new Stack<Integer>();
		int[] free_pets = new int[numberOfMatches + 1];

		// this variable holds matches of Pet/Person in format array[pet]=person i.e. a
		// matched person's id is stored in array at index matching chosen pet's id.
		int[] matchedPairsPetPerson = new int[numberOfMatches + 1];

		// this variable holds matches of Person/Pet in format array[person]=pet i.e. a
		// pet's id is stored in array at index matching chosen person's id.
		int[] matchedPairsPersonPet = new int[numberOfMatches + 1];

		for (int i = 1; i <= numberOfMatches; i++) {
			free_Person.push(i);
			free_pets[i] = i;
		}

		int[][] invertedPetPref_list = Util.invert2DArray(petPref_list);

		while (!free_Person.isEmpty()) {
			int currPerson = free_Person.peek();
			for (int i = 1; i <= numberOfMatches; i++) {
				int currPet = personPref_list[currPerson][i];
				if (free_pets[currPet] != -1) {
					free_Person.pop();
					matchedPairsPetPerson[currPet] = currPerson;
					free_pets[currPet] = -1;
					break;
				} else {
					int assignedPerson = matchedPairsPetPerson[currPet];
					int assignedPersonRank = invertedPetPref_list[currPet][assignedPerson];
					int currPersonRank = invertedPetPref_list[currPet][currPerson];
					if (currPersonRank < assignedPersonRank) {
						free_Person.pop();
						free_Person.push(assignedPerson);
						matchedPairsPetPerson[currPet] = currPerson;
						break;
					}
				}
			}
		}

		// inverting the array to store in pet-person format required for display.
		matchedPairsPersonPet = Util.inver1DArray(matchedPairsPetPerson);
		displayMatches(matchedPairsPersonPet, person_list, pet_list);
	}

	
	/*
	 * This method displays the stable pairs of Person/Pet.
	 * 
	 * @param matches[] - array holding Person/Pet matches in format -> matches[Pet_id]=Person_id
	 * @param person_list[] - persons list
	 * @param pet_list - pets list
	 * 
	 */
	private void displayMatches(int[] matches, String[] person_list, String[] pet_list) {
		for (int i = 1; i < matches.length; i++) {
			System.out.println(person_list[i] + " / " + pet_list[matches[i]]);
		}

	}

}
