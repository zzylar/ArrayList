
/*Array List
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
