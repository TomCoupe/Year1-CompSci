public class ThreeDiceScorer extends ThreeDice { // Defining the class ThreeDiceScorer which is a subclass of ThreeDice

	int points; //Defining variables of possible outcomes as integer values, i will be using these variables within the points system.
	
	public ThreeDiceScorer(int s1, int s2, int s3) {  //defining integer values of each dice roll
		super(s1,s2,s3); //calling the parent constructor
		points = s1+s2+s3; // adding the die values together = points
		
		if (threeSame())
			points = s1+s2+s3+60; //60 extra points if you get three of the same
		if (runOfThree())
			points = s1+s2+s3+40; //40 extra points if you get a run of three
		if (pair())
			points = s1+s2+s3+20; //20 extra points if you get a pair
		if (allDifferent())
			points = s1+s2+s3; // no extra points if they are all different
	}
	public int getpoints() {
		return points; // when getpoints() is called it returns points of die rolls
	}
}


		