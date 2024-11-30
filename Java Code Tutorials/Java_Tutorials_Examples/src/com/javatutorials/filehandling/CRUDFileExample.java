package com.javatutorials.filehandling;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class CRUDFileExample {
	private static final String filepath="D:\\Test\\";
	private static final String fileName = "CrudExample";
	public static 	Scanner input = new Scanner(System.in);
	public static void main(String[] args) {
		
		
		
		while(true) {
			try {
                mainMenu();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
		}
	
		
	}

	private static void mainMenu() {
		System.out.println("Choose an option:");
		System.out.println("1. Create File");
		System.out.println("2. Read File");
		System.out.println("3. Update File");
		System.out.println("4. Rename File");
		System.out.println("5. Delete File");
		System.out.println("6. List Files");
		System.out.print("Enter your choice: "); // Read user's choice from console'
		
		
		
		int choice = input.nextInt();
		switch (choice) {
		case 1:
			
			createFile();
			break;
		case 2:
			readFile();
			break;
		case 3:
			writeDataInFile();
			
			break;
		case 4:
			readFile();
			System.out.println("File renamed successfully.");
			break;
		case 5:
			deleteFile();
			break;
		case 6 :
				listFiles();
				break;
		default:
			System.err.println("Invalid choice. Please try again.");
			break;
		}
		
	}

	private static void listFiles() {
		File file=new File("D:\\Test\\");
		
		if(file.isDirectory()) {
			File[] files = file.listFiles();
			for(File f : files) {
				System.out.println(f.getName());
			}
		}else{
			System.out.println("Invalid file path. Please try again.");
		}
			
	}

	private static void deleteFile() {
		
		System.out.print("Enter the name of the file to delete: ");
		String fileName = filepath+input.next();
		File file=new File(fileName);
        if(file.exists()) {
        	if(file.delete()) {
        		System.out.println("File deleted successfully.");	
        	}
        }else{
        	System.err.println("File does not exist. Please try again.");
            return;
        }
	}

	private static void writeDataInFile() {
		try {
			System.out.print("Enter the name of the file: "); 
            String fileName = filepath+input.next();
            File file = new File(fileName);
            if(file.exists()) {
            	FileWriter writer = new FileWriter(file);
            	System.out.println("Enter data to write in file:");
            	String data = input.nextLine();
            	writer.write(data);
            	writer.close();
            	System.out.println("File updated successfully.");
            }else {
            	System.err.println("File not found !");
            	return;
            }
          
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void readFile() {
		try {
			System.out.print("Enter the name of the file: ");
			String fileName = filepath+input.next();
			File file = new File(fileName+".txt");
			if(file.exists()) {
				FileReader reader = new FileReader(file);
				BufferedReader bufferedReader=new BufferedReader(reader);
				String line=bufferedReader.readLine();
				while(line!=null) {
                    System.out.println(line);
                    line=bufferedReader.readLine();
                    
                }
				
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// create file
	public static void createFile() {
		try {
			System.out.print("Enter the name of the file: "); 
			String fileName = filepath+input.next();
			File file = new File(fileName+"txt");
			if(!file.exists()) {
				file.createNewFile();
				System.out.println("File created :"+file.getName());
				System.out.println("file created at path :"+file.getAbsolutePath());
			}
			else {
				System.err.println("File already exists.");
                return;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	}
	// write data into file
	// rename file
	// append data to file
	//
}
