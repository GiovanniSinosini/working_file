package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class try_with_resources {
	
	public static void main(String[] args) {
		
		// optimized process 
				
		String path = "c:\\temp\\in.txt";

		try (BufferedReader br = new BufferedReader(new FileReader(path))){
			String line = br.readLine();   // read to the end of the line
			
			while (line != null) {  
				System.out.println(line);
				line = br.readLine();
			}
		}	
		catch(IOException e) {
			System.out.println("Error: " + e.getMessage());
		}
		
	}
}