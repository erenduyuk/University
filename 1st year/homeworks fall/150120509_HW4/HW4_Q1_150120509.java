//Import scanner
import java.util.Scanner;
public class HW4_Q1_150120509 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Eren Duyuk 150120509
		
		/*The purpose of this program is to calculate the invoice of each flat in an apartment building. 
		Assume that there are N flats in a building and apartment heating is the central system. 
		30% of bill will be shared equally among the flats, the rest 70% will be shared according to 
		the consumption of each flat.*/
		
		
		
		//Create a scanner and prompt the user to enter the input
		Scanner input = new Scanner(System.in);
		int numberOfFlat = input.nextInt();
		
		double[] flats = new double[numberOfFlat];
		
		//Assign values which giving user to variables 
		for (int i = 0; i < numberOfFlat; i++) {
			flats[i] = input.nextDouble();
		}

		double totalBill = input.nextDouble();
		double[] bills = new double[flats.length];
		
		//Using method
		bills = calculateTheInvoice(flats, totalBill);
		printBills(bills);
		
	}
	
	//The method calculate the invoice for each flat
	public static double[] calculateTheInvoice(double[] flats, double totalBill) {
		double totalConsumption = 0;
		double[] bills = new double[flats.length];
		
		for (int i = 0; i < flats.length; i++) {
			totalConsumption += flats[i];
		}
		
		for (int i = 0; i < flats.length; i++) {
			 bills[i] = (int)((((totalBill * 0.3) / flats.length) + (totalBill * 0.7) * flats[i] / totalConsumption) * 100) / 100.0 ;
		}
		return bills;
	}
	
	//The method display the invoice for each flat 
	public static void printBills(double[] bills) {
		for (int i = 0; i < bills.length; i++) {
			System.out.println("Flat #" + (i+1) + ": " + bills[i]);
		}
	}

}
