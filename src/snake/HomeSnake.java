package snake;


import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;



public class HomeSnake extends Application {
	
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		FXMLLoader loader = new FXMLLoader(getClass().getResource("snake.fxml"));
		GridPane gridpane = loader.load();
		Scene scene = new Scene(gridpane);
		scene.onKeyPressedProperty().bindBidirectional(gridpane.onKeyPressedProperty());
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
