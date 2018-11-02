/*
	Name: Thomas Coupe
	Student ID: 201241037
	Departmental username: u7tc1
	University email address; T.Coupe@student.liverpool.ac.uk
*/

import java.util.*;
import java.io.*;


// Implement a linked list from the object A2Node
class A2List {

	private static Scanner keyboardInput = new Scanner (System.in);
	public static A2Node head, tail; // head and tail of the linked list
	private static final int MaxInitCount = 10;
	private static final int MaxReqCount = 100;
	public static int initCount;
	public static int reqCount;

	public static int[] reqData = new int[MaxReqCount]; // store the requests, accessible to all methods


	// DO NOT change the main method
	public static void main(String[] args) throws Exception {
		A2Node curr;
		int tmp=-1;
		int[] initData = new int[MaxInitCount];

		initCount = 0;
		reqCount = 0;
		head = null;
		tail = null;

		try {
//			System.out.println();
//			System.out.print("Enter the initial number of files in the cabinet (1-" + MaxInitCount + "): ");
			initCount = keyboardInput.nextInt();
			if (initCount > MaxInitCount || initCount <= 0)
				System.exit(0);
//			System.out.print("Enter the initial file IDs in the cabinet (" + initCount + " different +ve integers): ");
			for (int i=0; i<initCount; i++)
				initData[i] = keyboardInput.nextInt();				
//			System.out.println();
//			System.out.print("Enter the number of file requests (1=" + MaxReqCount + "): ");
			reqCount = keyboardInput.nextInt();
			if (reqCount > MaxReqCount || reqCount <= 0)
				System.exit(0);
//			System.out.print("Enter the request file IDs (" + reqCount + " different +ve integers): ");
			for (int i=0; i<reqCount; i++)
				reqData[i] = keyboardInput.nextInt();				
		}
		catch (Exception e) {
			keyboardInput.next();
			System.exit(0);
		}
		
		
		
		try {
			System.out.println("appendIfMiss...");
			// create a list with the input data
			// call appendIfMiss()
			for (int i=initCount-1; i>=0; i--) {
				insertNodeHead(new A2Node(initData[i]));
			}
			appendIfMiss();
		}
		catch (Exception e) {
			System.out.println("appendIfMiss exception! " + e);
		}

		try {
			System.out.println("moveToFront...");
			// empty the previous list and restart with the input data
			// then call moveToFront()
			emptyList();
			for (int i=initCount-1; i>=0; i--) {
				insertNodeHead(new A2Node(initData[i]));
			}
			moveToFront();
		}
		catch (Exception e) {
			System.out.println("moveToFront exception!");
		}

		try {
			System.out.println("freqCount...");
			// empty the previous list and restart with the input data
			// then call freqCount()
			emptyList();
			for (int i=initCount-1; i>=0; i--) {
				insertNodeHead(new A2Node(initData[i]));
			}
			freqCount();
		}
		catch (Exception e) {
			System.out.println("freqCount exception!");
		}		
	}
	
	// append to end of list when miss
	static void appendIfMiss() {
		A2Node curr;
		boolean found = false;
		int hit = 0;
		int comparisonsFound = 0;
		//iterating through all the values in reqCount
		for (int i = 0; i < reqCount; i++) {
			curr = head; 
			comparisonsFound = 0;
			while (curr != null) {
				comparisonsFound++;
				//declaring a hit by comparing the curr data with values of the reqData
				if (curr.data == reqData[i]) {
					hit++;
					found = true;
					break;
				}
				//if there wasn't a hit, set curr to the value next to the curr.
				curr = curr.next;
			}
			//putting the value at the tail of the list if there was no hit.
			if (!found) {
				tail.next = new A2Node(reqData[i]);
				tail = tail.next;
			}
			//setting the found to false for the next loop.
			found = false;
			System.out.print(comparisonsFound+" ");
		} 
		//outputting to the user
		System.out.println(hit+" h");
		printList();
		System.out.println();
	}

	// move the file requested to the beginning of the list
	static void moveToFront() {
		A2Node curr;
		A2Node temp; //creating a temp variable for holding data temporarily 
		boolean found = false;
		int hit = 0;
		int comparisonsFound = 0;
		//iterating through all the values in reqCount
		for (int i = 0; i < reqCount; i++) {
			curr = head;
			temp = curr;
			comparisonsFound = 0;
			while (curr != null) {
				comparisonsFound++;
				//declaring a hit by comparing the curr data with values of the reqData
				if (curr.data == reqData[i]) {
					hit++;
					found = true;
					//if the curr is already at the head it breaks from the loop as nothing more needs to be done
					if (curr == head)
						break;
					//putting the value at the head of the list
					temp.next = curr.next;
					curr.next = head;
					head = curr;
					break;
				}
				temp = curr;
				curr = curr.next;
			}
			//puts the value at the head of the list if curr is = null
			if (!found) {
				insertNodeHead(new A2Node(reqData[i])); 
			}
			found = false;
			System.out.print(comparisonsFound+" ");
		}
		//outputting to the user
		System.out.println(hit+" h");
		printList();
		System.out.println();
	}
	
	// move the file requested so that order is by non-increasing frequency
	static void freqCount() {
		A2Node curr;
		int f;
		int d;
		boolean found = false;
		int hit = 0;
		int comparisonsFound = 0;
		//itterating through all values in reqCount
		for (int i = 0; i < reqCount; i++) {
			curr = head;
			comparisonsFound = 0;
			while (curr != null) {
				comparisonsFound++;
				//declaring a hit by comparing the curr data with values of the reqData
				if (curr.data == reqData[i]) {
					hit++;
					curr.freq++;
					found = true;
					//calling the arrangeFreq method to arrange in frequency order
					arrangeFreq();
					break;
				}
				curr = curr.next;
			}
			//puts the value at the tail of the list if !found
			if (!found) {
				tail.next = new A2Node(reqData[i]);
				tail = tail.next;
			}
			//calling the arrangeFreq method again to order based on frequency if the values did not enter the last while loop
			arrangeFreq();
			found = false;
			System.out.print(comparisonsFound+" ");
		}
		//outputting to the user.
		System.out.println(hit+" h");
		printList();
		System.out.println();
		
	}
	//creating a method that arranges values in a non-increasing frequency order 
	static void arrangeFreq() {
		//calling curr from A2Node class
		A2Node curr; 
		int f;
		int d;
		//setting the curr to the head of the list before the while loop
		curr = head; 
		while (curr.next != null){
			//using an if statement to check if the frequency value next to curr is greater than the curr frequency.
			if ((curr.next).freq > curr.freq) { 
				d = (curr.next).data; //d = value next the the curr value
				f = (curr.next).freq; //f = frequency of the value next to curr.
				(curr.next).data = curr.data; //swapping the values of curr with the value next to curr 
				(curr.next).freq = curr.freq;
				curr.data = d;
				curr.freq = f;
				curr = head; //setting the curr back to the head of the list
			}
			//if the frequency is not higher than the value next to curr, curr will be swapped with that value.
			curr = curr.next;
		}
	}
	
	static void insertNodeHead(A2Node newNode) {

		newNode.next = head;
		if (head == null)
			tail = newNode;
		head = newNode;
	}

	// DO NOT change this method
	// delete the node at the head of the linked list
	static A2Node deleteHead() {
		A2Node curr;

		curr = head;
		if (curr != null) {
			head = head.next;
			if (head == null)
				tail = null;
		}
		return curr;
	}

	// DO NOT change this method
	// print the content of the list in two orders:
	// from head to tail
	static void printList() {
		A2Node curr;

		System.out.print("List: ");
		curr = head;
		while (curr != null) {
			System.out.print(curr.data + " ");
			curr = curr.next;
		}
		System.out.println();
	}

	
	// DO NOT change this method
	static void emptyList() {
		
		while (head != null)
			deleteHead();
	}

}