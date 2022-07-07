//Import scanner
import java.util.Scanner;
public class HW2_150120509_P3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Eren Duyuk 150120509
		
		/*The purpose of this program is calculates personal income tax for last 4 years
		 based on the given tax rates reported by The Turkish Revenue Administration.
		 */
		
		//Create a scanner and prompt the user to enter the information of year and income
		Scanner input = new Scanner(System.in);
		int year = input.nextInt();
		double income = input.nextDouble();
		
		double tax = 0;
		
		if (income <= 0 ) {
			System.out.println("Income must be > 0");
			System.exit(0);
		}
		
		//if year is 2020, it is calculated tax from below
		if (year == 2020) {
			if (income < 22000)
				tax = income * 0.15;
			else if (income < 49000)
				tax = 3300 + (income - 22000) * 0.20;
			else if (income < 180000)
				tax = 8700 + (income - 49000) * 0.27;
			else if (income < 600000)
				tax = 44070 + (income - 180000) * 0.35;
			else if (income >= 600000)
				tax = 191070 + (income - 600000) * 0.40;
			
		}
		//if year is 2019, it is calculated tax from below
		else if (year == 2019) {
			if (income < 18000)
				tax = income * 0.15;
			else if (income < 40000)
				tax = 2700 + (income - 18000) * 0.20;
			else if (income < 148000)
				tax = 7100 + (income - 40000) * 0.27;
			else if (income < 500000)
				tax = 36260 + (income - 148000) * 0.35;
			else if (income > 500000)
				tax = 159460 + (income - 500000) * 0.40;
			
			
		}
		//if year is 2018, it is calculated tax from below
		else if (year == 2018) {
			if (income < 14800)
				tax = income * 0.15;
			else if (income < 34000)
				tax = 2220 + (income - 14800) * 0.20;
			else if (income < 120000)
				tax = 6060 + (income - 34000) * 0.27;
			else if (income >= 120000)
				tax = 29280 + (income - 120000) * 0.35;	
			
		}
		//if year is 2017, it is calculated tax from below
		else if (year == 2017) {
			if (income < 13000)
				tax = income * 0.15;
			else if (income < 30000)
				tax = 1950 + (income - 13000) * 0.20;
			else if (income < 110000)
				tax = 5350 + (income - 30000) * 0.27;
			else if (income >= 110000)
				tax = 26950 + (income - 110000) * 0.35;	
			
		}
		//if year is undefined, it is displayed from below
		else {
			System.out.println("Undefined year value");
			System.exit(1);
		}
		
		//Calculate the outputs
		double incomeAfterTax = income - tax;
		double realTaxRate = tax / income * 100;
		
		//Display the result
		System.out.println("Income: " + (int)(income * 100) / 100.0);
		System.out.println("Tax amount " + (int)(tax * 100) / 100.0);
		System.out.println("Income after tax: " + (int)(incomeAfterTax * 100) / 100.0);
		System.out.println("Real tax rate: " + (int)(realTaxRate * 100) / 100.0 + "%");
			
	}

}
