package application;

import java.io.File;
import java.util.Scanner;

public class Handling_Folders {

	public static void main(String[] args) {

		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter a folder path: ");
		String strPath = sc.nextLine();
		
		File path = new File(strPath);
		
		
		File [] folders = path.listFiles(File::isDirectory);   // creates a list with the paths of the FOLDERS 
		System.out.println("FOLDERS:");
		for (File folder : folders) {    // print list
			System.out.println(folder);   
		}
		System.out.println("");
		
		File [] files = path.listFiles(File::isFile);
		System.out.println("FILES:");
		for (File file : files ) {
			System.out.println(file);
		}
		
		System.out.println("");
		boolean success = new File(strPath + "\\subdir").mkdir();  // create subfolder
		System.out.println("Directory created sucessfully: " + success);
		
		
		
		
		
		
		sc.close();
		
	}

}
