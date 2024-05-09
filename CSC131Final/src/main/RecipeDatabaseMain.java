package main;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
public class RecipeDatabaseMain {

	public static void main(String[] args) throws FileNotFoundException{
		keyboardInput keyb = new keyboardInput();
		boolean quit = false;
		Recipes recipes = new Recipes("recipeDatabase.txt");
		fileWrite fw = new fileWrite("recipeDatabase.txt");
		while(!quit) {
			switch(mainPage(keyb)) {
			case 0: tableOfContents(recipes);
					break;
					
			case 1: accessEntry(keyb, recipes);
					break;
			
			case 2: newEntry(keyb, recipes);
					break;
					
			case 3: editEntry(keyb, recipes);
					break;
					
			case 4: deleteEntry(keyb, recipes);
					break;
			
			case 5: quit = true;
					pL("Goodbye!\nSaving changes!");
					try {
						fw.saveFile(recipes);
					} catch (IOException e) {
						e.printStackTrace();
					}
					break;
			}
		}
		keyb.closeKeyboard();
	}

	public static int mainPage(keyboardInput keyb) {
		pL("");
		pL("What would you like to do?");
		pL("0) Access Table of Contents");
		pL("1) Access recipe from database");
		pL("2) Enter new recipe");
		pL("3) Edit an existing recipe");
		pL("4) Delete recipe");
		pL("5) Exit");
		return Integer.parseInt(promptUser("Enter Number: ", keyb));
	}
	
	public static String promptUser(String entryType, keyboardInput keyb) {
		p(entryType);
		return keyb.getKeyboardLine();
	}
	
	public static void tableOfContents(Recipes recipes) {
		pL("\nTable of Contents");
		for(int i = 0; i < recipes.databaseSize(); i++) {
			p((i + 1) + ": ");
			pL(recipes.getRecipeName(i));
		}
	}
	
	public static void newEntry(keyboardInput keyb, Recipes recipes) {
		String name = promptUser("Enter new recipe name: ", keyb);
		ArrayList<Ingredient> ingredients = new ArrayList<>();
		int numOfIngredients = Integer.parseInt(promptUser("How many ingredients are there? ", keyb));
		for(int i = 0; i < numOfIngredients; i++) {
			String ingredientName = promptUser("Ingredient " + (i + 1) + " name: ", keyb);
			String units = promptUser("Unit of meaurements: ", keyb);
			String quantity = promptUser("Amount: ", keyb);
			ingredients.add(new Ingredient(ingredientName, quantity, units));
		}
		recipes.addRecipe(name, ingredients);
	}
	
	public static void accessEntry(keyboardInput keyb, Recipes recipes) {
		int recipeNumber = Integer.parseInt(promptUser("Enter recipe number to access: ", keyb));
		double batches = Double.parseDouble(promptUser("How many batches would you like to make? ", keyb));
		pL("\n" + recipes.displayRecipe(recipeNumber - 1, batches));
	}
	
	public static void editEntry(keyboardInput keyb, Recipes recipes) {
		int recipeNumber = Integer.parseInt(promptUser("Enter recipe number to edit: ", keyb)) - 1;
		boolean answered = false;
		boolean willEdit = false;
		while(!answered) {
			String answer = promptUser("Would you like to edit the name of the recipe? (Y or N) ", keyb);
			if(answer.equalsIgnoreCase("Y")) {
				answered = true;
				willEdit = true;
			}
			else if(answer.equalsIgnoreCase("N"))
				answered = true;
		}
		if(willEdit)
			editEntryName(keyb, recipes, recipeNumber);
		answered = false;
		willEdit = false;
		while(!answered) {
			String answer = promptUser("Would you like to edit the ingredients of the recipe? (Y or N) ", keyb);
			if(answer.equalsIgnoreCase("Y")) {
				answered = true;
				willEdit = true;
			}
			else if(answer.equalsIgnoreCase("N"))
				answered = true;
		}
		if(willEdit)
			editEntryIngredients(keyb, recipes, recipeNumber);
	}
	
	public static void editEntryName(keyboardInput keyb, Recipes recipes, int recipeNumber) {
		String recipeName = promptUser("What is the new name? ", keyb);
		recipes.getRecipe(recipeNumber).editName(recipeName);
	}
	
	public static void editEntryIngredients(keyboardInput keyb, Recipes recipes, int recipeNumber) {
		ArrayList<Ingredient> ingredients = new ArrayList<>();
		int numOfIngredients = Integer.parseInt(promptUser("How many ingredients are there now? ", keyb));
		for(int i = 0; i < numOfIngredients; i++) {
			String ingredientName = promptUser("Ingredient " + (i + 1) + " name: ", keyb);
			String units = promptUser("Unit of meaurements: ", keyb);
			String quantity = promptUser("Amount: ", keyb);
			ingredients.add(new Ingredient(ingredientName, quantity, units));
		}
		recipes.getRecipe(recipeNumber).editIngredients(ingredients);
	}
	public static void deleteEntry(keyboardInput keyb, Recipes recipes) {
		String recipeNumber = promptUser("What entry would you like to delete? ", keyb);
		recipes.deleteRecipe(recipeNumber);
	}
	
	public static void pL(String text) {
		System.out.println(text);
	}
	
	public static void p(String text) {
		System.out.print(text);
	}
}
