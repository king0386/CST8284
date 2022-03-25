
package cst8284.wordsort;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class FileIO {

	private static int numberOfStringsLoaded;
	
	
	public static ArrayList<String> loadArrayListFromFile(File f){
		
		try {
			ArrayList<String> arIn = new ArrayList<>();
			Scanner input = new Scanner(f);
			while (input.hasNext()) {
				arIn.add(input.next());
				numberOfStringsLoaded++;
			}
			return arIn;
		} catch (FileNotFoundException e) {
			System.err.println("File not Found.");
			return null;
		}
		
	
	}
	
	public static boolean fileExists(File f) {
		if(f == null) return false;
		if(!f.exists()) return false;
		if(!f.isFile()) return false;
		if(f.length() == 0) return false;
		return true;
		
	}
	
	public static String toStringFromArrayList(ArrayList<String> arStr) {
		String newArString = "";
		for(String arLStr: arStr) {
			newArString += arLStr + "\n";
		}
		return newArString;
		
	}
	
	public static String toStringFileIO(File f) {
		Date fileDate = new Date(f.lastModified());
		String fileName = "File Name: " + f.getName() + "\n|";
		String fileSize = "File Size: " + f.length() + "\n";
		String modDate = "File Last Modified: " + fileDate + "\n";
		String totalStrings = "Number of Strings Retrieved: " + numberOfStringsLoaded;
		
		return (fileName + fileSize + modDate + totalStrings);
		
	}
}
