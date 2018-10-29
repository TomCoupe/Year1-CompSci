import java.lang.Math;

public abstract class Cockroach {
	private String name;
	private int floors = 1;
	private int highFloor;
	private int steps;
	
	public abstract void takestep(); //used by both cockroaches

	public Cockroach(String n) { //used to name each cockroach
		name = n; 
	}

	public String getName() { //returns cockroach name
		return name;
	}
	public int getHighFloor() { //reutrns highest floor
		return highFloor;
	}
	
	public int getFloor() { //gets current floor
		return this.floors;
	}
	
	public void setFloor(int n) { //used to set a floor for a cockroach
		highFloor = Math.max(this.floors, highFloor);
		floors = Math.min(Math.max(n,1),102);
	}
	
	public int getDieRoll(int v1, int v2) { // used to the die values and also used for the 0.01% chance don falls
		return  v1 + (int)(v2 * Math.random());
	}
 
	public void incSteps() { //increases steps by one each time it is called
		this.steps++;
	}
		
	public int getSteps(){ //gets steps value
		return this.steps;
	}
	
	public int[] stepsToTop() { //this method is used to measure how many steps it takes each cockroach to reach the top floor.
		int[] crtop = new int[2000];
		for (int i = 0; i < 2000; i++) {
			while(getFloor() < 102) {
				this.takestep();
				this.incSteps();
			}
			crtop[i] = getSteps();
			this.steps = 0;
			this.floors = 1;
		}
		return crtop;
	}			
}