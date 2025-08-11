package tree;

public class Node {
	// The class creates a tree of nodes, each node has 26 pointers to the next
	// letter of string
	private int count; // Holds how many times a string appears in the tree;
	private Node[] children = new Node['z' - 'a' + 1]; // The size is 26

	public int num(String s) {
		// This recursive method gets a string and returns the amount of times such a
		// string appears in the tree
		if (s == "")
			// if the string is empty return a letters count
			return count;
		// Will keep the index of the first char of the string in indexOfFirstChar
		int indexOfFirstChar = s.charAt(0) - 'a';
		// If the node in that index is null it means there isn't a letter in the string
		// in the placement indexOfFirstChar will return 0
		if (children[indexOfFirstChar] == null)
			return 0;
		// Otherwise it will call recursively to method num in to the next node with s
		// without the first letter
		return children[indexOfFirstChar].num(s.substring(1));
	}

	public void add(String s) {
		// This recursive method adds a string to the Node tree and updates the count
		// field
		if (s == "")
			// Ends the current recursion, we either reached the end of the string or the
			// string was an empty one
			return;
		// Will keep the index of the first char of the string in indexOfFirstChar
		int indexOfFirstChar = s.charAt(0) - 'a';
		if (children[indexOfFirstChar] == null)
			// If the node in that index is null it means there isn't a letter in the string
			// in the placement indexOfFirstChar, so it will create a new node
			children[indexOfFirstChar] = new Node();
		// Otherwise it will call the method add recursively to the next node with the
		// same string s without the first letter
		children[indexOfFirstChar].add(s.substring(1));
		if (s.length() == 1)
			// If the length of the string is 1 it will increase the count on the letter by
			// one
			children[indexOfFirstChar].count += 1;
		
	}
}
