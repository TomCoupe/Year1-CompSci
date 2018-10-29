public class RW {

	public static void main(String[] args) {

		double[] hf = new double[2];
		int[] Highestfloorsdon = new int[2000]; //dons high floors
		int[] Highestfloorsbel = new int[2000]; //bells high floors
		Cockroach[] cr = new Cockroach[2]; //two new cockroach objects
		int[] samefloor = new int[2000]; //number of co-occurances
		int counter = 1;

		for (int i = 0; i < 2000; i++) { //repeating the experiment 2000 times
			DonCockroach Don = new DonCockroach(); 
			BellaCockroach Bella = new BellaCockroach();
			cr[0] = Don; //defining which cockroach is which
			cr[1] = Bella;

			for (int j = 0; j < 100; j++) { //100 steps for each cockroach
				Don.takestep();
				Bella.takestep();
			}
			Highestfloorsdon[i] = Don.getHighFloor(); //returning the highest floor values and storing those values into an array
			Highestfloorsbel[i] = Bella.getHighFloor();
		}

		hf[0] = getAverage(Highestfloorsdon); //assigning the average highest floors to the hf[]
		hf[1] = getAverage(Highestfloorsbel);

		for (int i = 0; i < 2; i++) { //using a for loop that loops twice so i dont have to output 2 times seperately
			System.out.println("----------");
			System.out.println(cr[i].getName()); //get name of cockroach
			System.out.println("----------");
			System.out.println("2000 experiments, walking 100 steps, the maximum height achieved ");

			if (cr[i].getName() == "Don") {
				System.out.println("has an average value: "+hf[0]); //output dons average
				System.out.println("");
			}

			else if (cr[i].getName() == "Bella") {
				System.out.println("has an average value: "+hf[1]);//output bellas average
				System.out.println("");
			}

			System.out.println("2000 experiments, the steps it took to reach the top has average value: "+getAverage(cr[i].stepsToTop())); //average steps to top
		}
		for (int i = 0; i < 2000; i++) { // repeating 2000 times
			cr[0].setFloor(1); //ensuring floors = 1 at the start of each loop
			cr[1].setFloor(1);
			counter = 0;
			for (int k = 0; k < 2000; k++) { //2000 turns for each cockroach
				cr[0].takestep(); // calling takestep
				cr[1].takestep();
				if (cr[0].getFloor() == cr[1].getFloor()) { //if bella and don are on the same floor counter++
				counter++;
				}	
			}
			samefloor[i] = counter; //adding each final counter value to an array
		}
		System.out.println("----------");
		System.out.println("2000 experiments, the number of times Don and Bella were both on the same floor has an average value of: "+getAverage(samefloor)); //ouputting average of co-occurances
		System.out.println("----------");
	}
	
	public static double getAverage(int[] array) { // this method adds up the values of everything within an array and divides it by the array length
		double sum = 0;
		for (int i = 0; i < array.length; i++) {
			sum = sum + array[i];
		}
		return sum/array.length; // returns average
	}
}
				