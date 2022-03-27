package gui;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;
import java.util.ResourceBundle;

import db.DB;
import gui.util.Alerts;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import model.entities.Cliente;

public class ProfessionalRegistrationController implements Initializable {

	@FXML
	private Button adicionar;

	@FXML
	private Button alterar;

	@FXML
	private Button excluir;

	@FXML
	private TextField nome;

	@FXML
	private TextField endereco;

	@FXML
	private TextField telefone;

	@FXML
	private TextField email;

	@FXML
	private TableView<Cliente> table;

	@FXML
	private TableColumn<Cliente, Integer> idcli;

	@FXML
	private TableColumn<Cliente, String> nomecli;

	@FXML
	private TableColumn<Cliente, String> endcli;

	@FXML
	private TableColumn<Cliente, String> fonecli;

	@FXML
	private TableColumn<Cliente, String> emailcli;

	ObservableList<Cliente> listM;
	int index = -1;
	Connection conn = null;
	ResultSet rs = null;
	PreparedStatement pst = null;

	@Override
	public void initialize(URL url, ResourceBundle rb) {

		idcli.setCellValueFactory(new PropertyValueFactory<Cliente, Integer>("idcli"));
		nomecli.setCellValueFactory(new PropertyValueFactory<Cliente, String>("nomecli"));
		endcli.setCellValueFactory(new PropertyValueFactory<Cliente, String>("endcli"));
		fonecli.setCellValueFactory(new PropertyValueFactory<Cliente, String>("fonecli"));
		emailcli.setCellValueFactory(new PropertyValueFactory<Cliente, String>("emailcli"));

		listM = DB.getDataClientes();
		table.setItems(listM);
	}

	
	private void pesquisar_cliente() {

		Connection conn = DB.getConnection();

		try {
			PreparedStatement st = null;
			ResultSet rs = null;

			st = conn.prepareStatement("select * from client where nomecli like ?");
			st.setString(1, nome.getText() + "%");
			rs = st.executeQuery();

		} catch (Exception e) {

		}

	}

	public void adicionar(ActionEvent event) {
		adicionarCliente();
	}

	private void adicionarCliente() {

		Connection conn = DB.getConnection();

		try {
			PreparedStatement st = null;

			st = conn.prepareStatement("INSERT INTO client" + "(nomecli,endcli,fonecli,emailcli) values (?,?,?,?)");

			st.setString(1, nome.getText());
			st.setString(2, endereco.getText());
			st.setString(3, telefone.getText());
			st.setString(4, email.getText());

			if (nome.getText() == null || telefone.getText() == null) {
				Optional<ButtonType> result = Alerts.showConfirmation("Tela de dialogo",
						"Preencha todos os campos obrigatorios");
			}

			else {
				int resultt = st.executeUpdate();

				if (resultt > 0) {
					Optional<ButtonType> result = Alerts.showConfirmation("Tela de dialogo",
							"Cliente adicionado com sucesso");

					nome.setText(null);
					endereco.setText(null);
					telefone.setText(null);
					email.setText(null);
				}

			}

		} catch (Exception e) {
			e.printStackTrace();
			e.getCause();
		}
	}

}
