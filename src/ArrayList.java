/*Robert Huntington
 *Data Structurs Assignment 3
 * 
 * Array List
 * 
 * Purpose:  
 * This is a program that recreates the Java ArrayList class using only one dependency from the Java library (Array).
 * The ArrayList class contains 3 fields (an array named list, an int named arSize (current size of the ArrayList)).
 * There are two constructors, one default with no parameters making the array data structure a default capacity of 10, 
 * and a constructor allowing a single parameter, defining the array's capacity by an input provided by the user.  In addition,
 * the ArrayList class contains 10 instance methods as follows: 
 * 
 * 		add(Object o), adds an object to the end of the list.
 * 		add(index, Object o), adds an object to a specific index.
 * 		get(int index), returns an object at a user defined index.
 * 		size(), returns the size of the ArrayList (not the array data structure).
 * 		isEmpty(), returns true if no Objects have been added to the ArrayList, or false if it has been instantiated.
 * 		isIn(Object o), returns true if a user defined Object is found in the list, false if it is not found.
 * 		find(Object o), returns the first index where the Object specified is found.  Returns -1 if it is not found.
 * 		remove(Object o), removes the first instance of an Object entered into the parameter.  Does nothing if the Object is not found.
 * 		toString(), prints the ArrayList.
 * 		reSize(), a private method to resize the data structure when it is full.  Multiplies the capacity by 2 each time it is used.  
 * 
 *  Algorithms Used:
 *  
 *  add(Object o): First calls the reSize() method to make sure items can be added to the list.  Then checks to see where the first
 *  available null space is to add an object at that index using an if statement nested within a while loop.  The loop breaks once a 
 *  space for the object is found.
 *  
 *  add(index, Object o):  First calls the reSize() method to make sure items can be added to the list.  Then uses cascading for loops
 *  to first make a copy of the original ArrayList, then adds the object to the specified index, and then fills in the rest of the list using 
 *  the original ArrayList Object so that no index is replaced by the new value.  
 *  
 *  get(index):  Basic getter method to return the value at specified index.
 *  
 *  size():  Uses a counter variable to keep track of how many elements in the list are non-null values.  This is executed using an if statement
 *  nested in a for loop.  The counter is then returned.
 *  
 *  isEmpty():  Creates a boolean variable 'empty' to keep track of the list's empty state and is set to true by default.  Then uses a for loop
 *  to iterate through each index of the list, and if each index is null, the value of empty remains true.  Else it is set to false.
 *  The method finishes by returning 'empty'.
 *  
 *  isIn(Object o):  Creates an int counter and a boolean variable 'result' default set to false.  Has a nested while>for>if algorithm that checks
 *  if the parameter is equal to any sequential element in the list while the counter is less than the array length.  If the object
 *  is in the array, 'result' is set equal to  true.  The method finishes by returning 'result'
 *  
 *  find(Object o):  Has an int counter that while counter is less than array length and if value at index [counter] in the list is not equal to the parameter,
 *  increments the counter by one.  Else it returns the value of counter which signifies the index.  If the element is not found at any index,
 *  the method returns -1.
 *  
 *  remove(Object o):  Has an int counter that increments by one while it is less than the array length, and checks if the list at index
 *  [counter] is equal to the object.  If it is, it makes a copy of the array, without the element at the [counter] index, and then sets the 
 *  original array equal to this new copy without the value.
 *  
 *  toString():  Prints the Array List by first checking to see that it is not null, and then uses a for loop to append each element
 *  of the list to a string to return.  
 *  
 *  reSize():  Is used to check if the array data structure has any storage available to add a value.  If it does, it simply returns the original 
 *  unaltered array, if it is full, it creates a copy of array but with a length twice the size.  This condition is tested by checking if the 
 *  last index of the array has a value.
 *  
 *  
 *  
 *  Data Structure used:  This program used an Array as its data structure.
 *  
 *  
 *  
 *  How to use the program:  When the program runs, it prompts the user for a dimension to make the Array for ArrayList B.  Once given, it runs
 *  through all of the tests on each method, and returns a string explaining what each method does.  First, the program tests the 
 *  two ArrayLists before they have been instantiated, then it runs the tests again on the ArrayList objects, outputting the result from
 *  each method.  
 *  
 *  
 *  Classes:  There are two classes in the program.  These are the ArrayList class and the TestArray class.  The ArrayList class has all of the logic, 
 *  algorithms, and instance methods used to create an ArrayList.  The TestArray class contains the main method and runs each method on two different
 *  ArrayLists to test them.
 *  
 *  
 *  
 * 
 */


import java.util.Arrays;
public class ArrayList {
	Object[] list;
	int arSize = 0;
	//int listSize;

	
	/*Default constructor.  Creates a default ArrayList with 10 available index to instantiate. 
	 *Pre condition: an uninstantiated array.
	 *Post condition: an ArrayList containing an array of size 10.
	 */
	public ArrayList() {
		list = new Object[10];
		//listSize = list.length;
	}

	
	/*User defined constructor.  Allows the user to define how many elements the ArrayList can contain.  
	 *Pre Conditions: an uninstantiated array, an integer 'n' to determine the array size.
	 *Post condition: a ArrayList containing an array of size n.
	 */
	public ArrayList(int n) {
		int defaultValue = 10;
		int size = n;
		list = new Object[n];

		if (size < defaultValue) {
			list = new Object[size];
		} else {
			while (size >= defaultValue) {
				defaultValue *= 2;
				n = defaultValue;
			}
			list = new Object[n];
		}
		
	}

	/*Method that adds elements to the end of an ArrayList object and dynamically allocates new memory to the list once it is full.
	 *Pre Conditions: An ArrayList, an element to add to the ArrayList, a variable to keep track of the ArrayList size, the array.length.  
	 *Post Conditions: The ArrayList with a new element added to the end of the list, an updated list size.  
	 *Invariants:  The resize method.  
	 */
	public void add(Object o) {
		int i = 0;
		int length = list.length;
		list = reSize();
		while(i < length){
			if(list[i] == null){
				list[i] = o;
				i = length;
			}else{
				i++;
			}
		}
		arSize++;

	}
	
	/*User defined add method that takes two parameters, an index and an object.  The object is then added to the list at the specified index.
	 *Pre Conditions:  An ArrayList object, the index, the object to add to the list, the list size, and the array.length.
	 *Post Conditions: An updated ArrayList with a new element at the specified index and the rest of the elements shifted as a result,
	 *				   updated list size.
	 *Invariants:  The resize method.
	 * 
	 */

	public void add(int index, Object o) {
		Object[] a2 = new Object[list.length];
		reSize();
		for (int i = 0; i < index; i++) {
			a2[i] = list[i];
		}
		a2[index] = o;

		for (int i = index + 1; i < list.length; i++) {
			a2[i] = list[i - 1];
		}

		for (int i = 0; i < list.length; i++) {
			list[i] = a2[i];
		}
		
		arSize++;
	}


	/*get method that returns an object at the specified index.
	 *Pre Conditions:  an index integer.
	 *Post Condition:  an object stored at the specified index.
	 *Invariants:  an ArrayList object.  
	 */
	public Object get(int index) {

		return list[index];
	}
	
	
	/*size method that returns the current size of the ArrayList.
	 *Pre Condition:  int listSize set equal to 0.
	 *Post Condition:  int listSize updated to show the size of the list.
	 *Invariants:  an ArrayList object.
	 */
	public int size() {
		int listSize = 0;
		for (int i = 0; i < list.length; i++) {
			if (list[i] != null) {
				listSize++;
			}
		}
		return listSize;
	}

	
	/*isEmpty method which returns true if the ArrayList is empty and false if it is not.  
	 *Pre Conditions: boolean variable set to true.
	 *Post Condition: boolean variable either unchanged or altered.
	 *Invariants:  an ArrayList object.
	 */
	public boolean isEmpty() {
		boolean empty = true;
		for (int i = 0; i < list.length; i++) {
			if (list[i] == null) {

			} else {
				empty = false;
			}
		}
		return empty;
	}

	
	/*isIn method takes an object parameter and tests to see if that object is in the ArrayList.  
	 *Pre Conditions: an object parameter to test for; a boolean value set to false, and a counter variable.
	 *Post Conditions: an updated counter and boolean variable.
	 *Invariants:  an ArrayList object.
	 * 
	 */
	public boolean isIn(Object o) {
		int x = 0;
		boolean result = false;
		while (x <= list.length) {
			for (int i = 0; i < list.length; i++) {
				if (list[i] == o) {
					result = true;
				}
			}
			x++;
		}
		return result;
	}

	
	/*find method that takes an object an searches an ArrayList for it or returns -1 if it is not found.
	 *Pre Conditions:  an object to search for, a counter variable.
	 *Post Conditions: updated counter that is returned or -1 if the element is not found.
	 *Invariants:  an ArrayList object.
	 */
	public int find(Object o) {
		int i = 0;
		if(arSize == 0){
			System.out.println("Error: Your ArrayList is empty.");
		}else
		while (i < list.length) {
			if (list[i] != o) {
				i++;
			} else {
				return i;
			}
		}
		return -1;

	}

	
	/*remove method that removes the first instance of an object that is passed into the parameter.
	 *Pre Conditions: a parameter object to search for and remove, and counter variable, an ArrayList and a copy of that list.  
	 *Post Conditions: a new version of the ArrayList object without the specified value.
	 * 
	 */
	public void remove(Object o) {
		int x = 0;
		Object[] a2 = new Object[list.length];
		if(arSize == 0){
			System.out.println("Error: Your ArrayList is empty.");
		}else
		while (x < list.length) {
			
			if (list[x] == o) {
				for (int i = 0; i <= x - 1; i++) {
					a2[i] = list[i];
				}
				for (int i = x; i < list.length - 1; i++) {
					a2[i] = list[i + 1];
				}

				for (int i = 0; i < list.length - 1; i++) {
					list[i] = a2[i];
				}
				x = list.length;
			} else {
				x++;
			}
		}

	}

	
	/*toString method that returns an ArrayList object as a string.
	 *Pre Conditions:  an ArrayList object
	 *Post Conditions: a string displaying all of the elements in the list.
	 */
	public String toString() {
		int x = 0;
		String printList = "";
		if (list[0] == null) {
			return null;
		} else {
			printList = printList + "[";
			while (list[x] != null) {
				x++;
			}
			for (int i = 0; i < x - 1; i++) {
				printList = printList + list[i];
				printList = printList + ", ";

			}

			printList = printList + list[x - 1] + "]";
		}
		return printList;

	}
	
	
	/*reSize method checks how much space is available and then resizes the ArrayList if necessary.
	 *Pre Condition:  an ArrayList 
	 *Post Condition: either a new extended ArrayList, or the same unaltered ArrayList.  
	 * 
	 */
	private Object [] reSize(){
		Object [] temp;
			if(arSize >=list.length-1){
				temp = new Object[list.length*2];
				for(int i =0; i< list.length; i++){
					temp[i] = list[i];
				}
				list = temp;	
		}
			return list;
	}

}
