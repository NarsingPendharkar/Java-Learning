package com.javatutorials.filehandling;

import java.io.File;
import java.io.IOException;

public class CreateFile {
	
	public static void main(String[] args) throws IOException , IllegalAccessException {
		
		try {
			String Filepath="D:\\Test\\";
			String filename="narsing.txt";
			File file = new File(Filepath+filename);
			if(file.exists()) {
				System.out.println("File exists: " + file.getName()+"\n"+file.getAbsolutePath());
				throw new FileExistsException("Files with the same name exist please rename the File");
			}
			
			else if(file.createNewFile()) {
				System.out.println("File created: " + file.getName()+"\n"+file.getAbsolutePath());
			}
			
		}catch (FileExistsException e) {
			System.out.println(e.getMessage());
		}
		
		
	}
	

}
