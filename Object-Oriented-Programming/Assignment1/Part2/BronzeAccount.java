public class BronzeAccount extends StandardAccount {
	public BronzeAccount(int dt,int nt,int mbpm) {
		daytimeMinuetsPerMonth = dt;
		nighttimeMinuetsPerMonth = nt;
		megabytesPerMonth = mbpm;
		packageCost = 36.00;
		costOfDaytimeCalls = 0.12;
		costOfEveningAndWeekendCalls = 0.05;
		numberOfChannels = 60;
		broadband = 500;
		broadbandCost = 0.02;
		totalDaytimeCallCost = daytimeMinuetsPerMonth;
		totalEveningCallCost = nighttimeMinuetsPerMonth;
		totalExtraBroadbandCost = megabytesPerMonth;
		totalCost = 0;
		spotify = false;
		musicOnDemand = false;
		packageName = "Bronze";
	}
}
