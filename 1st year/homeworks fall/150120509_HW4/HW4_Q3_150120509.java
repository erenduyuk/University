//Import Scanner
import java.util.Scanner;

public class HW4_Q3_150120509 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Eren Duyuk 150120509
		
		/*The purpose of this program is takes an input letter and outputs it in a diamond shape. 
		 * Given a letter, it prints a diamond starting with 'A', with the supplied letter at the widest point.
		 */
		
		
		//Create a scanner and prompt the user to enter the input
		Scanner input = new Scanner(System.in);
		
		String info = input.nextLine();
		
		info = info.toUpperCase();
		
		//check for valid value
		if (info.length() != 1) {
			System.out.println("Invalid Input !");
			System.exit(0);
		}
		
		char letter = info.charAt(0);
		
		if ((letter >= 'A' && letter <= 'Z')) {					
		}
		else {
			System.out.println("Invalid Input !");
			System.exit(1);
		}
		
		//Using methods
		char[][] diamond = constructDiamond(letter);
		printDiamond(diamond);
	}
	
	
	//The method draw the shape
	public static char[][] constructDiamond(char letter) {
		
		int numberOfLetters = letter - 'A' + 1;
		
		int row = (numberOfLetters - 1) * 2 + 1;
		
		char[][] diamond = new char[row][row];
		int difference = 0;
		for (int i = 0; i < row; i++) {
			difference = Math.abs(row / 2 - i);
			for (int j = 0; j < row; j++) {
				if (difference == j ) {
					diamond[i][j] = (char)(letter - difference);
				}
				else if (row - 1 - difference == j) {
					diamond[i][j] = (char)(letter - difference);
				}
				else {
					diamond[i][j] = '.';
				}
			}
		}
		return diamond;
	}
	//The method display the shape
	public static void printDiamond(char[][] diamond) {
		for (int i = 0; i < diamond.length; i++) {
			for (int j = 0; j < diamond.length; j++) {
				System.out.print(diamond[i][j]);
			}
			System.out.println();
		}
	}
}
