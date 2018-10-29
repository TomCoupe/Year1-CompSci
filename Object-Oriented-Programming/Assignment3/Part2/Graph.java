 import java.util.Random;
 public abstract class Graph {
	protected int[] verticies;
	private int graphSize;
	private boolean twoStartingvals;

	public Graph(int size, boolean tsv)
	{
		verticies = new int[size];
		this.graphSize = size;
		this.twoStartingvals = tsv;
	}
	public abstract void onestep();
	
	public void getVertexSize(int size, boolean twoStartingvals) {
		verticies[0] = -1;
		for (int y = 1; y < size; y++) {
			verticies[y] = 1;
		}
	}
	public int getGraphSize() {
		return graphSize;
	}
	
	public boolean getVertexOnes() {
		for (int i = 0; i < verticies.length; i++) {
			if (verticies[i] == -1) {
				return false;
			}
		}
		return true;
	}

	public int random() {
		int randomnum = (int) Math.round((this.graphSize-2) * Math.random());
		return randomnum;
	}
	
	public int runSteps() {
		int counter = 0;
		while (!getVertexOnes()) {
			counter += 1;
			onestep();
		}
		//once there are no false values the loop will stop and will return the counter value.
		return counter;
	}
}