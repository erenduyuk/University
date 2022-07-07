// Eren Çetin 150120008
// Eren Duyuk 150120509
// The purpose of the program is that create pipe-puzzle game with the help of backendGame properties and display of that game on screen
import javafx.animation.PathTransition;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.scene.shape.HLineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.VLineTo;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;
import java.util.ArrayList;

public class Game extends Application {
	
	private Rectangle[][] rectangle;
	private GridPane boardPane;
	private BackendGame backendGame;
	private int x0;
	private int y0;
	private int level;
	private int moveCount;
	private ArrayList<Button> buttons;
	private String[] levelDesign;
	private Scene menuScene;
	private Scene gameScene;
	private Text showMoveCount;
	private Text situation;
	private Circle ball;
	
	// Override start method for displaying our game on screen
	public void start(Stage primaryStage) {
		buttons = new ArrayList<>();
		levelDesign = new String[] {"level1.txt","level2.txt","level3.txt","level4.txt","level5.txt","level6.txt"};
		ball = new Circle();
		backendGame = new BackendGame();
		boardPane = new GridPane();
		rectangle = new Rectangle[4][4];
		// Create each rectangle shape defaultly and add each rectangle to the boardPane
		for(int i = 0; i < rectangle.length ; i++) {
			for(int j = 0; j < rectangle[i].length ; j++) {
				rectangle[i][j] = new Rectangle(150,150,Color.WHITE);
				boardPane.add(rectangle[i][j], j, i);
			}
		}
		Button level1 = new Button("Play Level 1");
		buttons.add(level1);
		Button level2 = new Button("Play Level 2");
		buttons.add(level2);
		Button level3 = new Button("Play Level 3");
		buttons.add(level3);
		Button level4 = new Button("Play Level 4");
		buttons.add(level4);
		Button level5 = new Button("Play Level 5");
		buttons.add(level5);
		Button level6 = new Button("Play Level 6");
		buttons.add(level6);
		Button nextPuzzle = new Button("nextPuzzle");
		showMoveCount = new Text();		
		situation = new Text();
		// Declare and create Vbox object for nextPuzzle button, showMoveCount text, and situation text
		VBox vbox = new VBox(20);		
		vbox.getChildren().addAll(nextPuzzle,showMoveCount,situation);
		// Declare and create Pane object for boardPane and ball
		Pane pane = new Pane();
		pane.getChildren().addAll(boardPane,ball);
		// Declare and create Hbox object for pane and vbox.
		HBox hbox = new HBox(50);
		hbox.getChildren().addAll(pane,vbox);
		// Add hbox to the gameScene
		gameScene = new Scene(hbox);
		// SetOnAction event for each button in the buttons ArrayList
		for(int i = 0; i <buttons.size() ; i++) {
			int index = i;
			// Set scene according to button 
			buttons.get(i).setOnAction(a -> {
				 level = index + 1;
				 moveCount = 0;
				 backendGame.createBackend(levelDesign[index]);
				 setBall(levelDesign[index]);
				 createGridPane();
				 showMoveCount.setText("NumberofMoves:\n" + moveCount);
				 situation.setText("Solve Level " + level);
				 primaryStage.setTitle("The Pipe-Puzzle Game Level " + (index + 1));
				 primaryStage.setScene(gameScene);
				 primaryStage.setResizable(false);
			});
		}
		// SetOnAction event for nextPuzzle button
		nextPuzzle.setOnAction( a -> {
			// Check whether pipes connect each other properly from the start point to the end point
			if(backendGame.checkSolution()) {
				// If the last level is solved, back to the first level
				if(level >= 6) { 				
					PathTransition pt  = displayAnimation();
					pt.play(); 
					pt.setOnFinished(b -> {
						// After animation finish, set scene according to the first level
						level = 1;
						moveCount = 0;
						backendGame.createBackend(levelDesign[level - 1]);
						setBall(levelDesign[level -1]);
						createGridPane();
						showMoveCount.setText("NumberofMoves:\n" + moveCount);
						situation.setText("Solve Level " + level);
						primaryStage.setTitle("The Pipe-Puzzle Game Level " + level );
						primaryStage.setScene(gameScene);
						primaryStage.setResizable(false);
					});
				}
				else {
					PathTransition pt  = displayAnimation();
					pt.play(); 
					pt.setOnFinished(b -> {
						// After animation finish, set scene according to the next level
						level++;
						moveCount = 0;
						backendGame.createBackend(levelDesign[level - 1]);
						setBall(levelDesign[level -1]);					
						createGridPane();
						showMoveCount.setText("NumberofMoves:\n" + moveCount);
						situation.setText("Solve Level " + level);
						primaryStage.setTitle("The Pipe-Puzzle Game Level " + level );
						primaryStage.setScene(gameScene);
						primaryStage.setResizable(false);
					});
				}
			}
			else {
				moveCount = 0;
				situation.setText("There must be a problem\nwith your solution\nTry Again!");
				showMoveCount.setText("NumberofMoves:\n" + moveCount);
			}
		});   
						
		// Declare and create BorderPane object for menuScene
		BorderPane borderPane = new BorderPane();
		Text title = new Text("The Pipe-Puzzle Game");
		title.setFont(Font.font("Arial Black",FontWeight.BLACK, FontPosture.ITALIC, 15));
		borderPane.setTop(title);
		BorderPane.setAlignment(title,Pos.CENTER);		
		HBox allButton =  new HBox(20);
		// Add buttons ArrayList to the hbox
		allButton.getChildren().addAll(buttons);
		borderPane.setCenter(allButton);
		// Ad borderPane to the menuScene
		menuScene = new Scene(borderPane);
		primaryStage.setScene(menuScene);
		primaryStage.setResizable(false);
		primaryStage.show();  		
				 
	}
	// Create GridPane according to array which is belong to backendGame object and determine which rectangles are moveable and are free to drop moveable rectangles
	public void createGridPane() {
		for(int i = 0; i < backendGame.getBackendGame().length ; i++) {
			for(int j = 0; j < backendGame.getBackendGame()[i].length ; j++ ) {
				String type = backendGame.getBackendGame()[i][j].getType();
				String property = backendGame.getBackendGame()[i][j].getProperty();
				Image temp;
				if(type.equals("Pipe")) {
					if(property.equals("Vertical")) {
						temp = new Image("VerticalPipe.png"); 
						rectangle[i][j].setFill(new ImagePattern(temp,0,0,150,150,false));
					}
					else if(property.equals("Horizontal")) { 
						temp = new Image("HorizontalPipe.png");
						rectangle[i][j].setFill(new ImagePattern(temp,0,0,150,150,false));
					}
					else if(property.equals("00")) { 
						temp = new Image("CurvedPipe00.png");
						rectangle[i][j].setFill(new ImagePattern(temp,0,0,150,150,false));
					}
					else if(property.equals("01")) { 
						temp = new Image("CurvedPipe01.png");
						rectangle[i][j].setFill(new ImagePattern(temp,0,0,150,150,false));
					}
					else if(property.equals("10")) { 
						temp = new Image("CurvedPipe10.png");
						rectangle[i][j].setFill(new ImagePattern(temp,0,0,150,150,false));
					}
					else { 
						temp = new Image("CurvedPipe11.png");
						rectangle[i][j].setFill(new ImagePattern(temp,0,0,150,150,false));
					}				}
				else if(type.equals("PipeStatic")) {
					if(property.equals("Vertical")) {  
						temp = new Image("VerticalPipeStatic.png");
						rectangle[i][j].setFill(new ImagePattern(temp,0,0,150,150,false));
					}
					else if(property.equals("Horizontal")) {  
						temp = new Image("HorizontalPipeStatic.png");
						rectangle[i][j].setFill(new ImagePattern(temp,0,0,150,150,false));
					}
					else if(property.equals("00")) { 
						temp = new Image("CurvedPipeStatic00.png");
						rectangle[i][j].setFill(new ImagePattern(temp,0,0,150,150,false));
					}
					else if(property.equals("01")) { 
						temp = new Image("CurvedPipeStatic01.png");
						rectangle[i][j].setFill(new ImagePattern(temp,0,0,150,150,false));
					}
					else if(property.equals("10")) {
						temp = new Image("CurvedPipeStatic10.png");
						rectangle[i][j].setFill(new ImagePattern(temp,0,0,150,150,false));
					}
					else { 
						temp = new Image("CurvedPipeStatic11.png");
						rectangle[i][j].setFill(new ImagePattern(temp,0,0,150,150,false));
					}				}
				else if(type.equals("Empty")) {
					if(property.equals("none")) { 
						temp = new Image("Empty.png");
						rectangle[i][j].setFill(new ImagePattern(temp,0,0,150,150,false));
					}
					else {  
						temp = new Image("EmptyFree.png");
						rectangle[i][j].setFill(new ImagePattern(temp,0,0,150,150,false));
					}				}
				else if(type.equals("Starter")) {
					if(property.equals("Vertical")) { 
						temp = new Image("VerticalStarter.png");
						rectangle[i][j].setFill(new ImagePattern(temp,0,0,150,150,false));
					}
					else { 
						temp = new Image("HorizontalStarter.png");
						rectangle[i][j].setFill(new ImagePattern(temp,0,0,150,150,false));
					}				}
				else if(type.equals("End")) {
					if(property.equals("Vertical")) { 
						temp = new Image("VerticalPipeEnd.png");
						rectangle[i][j].setFill(new ImagePattern(temp,0,0,150,150,false));
					}
					else { 
						temp = new Image("HorizontalPipeEnd.png");
						rectangle[i][j].setFill(new ImagePattern(temp,0,0,150,150,false));
					}					}			}		}
		
		for(int i = 0; i < backendGame.getBackendGame().length ; i++) {
			for(int j = 0; j < backendGame.getBackendGame()[i].length ; j++) {
				String type = backendGame.getBackendGame()[i][j].getType();
				String property = backendGame.getBackendGame()[i][j].getProperty();
				if(type.equals("Pipe")) {
					setDraggable(rectangle[i][j]);
				}
				else if(type.equals("Empty") && property.equals("none")) {
					setDraggable(rectangle[i][j]);
				}
				else if(type.equals("Empty") && property.equals("Free")) {
					setFree(rectangle[i][j]);				
					}			}		}
		
		
		
	}
	// Set "setOnDragDetected" event on the passed Rectangle object
	public void setDraggable(Rectangle rect) {
		rect.setOnDragDetected(e -> {		
			 x0 = 0;
			 y0 = 0;
			Rectangle temp = (Rectangle) e.getSource();
			for(int i = 0; i < rectangle.length ; i++) {
				for(int j = 0; j < rectangle[i].length ; j++) {
					if(rectangle[i][j].equals(temp)) {
						x0 = i;
						y0 = j;
						break;
					}				}			}
			// We use startFullDrag method to determine coordinates of rectangle which is free to drop moveable rectangle
			rect.startFullDrag();
			e.consume();
		});
	}
	// Set "setOnMouseDragReleased" event on the passed Rectangle object and complete replacement process if it is possible
	public void setFree(Rectangle rect) {
		rect.setOnMouseDragReleased(e -> {
			int x1 = 0;
			int y1 = 0;
			Rectangle temp = (Rectangle) e.getSource();
			for(int i = 0; i < rectangle.length ; i++) {
				for(int j = 0; j <rectangle[i].length ; j++) {
					if(rectangle[i][j].equals(temp)) {
						x1 = i;
						y1 = j;
						break;
					}				}			}
			if(backendGame.isLegal(x0, y0, x1, y1)) {
				if(backendGame.isMoveable(x0, y0, x1, y1)) {
					backendGame.moveInfoCell(x0, y0, x1, y1);
					exchangeRectangle(x0,y0,x1,y1);
			}
		}
		});
   }
	// Exchange Rectangle objects on boardPane and exchange also contents of them 
	private void exchangeRectangle(int x0,int y0, int x1, int y1) {
		boardPane.getChildren().remove(rectangle[x0][y0]);
		boardPane.getChildren().remove(rectangle[x1][y1]);
		boardPane.add(rectangle[x0][y0], y1, x1);
		boardPane.add(rectangle[x1][y1], y0, x0);
		Rectangle copy = rectangle[x0][y0];
        rectangle[x0][y0] = rectangle[x1][y1];
        rectangle[x1][y1] = copy;
        setMoveCount(moveCount + 1);
        showMoveCount.setText("NumberofMoves:\n" + moveCount);
	}
	// Set beginning coordinates in the pane and radius of ball according to levelDesign
	public void setBall(String level) {		
		for(int i = 0; i <backendGame.getBackendGame().length ; i++) {  
			for(int j = 0; j <backendGame.getBackendGame()[i].length ; j++) {
				String type = backendGame.getBackendGame()[i][j].getType();
				if(type.equals("Starter")) {
					ball.setCenterX(75 + (150*j));  
					ball.setCenterY(75 + (150 *i));  
					ball.setRadius(24);
					Image temp;				
					temp = new Image("Ball.png");
					ball.setFill(new ImagePattern(temp));					
				}						            
			}  										
		}  											
	}
	public void setMoveCount(int moveCount) {
		this.moveCount = moveCount;
	}
	// Declare and create PathTransition object and set Duration, Path, Node, and CycleCount properties 
	public PathTransition displayAnimation() {  	 
		PathTransition pt = new PathTransition();
		pt.setDuration(Duration.millis(4000));
		pt.setPath(setPathOfBall());
		pt.setNode(ball);
		pt.setCycleCount(1);
		
		return pt;
	}
	// Set path of Ball according to nextMoveOfBall ArrayList which is belong to BackendGame object
	public Path setPathOfBall() {
		Path pathOfBall = new Path();
		pathOfBall.getElements().add(new MoveTo(ball.getCenterX(), ball.getCenterY()));
		for(String moveOfBall: backendGame.getNextMoveOfBall()) {
			if(moveOfBall.equals("up")) {
				pathOfBall.getElements().add(new VLineTo(ball.getCenterY() - 150));
				ball.setCenterY(ball.getCenterY() - 150);
			}
			else if(moveOfBall.equals("down")) {
				pathOfBall.getElements().add(new VLineTo(ball.getCenterY() + 150));
				ball.setCenterY(ball.getCenterY() + 150);
			}
			else if(moveOfBall.equals("right")) {
				pathOfBall.getElements().add(new HLineTo(ball.getCenterX() + 150));
				ball.setCenterX(ball.getCenterX() + 150);
			}
			else if(moveOfBall.equals("left")) {
				pathOfBall.getElements().add(new HLineTo(ball.getCenterX() - 150));
				ball.setCenterX(ball.getCenterX() - 150);
			}
		}
		return pathOfBall;
	}
	public static void main(String[] args) {
		launch(args);
	}
}