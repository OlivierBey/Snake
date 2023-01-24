package snake;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.input.InputEvent;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;


public class Controller {
	int x ,y=5;
	int length = 3;
	private Node[][] setsquares= new Node[15][13];
	ArrayList<Node> snakeBlocks= new ArrayList<>();
	
	Random random= new Random();
	int randomX,randomY;
	private int direction, addDirection;
	
	 public void initialize() {
		 
		createfield();
		setsnake();
		
	}

    private void setsnake() {
    	for (int i = 0; i < length; i++) {
    		Rectangle rect= (Rectangle) setsquares[i][y];
    		 x=i;
			AddSnakeBlocks(rect);
    	}
    	
    	
    	direction=2;
    	movesnake();
    	setCandy();
	}
	
	private void setCandy() {
		randomX = random.nextInt(15);
		randomY = random.nextInt(13);
		Rectangle rectCandy= (Rectangle)setsquares[randomX][randomY];
		rectCandy.setFill(Color.YELLOW);
		
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
		
		if(x== randomX && y== randomY) {
			length++;
			setCandy();
		}
		
		AddSnakeBlocks(setsquares[x][y]);
		if(direction==2 && x==14) {
			x=x-15;
		}
		if(direction==3 && y==12) {
			y=y-13;
		}
		if(direction==4 && x==0) {
			x=x+15;
		}
		if(direction==1 && y==0) {
			y=y+13;
		}
		checkDirection();
		
	}

	private void checkDirection() {
		 
		 
		if(direction==1 ) {
			if( addDirection==2) {
				x++;
				direction=2; addDirection=0;
			} else if(addDirection==4){
				x--;
				direction = 4; addDirection=0;
			} else {
				y--;addDirection=0;
			}
		}
		
		if(direction==2 ) {
			if( addDirection==1) {
				y--;
				direction=1; addDirection=0;	
			} else if(addDirection==3){
				y++;
				direction = 3; addDirection=0;
			} else {
				x++;addDirection=0;
			}
		}
		if( direction==3) {
			if( addDirection==2) {
				x++;
				direction=2;	
			} else if(addDirection==4){
				x--;
				direction = 4;
			} else {
				y++;addDirection=0;
			}
		}
		
		if( direction==4) {
			if( addDirection==1) {
				y--;
				direction=1;	
			} else if(addDirection==3){
				y++;
				direction = 3;
			} else {
				x--;addDirection=0;
			}
		}
		
			
		
		
		
		grid.setOnKeyPressed(new EventHandler<KeyEvent>() {
		      @Override public void handle(KeyEvent event) {
		    	  System.out.print("key pressed ");
		        switch (event.getCode()) {
		          case UP:    addDirection=1; System.out.println(direction+" "+direction+addDirection); break;
		          case RIGHT: addDirection=2;System.out.println(direction+" "+direction+addDirection); break;
		          case DOWN:  addDirection=3;System.out.println(direction+" "+direction+addDirection); break;
		          case LEFT:  addDirection=4;System.out.println(direction+" "+direction+addDirection); break;
				default:
					System.out.println("wrong key");
		        }
		      }
		    });
		
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

	@FXML
    private GridPane grid;
    
    




}

