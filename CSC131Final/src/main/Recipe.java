package main;

import java.util.ArrayList;

public class Recipe {
	private String name;
	private ArrayList<Ingredient> ingredients;
	
	public Recipe(String name, ArrayList<Ingredient> ingredients) {
		this.name = name;
		this.ingredients = ingredients;
	}
	
	public String displayRecipe(double batches) {
		String ret = "";
		for(int i = 0; i < ingredients.size(); i++) {
			ret += ingredients.get(i).toString(batches) + ", ";
		}
		ret = ret.substring(0, ret.length() - 2);
		return name + ": Ingredients: " + ret;
	}
	
	public String getName() {
		return name;
	}
	
	public void editName(String entryName) {
		name = entryName;
	}
	public String oneLine() {
		String ingredientsOneLine = "";
		for(int i = 0; i < ingredients.size(); i++)
			ingredientsOneLine += ingredients.get(i).oneLine();
		return name + "*" + ingredientsOneLine;
	}
	
	public void editIngredients(ArrayList<Ingredient> ingredients) {
		this.ingredients = ingredients;
	}
}
