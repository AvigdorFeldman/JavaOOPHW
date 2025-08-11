package tasks;

public class Tasks {
	// The class manages tasks with dependencies, tasks are numerical
	private int num; // This variable represents the number of tasks (size of the matrix)
	private int[][] tasks; // Adjacency matrix to represent dependencies
	private boolean[] visited;
	private boolean[] inStack;
	private int index;

	public Tasks(int num) {
		// Constructor for Tasks class
		this.num = num;
		tasks = new int[num][num]; // Creates a matrix of the tasks
		visited = new boolean[num]; // Array to check visited nodes
		inStack = new boolean[num]; // Array to track nodes in the recursion stack (will be used when DFS is
									// performed)
		index = num-1; // Initializes index to num-1
	}

	public boolean dependsOn(int task1, int task2) {
		// This method adds to the Adjacency matrix the dependencies according to the
		// arguments
		if (task1 >= num || task1 < 0 || task2 >= num || task2 < 0 || task2 == task1) {
			// Checks if the arguments task1 and task2 are legal if not it returns false
			return false;
		}
		// task2 must finish before task1
		tasks[task2][task1] = 1;
		return true; // The arguments are legal
	}
	
	private boolean dfs(int task, int[] result) {

		// The method performs DFS on task task, and puts the tasks connected to task in
		// result
		if (inStack[task]) { // The task is in the recursion stack, in other words there's a cycle
			return false;
		}
		if (visited[task]) { // Task already processed
			return true;
		}

		// Mark task as visited and on the current recursion stack
		inStack[task] = true;
		// Visit all tasks that depend on the current task
		for (int i = num-1; i >=0; i--) {
			if (tasks[task][i] == 1) { // If task i depends on task
				if (!dfs(i, result)) {
					return false; // Cycle detected during DFS
				}
			}
		}
		inStack[task] = false; // Remove task from recursion stack
		visited[task] = true; // Mark task as fully processed
		// After all dependencies are processed, add task to the end of result array
		result[index--] = task;

		return true; // There is no cycle
	}

	public int[] order() {
		// This method returns an array in topologically sorted order the tasks are
		// supposed to go
		int[] retArray = new int[num]; // Temporary array, will hold the tasks received from the method dfs
		// Initializes retArray(all elements are -1), visited and inStack(all elements
		// are false)
		for (int i = 0; i < num; i++) {
			retArray[i] = -1;
			visited[i] = false;
			inStack[i] = false;
		}
		// initializes index to num-1
		index = num-1;
		// Will perform DFS on each unvisited task and put the tasks in retArray
		for (int i = num-1; i >=0; i--) {
			if (!visited[i]) { // Calls dfs again on all the unvisited tasks
				if (!dfs(i, retArray)) {// Cycle detected, returns null
					return null; 
				}
			}
		}
		
		// retArray that was received in the DFS is topologically sorted
		return retArray;
	}

}
