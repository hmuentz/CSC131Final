package main;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class fileWrite {

	private String filename;
	
	public fileWrite(String filename) {
		this.filename = filename;
	}
	
	public void saveFile(Recipes database) throws IOException{
		FileWriter fw = new FileWriter(filename);
		BufferedWriter bw = new BufferedWriter(fw);
		for(int i = 0; i < database.databaseSize(); i++) {
			bw.write(database.getRecipe(i).oneLine() + "\n");
		}
		bw.close();
		fw.close();
	}
}
