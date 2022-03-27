package model.entities;

public class Cliente {

	private String nomecli;
	private String endcli;
	private String fonecli;
	private String emailcli;
	private int idcli;

	public Cliente(int idcli, String endcli, String fonecli, String emailcli, String nomecli) {

		this.nomecli = nomecli;
		this.endcli = endcli;
		this.fonecli = fonecli;
		this.emailcli = emailcli;
		this.idcli = idcli;

	}

	public int getIdcli() {
		return idcli;
	}

	public void setIdcli(int idcli) {
		this.idcli = idcli;
	}

	public String getNomecli() {
		return nomecli;
	}

	public void setNomecli(String nomecli) {
		this.nomecli = nomecli;
	}

	public String getEndcli() {
		return endcli;
	}

	public void setEndcli(String endcli) {
		this.endcli = endcli;
	}

	public String getFonecli() {
		return fonecli;
	}

	public void setFonecli(String fonecli) {
		this.fonecli = fonecli;
	}

	public String getEmailcli() {
		return emailcli;
	}

	public void setEmail(String emailcli) {
		this.emailcli = emailcli;
	}

}
