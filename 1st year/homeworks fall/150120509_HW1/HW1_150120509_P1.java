//Import the Scanner
import java.util.Scanner;

public class HW1_150120509_P1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Eren Duyuk 150120509
		
		/*The purpose of this program is to get informations from drivers such as distance to drive, 
		 the fuel efficiency of the car in miles per gallon, and the price per gallon and then 
		 displays the cost of trip. */
		
		//Create a scanner and prompt the user to enter the informations
		Scanner input = new Scanner(System.in);
		System.out.print("Enter the driving distance: ");
		double distance = input.nextDouble();
		System.out.print("Enter miles per gallon: ");
		double milesPerGallon = input.nextDouble();
		System.out.print("Enter price per gallon: ");
		double pricePerGallon = input.nextDouble();
		
		//Calculate the cost
		double cost = (distance / milesPerGallon) * pricePerGallon;
		
		//Display the cost
		System.out.print("The cost of driving is $" + (int)(cost * 100) / 100.0);
	}

}
