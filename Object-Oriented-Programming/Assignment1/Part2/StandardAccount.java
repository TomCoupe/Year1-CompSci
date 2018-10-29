import java.util.Scanner;
public abstract class StandardAccount {
	protected double packageCost;
	protected double costOfDaytimeCalls;
	protected double costOfEveningAndWeekendCalls; 
	protected int numberOfChannels;
	protected int broadband; 
	protected double broadbandCost;
	protected double totalDaytimeCallCost;
	protected double totalEveningCallCost;
	protected double totalExtraBroadbandCost; 
	protected double totalCost; 
	protected boolean spotify; 
	protected boolean musicOnDemand;
	protected String packageName;
	protected int daytimeMinuetsPerMonth;
	protected int nighttimeMinuetsPerMonth;
	protected int megabytesPerMonth;
	protected double overallTotalCost;
		
	public double accountType() {
		double v1,v2;
		
		v1 = totalDaytimeCallCost * daytimeMinuetsPerMonth;
		v2 = totalEveningCallCost * nighttimeMinuetsPerMonth;
		
		overallTotalCost = totalCost + totalDaytimeCallCost+totalEveningCallCost+totalExtraBroadbandCost+packageCost;
		
		System.out.println("Package name: "+packageName);
		System.out.println("Package cost: "+packageCost);
		System.out.println("Cost of daytime calls: "+costOfDaytimeCalls);
		System.out.println("Cost of evening and weekend calls: "+costOfEveningAndWeekendCalls+"/min");
		System.out.println("Number of channels: "+numberOfChannels);
		System.out.println("Broadband included: "+broadband+"Mb");
		System.out.println("Broadband cost (Above included limit): "+broadbandCost+"/Mb");
		System.out.println("Total daytime calls cost: "+v1);
		System.out.println("Total evening calls cost: "+v2);
		System.out.println("Total (Extra) broadband cost: "+broadbandCost*(Math.max(0, megabytesPerMonth-broadband)));
		System.out.println("Total cost: "+overallTotalCost);
		return overallTotalCost;
	}
	
}