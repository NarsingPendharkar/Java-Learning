package com.DatabaseToFileData;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

public class GenerateTableDataInPdf {

    public static void main(String[] args) {
        GenerateTableDataInPdf pdf = new GenerateTableDataInPdf();
        pdf.generatePdf();
    }

    public void generatePdf() {
        try {
            // Create file and document
            File file = new File("D:\\Test\\customertable.pdf");
            Document doc = new Document();
            FileOutputStream fos = new FileOutputStream(file);
            PdfWriter.getInstance(doc, fos);
            doc.open();
            
            // Title / Heading for the document
            Font titleFont = new Font(Font.FontFamily.HELVETICA, 18, Font.BOLD, BaseColor.GREEN);
            Phrase title = new Phrase("Customer Data Table", titleFont);
            doc.add(title);
            doc.add(new Phrase("\n"));  // Adding an empty line
            
            // Create table with 4 columns
            PdfPTable table = new PdfPTable(4);
            
            // Add headers with colorful background
            addTableHeader(table, "ID", BaseColor.CYAN);
            addTableHeader(table, "Email", BaseColor.CYAN);
            addTableHeader(table, "Name", BaseColor.CYAN);
            addTableHeader(table, "Address", BaseColor.CYAN);
            
            // Fetch data from database and populate the table
            DatabaseConnection dbconnect = new DatabaseConnection();
            PreparedStatement pst = dbconnect.connection().prepareStatement("SELECT * FROM Customer");
            ResultSet rs = pst.executeQuery();
            
            while (rs.next()) {
                // Add data rows with alternating background colors
                addTableRow(table, rs.getString("id"), rs.getString("email"), rs.getString("name"), rs.getString("address"));
            }
            
            // Add table to the document
            doc.add(table);
            
            // Close the document
            doc.close();
            
            System.out.println("PDF Generated Successfully!");
            
        } catch (DocumentException | FileNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Method to add a header to the table with a specified background color
    private void addTableHeader(PdfPTable table, String header, BaseColor bgColor) {
        PdfPCell headerCell = new PdfPCell(new Phrase(header));
        headerCell.setBackgroundColor(bgColor);
        headerCell.setPadding(5);
        headerCell.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        table.addCell(headerCell);
    }

    // Method to add a row of data with alternating row colors for better visualization
    private void addTableRow(PdfPTable table, String id, String email, String name, String address) {
        PdfPCell cell;

        // Add ID cell with normal color
        cell = new PdfPCell(new Phrase(id));
        cell.setPadding(5);
        cell.setBackgroundColor(BaseColor.WHITE);
        table.addCell(cell);

        // Add Email cell with normal color
        cell = new PdfPCell(new Phrase(email));
        cell.setPadding(5);
        cell.setBackgroundColor(BaseColor.WHITE);
        table.addCell(cell);

        // Add Name cell with normal color
        cell = new PdfPCell(new Phrase(name));
        cell.setPadding(5);
        cell.setBackgroundColor(BaseColor.WHITE);
        table.addCell(cell);

        // Add Address cell with normal color
        cell = new PdfPCell(new Phrase(address));
        cell.setPadding(5);
        cell.setBackgroundColor(BaseColor.WHITE);
        table.addCell(cell);
    }
}
