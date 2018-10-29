public class DonCockroach extends Cockroach {
	int roll;
	int reroll;
	
	public DonCockroach() {
		super("Don");
	}
	
	public void takestep() {
		if (getDieRoll(1,1000) == 1) { //0.01% chance don falls
			setFloor(1); //sets floor to one if done falls
		}
		else {
			roll = getDieRoll(1,6); //roll die
			if (roll == 1 || roll == 2) { 
				setFloor(getFloor() - 1); //if roll = 1 or 2, move down a floor
			}
			else if (roll == 3 || roll == 4 || roll == 5) {
				setFloor(getFloor() + 1); //if roll = 3, 4 or 5 move up one floor
			}
			else if (roll == 6) {
				reroll = getDieRoll(1,6);
				setFloor(getFloor() + reroll); //move up the amount of floors equal the the reroll value.
			}
		}
		getSteps();
	}	
}