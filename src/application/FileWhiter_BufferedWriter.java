package application;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class FileWhiter_BufferedWriter {
	
	public static void main(String[] args) {
		
		String [] lines = new String[] {"Good morning", "Good afternoon", "Good night"};
		
		String path = "c:\\temp\\out.txt";
		
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(path, true))){   // create the file - with true = add at the end - without true = recreates and replaces the previous one    
			                                            
			for (String line : lines) { // for each "string" contained in the "lines" vector
				bw.write(line);  // write to file
				bw.newLine();  // line break
			}	
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
}
