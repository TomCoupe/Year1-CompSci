public class Average
{
	//add up all the values in score
	//divide by the length of the list
	public static void main(String[] args) 
	{
		double points = 0;
		
		for (int var1 = 1; var1<=6; var1++) 
		{
			for(int var2 = 1; var2<=6; var2++) 
			{
				for(int var3 = 1; var3<=6; var3++) 
				{
				points += new ThreeDiceScorer(var1,var2,var3).getpoints(); 
				}
			}
		}
		System.out.println(points/216); //216 = 6 x 6 x 6
		
		points = 0;
		
		int[]badDice = {2,3,4,5,6,6};
		for (int var1 = 1; var1<=6; var1++) 
		{
			for(int var2 = 1; var2<=6; var2++) 
			{
				for(int var3 = 0; var3<=5; var3++) 
				{
				points += new ThreeDiceScorer(var1,var2,badDice[var3]).getpoints();
				}
			}
		}
		System.out.println(points/216);	
	}	
}