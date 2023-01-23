package snake;


import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;



public class HomeSnake extends Application {
	
	Controller controller= new Controller();
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		
		FXMLLoader loader = new FXMLLoader(getClass().getResource("snake.fxml"));
		GridPane gridpane = loader.load();
		
		Scene scene = new Scene(gridpane);
		scene.onKeyPressedProperty().bindBidirectional(gridpane.onKeyPressedProperty());
//		scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
//			
//            @Override
//            public void handle(KeyEvent event) {
//            	System.out.println("xxxx "); 
//                switch (event.getCode()) {
//                    
//                case UP:	controller.setAddDirection(controller.getDirection()+1);System.out.println(controller.getDirection()); 
//                		
//                		break;
//                    
//                case DOWN:	controller.setAddDirection(controller.getDirection()+3); 
//                System.out.println(controller.getDirection()); 
//                		break;
//                    
//                case LEFT:	controller.setAddDirection(controller.getDirection()+4);System.out.println(controller.getDirection()); 
//                		break;
//                   
//                case RIGHT:	controller.setAddDirection(controller.getDirection()+2); System.out.println(controller.getDirection()); 
//                		break;
//				default:
//					System.out.println("Wrong key!!");
//                   
//                }
//                System.out.println("direction = "+ controller + " " +controller.getDirection()+" "+controller.getAddDirection()) ;
//                }
//            
//            
//			
//        });
		
		primaryStage.setResizable(false);
		primaryStage.setScene(scene);
		primaryStage.setMinHeight(543);
	    primaryStage.setMinWidth(514);
	    primaryStage.setMaxHeight(543);
	    primaryStage.setMaxWidth(514);
		primaryStage.setTitle("Play Snake");
		
		primaryStage.show();

	}
	
		public static void main(String[] args) {
			Application.launch();
			
		
	}

}
