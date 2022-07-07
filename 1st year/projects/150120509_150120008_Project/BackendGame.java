// Eren Çetin 150120008
// Eren Duyuk 150120509
// The purpose of this program is to include methods that allow the game to run in the background.
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


public class BackendGame {

	private InfoNode[][] backendGame;
	private ArrayList<String> nextMoveOfBall = new ArrayList<>();
	
	// Constructor of BackendGame
	public BackendGame() {
		backendGame = new InfoNode[4][4];
	}
	
	// This method reads the information of the cells on the game board from the input file and assigns these values to them.
	public void createBackend(String fileName)  {
				
		String line;
		int x = 0;
		int y = 0;
		
		try(BufferedReader br = new BufferedReader(new FileReader(fileName))) {
			
			while((line = br.readLine()) != null) {
				if(line.length() == 0) {
					continue;
				}
				else {
				String[] lineArray = line.split(",");
				InfoNode infoNode = new InfoNode(Integer.parseInt(lineArray[0]),lineArray[1],lineArray[2]);
				backendGame[x][y] = infoNode;
				y++;
				if(y >= 4) {
					x++;
					y = 0;
				}
				if(y > 4 || x > 4) {
					throw new ArrayIndexOutOfBoundsException();
				}
			}
		}
	}
		catch(NumberFormatException ex) {
			ex.printStackTrace();
		}
		catch(ArrayIndexOutOfBoundsException ex) {
			ex.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {			
			e.printStackTrace();
		}
				
	}
	
	// Check its movable based on the distance between cell x0 and y0 and cell x1 and y1
	public boolean isMoveable(int x0 ,int y0, int x1, int y1) {
		
		return (Math.abs(x0-x1)==1 && Math.abs(y0-y1)==0)||(Math.abs(y0-y1)==1 && Math.abs(x0-x1)==0);					
	}
	
	// This method replaces the cell at x0 and y0 and the cell at x1 and y1
	public void moveInfoCell(int x0,int y0,int x1,int y1) {
		InfoNode temp = backendGame[x0][y0];
		backendGame[x0][y0] = backendGame[x1][y1];
		backendGame[x1][y1] = temp;
	}
	
	// This method checks that the player has connected the pipes correctly
	public boolean checkSolution() {
		
		// Everything in the list must be removed otherwise all paths will merge
		nextMoveOfBall.removeAll(getNextMoveOfBall());
		int x0 = 0;
		int y0 = 0;
		int x1 = 0;
		int y1 = 0;
		
		// Finds the starter cell and the next cell
		for(int i = 0 ; i < backendGame.length ; i++) {
			for(int j = 0; j < backendGame[i].length ; j++) {
				if(backendGame[i][j].getType().equals("Starter")) {
					x0 = i;
					y0 = j;
					break;
				}			}		}
		if(backendGame[x0][y0].getProperty().equals("Vertical")) {
			x1 = x0 + 1;
			y1 = y0;
			nextMoveOfBall.add("down");
		}
		else {
			x1 = x0;
			y1 = y0 - 1;
			nextMoveOfBall.add("left");
		}	
		
		// Returns true if pipes are connected correctly and end cell is reached, otherwise returns false
		while(true) {
			InfoNode current = backendGame[x1][y1];
			// The if block that determines the type of cell
			if (current.getType().equals("End")) {
				if (current.getProperty().equals("Vertical") && x1 < x0) {
					return true;
				}
				else if (current.getProperty().equals("Horizontal") && y1 > y0) {
					return true;
				}
				else
					return false;
			}
			else if (current.getType().equals("Pipe") || current.getType().equals("PipeStatic")) {
				if (current.getProperty().equals("Vertical")) {
					// If block determining which direction the ball is coming from
					if (x1 > x0) {
						x0 = x1;
						y0 = y1;
						current = backendGame[x1+1][y1];
						x1++;
						// Adds the direction the ball will go to the list
						nextMoveOfBall.add("down");
					}
					else if (x1 < x0) {
						x0 = x1;
						y0 = y1;
						current = backendGame[x1-1][y1];
						x1--;
						nextMoveOfBall.add("up");
					}
				}
				else if (current.getProperty().equals("Horizontal")) {
					if (y1 > y0) {
						x0 = x1;
						y0 = y1;
						current = backendGame[x1][y1+1];
						y1++;
						nextMoveOfBall.add("right");
					}
					else if (y1 < y0) {
						x0 = x1;
						y0 = y1;
						current = backendGame[x1][y1-1];
						y1--;
						nextMoveOfBall.add("left");
					}
				}
				else if (current.getProperty().equals("00")) {
					if (x1 > x0) {
						x0 = x1;
						y0 = y1;
						current = backendGame[x1][y1-1];
						y1--;
						nextMoveOfBall.add("left");
					}
					else if (x1 == x0) {
						x0 = x1;
						y0 = y1;
						current = backendGame[x1-1][y1];
						x1--;
						nextMoveOfBall.add("up");
					}
				}
				else if (current.getProperty().equals("01")) {
					if (x1 > x0) {
						x0 = x1;
						y0 = y1;
						current = backendGame[x1][y1+1];
						y1++;
						nextMoveOfBall.add("right");
					}
					else if (x1 == x0) {
						x0 = x1;
						y0 = y1;
						current = backendGame[x1-1][y1];
						x1--;
						nextMoveOfBall.add("up");
					}
				}
				else if (current.getProperty().equals("10")) {
					if (x0 == x1) {
						x0 = x1;
						y0 = y1;
						current = backendGame[x1+1][y1];
						x1++;
						nextMoveOfBall.add("down");
					}
					else if (x1 < x0) {
						x0 = x1;
						y0 = y1;
						current = backendGame[x1][y1-1];
						y1--;
						nextMoveOfBall.add("left");
					}
				}
				else if (current.getProperty().equals("11")) {
					if (x0 > x1) {
						x0 = x1;
						y0 = y1;
						current = backendGame[x1][y1+1];
						y1++;
						nextMoveOfBall.add("right");
					}
					else if (x1 == x0) {
						x0 = x1;
						y0 = y1;
						current = backendGame[x1+1][y1];
						x1++;
						nextMoveOfBall.add("down");
					}
				}
			}
			else
				return false;
		}
		
		
	}
	
	// Checks the movable of cell x0 and y0 and cell x1 and y1
	public boolean isLegal(int x0,int y0, int x1, int y1) {
		if(backendGame[x0][y0].getType().equals("Starter")||backendGame[x0][y0].getType().equals("End")||backendGame[x0][y0].getType().equals("PipeStatic")||backendGame[x0][y0].getProperty().equals("Free")||(backendGame[x0][y0].getType().equals("Pipe") && backendGame[x1][y1].getProperty().equals("none"))||(backendGame[x0][y0].getProperty().equals("none") && backendGame[x1][y1].getType().equals("Pipe"))||(backendGame[x0][y0].getProperty().equals("none") && backendGame[x1][y1].getProperty().equals("none"))||(backendGame[x0][y0].getType().equals("Pipe") && backendGame[x1][y1].getType().equals("Pipe"))||(backendGame[x0][y0].getProperty().equals("none") &&backendGame[x1][y1].getType().equals("End"))||(backendGame[x0][y0].getType().equals("Pipe")&&backendGame[x1][y1].getType().equals("End"))) {
			return false;
		}
		else {
			return true;
		}
	}
	public InfoNode[][] getBackendGame() {
		return backendGame;
	}

	public void setBackendGame(InfoNode[][] backendGame) {
		this.backendGame = backendGame;
	}
	public ArrayList<String> getNextMoveOfBall() {
		return nextMoveOfBall;
	}

	public void setNextMoveOfBall(ArrayList<String> nextMoveOfBall) {
		this.nextMoveOfBall = nextMoveOfBall;
	}
	
	
}