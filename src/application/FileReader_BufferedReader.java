package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileReader_BufferedReader {
	
	public static void main(String[] args) {
		
		// manual process - not optimized
				
		String path = "c:\\temp\\in.txt";
		FileReader fr = null;
		BufferedReader br = null;
		
		try {
			fr = new FileReader(path);
			br = new BufferedReader(fr); // make reading faster with the buffer
			
			String line = br.readLine();   // read to the end of the line
			
			while (line != null) {  
				System.out.println(line);
				line = br.readLine();
			}
		}	
		catch(IOException e) {
			System.out.println("Error: " + e.getMessage());
		}
		
		finally {
			try {
				if (br != null) {
					br.close();
				}
				if (fr != null) {
					fr.close();
				}
			}
			catch(IOException e){
				e.printStackTrace();
			}
		}
	}
}