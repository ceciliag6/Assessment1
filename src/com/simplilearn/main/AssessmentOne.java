package com.simplilearn.main;

import java.io.File;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class AssessmentOne {
	
	public static void main(String[] args) throws IOException, IllegalMainMenuOption {
		Welcome welcome = new Welcome();
		Scanner sc = new Scanner(System.in);
		int i = 0;
		String[] names;
		
		System.out.println(welcome.LABELAPPLICATIONNAME.concat(welcome.applicationName));
		System.out.println(welcome.LABELDEVELOPERNAME.concat(welcome.developerName));
		System.out.println(welcome.welcomeApplication);
		
		File f = new File("ceciliaTest");
		if(!f.exists()) {
			f.mkdir();
		}
		do {
			System.out.println("");
			System.out.println("");
			System.out.println("----------------------------------------");
			System.out.println("Main Menu");
			System.out.println("----------------------------------------");
			System.out.println("1.- List the folders inside the directory");
			System.out.println("2.- Add/ delete/ search a file inside the directory");
			System.out.println("3.- Close the application");
			
			try {
				i = sc.nextInt();
				if (i<=0 || i>=4) {
					IllegalMainMenuOption mo = new IllegalMainMenuOption();
					throw mo;	
				}
			}
			catch(InputMismatchException AE) {
				System.out.println("Invalid Menu Option. Please try again. Int value is required");
				sc.next();
				i=4;
			}			
			catch(IllegalMainMenuOption o) {
				o.print();
				i=4;
			}
			
			switch (i) {
			case 1:
				names = f.list();
				for (String name:names) {
					System.out.println(name);
				}
				break;
			case 2:
				String ch;
				do {
					System.out.println("----------------------------------------");
					System.out.println("Additional Menu");
					System.out.println("----------------------------------------");
					System.out.println("a.- Add a new file into the directory");
					System.out.println("b.- Delete an existing file into the directory");
					System.out.println("c.- Search an existing file into the directory");
					System.out.println("d.- Return to the main menu");
					
					ch = sc.next();
					try {
						if (!(ch.compareTo("a") == 0 || ch.compareTo("b") == 0 || ch.compareTo("c") == 0 || ch.compareTo("d") == 0 )){
							IllegalMainMenuOption mo = new IllegalMainMenuOption();
							throw mo;
						}
					}
					catch(IllegalMainMenuOption o){
						o.print();
					}
					
					switch(ch) {
					case "a":
						System.out.println("Enter the name of the new file");
						String fileName = sc.next();
						File addFile = new File("ceciliaTest".concat("\\").concat(fileName));
						addFile.createNewFile();
						break;
					case "b":
						System.out.println("Enter the name of the file to delete");
						Boolean isDeleted = false;
						fileName = sc.next();
						names = f.list();
						for(String name:names) {
							if(name.toLowerCase().equals(fileName.toLowerCase())) {
								File deleteFile = new File("ceciliaTest".concat("\\").concat(fileName));
								deleteFile.delete();
								isDeleted = true;
							}
						}
						if (isDeleted) {
							System.out.println("File deleted");
						} else{
							System.out.println("File Not Found");
						}
						break;
					case "c":
						System.out.println("Enter the name of the file to search");
						fileName = sc.next();
			            names = f.list();	
			            Boolean isFounded = false;
						for(String name:names) {
							if (name.toLowerCase().contains(fileName.toLowerCase())) {
								System.out.println(name);
								isFounded = true;
							}
						}
						if(!isFounded) {
							System.out.println("No files founded with that name");
						}
						break;
					case "d":
						System.out.println("Returning to the main menu");
						break;
					}
					
				}	while(ch.compareTo("d")!=0);
				break;
			case 3:
				System.out.println("Closing the application");
				break;		
			}
			
		}while(i!=3);

		sc.close();
	}
}
