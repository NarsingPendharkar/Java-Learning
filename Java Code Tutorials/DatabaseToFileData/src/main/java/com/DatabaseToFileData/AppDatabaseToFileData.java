package com.DatabaseToFileData;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.sql.*;

public class AppDatabaseToFileData

{

	public static void main(String[] args) {
		System.out.println("Hello World!");
		GenerateTextFile textfile=new GenerateTextFile();
		textfile.generateTextFile();
		GeneratePdfFile pdffile=new GeneratePdfFile();
		pdffile.generatePdf();
		

	}

	
	}


