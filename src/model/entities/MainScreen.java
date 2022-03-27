package model.entities;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainScreen {

	public void start(Stage primaryStage) throws Exception {
		
		 Parent root = FXMLLoader.load(getClass().getResource("/gui/MainScreen/.fxml"));
		 primaryStage.setTitle("TELA PRINCIPAL");
		 primaryStage.setScene(new Scene(root, 600, 400));
		 primaryStage.show();
	}
	
	
}
