package com.lockedMe;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class FilesLocker {

	public static void main(String[] args) {
		
		//Variable declaration
		int option = 1;
		
		//loop till user exits the system
		do {
			int choice = displayMenu();
			switch(choice) {
			case 1 : getFiles();
					break;
			case 2 : addNewFile();
					break;
			case 0 : 
				option = 0;
				System.out.println("Thank you for using our services.");
				System.exit(0);
				break;
			default : 
				System.out.println("Invalid input. ");
			}
			
		}
		while(option > 0);

		

	}
	public static int  displayMenu() {
		System.out.println("1. Display all Files.");
		System.out.println("2. Add a new File.");
		System.out.println("Enter your choice : ");
		Scanner sc = new Scanner(System.in);
		int choice = sc.nextInt();
		if (choice == 0)
			choice = 0;
		return choice;
	}
	// ==========GET ALL FILES===========
	public static void getFiles() {
		int count = 0;
		List<String> files = FileSystem.retrieveAllFiles();
		count = files.size();
		System.out.println("Total " + count + " files are present.");
		Collections.sort(files);
		for (String s : files) {
			System.out.println(s);
		}
	}

	// =========Add A FILE===============
	// This method takes input from user and calls addFile function to create a new
	// file
	public static void addNewFile() {
		Scanner sc = new Scanner(System.in);
		List<String> fileContent = new ArrayList<String>();
		System.out.println("Enter your file name :");
		String fileName = sc.nextLine();
		System.out.println(fileName);
		System.out.println("Enter number of lines you want to add :");
		int linesCount = Integer.parseInt(sc.nextLine());

		for (int i = 1; i <= linesCount; i++) {
			System.out.println("Enter line " + i + ":");
			String lines = sc.nextLine();
			fileContent.add(lines);
		}

		boolean fileAdded = FileSystem.addFile(fileName, fileContent);
		if (fileAdded)
			System.out.println("File saved successfully.");
		else
			System.out.println("File could not be saved. Try again later.");

	}

}
