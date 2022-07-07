//Eren Duyuk 150120509
/*The purpose of this program is to define the metro system and to create 
the shortest route from the user's location to the target location in this metro system.*/


#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <Math.h>
#define SIZE 10

//creating structures
struct MetroStation {
	char name[20];
	double x;
	double y;
};
typedef struct MetroStation MetroStation;

struct MetroLine {
	char color[20];
	MetroStation MetroStations[SIZE];
};
typedef struct MetroLine MetroLine;

struct MetroSystem {
	char name[20];
	MetroLine MetroLines[SIZE];	
};
typedef struct MetroSystem MetroSystem;

//functions body
int equals(MetroStation s1, MetroStation s2);
void addStation(MetroLine *line, MetroStation station);
int hasStation(MetroLine line, MetroStation station);
MetroStation getFirstStop(MetroLine line);
MetroStation getPreviousStop(MetroLine line, MetroStation station);
MetroStation getNextStop(MetroLine line, MetroStation station);
void addLine(MetroSystem *system, MetroLine line);
void printLine(MetroLine line);
void printPath(MetroStation stations[]);
double getDistanceTravelled(MetroStation stations[]);
MetroStation findNearestStation(MetroSystem system, double x, double y);
void getNeighboringStations(MetroSystem system, MetroStation station, MetroStation neigboringStations[]);
void findPath(MetroStation start, MetroStation finish, MetroStation path[]);
void recursiveFindPath(MetroStation start, MetroStation finish, MetroStation partialPath[], MetroStation bestPath[]);
int containArray(MetroStation station, MetroStation stations[]);

//Declare a MetroSystem with the name of istanbul and an empty content.
MetroSystem istanbul = {"istanbul", '\0'};

int main(void)
{
int i;
	double myX=1, myY=2; 
	double goalX=62, goalY=45; 
	
	// define 3 metro lines, 9 metro stations, and an empty myPath
	MetroLine red={'\0'}, blue={'\0'}, green={'\0'};
	MetroStation s1, s2, s3, s4, s5, s6, s7, s8, s9;
	MetroStation myPath[SIZE]={'\0'};
	
	strcpy(red.color, "red"); 
	strcpy(blue.color, "blue");
	strcpy(green.color, "green");

	
	strcpy(s1.name, "Haydarpasa"); 		s1.x=0; 	s1.y=0;
	strcpy(s2.name, "Sogutlucesme"); 	s2.x=10; 	s2.y=5;
	strcpy(s3.name, "Goztepe"); 		s3.x=20; 	s3.y=10;
	strcpy(s4.name, "Kozyatagi"); 		s4.x=30; 	s4.y=35;
	strcpy(s5.name, "Bostanci"); 		s5.x=45; 	s5.y=20;
	strcpy(s6.name, "Kartal"); 			s6.x=55; 	s6.y=20;
	strcpy(s7.name, "Samandira"); 		s7.x=60; 	s7.y=40;
	strcpy(s8.name, "Icmeler"); 		s8.x=70; 	s8.y=15;
	
	//Add several metro stations to the given metro lines.
	addStation(&red, s1); addStation(&red, s2); addStation(&red, s3); addStation(&red, s4); addStation(&red, s5); addStation(&red, s8);
	
	addStation(&blue, s2); addStation(&blue, s3); addStation(&blue, s4); addStation(&blue, s6); addStation(&blue, s7);
	
	addStation(&green, s2); addStation(&green, s3); addStation(&green, s5); addStation(&green, s6); addStation(&green, s8);
	
	// Add red, blue, green metro lines to the Istanbul metro system.
	addLine(&istanbul, red);
	addLine(&istanbul, blue);
	addLine(&istanbul, green);
	
	// print the content of the red, blue, green metro lines
	printLine(red);
	printLine(blue);
	printLine(green);
		
		
	// find the nearest stations to the current and target locations
	MetroStation nearMe = findNearestStation(istanbul, myX, myY);
	MetroStation nearGoal = findNearestStation(istanbul, goalX, goalY);
	
	printf("\n");
	
	printf("The best path from %s to %s is:\n", nearMe.name, nearGoal.name);
	
	// if the nearest current and target stations are the same, then print a message and exit.
	if(equals(nearMe, nearGoal)){
		printf("It is better to walk!\n");
		return 0;
	}
	
	// Calculate and print the myPath with the minimum distance travelled from start to target stations.
	findPath(nearMe, nearGoal, myPath);
	
	if(strlen(myPath[0].name) == 0)
		printf("There is no path on the metro!\n");
	else{
		printPath(myPath);
	}
	
	return 0;
}

//checks if two stations are the same
int equals(MetroStation s1, MetroStation s2)
{
	if(strcmp(s1.name, s2.name) == 0) 
		return 1;
	else
		return 0;
}

//Adds the metro station to the metro line
void addStation(MetroLine *line, MetroStation station)
{
	int i;
	for(i = 0; i < SIZE; i++) {
		if(strcmp(line->MetroStations[i].name, "\0") == 0) {
			line->MetroStations[i] = station;
			break;
		}
	}
}

//Checks whether the given station exists on the given metro line
int hasStation(MetroLine line, MetroStation station) 
{
	int i;
	for(i = 0; i < SIZE; i++) {
		if(strcmp(line.MetroStations[i].name, station.name) == 0)
			return 1;
		else
			return 0;
	}
}

//Returns the first stop of the metro line
MetroStation getFirstStop(MetroLine line)
{
	if(strcmp(line.MetroStations[0].name, "\0") != 0)
		return line.MetroStations[0];
	else {
		MetroStation emptyStation = {'\0'};
		return emptyStation;
	}
}

//the previous stop from the given station on the given metro line
MetroStation getPreviousStop(MetroLine line, MetroStation station)
{
	int i;
	for(i = 0; i < SIZE; i++) {
		if(strcmp(line.MetroStations[i].name, station.name) == 0) {
			if(i != 0) {
				return line.MetroStations[i-1];
			}
			else if(i == 0) {
				MetroStation emptyStation = {'\0'};
				return emptyStation;
			}
		}
		
	}
}

//the next stop from the given station on the given metro line
MetroStation getNextStop(MetroLine line, MetroStation station)
{
	int i;
	for(i = 0; i < SIZE; i++) {
		if(strcmp(line.MetroStations[i].name, station.name) == 0) {
			if(strcmp(line.MetroStations[i+1].name, "\0") == 0) {
				MetroStation emptyStation = {'\0'};
				return emptyStation;
			}
			else {
				return line.MetroStations[i+1];
			}
		}
	}
}

//Adds the metro line to the metro system
void addLine(MetroSystem *system, MetroLine line)
{
	int i;
	for(i = 0; i < SIZE; i++) {
		if(strcmp(system->MetroLines[i].color, "\0") == 0) {
			system->MetroLines[i] = line;
			break;
		}
	}	
}

//prints the given metro line to the console
void printLine(MetroLine line)
{
	printf("Metroline %s:", line.color);
	int i;
	for(i = 0; i < SIZE; i++) {
		if(strcmp(line.MetroStations[i].name, "\0") != 0) {
			printf(" %s", line.MetroStations[i].name);
		}
	}
	printf(".\n");
}

//prints the given path to the console
void printPath(MetroStation stations[])
{
	int i;
	for(i = 0; i < SIZE; i++) {
		if(strcmp(stations[i].name, "\0") != 0) {
			printf("%d. %s\n", i+1, stations[i].name);
		}
	}
}

//Calculates the length of the given path
double getDistanceTravelled(MetroStation stations[])
{
	int i;
	double totalDistance = 0;
	for(i = 1; i < SIZE; i++) {
		if(strcmp(stations[1].name, "\0") == 0) {
			return 0;
		}
		else if (strcmp(stations[i].name, "\0") != 0) {
			totalDistance += sqrt(pow(stations[i].x - stations[i-1].x, 2) + pow(stations[i].y - stations[i-1].y, 2));
		}
	}
	return totalDistance;
}

//Returns the nearest station to the given coordinates in the given metro system
MetroStation findNearestStation(MetroSystem system, double x, double y)
{
	int i, j, lineNumber = 0, stationNumber = 0;
	double distance = sqrt(pow(system.MetroLines[0].MetroStations[0].x - x, 2) + pow(system.MetroLines[0].MetroStations[0].y - y, 2));
	for(i = 0; i < SIZE; i++) {
		for(j = 0; j < SIZE; j++) {
			if(strcmp(system.MetroLines[i].MetroStations[j].name, "\0") != 0) {
				if(sqrt(pow(system.MetroLines[i].MetroStations[j].x - x, 2) + pow(system.MetroLines[i].MetroStations[j].y - y, 2)) < distance) {
					distance = sqrt(pow(system.MetroLines[i].MetroStations[j].x - x, 2) + pow(system.MetroLines[i].MetroStations[j].y - y, 2));
					lineNumber = i;
					stationNumber = j;
				}
			}
			
		}
	}
	return system.MetroLines[lineNumber].MetroStations[stationNumber];
}

//fills the stations adjacent to the given station into the given array
void getNeighboringStations(MetroSystem system, MetroStation station, MetroStation neigboringStations[])
{
	int i,j,m,k = 0;
	for(i = 0; i < SIZE; i++) {
		for(j = 0; j < SIZE; j++) {
			if(strcmp(system.MetroLines[i].MetroStations[j].name, station.name) == 0) {
				if(j == 0 && !containArray(system.MetroLines[i].MetroStations[j+1], neigboringStations)) { 
					neigboringStations[k] = system.MetroLines[i].MetroStations[j+1];
					k++;
					
				}
				else if(strcmp(system.MetroLines[i].MetroStations[j+1].name, "\0") == 0 && !containArray(system.MetroLines[i].MetroStations[j-1], neigboringStations)) {
						neigboringStations[k] = system.MetroLines[i].MetroStations[j-1];
						k++;
				}
				else {
					if(!containArray(system.MetroLines[i].MetroStations[j-1], neigboringStations)) {
						neigboringStations[k] = system.MetroLines[i].MetroStations[j-1];
						k++;
					}
					if(!containArray(system.MetroLines[i].MetroStations[j+1], neigboringStations)) {
						neigboringStations[k] = system.MetroLines[i].MetroStations[j+1];
						k++;
					}
						
				}
		}
	}
}
}

//
void findPath(MetroStation start, MetroStation finish, MetroStation path[])
{
	MetroStation partialPath[SIZE] = {'\0'};
	recursiveFindPath(start, finish, partialPath, path);
}

//
void recursiveFindPath(MetroStation start, MetroStation finish, MetroStation partialPath[], MetroStation bestPath[])
{
	int i;
	for (i = 0; i < SIZE; i++) {
    	if (equals(partialPath[i], start))
           return;
   	}
	if(equals(start, finish)) {
		for (i = 0; i < SIZE; i++) {
           if (strcmp(partialPath[i].name, "\0") == 0) {
               partialPath[i] = finish;
               break;
           }
       }
		int j;
		if(getDistanceTravelled(partialPath) < getDistanceTravelled(bestPath) || getDistanceTravelled(bestPath) == 0) {
			for(j = 0; j < SIZE; j++) {
			bestPath[j] = partialPath[j];
		}
		return;
		}
		}
		
	
	MetroStation neighbors[SIZE] = {'\0'};
	getNeighboringStations(istanbul, start, neighbors);
			
	int n;
	for(n = 0; n < SIZE; n++) {
		MetroStation duplicatePath[SIZE] = {'\0'};
		int k;
		for(k = 0; k < SIZE; k++) {
			duplicatePath[k] = partialPath[k];
		}
		int m;
		for(m = 0; m < SIZE; m++) {
			if(strcmp(duplicatePath[m].name, "\0") == 0) {
				duplicatePath[m] = start;
				break;
			}
		}
		if(strcmp(neighbors[n].name, "\0") != 0) {
			recursiveFindPath(neighbors[n], finish, duplicatePath, bestPath);
		}		
	}
		
}

//
int containArray(MetroStation station, MetroStation stations[])
{
	int i,result = 0;
	for(i = 0; i < SIZE; i++) {
		if(strcmp(stations[i].name, station.name) == 0) {
			result = 1;
		}
	}
	return result;
}


