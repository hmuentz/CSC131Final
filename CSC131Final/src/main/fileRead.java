package main;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class fileRead {

	private ArrayList<String> lines;
	
	public fileRead(String filename) throws FileNotFoundException{
		lines = new ArrayList<>();
		File database = new File(filename);
		Scanner fileReader = new Scanner(database);
		while(fileReader.hasNextLine()) {
			String line = fileReader.nextLine();
			lines.add(line);
		}
		fileReader.close();
	}
	
	public int getNumberOfLines() {
		return lines.size();
	}
	
	public String getLine(int index) {
		return lines.get(index);
	}
}
