public class GoldAccount extends StandardAccount {
	public GoldAccount(int dt,int nt,int mbpm) {
		daytimeMinuetsPerMonth = dt;
		nighttimeMinuetsPerMonth = nt;
		megabytesPerMonth = mbpm;
		packageCost = 66.00;
		costOfDaytimeCalls = 0.00;
		costOfEveningAndWeekendCalls = 0.00;
		numberOfChannels = 230;
		broadband = 1520;
		broadbandCost = 0.01;
		totalDaytimeCallCost = daytimeMinuetsPerMonth;
		totalEveningCallCost = nighttimeMinuetsPerMonth;
		totalExtraBroadbandCost = megabytesPerMonth;
		totalCost = 0;
		spotify = true;
		musicOnDemand = true;
		packageName = "Gold";
	}
}