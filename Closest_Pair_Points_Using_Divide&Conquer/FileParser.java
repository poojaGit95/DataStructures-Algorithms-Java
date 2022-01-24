import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * 
 * Class to read file.
 * Functionality is to read data from file, store it into array.
 * Returns array of data.
 * 
 * @author pooja nadagouda
 *
 */
public class FileParser {
	
	/*
	 * Reads data from text file.
	 * pre: allocates memory to array to store data from file.
	 * post: Returns array data.
	 */
	public String[] readDataFromFile(String path) {
		File file = new File(path);
		BufferedReader bf = null;
		String[] data = null;
		try {
			bf = new BufferedReader(new FileReader(file));
			String text = bf.readLine();
			if (text != null) {
				text = text.trim().replaceAll(" +", " ");
				int size = Integer.valueOf(text);
				data = new String[size + 1];
				data[0] = text;
			}
			int i =1;
			while ((text=bf.readLine()) != null) {
				text = text.trim().replaceAll(" +", " ");
				data[i] = text;
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
