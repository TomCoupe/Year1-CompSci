 public class BellaCockroach extends Cockroach {
	boolean floor86 = false;
	int roll;
	
	public BellaCockroach() {
		super("Bella");
	}

	public void takestep() {
		if (floor86 = false && getFloor() == 86) { //if bella is on floor 86, floor 86 = true
			floor86 = true;
		}
		else {
			roll = getDieRoll(1,6);
			if (roll == 1 || roll == 2 || roll == 3) {
				floor86passed(-1); //if bella rolls 1, 2 or 3 move down one floor unless she tries to go through floor 86
				floor86 = false;
			}
			else if (roll == 4) {
				floor86passed(2);// if bella rolls 4, move up 2 floors unless she tries to go through floor 86
				floor86 = false;
			}
			else if (roll == 5) {
				floor86passed(3); //if bella rolls 5 move up 3 floors unless she tries to go through floor 86
				floor86 = false;
			}
		}
		getSteps();
	}
	/*this methods does not allow bella to move onto or move through floor 86
	until she has waited on floor 86 for one whole takestep*/
	public void floor86passed(int n) {  
		if ((this.getFloor() < 86 && this.getFloor() + n > 86)||(this.getFloor() > 86 && this.getFloor() + n < 86)) {
			this.setFloor(86);
		}
		else {
			this.setFloor(this.getFloor()+n);
		}
	}
}