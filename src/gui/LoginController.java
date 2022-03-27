package gui;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;

import db.DB;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LoginController implements Initializable {

	@FXML
	private Button cancelButton;

	@FXML
	private Label loginMessageLabel;

	@FXML
	private TextField usernameTextField;

	@FXML
	private PasswordField enterPasswordField;

	public void loginButtonOnAction(ActionEvent event) throws IOException {

		if (usernameTextField.getText().isBlank() == false && enterPasswordField.getText().isBlank() == false) {
			validateLogin();

		} else {
			loginMessageLabel.setText("Please enter username and password");
		}
	}

	public void cancelButtonOnAction(ActionEvent event) {

		Stage stage = (Stage) cancelButton.getScene().getWindow();
		stage.close();

	}

	public void validateLogin() {

		Connection conn = DB.getConnection();

		String verifyLogin = "SELECT count(2) FROM user_account WHERE username = '" + usernameTextField.getText()
				+ "' and password = '" + enterPasswordField.getText() + "'";

		try {

			Statement statement = conn.createStatement();
			ResultSet queryResult = statement.executeQuery(verifyLogin);

			while (queryResult.next()) {
				if (queryResult.getInt(1) == 1) {
					// loginMessageLabel.setText("Congratulations!");
					mainScreenCome();
					Stage stage = (Stage) cancelButton.getScene().getWindow(); 
					stage.close();

				} else {
					loginMessageLabel.setText("Invalid login. Please try again");
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
			e.getCause();
		}

	}

	public void mainScreenCome() {
		try {

			Parent root = FXMLLoader.load(getClass().getResource("/gui/MainScreen.fxml"));
			Stage registerStage = new Stage();

			registerStage.setTitle("Ícaro Tecnologia - Ordem de Serviço");
			registerStage.setScene(new Scene(root, 1280, 745));
			registerStage.show();

		} catch (Exception e) {
			e.printStackTrace();
			e.getCause();
		}

	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub

	}

}
