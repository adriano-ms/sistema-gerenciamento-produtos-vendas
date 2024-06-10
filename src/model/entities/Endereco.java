package model.entities;

public class Endereco {
	private int codigo;
	private String logradouro;
	private int numero;
	private String complemento;
	private String cep;
	
	public Endereco() {
		super();
	}

	public Endereco(int codigo, String logradouro, int numero, String complemento, String cep) {
		super();
		this.codigo = codigo;
		this.logradouro = logradouro;
		this.numero = numero;
		this.complemento = complemento;
		this.cep = cep;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	
	@Override
	public String toString() {
		return codigo + ","
				+ logradouro + ","
				+ numero + ","
				+ complemento + ","
				+ cep;
	}
	
}
