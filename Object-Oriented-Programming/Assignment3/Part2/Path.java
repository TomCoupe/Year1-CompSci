public class Path extends Graph {
	
	public Path(int size, boolean twoStartingvals) {
		super(size, twoStartingvals);
		getVertexSize(size, twoStartingvals);
		
		if (twoStartingvals) {
			verticies[verticies.length - 1] = -1;
		}
	}
	
	public void onestep() {
		int rand = random();
		int pair = rand + 1;
		int randomValue = verticies[rand];
		int pairValue = verticies[pair];
		verticies[rand] = randomValue * pairValue;
		verticies[pair] = randomValue * pairValue;
	}
}
	