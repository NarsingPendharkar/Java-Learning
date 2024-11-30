package com.javacorepack;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class TryCatchExample10 {

    public static void main(String[] args) {
        PrintWriter writer = new PrintWriter(System.out);

        // Printing with print() (no new line)
        writer.print("Hello, ");
        writer.print("World!");

        // Printing with println() (appends a new line)
        writer.println(" Welcome to Java.");

        // Printing formatted output
        writer.printf("The current year is: %d%n", 2024);

        writer.flush(); // Explicit flush (optional here, as println already flushes)
        writer.close();

    }
}
