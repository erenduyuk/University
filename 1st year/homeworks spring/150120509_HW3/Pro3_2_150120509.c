
//Eren Duyuk 150120509
/*this program calculates super digit
Super digit is if X has only 1 digit, then its super digit is X.
If X has more than 1 digit, then its super digit is equal to the super digit of the digit-sum of X.*/

#include <stdio.h>

int n, k, result, count = 0, sum = 0;
void superDigit(int number, int repetition);
void toString(int repeat);

int main(void)
{
	printf("Please enter a number (n=) : ");
	//get input from user
	scanf("%d", &n);
	printf("Please enter repetition factor (k=) : ");
	scanf("%d", &k);
	printf("Super digit of number ");
	//run the functions
	superDigit(n, k);
	toString(k);
	printf(" is %d.", result);
}

//this function calculates super digit
void superDigit(int number, int repetition)
{
	if(number != 0) {
		sum += (number % 10) * repetition;
		number /= 10;
		superDigit(number, repetition);
	}
	repetition = 1;
	if(sum >= 10) {
		number = sum;
		sum = 0;
		superDigit(number, repetition);
	}
	else {
		result = sum;
	}
	
}
//this function prints the output
void toString(int repeat)
{
	if(repeat != 0) {
		printf("%d", n);
		repeat--;
		toString(repeat);
	}
}
