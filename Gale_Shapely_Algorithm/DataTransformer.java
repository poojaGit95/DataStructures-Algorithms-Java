/**
 * @author Pooja Nadagouda
 * 
 * This class gives the data required for executing stable matching in
 * appropriate format by processing data sent from the text file.
 *
 */

public class DataTransformer {

	/*
	 * This method returns number of matches/ number of people/ number of pets from
	 * file which is the 1st entry in the data file.
	 * 
	 * @param data[] - array holding file data
	 * 
	 * @return int - number of persons/pets
	 */
	public int getNumberOfMatches(String[] data) {
		return Integer.valueOf(data[0]);
	}
	

	/*
	 * This method returns array of people names from the file array data.
	 * 
	 * @param data[] - array holding file data
	 * 
	 * @param size - number of persons/pets
	 * 
	 * @return String[] - array of persons
	 */
	public String[] getPersonsList(String[] data, int size) {
		// adds names of persons to an array
		String[] person_list = new String[size + 1];
		for (int i = 1; i < person_list.length; i++) {
			person_list[i] = data[i];
		}
		return person_list;
	}

	
	/*
	 * This method returns 2D array of people preferences from the data file.
	 * 
	 * @param data[] - array holding file data
	 * 
	 * @param size - number of persons/pets
	 * 
	 * @return int[][] - 2D array of person preferences
	 */
	public int[][] getAllPersonPerferences(String[] data, int size) {
		// adds preference order of all pets to 2D array
		int[][] personPref_list = new int[size + 1][size + 1];
		int k = size + 1;
		for (int i = 1; i < personPref_list.length; i++) {
			String str = data[k];
			k++;
			String[] s = str.split(" ");
			for (int j = 1; j < personPref_list.length; j++) {
				personPref_list[i][j] = Integer.valueOf(s[j - 1]);
			}

		}
		return personPref_list;
	}

	
	/*
	 * This method returns array of pet names from the data file.
	 * 
	 * @param data[] - array holding file data
	 * 
	 * @param size - number of persons/pets
	 * 
	 * @return String[] - array of pets
	 */
	public String[] getPetsList(String[] data, int size) {
		// adds names of pets to an array
		String[] pet_list = new String[size + 1];
		int j = (size * 2) + 1;
		for (int i = 1; i < pet_list.length; i++) {
			pet_list[i] = data[j];
			j++;
		}
		return pet_list;
	}

	
	/*
	 * This method returns 2D array of pet preferences from the data file.
	 * 
	 * @param data[] - array holding file data
	 * 
	 * @param size - number of persons/pets
	 * 
	 * @return int[][] - 2D array of pet preferences
	 */
	public int[][] getAllPetPreferences(String[] data, int size) {
		// adds preference order of all persons to 2D array
		int[][] petPref_list = new int[size + 1][size + 1];
		int k = (size * 3) + 1;
		for (int i = 1; i < petPref_list.length; i++) {
			String str = data[k];
			k++;
			String[] s = str.split(" ");
			for (int j = 1; j < petPref_list.length; j++) {
				petPref_list[i][j] = Integer.valueOf(s[j - 1]);
			}
		}
		return petPref_list;
	}

}
