import java.util.Scanner;
 
public class AccountUser {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int daytimeMinuetsPerMonth;
		int nighttimeMinuetsPerMonth;
		int megabytesPerMonth;
		
		while (true) {
			System.out.printf("Please enter the number of daytime minutes used per month: ");
			daytimeMinuetsPerMonth = input.nextInt();
			if (daytimeMinuetsPerMonth < 0) 
				System.out.println("You can't have a number less than 0");
			else
				break;
		} 
		while (true) {
			System.out.printf("Please enter the number of nighttime minutes used per month: ");
			nighttimeMinuetsPerMonth = input.nextInt();
			if (nighttimeMinuetsPerMonth < 0) 
				System.out.println("You can't have a number less than 0");
			else
				break;
		}	
		while (true) {
			System.out.printf("Please enter the number of Megabytes used per month: ");
			megabytesPerMonth = input.nextInt();
			if (megabytesPerMonth < 0) 
				System.out.println("You can't have a number less than 0");
			else
				break;
		}
		BronzeAccount newBronzeAccount;
		newBronzeAccount = new BronzeAccount(daytimeMinuetsPerMonth, nighttimeMinuetsPerMonth, megabytesPerMonth);
		System.out.println();
		double BronzeAccountTotal = newBronzeAccount.accountType();
		
		SilverAccount newSilverAccount;
		newSilverAccount = new SilverAccount(daytimeMinuetsPerMonth, nighttimeMinuetsPerMonth, megabytesPerMonth);
		System.out.println();
		double SilverAccountTotal = newSilverAccount.accountType();
		
		GoldAccount newGoldAccount;
		newGoldAccount = new GoldAccount(daytimeMinuetsPerMonth, nighttimeMinuetsPerMonth, megabytesPerMonth);
		System.out.println();
		double GoldAccountTotal = newGoldAccount.accountType();
		
		if (BronzeAccountTotal < SilverAccountTotal && BronzeAccountTotal < GoldAccountTotal){
			System.out.println("Bronze account is the cheapest option");
		}
		
		if (SilverAccountTotal < BronzeAccountTotal && SilverAccountTotal < GoldAccountTotal) {
			System.out.println("Silver account is the cheapest option");
		}	
		
		if (GoldAccountTotal < SilverAccountTotal && GoldAccountTotal < BronzeAccountTotal) {
			System.out.println("Gold account is the cheapest option");
		
		
		}				
	}
}
		


			
		
		