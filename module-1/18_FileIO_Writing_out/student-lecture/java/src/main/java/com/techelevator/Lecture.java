package com.techelevator;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Lecture {
	public static void main(String args[]) throws IOException {
		
		Scanner input = new Scanner (System.in);
		System.out.println("Enter the path of a file or directory: ");
		String path = input.nextLine();
		
		File file = new File(path);
		
		if (file.exists()) {
			System.out.println("File information: ");
			System.out.println("\tName: " + file.getName());
			System.out.println("\tAbsolute path: " + file.getAbsolutePath());
			System.out.println("\tSize: " + file.length());
		
		
			if (file.isDirectory()) {
			System.out.println("\ttype: direcotry");
			}else System.out.println("\ttype: file");
		
		}else System.out.println("File not found");
		
		
		System.out.println("\nEnter the name for a new directory: ");
		String pathName = input.nextLine();
		
		File newDirectory = new File(pathName);
		if (newDirectory.exists()) {
			System.out.println("Already exists");
//			System.exit(0);
		}else {
			if (newDirectory.mkdir()) {
				System.out.println("New directory created at " + newDirectory.getAbsolutePath());
			}else System.out.println("Could not create direcotry");
			
		}
		
		System.out.println("Enter a name for a new file: ");
		String fileName = input.nextLine();
		File newFile = new File (newDirectory, fileName);
		
		newFile.createNewFile();
		
		System.out.println("File information: ");
		System.out.println("\tName: " + newFile.getName());
		System.out.println("\tAbsolute path: " + newFile.getAbsolutePath());
		System.out.println("\tSize: " + newFile.length());
		
		
		System.out.println("\nEnter text to be written to a file: ");
		String message = input.nextLine();
		PrintWriter writer = new PrintWriter(newFile);
		writer.println(message);
		writer.close();
		
		System.out.println("File information: ");
		System.out.println("\tName: " + newFile.getName());
		System.out.println("\tAbsolute path: " + newFile.getAbsolutePath());
		System.out.println("\tSize: " + newFile.length());
		
	}
}