public class Cycle extends Graph {
	
	public Cycle(int size, boolean twoStartingvals) {
		super(size, twoStartingvals);

		if (twoStartingvals) {
			verticies[size / 2] = -1;
		}
	}
	
	public void onestep() {
		int pair = random() + 1;
		if (pair >= verticies.length) {
			pair = 0;
		}
		int randomValue = verticies[random()];
		int pairValue = verticies[pair];
		
		verticies[random()] = randomValue * pairValue;
		verticies[pair] = randomValue * pairValue;
	}
}
