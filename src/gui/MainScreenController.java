package gui;

import java.io.IOException;


import java.util.Optional;

import gui.util.Alerts;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;

public class MainScreenController {

	@FXML
	private Button registerButton;

	@FXML
	private Button logoff;
	
	@FXML
	private Button about;
	
	@FXML
	private Button professionalRegistration;

	public void registerScreenCome() {
		try {

			Parent root = FXMLLoader.load(getClass().getResource("/gui/registerScreen.fxml"));
			Stage registerStage = new Stage();

			registerStage.setTitle("Ícaro Tecnologia - Ordem de Serviço");
			registerStage.setScene(new Scene(root, 800, 582));
			registerStage.show();

		} catch (Exception e) {
			e.printStackTrace();
			e.getCause();
		}

	}

	public void registerButtonOnAction(ActionEvent event) throws IOException {

		registerScreenCome();

	}
	
	public void aboutOnAction(ActionEvent event) {
		
		try {

			Parent root = FXMLLoader.load(getClass().getResource("/gui/About.fxml"));
			Stage registerStage = new Stage();

			registerStage.setTitle("Ícaro Tecnologia - Ordem de Serviço");
			registerStage.setScene(new Scene(root, 250, 300));
			registerStage.show();

		} catch (Exception e) {
			e.printStackTrace();
			e.getCause();
		}
	}

	public void logoffOnAction(ActionEvent event) {

		Optional<ButtonType> result = Alerts.showConfirmation("Confirmation", "Are you sure to quit ?");

		if (result.get() == ButtonType.OK) {
			Stage stage = (Stage) logoff.getScene().getWindow();
			stage.close();
		}

	}
	
	
	public void professionalRegistration() {
		
		try {

			Parent root = FXMLLoader.load(getClass().getResource("/gui/ProfessionalRegistration.fxml"));
			Stage registerStage = new Stage();

			registerStage.setTitle("Ícaro Tecnologia - Ordem de Serviço");
			registerStage.setScene(new Scene(root, 800, 582));
			registerStage.show();

		} catch (Exception e) {
			e.printStackTrace();
			e.getCause();
		}
	}
	
	
	public void registrationProfessional(ActionEvent evnt) {
		professionalRegistration();
	}
	
	
	
		
		
		
	}
	
	
	
	
	
	


