package gui;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

import db.DB;
import gui.util.Alerts;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;

public class registerScreenController {

	@FXML
	private TextField firstName;
	@FXML
	private TextField locale;
	@FXML
	private TextField fone;
	@FXML
	private TextField email;
	@FXML
	private TextField id;

	@FXML
	private TextField fone2;

	@FXML
	private TextField username;

	@FXML
	private TextField senha;

	@FXML
	private TextField cep;

	@FXML
	private TextField numero;

	@FXML
	private TextField complemento;

	@FXML
	private TextField bairro;

	@FXML
	private TextField municipio;

	@FXML
	private TextField cpf;

	@FXML
	private Button add;
	@FXML
	private Button search;
	@FXML
	private Button remove;
	@FXML
	private Button change;

	

	public void addcliOnAction(ActionEvent event) {

		adicionarCliente();

	}

	public void searchcliOnAction(ActionEvent event) {
		consultar();
	}

	public void changecliOnAction(ActionEvent event) {
		alterarCliente();
	}

	public void removecliOnAction(ActionEvent event) throws SQLException {

		remover();

	}

	private void remover() throws SQLException {

		Connection conn = DB.getConnection();
		PreparedStatement st = null;

		Optional<ButtonType> result = Alerts.showConfirmation("Tela de dialogo",
				"Tem ceterza que deseja excluir esse usuário ?");

		if (result.get() == ButtonType.OK) {

			st = conn.prepareStatement("delete from user_account where account_id=?");
			st.setString(1, id.getText());
			int result2 = st.executeUpdate();
			if (result2 > 0) {
				Optional<ButtonType> result3 = Alerts.showConfirmation("Tela de dialogo",
						"Usuário removido com sucesso !");

				id.setText(null);
				firstName.setText(null);
				locale.setText(null);
				fone.setText(null);
				email.setText(null);
				username.setText(null);
				senha.setText(null);
				complemento.setText(null);
				fone2.setText(null);
				cep.setText(null);
				numero.setText(null);
				bairro.setText(null);
				municipio.setText(null);
				cpf.setText(null);

			}
		}

	}

	private void alterarCliente() {

		Connection conn = DB.getConnection();

		try {
			PreparedStatement st = null;
			st = conn.prepareStatement(
					"update user_account set firstname=?,username=?,password=?,email=?,endereco=?,complemento=?,telefone=?,CEP=?,numero=?,bairro=?,municipio=?,telefone2=?,cpf=?  where account_id=?");

			st.setString(1, firstName.getText());
			st.setString(2, username.getText());
			st.setString(3, senha.getText());
			st.setString(4, email.getText());
			st.setString(5, locale.getText());
			st.setString(6, complemento.getText());
			st.setString(7, fone.getText());
			st.setString(8, cep.getText());
			st.setString(9, numero.getText());
			st.setString(10, bairro.getText());
			st.setString(11, municipio.getText());
			st.setString(12, fone2.getText());
			st.setString(13, cpf.getText());
			st.setString(14, id.getText());

			int resultt = st.executeUpdate();

			if (resultt > 0) {
				Optional<ButtonType> result = Alerts.showConfirmation("Tela de dialogo",
						"Dados do usuario do usuario alterados com sucesso");
				id.setText(null);
				firstName.setText(null);
				locale.setText(null);
				fone.setText(null);
				email.setText(null);
				username.setText(null);
				senha.setText(null);
				complemento.setText(null);
				fone2.setText(null);
				cep.setText(null);
				numero.setText(null);
				bairro.setText(null);
				municipio.setText(null);
				cpf.setText(null);

			}

		} catch (Exception e) {
			e.printStackTrace();
			e.getCause();
		}

	}

	private void adicionarCliente() {

		Connection conn = DB.getConnection();

		try {
			PreparedStatement st = null;

			st = conn.prepareStatement("INSERT INTO user_account"
					+ "(account_id,firstname,username,password,email,endereco,complemento,telefone,CEP,numero,bairro,municipio,telefone2,cpf)"
					+ "VALUES" + "(?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
			st.setString(1, id.getText());
			st.setString(2, firstName.getText());
			st.setString(3, username.getText());
			st.setString(4, senha.getText());
			st.setString(5, email.getText());
			st.setString(6, locale.getText());
			st.setString(7, complemento.getText());
			st.setString(8, fone.getText());
			st.setString(9, cep.getText());
			st.setString(10, numero.getText());
			st.setString(11, bairro.getText());
			st.setString(12, municipio.getText());
			st.setString(13, fone2.getText());
			st.setString(14, cep.getText());

			if (id.getText().isEmpty() || firstName.getText() == null || locale.getText() == null
					|| fone.getText() == null || email == null) {
				Optional<ButtonType> result = Alerts.showConfirmation("Tela de dialogo",
						"Preencha todos os campos obrigatorios");
			} else {
				int resultt = st.executeUpdate();

				if (resultt > 0) {
					Optional<ButtonType> result = Alerts.showConfirmation("Tela de dialogo",
							"Usuário adicionado com sucesso");
					id.setText(null);
					firstName.setText(null);
					locale.setText(null);
					fone.setText(null);
					email.setText(null);
					username.setText(null);
					senha.setText(null);
					complemento.setText(null);
					fone2.setText(null);
					cep.setText(null);
					numero.setText(null);
					bairro.setText(null);
					municipio.setText(null);
					cpf.setText(null);

				}

			}

		} catch (Exception e) {
			e.printStackTrace();
			e.getCause();
		}
	}

	private void consultar() {
		Connection conn = DB.getConnection();

		try {

			PreparedStatement st = null;
			ResultSet rs = null;

			st = conn.prepareStatement("SELECT * FROM user_account WHERE account_id = ?");
			st.setString(1, id.getText());
			rs = st.executeQuery();

			if (rs.next()) {

				firstName.setText(rs.getString(2));
				username.setText(rs.getString(3));
				senha.setText(rs.getString(4));
				email.setText(rs.getString(5));
				locale.setText(rs.getString(6));
				complemento.setText(rs.getString(7));
				fone.setText(rs.getString(8));
				cep.setText(rs.getString(9));
				numero.setText(rs.getString(10));
				bairro.setText(rs.getString(11));
				municipio.setText(rs.getString(12));
				fone2.setText(rs.getString(13));
				cpf.setText(rs.getString(14));

			} else {
				Optional<ButtonType> result = Alerts.showConfirmation("ATENÇÃO !", "Usuário não cadastrado");

				firstName.setText(null);
				locale.setText(null);
				fone.setText(null);
				email.setText(null);
				username.setText(null);
				senha.setText(null);
				complemento.setText(null);
				fone2.setText(null);
				cep.setText(null);
				numero.setText(null);
				bairro.setText(null);
				municipio.setText(null);
				cpf.setText(null);

			}

		} catch (Exception e) {

			e.printStackTrace();
			e.getCause();

		}

	}
}
