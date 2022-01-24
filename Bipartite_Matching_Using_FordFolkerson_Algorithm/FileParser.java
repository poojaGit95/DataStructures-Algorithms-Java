import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * Class to read file.
 * Functionality is to read data from file, store it into array list.
 * Returns array list of data.
 * 
 * @author pooja nadagouda
 *
 */

public class FileParser {

	/*
	 * Reads data from text file.
	 * pre: allocates memory to array list to store data from file.
	 * post: Returns array list data.
	 */
	public List<String> readDataFromFile(String path) {
		File file = new File(path);
		BufferedReader bf = null;
		List<String> data = new ArrayList<>();
		try {
			bf = new BufferedReader(new FileReader(file));
			String text;
			while ((text = bf.readLine()) != null) {
				text = text.trim().replaceAll(" +", " ");
				data.add(text);

			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (bf != null) {
					bf.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return data;
	}

}
