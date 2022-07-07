
//Eren Duyuk 150120509
/*The purpose of this program is to print sierpinski triangles according to the given input.*/



#include <stdio.h>
#include <math.h>

void toString(int splitedLine);
int columnsMinus = 32, columnsPlus = 32, numberOfRow = 1, splitedLine;
int row = 1, column = 1;

int main(void)
{
	int i, splitedLine;
	printf("Enter the number of iterations: ");
	//get input from user
	scanf("%d", &i);
	splitedLine = pow(2, i);
	//run the function
	toString(splitedLine);	
}

//this function prints triangles
void toString(int splitedLine)
{
		if(row != 33) {
			//if here is end of column
	 		if(column == 64) {
				column = 1;
				row++;
				if(row != 33) {
					printf("\n");
					columnsPlus++;
	 				columnsMinus--;	
				}
			}
			//prints 1 if it needs to print
	 		if(columnsMinus <= column && column <= columnsPlus) {
	 			printf("1");
	 			column++;
	 			toString(splitedLine);
			 }
			 else {
	 			printf("_");
	 			column++;
	 			toString(splitedLine);
	 		}
		}
}
