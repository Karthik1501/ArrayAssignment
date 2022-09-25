package task;

import java.io.*;
import java.util.Scanner;

public class Task {
		public static void main(String[] args) {
			
			 
			File myFile = new File("/home/user1/eclipse-workspace/task/src/task/Task.java");
			try {
					  
				Scanner reader = new Scanner(myFile);
				String str="";
				int lineCount = 0;
				while(reader.hasNextLine()){
					lineCount++;
					str+=reader.nextLine()+"\n";
					
				}
				 
				try {
					// Writing file path
					File file = new File("/home/user1/Desktop/newFile.txt");
					FileWriter writer = new FileWriter(file.getAbsolutePath());
					writer.write(str);
					writer.write("Number of line's : "+lineCount);
					writer.write("\nNumber of Character's : "+ str.length());
					writer.close();
					
					System.out.println("\n"+str);
					System.out.println("Number of line's : "+lineCount);
					System.out.println("Number of Character's : "+ str.length());
					System.out.println("Writing file path name : "+ file.getAbsolutePath());
					
				} catch (IOException e) {
					System.out.println("Writer exception ");
					e.printStackTrace();
				}
				
				
			} catch (FileNotFoundException e) {
				System.out.println("Read File doesn't exist");
				e.printStackTrace();
			}
			
			
		}

}
