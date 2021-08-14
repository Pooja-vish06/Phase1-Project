package com.lockedMe;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class FilesLocker {

	public static void main(String[] args) {

		// Variable declaration
		int option = 1;

		// loop till user exits the system
		do {
			welcomePage();
			int choice = displayMenu();
			switch (choice) {
			case 1:
				getFiles();
				break;
			case 2:
				addNewFile();
				break;
			case 3:
				deleteFile();
				break;
			case 4:
				searchFile();
				break;
			case 5:
				option = 0;
				System.out.println("Thank you for using our services.");
				System.out.println("Developed by - Pooja Vishwakarma.");
				System.exit(0);
				break;
			default:
				System.out.println("Invalid input. Please enter valid option. ");
			}

		} while (option > 0);

	}

	// =====WELCOME PAGE=====
	public static void welcomePage() {
		System.out.println("=================================================");
		System.out.println("$\t\tLOCKER PVT LTD.\t\t\t$");
		System.out.println("\tDeveloped by - Pooja Vishwakarma");
		System.out.println("=================================================");

	}

	// ======DISPLAY MENU======
	public static int displayMenu() {

		//
		Scanner sc = new Scanner(System.in);

		System.out.println("\t1. Display all Files.");
		System.out.println("\t2. Add a new File.");
		System.out.println("\t3. Delete a File.");
		System.out.println("\t4. Search a File.");
		System.out.println("\t5. Exit.");
		System.out.println("=================================================");
		System.out.println("Enter your choice : ");

		// take choice from user.

		try {
			int choice = Integer.parseInt(sc.nextLine());
			return choice;
		} catch (NumberFormatException e) {
			System.out.println("You've entered non-integer number. Please enter valid option from below.");
			System.out.println("=================================================");
			return displayMenu();
		}

	}

	// ======GET ALL FILES======
	public static void getFiles() {
		int count = 0;
		List<String> files = FileSystem.retrieveAllFiles();
		count = files.size();
		System.out.println("Total " + count + " files are present.");
		System.out.println("Files are : ");
		Collections.sort(files);
		for (String s : files) {
			System.out.println(s);
		}
	}

	// ======Add A FILE======
	public static void addNewFile() {
		Scanner sc = new Scanner(System.in);
		List<String> fileContent = new ArrayList<String>();

		// User will input the file name
		System.out.println("Enter your file name :");
		String fileName = sc.nextLine();

		// User will enter number of lines here
		System.out.println("Enter number of lines you want to add :");
		int linesCount = Integer.parseInt(sc.nextLine());

		// Loop through number of lines
		for (int i = 1; i <= linesCount; i++) {
			System.out.println("Enter line " + i + ":");
			String lines = sc.nextLine();
			fileContent.add(lines);
		}

		boolean fileAdded = FileSystem.addFile(fileName, fileContent);
		if (fileAdded)
			System.out.println("File saved successfully.");
		else {
			System.out.println("File could not be saved. Try again later.");
			System.out.println("if probelm persists, contact admin admin@lockerme.com.");
		}

	}

	// ======DELETE A FILE======
	public static void deleteFile() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the file name to be deleted :");
		String fileName = sc.nextLine();
		boolean isDeleted = FileSystem.deleteFile(fileName);
		if (isDeleted) {
			System.out.println(fileName + " deleted successfully.");
		} else {
			System.out.println(fileName + " couldn't be deleted. Try again later.");
			System.out.println("if probelm persists, contact admin admin@lockerme.com.");
		}

	}

	// ======SEARCH A FILE======
	public static void searchFile() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter file name to be searched");
		String fileName = sc.nextLine();
		boolean isFound = FileSystem.searchFile(fileName);
		if (isFound)
			System.out.println(fileName + " is present in the locker.");
		else
			System.out.println(fileName + " is not present in the locker.");

	}

}
