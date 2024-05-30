package model;

public class PessoaFisica extends Cliente {
	private String cpf;
	private String celular;

	public PessoaFisica() {
		// TODO Auto-generated constructor stub
	}
	
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getCelular() {
		return celular;
	}
	public void setCelular(String celular) {
		this.celular = celular;
	}
}
