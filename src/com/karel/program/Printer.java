package com.karel.program;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Printer {
    private String fileName;

    public Printer(String fileName) throws Exception {
        this.fileName = fileName;
        if (!new java.io.File(fileName).exists()) {
            throw new Exception("File not found: " + fileName);
        }
    }

    public void printLinesWhichContain(String word) {
        try (BufferedReader br = new BufferedReader(new FileReader(fileName)) ) {
            String line;
            while ((line = br.readLine()) != null) {
                if (word.isEmpty()) {
                    System.out.println(line);
                } else {
                    if (line.contains(word)) {
                        System.out.println(line);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Printer printer = null;
        try {
            printer = new Printer("src/textfile.txt");
            printer.printLinesWhichContain("Väinämöinen");
            System.out.println("-----");
            printer.printLinesWhichContain("Frank Zappa");
            System.out.println("-----");
            printer.printLinesWhichContain("");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
