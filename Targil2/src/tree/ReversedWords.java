package tree;

import java.util.Scanner;

public class ReversedWords {
	// The class holds two static methods, its main job is to get input from the
	// console end return the amount of strings the appeared reversed
	private static String reverse(String str) {
		// This static method gets a string and returns a reversed string
		char ch;
		String revStr = ""; // the returned reversed string, initiated to ""
		for (int i = 0; i < str.length(); i++) {
			// reverses the string
			ch = str.charAt(i);
			revStr = ch + revStr;
		}
		return revStr;
	}

	
	public static int checkReversed() {
		// The static method counts how many strings appear reversed in the input, each
		// string will be put in the Node tree using class Node
		int count = 0; // Holds the amount of reversed strings, initiated to 0
		Node root = new Node(); // Creates a new node
		Scanner scan = new Scanner(System.in); // Gets a string from input using Scanner, if the input is X it will stop
		String strScan = scan.next();
		while (!strScan.equals("X")) {
			
			if ((root.num(reverse(strScan)) >= 1) && (!(strScan.equals(reverse(strScan))&& root.num(strScan) == 0))) {
				// Checks if a reversed string has already appeared and if so increases count by
				// 1, it also makes sure that a palindrome string isn't considered in the count
				count++;
			}
			root.add(strScan); // Adds the string to the Node tree
			// Gets the next string
			strScan = scan.next();
		}
		// Closes the scanner and return count to end the method
		scan.close();
		return count;
	}
}
