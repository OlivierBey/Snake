package snake;


import java.security.PublicKey;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Timer;
import java.util.TimerTask;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;


public class Controller {
	int x ,y;
	int length = 3;
	private Node[][] setsquares= new Node[15][13];
	ArrayList<Node> snakeBlocks= new ArrayList<>();
	private boolean goNorth= false, goSouth= false, goEast= true, goWest= false;
	
	
	
	 public void initialize() {
		 
		createfield();
		setsnake();
		
	}

    private void setsnake() {
    	for (int i = 0; i < length; i++) {
    		Rectangle rect= (Rectangle) setsquares[i][0];
    		y=0; x=i;
			AddSnakeBlocks(rect);
    	}
    	movesnake();
	}
	
	private void AddSnakeBlocks(Node rect) {
		((Shape) rect).setFill(Color.RED);
		snakeBlocks.add(rect);
		if (snakeBlocks.size()== length+1) {
			removeSnakeBlocks();
		}
	}

	private void removeSnakeBlocks() {
		Rectangle rect2= (Rectangle)snakeBlocks.get(0);
		rect2.setFill(Color.GREEN);
		snakeBlocks.remove(0);
	}

	public void movesnake() {
		Timer timer = new Timer();
		TimerTask task = new TimerTask() {
			
			@Override
			public void run() {
				nextPosition();
			}
		};
		timer.schedule(task, 1000, 500);
	}

	protected void nextPosition() {
		checkDirection();
		System.out.println(x+" "+y);
		AddSnakeBlocks(setsquares[x][y]);
		if(x==14) {
			x=x-15;
		}
		if(y==12) {
			y=y-13;
		}
		
	}

	private void checkDirection() {
		
		
		
		System.out.println("North:"+goNorth+"  South:"+goSouth+"  East:"+goEast+"  West:"+goWest);
		x++;
	}

	private void createfield() {
    	for (int i = 0; i < grid.getColumnCount(); i++) {
			for (int j = 0; j < grid.getRowCount(); j++) {
				Rectangle r= new Rectangle();
				r.setHeight(30);
				r.setWidth(30);
				r.setFill(Color.GREEN);
				r.setVisible(true);
				
				grid.add(r, i, j);
				setsquares[i][j]= r;
				
			}
		}
		
	}

	public boolean isGoNorth() {
		return goNorth;
	}

	public void setGoNorth(boolean goNorth) {
		this.goNorth = goNorth;
	}

	public boolean isGoSouth() {
		return goSouth;
	}

	public void setGoSouth(boolean goSouth) {
		this.goSouth = goSouth;
	}

	public boolean isGoEast() {
		return goEast;
	}

	public void setGoEast(boolean goEast) {
		this.goEast = goEast;
	}

	public boolean isGoWest() {
		return goWest;
	}

	public void setGoWest(boolean goWest) {
		this.goWest = goWest;
	}

	@FXML
    private GridPane grid;
    
    




}

