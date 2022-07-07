//Import scanner
import java.util.Scanner;
public class HW2_150120509_P2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Eren Duyuk 150120509
		
		//The purpose of this program is to find the day of any date 
		
		
		//Create a scanner and prompt the user to enter the information
		Scanner input = new Scanner(System.in);
		System.out.print("Enter year (e.g. 2012): ");
		int year = input.nextInt();
		System.out.print("Enter month (e.g. 1-12): ");
		int month = input.nextInt();
		System.out.print("Enter the day of the month (e.g. 1-31): ");
		int day = input.nextInt();
		
		/*January and February count as 13 and 14 in the formula, so you need to convert
		 the user input for the month from 1 to 13 and 2 to 14 and convert the year to the previous year */
		if (month == 1) {
			month = 13;
			year--;
		}
		else if (month == 2) {
			month = 14;
			year--;
		}
		
		
		int century = year / 100;
		int yearOfCentury = year % 100;
		
		//Apply formula
		int whichDay = (day + 26*(month + 1)/10 + yearOfCentury + yearOfCentury/4 + century/4 + 5*century) % 7;
		
		//Display the day according to result
		switch (whichDay) {
			case 0: System.out.println("Day of the week is Saturday");	
			break;
			case 1: System.out.println("Day of the week is Sunday");	
			break;
			case 2: System.out.println("Day of the week is Monday");	
			break;
			case 3: System.out.println("Day of the week is Tuesday");	
			break;
			case 4: System.out.println("Day of the week is Wednesday");	
			break;
			case 5: System.out.println("Day of the week is Thursday");	
			break;
			case 6: System.out.println("Day of the week is Friday");	
			break;
			
		}
		

	}

}
