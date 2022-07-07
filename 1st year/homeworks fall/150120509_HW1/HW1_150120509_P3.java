//Import the scanner
import java.util.Scanner;

public class HW1_150120509_P3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Eren Duyuk 150120509
		
		/*The purpose of this program is that will calculate the compound monthly interest. 
		 The program asks user to enter the values for 
		 a) initial principal in TL/USD, etc.,
		 b) annual interest rate percentage,
 		 c) number of time periods in months , and calculates the corresponding
		 d) monthly interest rate percentage ,
		 e) total compound interest amount in TL/USD, etc.,
		 f) final balance amount in TL/USD, etc.*/
		
		//Create a scanner and prompt the user to enter the informations
		Scanner input = new Scanner(System.in);
		System.out.print("Enter initial principal amount: ");
		double initialPrincipalAmount = input.nextDouble();
		System.out.print("Enter annual interest rate (e.g. 9.45): ");
		double annualInterestRate = input.nextDouble();
		System.out.print("Enter number of time periods in months: ");
		double timeInMonths = input.nextDouble();
		
		double finalBalanceAmount, totalCompoundInterestAmount;
		
		//Calculate final balance amount
		finalBalanceAmount = initialPrincipalAmount * Math.pow(1 + annualInterestRate / 1200, timeInMonths);
		totalCompoundInterestAmount = finalBalanceAmount - initialPrincipalAmount;
		
		//Display the result
		System.out.println("-----------------------------------");
		System.out.println("Initial Principal Amount : " + initialPrincipalAmount);
		System.out.println("Monthly Interest Rate : " + (int)((annualInterestRate / 12) * 100) / 100.0);
		System.out.println("Total Compound Interest Amount : " + (int)(totalCompoundInterestAmount * 100) / 100.0);
		System.out.println("Final Balance Amount : " + (int)(finalBalanceAmount * 100) / 100.0);
	}

}
