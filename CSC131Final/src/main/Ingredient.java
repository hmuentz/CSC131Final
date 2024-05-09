package main;

public class Ingredient {
	private String name;
	private double quantity;
	private String unit;
	
	public Ingredient(String name, String quantityString, String unit) {
		this.name = name;
		quantity = Double.parseDouble(quantityString);
		this.unit = unit;
	}
	
	public String toString(double batches) {
		return Double.toString(quantity * batches) + " " + unit + " of " + name;
	}
	
	public String oneLine() {
		return name + "*" + Double.toString(quantity) + "*" + unit + "*";
	}
}
