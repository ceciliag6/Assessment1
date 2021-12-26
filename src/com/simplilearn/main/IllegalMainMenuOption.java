package com.simplilearn.main;

public class IllegalMainMenuOption extends Exception{

	IllegalMainMenuOption(){	
	}
	
	IllegalMainMenuOption(String message){
		System.out.println(message);
	}
	
	void print() {
		System.out.println("Invalid Menu Option. Please try again");
	}
}
