module Snake {
	requires javafx.controls;
	requires javafx.fxml;
	requires javafx.graphics;
	requires javafx.base;
	
	opens snake to javafx.graphics, javafx.fxml;
}
