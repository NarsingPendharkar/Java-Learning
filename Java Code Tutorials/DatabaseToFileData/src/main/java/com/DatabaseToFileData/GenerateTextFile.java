package com.DatabaseToFileData;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class GenerateTextFile {

	public void generateTextFile() {
		String Filepath = "D:\\Test\\dbtext2.txt";
		File file = new File(Filepath);

		try {
			FileWriter writer = new FileWriter(file);
			DatabaseConnection dbconnect = new DatabaseConnection();
			PreparedStatement ps = dbconnect.connection().prepareStatement("SELECT * FROM customer");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				writer.write(rs.getString("id") + " | " + rs.getString("email") + " | " + rs.getString("name") + " | "
						+ rs.getString("address") +"\n" );
			}
			writer.close();
			if (file.exists()) {
				FileReader redFileReader = new FileReader(file);
				BufferedReader bufferedReader = new BufferedReader(redFileReader);
				String line = bufferedReader.readLine();
				System.out.println(line);
				bufferedReader.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}}
