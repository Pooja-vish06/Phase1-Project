package com.lockedMe;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

public class FileSystem {

	public static final String FOLDERPATH = "/home/pooja/Documents/Simplilern/Phase1-Project/Files";

	/**
	 * This method provides the name of all files present in the defined folder.
	 * 
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
	 * This method creates a new file and adds the content provided by the user
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

}
