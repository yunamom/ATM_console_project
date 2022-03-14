package view;

import java.io.*;
import java.nio.file.*;
import java.util.*;

public class FileRead {

	public static void main(String[] args) throws IOException {
		System.out.println("\n\n	1. FileReader");
		// 1. FileReader
		
		
		FileReader reader = new FileReader("test.txt");
	
		int check;
			
		while((check = reader.read()) != -1) {
			System.out.print((char)check);
		}
		
		
		System.out.println("	2. BufferedReader");
		// 2. BufferedReader
		BufferedReader bufferedReader = new BufferedReader(
				new FileReader("test.txt"),
				16*1024
		);
		String str;
		
		while((str = bufferedReader.readLine()) != null){
			System.out.println(str);
		}
		bufferedReader.close();
		
		
		System.out.println("	3. Scanner");
		// 3. Scanner
		Scanner scan = new Scanner(new File("test.txt"));
		
		while(scan.hasNext()) {
			str = scan.next();
			System.out.println(str);
		}
		
		
		System.out.println("	4. Files");
		// 3. Files
		
		List<String> lines = Files.readAllLines(Paths.get("test.txt"));
		
		System.out.println(lines);
		
	}
}
