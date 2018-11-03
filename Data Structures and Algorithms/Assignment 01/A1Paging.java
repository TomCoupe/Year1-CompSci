import java.util.*;
import java.io.*;

class A1Paging {

	private static Scanner keyboardInput = new Scanner (System.in);
	private static final int maxCacheSize = 10;
	private static final int maxRequest = 100;


	// Do NOT change the main method!
	// main program
	public static void main(String[] args) throws Exception {
		int count=0, size=0;
		int[] org_cache = new int[maxCacheSize];
		int[] cache = new int[maxCacheSize];
		int[] request = new int[maxRequest];
		
		init_array(org_cache, maxCacheSize, -1);
		init_array(request, maxRequest, 0);

		// get the cache size and the number of requests 
		// then get the corresponding input in the respective arrays
		try {
			System.out.println();
			System.out.print("Enter the cache size (1-" + maxCacheSize + "): ");
			size = keyboardInput.nextInt();
			System.out.print("Enter the content of the cache (" + size + " different +ve integers): ");
			for (int i=0; i<size; i++)
				org_cache[i] = keyboardInput.nextInt();				
			System.out.println();
			System.out.print("Enter the number of page requests: (1-" + maxRequest + "): ");
			count = keyboardInput.nextInt();
			if (count > maxRequest || count <= 0)
				System.exit(0);
			System.out.print("Enter " + count + " +ve integers: ");
			for (int i=0; i<count; i++)
				request[i] = keyboardInput.nextInt();				
		}
		catch (Exception e) {
			keyboardInput.next();
			System.exit(0);
		}
		
		System.out.println();
		System.out.println("Cache content: ");
		print_array(org_cache, size);
		System.out.println("Request sequence: ");
		print_array(request, count);

		
		copy_array(org_cache, cache, size);
		no_evict(cache, size, request, count);
		copy_array(org_cache, cache, size);
		evict_largest(cache, size, request, count);
		copy_array(org_cache, cache, size);
		evict_fifo(cache, size, request, count);
		copy_array(org_cache, cache, size);
		evict_lfu(cache, size, request, count);

	}
	
	// Do NOT change this method!
	// set array[0]..array[n-1] to 0
	static void init_array(int[] array, int n, int value) {
		for (int i=0; i<n; i++) 
			array[i] = value;
	}
	
	// Do NOT change this method!
	// set array[0]..array[n-1] to 0
	static void print_array(int[] array, int n) {
		for (int i=0; i<n; i++) {
			System.out.print(array[i] + " ");
			if (i%10 == 9)
				System.out.println();
		}
		System.out.println();
	}
	
	// Do NOT change this method!
	// copy n numbers from array a1 to array a2, starting from a1[x1] and a2[x2]
	static void copy_array(int[] a1, int[] a2, int n) {
		for (int i=0; i<n; i++) {
			a2[i] = a1[i];
		}
	}	

	static void no_evict(int[] cache, int c_size, int[] request, int r_size) {
		boolean fnd = false; //creating a boolean variable fnd which returns false if hit and returns true if miss.
		int hits = 0; //creating a variable of hits
		int miss = 0; //creating a variable of misses
		for (int x=0; x<r_size; x++) { //increments x by 1 when it loops
			for (int y=0; y<c_size; y++) { //increments y by 1 when it loops
				if (cache[y] == request[x]) {
					hits++; // adding 1 to hits 
					System.out.print("h"); //outputting that it was a hit
					fnd = true; //defining fnd as true as we got a hit
					break;
				}
			}
			if (!fnd){ //if fnd = false
				miss++; // add 1 to misses
				System.out.print("m"); //outputting that it was a miss
			}
			fnd = false; //defining fnd as false as we got a miss
		
        }
		System.out.print("\n"+hits+"h "); //outputs the total amount of hits
        System.out.println(miss+"m"); //outputs the total amount of misses

	}


	static void evict_largest(int[] cache, int c_size, int[] request, int r_size) {
		boolean fnd = false; //creating a boolean variable fnd which returns false if hit and returns true if miss.
		int hits = 0; //creating a variable of hits
		int miss = 0; //creating a variable of misses
		int largest = 0;
		for (int x=0; x<r_size; x++) { //increments x by 1 when it loops
			for (int y=0; y<c_size; y++) { //increments y by 1 when it loops
				if (cache[y] == request[x]) {
					hits++; //adds 1 to hits
					System.out.print("h"); //outputting that it was a hit
					fnd = true; //fnd = true as we got a hit
					break; 
				} 
			}
			if (!fnd){ //if fnd = false
				miss++; // add 1 to misses
				System.out.print("m"); //outputing that it was a miss
				for (int y=0; y<c_size; y++) {
					if (cache[largest] < cache[y]) // determining the largest value in the cache
						largest = y; // largest is equal to the largest value y
				}
				cache[largest] = request[x];		
			}
			fnd = false; //fnd = false as its a miss
		}
		System.out.print("\n"+hits+"h "); //outputs the total amount of hits
        System.out.println(miss+"m"); //outputs the total amount of misses
    }	
	
	
	
	static void evict_fifo(int[] cache, int c_size, int[] request, int r_size) {
		boolean fnd = false; //creating a boolean variable fnd which returns true if hit and returns false if miss.
		int hits = 0;
		int miss = 0;
		int longest = 0;
		for (int x=0; x<r_size; x++) { //increments x by 1 when it loops
			for (int y=0; y<c_size; y++) { //increments y by 1 when it loops
				if (cache[y] == request[x]) {
					System.out.print("h"); //outputting that its a hit
					fnd = true; //fnd = true as its a hit 
					break;
				}
			}
			if (fnd == true)
				hits++; //increasing hits by 1
			else {
				System.out.print("m"); //outputting that its a miss
				fnd = false; //fnd = false as its a miss
				miss++; //increase miss by 1
				cache[longest] = request[x]; 
				if (longest == r_size-1)
				    longest = 0; 
				else
					longest++; //adding 1 to longest
			}
			fnd = false; //fnd = false as its a miss
		}
		System.out.print("\n"+hits+"h "); //outputs the total amount of hits
        System.out.println(miss+"m"); //outputs the total amount of misses
	}

	static void evict_lfu(int[] cache, int c_size, int[] request, int r_size) {
		boolean fnd = false;
		int hits = 0;
		int miss = 0;
		int[] frequent = new int[c_size]; //declaring a new frequent variable that stores the most frequent value
		for (int i=0; i<c_size; i++) //increments i by 1
			frequent[i] = 1; 
		for (int x=0; x<r_size; x++) { //increments x by 1
			for (int y=0; y<c_size; y++) { //increments y by 1
				if (cache[y] == request[x]) {
					System.out.print("h"); // outputting that its a hit
					fnd = true; //fnd = true as its a hit
					frequent[y]++; // increasing frequent with a value of y by 1
					hits++; // increasing hits by one
					break;
				}
			}
				if (!fnd) { // if fnd = false
				System.out.print("m"); // outtping its a miss
				fnd = false; 
				int lowval = frequent[0]; //lowval is equal to the lowest value
				miss++; // adding 1 to misses
					for (int y=0; y<c_size; y++) { //incrementing y by 1
						if (frequent[y] < lowval){
							lowval = y;
						}
					cache[lowval] = request[x];
					frequent[lowval] = 1;
					}
				}
			fnd = false; // fnd = false as its a miss
		}		
		System.out.print("\n"+hits+"h "); //outputs the total amount of hits
		System.out.println(miss+"m"); //outputs the total amount of misses	
	}
}



			
	

