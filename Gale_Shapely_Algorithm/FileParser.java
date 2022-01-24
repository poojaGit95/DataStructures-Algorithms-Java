import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author Pooja Nadagouda
 * 
 * This class reads the data from text file and stores it in an array.
 */

public class FileParser {
	
	/*
	 * This method reads the data from text file and stores it into an array. The
	 * size of the array is the 1st entry in the file.
	 */
	public String[] readDataFromFile(String filePath) {
		File file = new File(filePath);
		BufferedReader bf = null;
		String[] data = null;
		try {
			bf = new BufferedReader(new FileReader(file));
			String text = bf.readLine();
			if (text != null) {
				int size = Integer.valueOf(text);
				data = new String[1 + (4 * size)];
			}
			int i = 0;
			while ((text) != null) {
				data[i] = text;
				text = bf.readLine();
				i++;
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

