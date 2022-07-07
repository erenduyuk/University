//Import scanner
import java.util.Scanner;
public class HW4_Q2_150120509 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Eren Duyuk 150120509
		
		/*The purpose of this program is determine whether or not it is valid per the Luhn formula. 
		 The Luhn algorithm is a simple checksum formula used to validate a variety of
		 identification numbers, such as credit card numbers.*/
		
		//Create a scanner and prompt the user to enter the input
		Scanner input = new Scanner(System.in);
		String number = input.nextLine();
		
		//Using method
		validateNumber(number);
	}
	
	//The method checking Luhn formula
	public static boolean validateNumber(String number) {
		
		String intNumber = "";
		
		//check for valid value
		for (int i = 0; i < number.length(); i++) {
			if (number.charAt(i) <= '9' && number.charAt(i) >= '0') {
				intNumber += number.charAt(i);
			}
			else if (number.charAt(i) == ' ') {
				continue;
			}
			else {
				System.out.println("Invalid Input !");
				return false;
			}
		}
		
		int sum = 0;
		int a = 0;
		String DNumber = "";
		String LNumber = "";
		
		for (int i = 0; i < intNumber.length(); i++) {
			if (intNumber.length() % 2 == 0) {
				if (i % 2 == 0) {
					DNumber += intNumber.charAt(i) + "_";
				
					a = (int)(intNumber.charAt(i) - '0');
					a *= 2;
					if (a > 9)
						a -= 9;			
				}
				else {
					a = (int)(intNumber.charAt(i) - '0');
				}
			}
			else {
				if (i % 2 != 0) {
					DNumber += "_" + intNumber.charAt(i);
				
					a = (int)(intNumber.charAt(i) - '0');
					a *= 2;
					if (a > 9)
						a -= 9;			
				}
				else {
					a = (int)(intNumber.charAt(i) - '0');
				}
				if (i == intNumber.length() - 1)
					DNumber += "_";
			}
			
			LNumber += "" + a;
			sum += a;
			
		}
		
		//chech the sum
		if (sum % 10 == 0) {
			System.out.println("DNumber:" + DNumber);
			System.out.println("LNumber:" + LNumber);
			System.out.println("Number is Valid");
			return true;
		}
		else {
			System.out.println("DNumber:" + DNumber);
			System.out.println("LNumber:" + LNumber);
			System.out.println("Number is Invalid");
			return false;
		}
			
	
	}
	

}
