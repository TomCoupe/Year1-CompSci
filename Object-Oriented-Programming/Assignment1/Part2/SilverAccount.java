public class SilverAccount extends StandardAccount {
	public SilverAccount(int dt,int nt,int mbpm) {
		daytimeMinuetsPerMonth = dt;
		nighttimeMinuetsPerMonth = nt;
		megabytesPerMonth = mbpm;
		packageCost = 46.00;
		costOfDaytimeCalls = 0.12;
		costOfEveningAndWeekendCalls = 0.00;
		numberOfChannels = 130;
		broadband = 1000;
		broadbandCost = 0.01;
		totalDaytimeCallCost = daytimeMinuetsPerMonth;
		totalEveningCallCost = nighttimeMinuetsPerMonth;
		totalExtraBroadbandCost = megabytesPerMonth;
		totalCost = 0;
		spotify = true;
		musicOnDemand = false;
		packageName = "Silver";
	}
}