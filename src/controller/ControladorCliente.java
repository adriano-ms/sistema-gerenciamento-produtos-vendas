package controller;

import model.bd.PessoaFisicaBD;
import model.bd.PessoaJuridicaBD;
import model.entitites.Cliente;
import model.entitites.PessoaFisica;
import model.entitites.PessoaJuridica;

public class ControladorCliente {

	private PessoaFisicaBD pessoaFisicaBD;
	private PessoaJuridicaBD pessoaJuridicaBD;
	
	public ControladorCliente() {
		super();
	}

	public void setPessoaFisicaBD(PessoaFisicaBD pessoaFisicaBD) {
		this.pessoaFisicaBD = pessoaFisicaBD;
	}

	public void setPessoaJuridicaBD(PessoaJuridicaBD pessoaJuridicaBD) {
		this.pessoaJuridicaBD = pessoaJuridicaBD;
	}

	public void cadastrar(Cliente cliente) throws Exception {
		validarDados(cliente);
		cliente.setId(cliente.hashCode());
		if(cliente instanceof PessoaFisica) {
			pessoaFisicaBD.adicionar((PessoaFisica)cliente);
		}
		if(cliente instanceof PessoaJuridica) {
			pessoaJuridicaBD.adicionar((PessoaJuridica)cliente);;
		}
	}
	
	public void consultar(int id) {
		
	}
	
	private Integer definirId(Cliente cliente) {
		if(cliente instanceof PessoaFisica) {
			var clientes = pessoaFisicaBD.consultar();
			
		}
		if(cliente instanceof PessoaJuridica) {
			pessoaJuridicaBD.adicionar((PessoaJuridica)cliente);;
		}
		return null;
	}
	
	private void validarDados(Cliente cliente) throws Exception {
		if(cliente == null) {
			throw new Exception("O cliente não pode ser nulo!");	
		}
		if(cliente.getNome() == null || cliente.getNome().isBlank()) {
			throw new Exception("Nome inválido!");
		}
		var endereco = cliente.getEndereco();
		if(validarCampo(endereco.getLogradouro())) {
			throw new Exception("Logradouro inválido!");
		}
		if(validarCampo(endereco.getComplemento())) {
			throw new Exception("Complemento inválido!");
		}
		if(validarCampo(endereco.getCep())) {
			throw new Exception("CEP inválido!");
		}
		if(validarCampo(endereco.getLogradouro())) {
			throw new Exception("Logradouro inválido!");
		}
		
		if(cliente instanceof PessoaFisica) {
			validarPessoaFisica((PessoaFisica)cliente);
		} else if(cliente instanceof PessoaJuridica) {
			validarPessoaJuridica((PessoaJuridica)cliente);
		}
	}
	
	private Boolean validarCampo(String s) {
		return s == null || s.isBlank();
	}
	
	private void validarPessoaFisica(PessoaFisica cliente) throws Exception {
		if(validarCampo(cliente.getCpf())) {
			throw new Exception("CPF inválido!");
		}
		if(validarCampo(cliente.getCelular())) {
			throw new Exception("Celular inválido!");
		}
	}
		
	private void validarPessoaJuridica(PessoaJuridica cliente) throws Exception {
		if(validarCampo(cliente.getCnpj())) {
			throw new Exception("CNPJ inválido!");
		}
		if(validarCampo(cliente.getTelefone())) {
			throw new Exception("Telefone inválido!");
		}
		if(validarCampo(cliente.getEmail())) {
			throw new Exception("E-mail inválido!");
		}
	}
	
}
