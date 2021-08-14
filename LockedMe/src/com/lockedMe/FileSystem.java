package com.lockedMe;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

public class FileSystem {

	// variable declaration
	public static final String FOLDERPATH = "/home/pooja/Documents/Simplilern/Phase1-Project/Files";

	/**
	 * This method provides the name of all files present in the defined folder.
	 * 
	 * @return List of files
	 * @String
	 */
	public static List<String> retrieveAllFiles() {

		File file = new File(FOLDERPATH);

		File[] fileNames = file.listFiles();

		List<String> allFiles = new ArrayList<String>();

		for (File f : fileNames)
			allFiles.add(f.getName());

		return allFiles;

	}

	/**
	 * This method creates a new file and adds the content provided by the user,
	 * returns true if file is added.
	 * 
	 * @param fileName
	 * @param fileContent
	 * @return boolean
	 */
	public static boolean addFile(String fileName, List<String> fileContent) {

		File file = new File(FOLDERPATH + "/" + fileName);

		try {
			FileWriter fw = new FileWriter(file);
			for (String content : fileContent)
				fw.write(content + "\n");

			fw.close();
			return true;
		} catch (Exception ex) {

			return false;
		}

	}

	/**
	 * This method deletes the file specified by user, returns true if deleted.
	 * 
	 * @param fileName
	 * @return boolean
	 */
	public static boolean deleteFile(String fileName) {

		File file = new File(FOLDERPATH + "/" + fileName);
		if (file.delete())
			return true;
		else
			return false;

	}

	/**
	 * This method searches the user specified file in the locker folder, returns
	 * true if found.
	 * 
	 * @param fileName
	 * @return boolean
	 */
	public static boolean searchFile(String fileName) {

		File file = new File(FOLDERPATH + '/' + fileName);
		if (file.exists())
			return true;
		else
			return false;

	}

}
