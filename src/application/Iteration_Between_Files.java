package application;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Product;

public class Iteration_Between_Files {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		
		List<Product> list = new ArrayList<>();
		
		System.out.print("Enter file path: ");
		String sourceFileStr = sc.nextLine();
		
		File sourceFile = new File(sourceFileStr); // read file path
		String sourceFolderStr = sourceFile.getParent(); // save folder path
		
		boolean success = new File(sourceFolderStr + "\\out").mkdir();
		
		String targetFileStr = sourceFolderStr + "\\out\\summary.csv";  // destination path 
		
		
		try (BufferedReader br = new BufferedReader(new FileReader(sourceFile))) {     // read source file
			
			String itemCsv = br.readLine();
			
			while (itemCsv != null) {   // while as there is content on the line
				
				String[] fields = itemCsv.split(",");
				
				String name = fields[0];
				double price = Double.parseDouble(fields[1]);
				int quantity = Integer.parseInt(fields[2]);
				
				list.add(new Product(name, price, quantity));
				
				itemCsv = br.readLine();
				
			}
			try(BufferedWriter bw = new BufferedWriter(new FileWriter(targetFileStr))){  //create file
				
				for (Product item : list) {
					bw.write(item.getName() + "," + String.format("%.2f", item.total()));
					bw.newLine();
				}
				System.out.println(targetFileStr + "CREATED!");
				
			}
			catch(IOException e) {
				System.out.println("Error writing file: " + e.getMessage());
			}
			
		}
		
		catch(IOException e) {
			System.out.println("Error reading file: " + e.getMessage());
		}
		
		
		
		
		
		sc.close();
		
		
		
		
		
	}

}
