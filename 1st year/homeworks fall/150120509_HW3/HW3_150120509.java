//Import Scanner
import java.util.Scanner;
public class HW3_150120509 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Eren Duyuk 150120509
		
		/*The purpose of this program is that draws the coordinate system 
		 and some geometric shapes on the console screen*/
		
		
		//Create a scanner and prompt the user to enter the information
		Scanner input = new Scanner(System.in);
		
		//Runs repeatedly until exiting the program
		while (true) {
		//Display the menu and get information from user
		System.out.print("Which shape would you like to draw?\r\n" + 
				"1. Line\r\n" + 
				"2. Triangle\r\n" + 
				"3. Rectangle\r\n" + 
				"4. Parabola\r\n" + 
				"5. Circle\r\n" + 
				"6.Exit");
		int info = input.nextInt();
		
		
		
		if (info == 1) {
			//Informing the user and getting value
			System.out.println("Line formula is y = ax + b");
			System.out.print("Please enter the coefficients a and b: ");
			int a = input.nextInt();
			int b = input.nextInt();
			
			//Draw the line and graph
			for (int y = 10; y >= -11; y--) {
				for (int x = -10;  x <= 11; x++) {
					if (a*x + b == y) {
						System.out.print("*");
					}
					else if (x == 0) {
						if (y == 10)
							System.out.print("y");
						else
							System.out.print("|");
					}
					else if (y == 0) {
						if (x == 11)
							System.out.print("x");
						else
							System.out.print("-");
					}
					
					else {
						System.out.print(" ");
					}
					
				}
				System.out.println("");
			}
			
					
		}
		else if (info == 2) {
			//Informing the user and getting value
			System.out.println("For triangle, we need the coordinates of the points for three vertices.");
			System.out.print("Please enter the coordinates of 3 vertices a, b, c, d, e, f: ");
			int a = input.nextInt();
			int b = input.nextInt();
			int c = input.nextInt();
			int d = input.nextInt();
			int e = input.nextInt();
			int f = input.nextInt();
			
			//Draw the triangle and graph
			for (int y = 10; y >= -11; y--) {
				for (int x = -10;  x <= 11; x++) {
					
					
			
					if (x == 0) {
						if (y == 10) {
							System.out.print("y");
						}
						else if ((y - b) * (c - a) == (d - b) * (x - a)) {
							if (x <= c && x >= a) {
								if (y <= b && y >= d) 
									System.out.print("*");
								else if (y <= d && y >= b)
									System.out.print("*");
								else
									System.out.print("|");
							}
							else if (x <= a && x >= c) {
								if (y <= b && y >= d) 
									System.out.print("*");
								else if (y <= d && y >= b)
									System.out.print("*");
								else
									System.out.print("|");
							}
							else {
								System.out.print("|");
							}
						}
						else if ((y - b) * (e - a) == (f - b) * (x - a)) {
							if (x <= e && x >= a) {
								if (y <= b && y >= f) 
									System.out.print("*");
								else if (y <= f && y >= b)
									System.out.print("*");
								else
									System.out.print("|");
							}
							else if (x <= a && x >= e) {
								if (y <= b && y >= f) 
									System.out.print("*");
								else if (y <= f && y >= b)
									System.out.print("*");
								else
									System.out.print("|");
							}
							else {
								System.out.print("|");
							}
							
						}
						else if ((y - f) * (c - e) == (d - f) * (x - e)) {
							if (x <= c && x >= e) {
								if (y <= f && y >= d) 
									System.out.print("*");
								else if (y <= d && y >= f)
									System.out.print("*");
								else
									System.out.print("|");
							}
							else if (x <= e && x >= c) {
								if (y <= f && y >= d) 
									System.out.print("*");
								else if (y <= d && y >= f)
									System.out.print("*");
								else
									System.out.print("|");
							}
							else {
								System.out.print("|");
							}
						}
						else {
							System.out.print("|");
						}
					}
					
					
					
					
					else if (y == 0) {
						if (x == 11) {
							System.out.print("x");
						}
						else if ((y - b) * (c - a) == (d - b) * (x - a)) {
							if (x <= c && x >= a) {
								if (y <= b && y >= d) 
									System.out.print("*");
								else if (y <= d && y >= b)
									System.out.print("*");
								else
									System.out.print("-");
							}
							else if (x <= a && x >= c) {
								if (y <= b && y >= d) 
									System.out.print("*");
								else if (y <= d && y >= b)
									System.out.print("*");
								else
									System.out.print("-");
							}
							else {
								System.out.print("-");
							}
						}
						else if ((y - b) * (e - a) == (f - b) * (x - a)) {
							if (x <= e && x >= a) {
								if (y <= b && y >= f) 
									System.out.print("*");
								else if (y <= f && y >= b)
									System.out.print("*");
								else
									System.out.print("-");
							}
							else if (x <= a && x >= e) {
								if (y <= b && y >= f) 
									System.out.print("*");
								else if (y <= f && y >= b)
									System.out.print("*");
								else
									System.out.print("-");
							}
							else {
								System.out.print("-");
							}
							
						}
						else if ((y - f) * (c - e) == (d - f) * (x - e)) {
							if (x <= c && x >= e) {
								if (y <= f && y >= d) 
									System.out.print("*");
								else if (y <= d && y >= f)
									System.out.print("*");
								else
									System.out.print("-");
							}
							else if (x <= e && x >= c) {
								if (y <= f && y >= d) 
									System.out.print("*");
								else if (y <= d && y >= f)
									System.out.print("*");
								else
									System.out.print("-");
							}
							else {
								System.out.print("-");
							}
						}

						else {
							System.out.print("-");
						}
					}
					
					
					
					
					
					else if ((y - b) * (c - a) == (d - b) * (x - a)) {
						if (x <= c && x >= a) {
							if (y <= b && y >= d) 
								System.out.print("*");
							else if (y <= d && y >= b)
								System.out.print("*");
							else
								System.out.print(" ");
						}
						else if (x <= a && x >= c) {
							if (y <= b && y >= d) 
								System.out.print("*");
							else if (y <= d && y >= b)
								System.out.print("*");
							else
								System.out.print(" ");
						}
						else {
							System.out.print(" ");
						}
					}
					else if ((y - b) * (e - a) == (f - b) * (x - a)) {
						if (x <= e && x >= a) {
							if (y <= b && y >= f) 
								System.out.print("*");
							else if (y <= f && y >= b)
								System.out.print("*");
							else
								System.out.print(" ");
						}
						else if (x <= a && x >= e) {
							if (y <= b && y >= f) 
								System.out.print("*");
							else if (y <= f && y >= b)
								System.out.print("*");
							else
								System.out.print(" ");
						}
						else {
							System.out.print(" ");
						}
						
					}
					else if ((y - f) * (c - e) == (d - f) * (x - e)) {
						if (x <= c && x >= e) {
							if (y <= f && y >= d) 
								System.out.print("*");
							else if (y <= d && y >= f)
								System.out.print("*");
							else
								System.out.print(" ");
						}
						else if (x <= e && x >= c) {
							if (y <= f && y >= d) 
								System.out.print("*");
							else if (y <= d && y >= f)
								System.out.print("*");
							else
								System.out.print(" ");
						}
						else {
							System.out.print(" ");
						}
					}
					
					
					
					else {
						System.out.print(" ");
					}
					
				}
				System.out.println("");
			}
			
		}
		else if (info == 3) {
			//Informing the user and getting value
			System.out.println("For rectangle, we need the coordinates of the points for three vertices.");
			System.out.print("Please enter the coordinates of 3 vertices a, b, c, d, e, f: ");
			int a = input.nextInt();
			int b = input.nextInt();
			int c = input.nextInt();
			int d = input.nextInt();
			int e = input.nextInt();
			int f = input.nextInt();
			
			//Find fourth vertice
			int g = e + c - a;
			int h = d + f -b;
			
			//Checking if given points form a rectangle using the Pythagorean theorem
			if (Math.pow((c-a), 2) + Math.pow((d-b), 2) + Math.pow((e-a), 2)  + Math.pow((f-b), 2) != Math.pow((e-c), 2) + Math.pow((f-d), 2)) {
				System.out.println("A rectangle cannot be drawn with these points!\n");
			}
			else {
			
			//Draw the rectangle and graph
			for (int y = 10; y >= -11; y--) {
				for (int x = -10;  x <= 11; x++) {
					
					
					if (x == 0) {
						if (y == 10) {
							System.out.print("y");
						}else if ((y - b) * (c - a) == (d - b) * (x - a)) {
							if (x <= c && x >= a) {
								if (y <= b && y >= d) 
									System.out.print("*");
								else if (y <= d && y >= b)
									System.out.print("*");
								else
									System.out.print("|");
							}
							else if (x <= a && x >= c) {
								if (y <= b && y >= d) 
									System.out.print("*");
								else if (y <= d && y >= b)
									System.out.print("*");
								else
									System.out.print("|");
							}
							else {
								System.out.print("|");
							}
						}
						else if ((y - b) * (e - a) == (f - b) * (x - a)) {
							if (x <= e && x >= a) {
								if (y <= b && y >= f) 
									System.out.print("*");
								else if (y <= f && y >= b)
									System.out.print("*");
								else
									System.out.print("|");
							}
							else if (x <= a && x >= e) {
								if (y <= b && y >= f) 
									System.out.print("*");
								else if (y <= f && y >= b)
									System.out.print("*");
								else
									System.out.print("|");
							}
							else {
								System.out.print("|");
							}
							
						}
						else if ((y - h) * (c - g) == (d - h) * (x - g)) {
							if (x <= c && x >= h) {
								if (y <= h && y >= d) 
									System.out.print("*");
								else if (y <= d && y >= h)
									System.out.print("*");
								else
									System.out.print("|");
							}
							else if (x <= g && x >= c) {
								if (y <= h && y >= d) 
									System.out.print("*");
								else if (y <= d && y >= h)
									System.out.print("*");
								else
									System.out.print("|");
							}
							else {
								System.out.print("|");
							}
						}
						else if ((y - h) * (e - g) == (f - h) * (x - g)) {
							if (x <= e && x >= g) {
								if (y <= h && y >= f) 
									System.out.print("*");
								else if (y <= f && y >= h)
									System.out.print("*");
								else
									System.out.print("|");
							}
							else if (x <= g && x >= e) {
								if (y <= h && y >= f) 
									System.out.print("*");
								else if (y <= f && y >= h)
									System.out.print("*");
								else
									System.out.print("|");
							}
							else
								System.out.print("|");
							
						}
						else {
							System.out.print("|");
						}
					}
					
					
					
					
					else if (y == 0) {
						if (x == 11) {
							System.out.print("x");
						}
						else if ((y - b) * (c - a) == (d - b) * (x - a)) {
							if (x <= c && x >= a) {
								if (y <= b && y >= d) 
									System.out.print("*");
								else if (y <= d && y >= b)
									System.out.print("*");
								else
									System.out.print("-");
							}
							else if (x <= a && x >= c) {
								if (y <= b && y >= d) 
									System.out.print("*");
								else if (y <= d && y >= b)
									System.out.print("*");
								else
									System.out.print("-");
							}
							else {
								System.out.print("-");
							}
						}
						else if ((y - b) * (e - a) == (f - b) * (x - a)) {
							if (x <= e && x >= a) {
								if (y <= b && y >= f) 
									System.out.print("*");
								else if (y <= f && y >= b)
									System.out.print("*");
								else
									System.out.print("-");
							}
							else if (x <= a && x >= e) {
								if (y <= b && y >= f) 
									System.out.print("*");
								else if (y <= f && y >= b)
									System.out.print("*");
								else
									System.out.print("-");
							}
							else {
								System.out.print("-");
							}
							
						}
						else if ((y - h) * (c - g) == (d - h) * (x - g)) {
							if (x <= c && x >= h) {
								if (y <= h && y >= d) 
									System.out.print("*");
								else if (y <= d && y >= h)
									System.out.print("*");
								else
									System.out.print("-");
							}
							else if (x <= g && x >= c) {
								if (y <= h && y >= d) 
									System.out.print("*");
								else if (y <= d && y >= h)
									System.out.print("*");
								else
									System.out.print("-");
							}
							else {
								System.out.print("-");
							}
						}
						else if ((y - h) * (e - g) == (f - h) * (x - g)) {
							if (x <= e && x >= g) {
								if (y <= h && y >= f) 
									System.out.print("*");
								else if (y <= f && y >= h)
									System.out.print("*");
								else
									System.out.print("-");
							}
							else if (x <= g && x >= e) {
								if (y <= h && y >= f) 
									System.out.print("*");
								else if (y <= f && y >= h)
									System.out.print("*");
								else
									System.out.print("-");
							}
							else
								System.out.print("-");
							
						}
						else {
							System.out.print("-");
						}
					}
					
					
					
					else if ((y - b) * (c - a) == (d - b) * (x - a)) {
						if (x <= c && x >= a) {
							if (y <= b && y >= d) 
								System.out.print("*");
							else if (y <= d && y >= b)
								System.out.print("*");
							else
								System.out.print(" ");
						}
						else if (x <= a && x >= c) {
							if (y <= b && y >= d) 
								System.out.print("*");
							else if (y <= d && y >= b)
								System.out.print("*");
							else
								System.out.print(" ");
						}
						else {
							System.out.print(" ");
						}
					}
					else if ((y - b) * (e - a) == (f - b) * (x - a)) {
						if (x <= e && x >= a) {
							if (y <= b && y >= f) 
								System.out.print("*");
							else if (y <= f && y >= b)
								System.out.print("*");
							else
								System.out.print(" ");
						}
						else if (x <= a && x >= e) {
							if (y <= b && y >= f) 
								System.out.print("*");
							else if (y <= f && y >= b)
								System.out.print("*");
							else
								System.out.print(" ");
						}
						else {
							System.out.print(" ");
						}
						
					}
					else if ((y - h) * (c - g) == (d - h) * (x - g)) {
						if (x <= c && x >= h) {
							if (y <= h && y >= d) 
								System.out.print("*");
							else if (y <= d && y >= h)
								System.out.print("*");
							else
								System.out.print(" ");
						}
						else if (x <= g && x >= c) {
							if (y <= h && y >= d) 
								System.out.print("*");
							else if (y <= d && y >= h)
								System.out.print("*");
							else
								System.out.print(" ");
						}
						else {
							System.out.print(" ");
						}
					}
					else if ((y - h) * (e - g) == (f - h) * (x - g)) {
						if (x <= e && x >= g) {
							if (y <= h && y >= f) 
								System.out.print("*");
							else if (y <= f && y >= h)
								System.out.print("*");
							else
								System.out.print(" ");
						}
						else if (x <= g && x >= e) {
							if (y <= h && y >= f) 
								System.out.print("*");
							else if (y <= f && y >= h)
								System.out.print("*");
							else
								System.out.print(" ");
						}
						else
							System.out.print(" ");
						
					}
					
					
					
					else {
						System.out.print(" ");
					}
					
				}
				System.out.println("");
			}
			}
			
			
		}
		else if (info == 4) {
			//Informing the user and getting value
			System.out.println("Parabola formula is y = ax^2 + bx + c");
			System.out.print("Please enter the coefficients a, b and c: ");
			int a = input.nextInt();
			int b = input.nextInt();
			int c = input.nextInt();
			
			//Draw the parabola and graph
			for (int y = 10; y >= -11; y--) {
				for (int x = -10;  x <= 11; x++) {
					if (a*Math.pow(x, 2) + b*x + c == y) {
						System.out.print("*");
					}
					else if (x == 0) {
						if (y == 10)
							System.out.print("y");
						else
							System.out.print("|");
					}
					else if (y == 0) {
						if (x == 11)
							System.out.print("x");
						else
							System.out.print("-");
					}
					
					else {
						System.out.print(" ");
					}
					
				}
				System.out.println("");
			}

			
		}
		else if (info == 5) {
			//Informing the user and getting value
			System.out.println("Circle formula is (x-a)^2 + (y-b)^2 = r^2");
			System.out.print("Please enter the coordinates of the center (a,b) and the radius: ");
			int a = input.nextInt();
			int b = input.nextInt();
			int r = input.nextInt();
			
			//Draw the circle and graph
			for (int y = 10; y >= -11; y--) {
				for (int x = -10;  x <= 11; x++) {
					if (Math.pow((x-a), 2) + Math.pow((y-b), 2) == Math.pow(r, 2)) {
						System.out.print("*");
					}
					else if (x == 0) {
						if (y == 10)
							System.out.print("y");
						else
							System.out.print("|");
					}
					else if (y == 0) {
						if (x == 11)
							System.out.print("x");
						else
							System.out.print("-");
					}
					
					else {
						System.out.print(" ");
					}
					
				}
				System.out.println("");
			}
			
		}
		else if (info == 6) {
			System.exit(0);
		}
		}
	}

}
