
//Eren Duyuk 150120509
/*The purpose of this program is to calculate the total number of ears of rabbits 
in a line. Sequence number is 2 ears if single, 3 ears if double*/


#include <stdio.h>

int numberOfEars = 0;
int line = 0;
int calculateEars(int n);

int main()
{
	int n;
	printf("Please enter the number of lines (n=): ");
	//get input from user
	scanf("%d", &n);
	//run the function
	return calculateEars(n);	
}

//this function calculates the number of ears
int calculateEars(int n)
{
	//prints the first output
	if(line == 0) {
		printf("bunnyEars%d(0) -> 0\n", n);
		line++;
		calculateEars(n);
	}
	//It checks whether the row is odd or even and adds the number of ears to the total number of ears accordingly. It also prints the outputs
	else if(line <= n) {
		if(line % 2 == 0) {
			numberOfEars += 3;
			printf("bunnyEars%d(%d) -> %d\n", n, line, numberOfEars);
			line++;
			calculateEars(n);
		}
		else if(line % 2 == 1) {
			numberOfEars += 2;
			printf("bunnyEars%d(%d) -> %d\n", n, line, numberOfEars);
			line++;
			calculateEars(n);
		}
	}
	return numberOfEars;
}

