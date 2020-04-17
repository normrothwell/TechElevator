package com.techelevator;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Lecture {

   public static void main(String[] args) throws IOException {		
      //java.io.File class gives us access to File information and directory path info.
	  // we can use methods to inspect and modify file system objects.
	   
	   Scanner input = new Scanner (System.in);
	   
	   System.out.println("Enter the path of a file or directory: ");
	   String path = input.nextLine();
	   // use the path from user input to create a new File object
	   
	   File file = new File(path);
	   
	   // Some methods we can use
	   /* *************  FYI ***********************
	    *     The File class does not need try/catch or throws logic
	    *     It only gives external information about the file
	    *     It is only when I try to read or write (establishing a stream)
	    *     that I need to handle any exceptions
	    */
	   if (file.exists()) {
		   System.out.println("File information: ");
		   System.out.println("\tName: " + file.getName());
		   System.out.println("\tAbsolute path: " + file.getAbsolutePath());
		   System.out.println("\tSize: " + file.length());
		   
		   if (file.isDirectory()) {
			   System.out.println("\ttype: directory");
		   } 
		   if (file.isFile()){
			   System.out.println("\ttype: file");
			   
		   }
	   } else { // does not automatically let us know if the file does not exist
		   System.out.println("File does not exist");
	   }
	   
	// we can also create a new directory
	   // ***** Moved so we can create directory before creating second file
	   System.out.println();
	   System.out.println("Enter the name of a directory: ");
	   String pathName = input.nextLine();
	   
	   File newDirectory = new File(pathName);
	   
	   if (newDirectory.exists()) {  // let's just make sure directory doesn't already exist
		   System.out.println("Sorry, directory already exists");
		   System.exit(0);
	   } else {  // make a new directory
		   if (newDirectory.mkdir()) {  //mkdir returns true or false
			   System.out.println("New directory created at " + 
					   newDirectory.getAbsolutePath());
		   } else {
			   System.out.println("Could not create the directory");
			   System.exit(0);
		   }
	   }
	   
	   System.out.println();
	   System.out.println("Let's create a new file");
	   System.out.println("Enter a name for a file: ");
	   String fileName = input.nextLine();
	   File newFile = new File (newDirectory, fileName); // pass in the directory name as first value
	   
	   newFile.createNewFile();  // this has an IOException that may be thrown
	   // so we had to either add throws 
	   
	   System.out.println("File information: ");
	   System.out.println("\tName: " + newFile.getName());
	   System.out.println("\tAbsolute path: " + newFile.getAbsolutePath());
	   System.out.println("\tSize: " + newFile.length());
	   
	   /*
	    *  ****************  Let's FINALLY write some stuff to a file!
	    */
	   System.out.println();
	   System.out.println("Writing to a file");
	   System.out.println("Enter some text to be written to the file: ");
	   String message = input.nextLine();
	   
	   PrintWriter writer = new PrintWriter(newFile); // this throws an IOException as well
	   //    Another checked exception
	   writer.println(message);
	   writer.close();
	   
	   System.out.println("File information: ");
	   System.out.println("\tName: " + newFile.getName());
	   System.out.println("\tAbsolute path: " + newFile.getAbsolutePath());
	   System.out.println("\tSize: " + newFile.length());
	   
   }
}









