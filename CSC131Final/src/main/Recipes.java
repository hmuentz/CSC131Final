package main;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Recipes {
	private ArrayList<Recipe> recipes;
	
	
	public Recipes(String filename) throws FileNotFoundException {
		recipes = new ArrayList<>();
		fileRead database = new fileRead(filename);
		for(int i = 0; i < database.getNumberOfLines(); i++) {
			String line = database.getLine(i);
			ArrayList<Ingredient> ingredients = new ArrayList<>();
			StringTokenizer st = new StringTokenizer(line, "*");
			String name = st.nextToken();
			while(st.hasMoreTokens()){
				String ingredientName = st.nextToken();
				String quantity = st.nextToken();
				String unit = st.nextToken();
				ingredients.add(new Ingredient(ingredientName, quantity, unit));
			}
			recipes.add(new Recipe(name, ingredients));
		}
	}

	public String displayRecipe(int number, double batches) {
		return recipes.get(number).displayRecipe(batches);
	}
	
	public String getRecipeName(int number) {
		return recipes.get(number).getName();
	}
	public Recipe getRecipe(int number) {
		return recipes.get(number);
	}
	
	public void addRecipe(String name, ArrayList<Ingredient> ingredients) {
		recipes.add(new Recipe(name, ingredients));
	}
	
	public void deleteRecipe(String number) {
		recipes.remove(Integer.parseInt(number) - 1);
	}
	public int databaseSize() {
		return recipes.size();
	}
}
