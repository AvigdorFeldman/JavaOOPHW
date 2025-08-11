package tasks;

import java.util.HashMap;
import java.util.Map;

public class NamedTasks extends Tasks {
	// This class inherits from class Tasks, these tasks are strings
	private String[] names; // Array of the tasks
	private Map<String, Integer> nameToIndex; // A HashMap to change from string tasks to numerical tasks

	public NamedTasks(String[] names) {
		// Constructor for the NamedTasks class
		super(names.length); // Calls the constructor of tasks with name.length as the amount of tasks
		this.names = names;
		nameToIndex = new HashMap<>(); // Creates a HashMap
		// Create a mapping from task names to indices, we assume that the names of the
		// tasks has connection to their indices in names array
		for (int i = 0; i < names.length; i++) {
			nameToIndex.put(names[i], i);
		}
	}

	public boolean dependsOn(String task1, String task2) {
		// The method uses methods from the HashMap and checks if task1 and task2 have
		// numerical values
		if (nameToIndex.get(task1) == null || nameToIndex.get(task2) == null)
			// if it failed it returns false
			return false;
		// Otherwise, it will call on dependsOn from the dependsOn from the inherited
		// class with the tasks numerical values. If the their numerical values are okay
		// they will be added to the dependancies matrix
		return super.dependsOn(nameToIndex.get(task1), nameToIndex.get(task2));
	}

	public String[] nameOrder() {
		// The method performs topologically sorted order of the tasks and returns them
		// in an array of strings
		int[] order = super.order(); // Creates a topologically sorted order array of the numerical dependancies
										// matrix by calling order from the inherited class
		if (order == null)
			// Checks if the array is null, and if so will return null
			return null;
		String[] retNameOrder = new String[order.length]; // Initializes the returned array of strings
		for (int i = 0; i < order.length; i++) {
			// Using the topologically sorted order array will put the strings in a
			// topologically sorted string array
			retNameOrder[i] = names[order[i]];
		}
		// Returns the topologically sorted string array
		return retNameOrder;
	}
}
