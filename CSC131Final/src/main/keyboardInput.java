package main;

import java.util.Scanner;

public class keyboardInput {
	private Scanner keyb;
	
	public keyboardInput() {
		keyb = new Scanner(System.in);
	}
	
	public String getKeyboardLine() {
		return keyb.nextLine();
	}
	
	public void closeKeyboard() {
		keyb.close();
	}
}
