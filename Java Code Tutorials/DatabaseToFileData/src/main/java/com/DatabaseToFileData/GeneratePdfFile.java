package com.DatabaseToFileData;

import java.io.FileOutputStream;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

public class GeneratePdfFile {
	private static final String filepath = "D:\\Test\\";
	private static final String fileName = "CrudExample";
	public static String paragraph1;

	public void generatePdf() {

		try {
			String pdfFilePath = "D:\\Test\\customers.pdf";
			// create document object
			Document document = new Document();
			FileOutputStream fos = new FileOutputStream(pdfFilePath);
			PdfWriter.getInstance(document, fos);
			document.open();
			DatabaseConnection dbconnect = new DatabaseConnection();
			PreparedStatement ps = dbconnect.connection().prepareStatement("SELECT * FROM customer");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				paragraph1 = (rs.getString("id") + " | " + rs.getString("email") + " | " + rs.getString("name") + " | "
						+ rs.getString("address") + "\n");
				Paragraph paragraph = new Paragraph(paragraph1);

				document.add(paragraph);
			}

			document.close();
			System.out.println("PDF created successfully.");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
