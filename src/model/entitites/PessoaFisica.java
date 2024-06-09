package model.entitites;

public class PessoaFisica extends Cliente {
	private String cpf;
	private String celular;

	public PessoaFisica(String cpf, String celular) {
		this.cpf = cpf;
		this.celular = celular;
	}

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
	
	@Override
	public String toString() {
		return this.getId() + ","
		+ this.getNome() + ","
		+ (this.getEndereco() != null ? Integer.toString(this.getEndereco().getCodigo()) : -1) + ","
		+ cpf + ","
		+ celular;
	}

}
