//Import scanner
import java.util.Scanner;
public class HW2_150120509_P1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Eren Duyuk 150120509
		
		/*The purpose of this program is finding 
		 last digit of an ISBN-10 (International Standard Book Number)*/
		
		//Create a scanner and prompt the user to enter the first 9 digits of ISBN-10
		Scanner input = new Scanner(System.in);
		System.out.print("Enter the first 9 digits of an ISBN as integer: ");
		int nineDigits = input.nextInt();
		
		//Division into digits
		int M= nineDigits%10;
		int L= nineDigits%100/10;
		int K= nineDigits%1000/100;
		int F= nineDigits%10000/1000;
		int E= nineDigits%100000/10000;
		int D= nineDigits%1000000/100000;
		int C= nineDigits%10000000/1000000;
		int B= nineDigits%100000000/10000000;
		int A= nineDigits%1000000000/100000000;
		
		/*If nineDigits start with 0(zero), java will delete the 0(zero) 
		 so this line convert the nineDigits from int to string*/
		String strDigits = "" + A + B + C + D + E + F + K + L + M;
		
		//Apply the formula
		int result = (A*1 + B*2 + C*3 + D*4 + E*5 + F*6 + K*7 + L*8 + M*9) % 11;
		
		//Check the result
		if (result == 10) {
			System.out.println("The ISBN-10 number is " + strDigits + "X");
		}
		else {
			System.out.println("The ISBN-10 number is " + strDigits + result);
		}
	}

}
