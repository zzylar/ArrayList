import java.util.Arrays;
import java.util.Scanner;

import javax.swing.plaf.synth.SynthSeparatorUI;

import java.util.Random;

public class TestArray {

	public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	System.out.println("ArrayList A has a default max dimension of 10 cells.\nPlease provide a dimension for ArrayList B...");
	int input = sc.nextInt();
	ArrayList a = new ArrayList();
	ArrayList b = new ArrayList(input);
	
	// Tests (exluding add() and add(index, value)) on the empty Array Lists..
	System.out.println("Tests on empty ArrayLists..\n");
	System.out.println("size() method");
	System.out.println("Array A size: " + a.size() + "\nArray B size: " + b.size());
	System.out.println();
	
	System.out.println("isEmpty() method");
	System.out.println("Return true if a is empty: " + a.isEmpty() + "\nReturn true if b is empty: " + b.isEmpty());
	System.out.println();
	
	System.out.println("toString() method");
	System.out.println("a.toString() returns: " + a.toString() + "\nb.toString() returns: " + b.toString());
	System.out.println();
	
	System.out.println("remove() method");
	System.out.print("a.remove(a.get(0) returns: ");
	a.remove(a.get(0));
	System.out.print("b.remove(b.get(5) returns: ");
	b.remove(b.get(5));
	System.out.println();
	
	System.out.println("find() method");
	System.out.print("a.find(a.get(0) returns: ");
	a.find(a.get(0));
	System.out.print("b.find(b.get(5)) returns: ");
	b.find(b.get(5));
	System.out.println();
	
	System.out.println("isIn() method: ");
	System.out.println("a.isIn(0) returns: " + a.isIn(0));
	System.out.println("b.isIn(5) returns: " + b.isIn(5));
	System.out.println();
	
	System.out.println("get() method");
	System.out.println("a.get(0) returns: " + a.get(0));
	System.out.println("b.get(5) returns: " + b.get(5));
	System.out.println();
	
	
	
	// Fills both ArrayLists with random integers testing the add() function on both ArrayLists..
	
	
	Random rand = new Random();
	for(int i = 0; i < 15; i++){
		a.add(rand.nextInt(25) + 1);
		b.add(rand.nextInt(25) + 1);
	}
	System.out.println("Tests on the following filled ArrayLists..\n\n" +  "A: " + a.toString()+ "\n" + "B: " + b.toString() + "\n");
	
	System.out.println("add() method");
	a.add(0);
	b.add(5);
	System.out.println("a.add(0) will add a 0 to the last index: " + a.toString());
	System.out.println("b.add(5) will add a 5 to the last index: " + b.toString() + "\n");
	
	System.out.println("add(index, object) method");
	a.add(3, 5);
	System.out.println("a.add(3, 5) will add a 5 to the 3rd index: " + a.toString());
	b.add(5,0);
	System.out.println("b.add(5, 0) will add a 0 to the 5th index: " + b.toString()+"\n");
	
	System.out.println("size() method");
	System.out.println("Array A size: " + a.size() + "\nArray B size: " + b.size());
	System.out.println();
	
	System.out.println("isEmpty() method");
	System.out.println("Return true if a is empty: " + a.isEmpty() + "\nReturn true if b is empty: " + b.isEmpty());
	System.out.println();
	
	System.out.println("toString() method");
	System.out.println("a.toString() returns: " + a.toString() + "\nb.toString() returns: " + b.toString());
	System.out.println();
	
	System.out.println("remove() method");
	System.out.print("ArrayList after a.remove(a.get(0)) is: ");
	a.remove(a.get(0));
	System.out.println(a.toString());
	System.out.print("ArrayList after b.remove(b.get(5)) is: ");
	b.remove(b.get(5));
	System.out.print(b.toString());
	System.out.println("\n");
	
	System.out.println("find() method");
	System.out.println("a.find(a.get(0)) returns: " + a.find(a.get(0)));
	System.out.println("b.find(b.get(5)) returns: " + b.find(b.get(5)));
	System.out.println();
	
	System.out.println("isIn() method: ");
	System.out.println("a.isIn(a.get(0) returns (should be true): " + a.isIn(a.get(0)));
	System.out.println("b.isIn(-1) returns (should be false): " + b.isIn(-1));
	System.out.println();
	
	System.out.println("get() method");
	System.out.println("a.get(0) returns: " + a.get(0));
	System.out.println("b.get(5) returns: " + b.get(5));
	System.out.println();
	
	}

}
