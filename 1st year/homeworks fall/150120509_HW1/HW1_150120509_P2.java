//Import the scanner
import java.util.Scanner;

public class HW1_150120509_P2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Eren Duyuk 150120509
		
		/*The purpose of this program is converts a date that is given in days to 
		 “Year: <years>, Month: <months>, Day: <days>” format.*/
		
		//Create a scanner and prompt the user to enter the days
		Scanner input = new Scanner(System.in);
		System.out.print("Number of days: ");
		int userDay = input.nextInt();
		
		//Convert the days to years, months, days
		int years = userDay / 365;
		int months = (userDay % 365) / 31;
		int days = (userDay % 365) % 31;
		
		//Display the years, months, days format
		System.out.println("Year: " + years + " Month: " + months + " Day: " + days);

	}

}
