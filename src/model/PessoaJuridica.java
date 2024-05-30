package model;

public class PessoaJuridica extends Cliente {
	private String cpnj;
	private String telefone;
	private String email;
	
	public PessoaJuridica() {
		// TODO Auto-generated constructor stub
	}
	
	public String getCpnj() {
		return cpnj;
	}
	public void setCpnj(String cpnj) {
		this.cpnj = cpnj;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
}
