public class CoopGame {
	public static void main(String[] args) {
		int numV = 100;
		try {
			numV = Integer.parseInt(args[0]);
			if (args.length < 1) {
				System.out.println("Error - Example usage: java CoopGame n [Trials] ");
				System.out.println("n = number of verticies (must be greater than 3)");
				System.out.println("[Trials] = number of trials (optional) ");
				System.exit(1);
			}
			if (numV < 3) {
				System.out.println("Error - First argument is less than 3");
				System.exit(1);
			}
		}
		catch (NumberFormatException nfe) {
			System.out.println("Error - Please input an integer value");
			System.exit(1);
		}
		catch (ArrayIndexOutOfBoundsException ie) {
			System.out.println("Error - Please input an integer into the args");
			System.out.println("Example usage: java CoopGame n [Trials] ");
			System.out.println("n = number of verticies (must be greater than 3)");
			System.out.println("[Trials] = number of trials (optional) ");
			System.exit(1);
		}
		int numT;
		try {
			numT = Integer.parseInt(args[1]);
			if (numT < 0 || numT > 5000) {
				System.out.println("Error - Second argument must be between 0 and 5000");
				System.exit(1);
			}
		}
		catch(ArrayIndexOutOfBoundsException ie) {
			numT = 2000;
		}
		double ap = 0.0;
		double ap2 = 0.0;
		double ac = 0.0;
		double ac2 = 0.0;

		
		for (int y = 0; y < numT; y++) {
			Path path = new Path(Integer.parseInt(args[0]), false);
			Path path2 = new Path(Integer.parseInt(args[0]), true);
			Cycle cycle = new Cycle(Integer.parseInt(args[0]), false);
			Cycle cycle2 = new Cycle(Integer.parseInt(args[0]), true);
			ap = ap + path.runSteps();
			ap2 = ap2 + path2.runSteps();
			ac = ac + cycle.runSteps();
			ac2 = ac2 + cycle2.runSteps();
		}
		ap = ap / numT;
		ap2 = ap2 / numT;
		ac = ac / numT;
		ac2 = ac2 / numT;

		System.out.println("Cycle of size "+numV+" ("+numT+" trials) with one starting -1 value: "+ac);
		System.out.println("Cycle of size "+numV+" ("+numT+" trials) with one starting -1 value: "+ac2);
		System.out.println("\n");
		System.out.println("Path of size "+numV+" ("+numT+" trials) with two starting -1 values: "+ap);
		System.out.println("Path of size "+numV+" ("+numT+" trials) with two starting -1 values: "+ap2);

	}
}