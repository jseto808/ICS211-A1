package edu.ics211.h01;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Reader {
	public int numWords (String fileName) { //Reader method
		try (Scanner scanner = new Scanner(new File(fileName))) { //Try/Catch exception for File Not Found error
			int count = 0;
			while (scanner.hasNext()) { //Loop for scanner to count words
				scanner.next();
				count++;
			}
			return count;
		} catch (FileNotFoundException e) { //File Not Found Exception
			return -1;
		}
	}


	public static void main(String[] args) { //Unit Test
		Reader readerInstance = new Reader();
		for (String fileName : args) {
			int numWords = readerInstance.numWords(fileName);
			if (numWords == -1) {
				System.out.println(fileName + " Not Found");
			} else {
				System.out.println(fileName + " " + numWords);
			}
		}
		
	}
}

