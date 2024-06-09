package model.entitites;

public class PessoaJuridica extends Cliente {
	private String cnpj;
	private String telefone;
	private String email;
	
	public PessoaJuridica() {
		// TODO Auto-generated constructor stub
	}
	
	public String getCnpj() {
		return cnpj;
	}
	public void setCnpj(String cpnj) {
		this.cnpj = cpnj;
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
	
	@Override
	public String toString() {
		return this.getId() + ","
		+ this.getNome() + ","
		+ (this.getEndereco() != null ? Integer.toString(this.getEndereco().getCodigo()) : -1) + ","
		+ cnpj + ","
		+ telefone + ","
		+ email;
	}
	
}
