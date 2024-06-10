package controller;

import br.edu.fateczl.list.List;
import model.bd.EnderecoBD;
import model.bd.PessoaFisicaBD;
import model.bd.PessoaJuridicaBD;
import model.entities.Cliente;
import model.entities.Endereco;
import model.entities.PessoaFisica;
import model.entities.PessoaJuridica;

public class ControladorCliente {

	private PessoaFisicaBD pessoaFisicaBD;
	private PessoaJuridicaBD pessoaJuridicaBD;
	private EnderecoBD enderecoBD;
	private List<PessoaFisica> repositorioPF;
	private List<PessoaJuridica> repositorioPJ;
	private List<Endereco> repositorioEndereco;
	private Integer proxId;
	
	public ControladorCliente() throws Exception {
		this.pessoaFisicaBD = new PessoaFisicaBD();
		this.pessoaJuridicaBD = new PessoaJuridicaBD();
		this.enderecoBD = new EnderecoBD();
		this.repositorioPF = pessoaFisicaBD.consultar();
		this.repositorioPJ = pessoaJuridicaBD.consultar();
		this.repositorioEndereco = enderecoBD.consultar();
		this.proxId = definirProxId();
	}

	private Integer definirProxId() throws Exception {
		int pfs = repositorioPF.size();
		int pjs = repositorioPJ.size();
		if(pfs == 0 && pjs == 0) {
			return 0;
		}
		int maiorPF = 0;
		for (int i = 0; i < pfs; i++) {
			int atual = repositorioPF.get(i).getId();
			if(atual > maiorPF) {
				maiorPF = atual;
			}
		}
		int maiorPJ = 0;
		for (int i = 0; i < pjs; i++) {
			int atual = repositorioPJ.get(i).getId();
			if(atual > maiorPJ) {
				maiorPJ = atual;
			}
		}
		if(maiorPJ > maiorPF) {
			return maiorPJ + 1;
		}
		return maiorPF + 1;
	}

	public void cadastrar(Cliente cliente) throws Exception {
		validarDados(cliente);
		cliente.setId(proxId);
		var endereco = cliente.getEndereco();
		endereco.setCodigo(proxId);
		proxId++;
		enderecoBD.adicionar(endereco);
		repositorioEndereco = enderecoBD.consultar();
		if(cliente instanceof PessoaFisica) {
			pessoaFisicaBD.adicionar((PessoaFisica)cliente);
			repositorioPF = pessoaFisicaBD.consultar();
		}
		if(cliente instanceof PessoaJuridica) {
			pessoaJuridicaBD.adicionar((PessoaJuridica)cliente);
			repositorioPJ = pessoaJuridicaBD.consultar();
		}
	}
	
	public Cliente consultar(int id) throws Exception {
		try {
			Cliente cliente;
			int size = repositorioPF.size();
			for (int i = 0; i < size; i++) {
				cliente = repositorioPF.get(i);
				if(cliente.getId() == id) {
					cliente.setEndereco(encontrarEndereco(id));
					return cliente;
				}
			}
			size = repositorioPJ.size();
			for (int i = 0; i < size; i++) {
				cliente = repositorioPJ.get(i);
				if(cliente.getId() == id) {
					cliente.setEndereco(encontrarEndereco(id));
					return cliente;
				}
			}
		} catch (Exception e) {
			throw new Exception("Ocorreu um erro durante a consulta!");
		}
		throw new Exception("Cliente não encontrado!");
	}
	
	public Cliente remover(int id) throws Exception {
		try {
			int size = repositorioPF.size();
			for (int i = 0; i < size; i++) {
				var cliente = repositorioPF.get(i);
				if(cliente.getId() == id) {
					repositorioPF.remove(i);
					pessoaFisicaBD.alterar(repositorioPF);
					return cliente;
				}
			}
			size = repositorioPJ.size();
			for (int i = 0; i < size; i++) {
				var cliente = repositorioPJ.get(i);
				if (cliente.getId() == id) {
					repositorioPJ.remove(i);
					pessoaJuridicaBD.alterar(repositorioPJ);
					return cliente;
				}
			}
			size = repositorioEndereco.size();
			for(int i = 0; i < size; i++) {
				if(repositorioEndereco.get(i).getCodigo() == id) {
					repositorioEndereco.remove(i);
					enderecoBD.alterar(repositorioEndereco);
				}
			}
		} catch (Exception e) {
			throw new Exception("Ocorreu um erro durante a exclusão!");
		}
		throw new Exception("Cliente não encontrado!");
	}
	
	public void editar(Cliente cliente) throws Exception {
		validarDados(cliente);
		int id = cliente.getId();
		try {
			int size;
			if (cliente instanceof PessoaFisica) {
				size = repositorioPF.size();
				for (int i = 0; i < size; i++) {
					var entidade = repositorioPF.get(i);
					if (entidade.getId() == id) {
						repositorioPF.remove(i);
						repositorioPF.add((PessoaFisica) cliente, i);
						pessoaFisicaBD.alterar(repositorioPF);
					}
				} 
			} else if (cliente instanceof PessoaJuridica){
				size = repositorioPJ.size();
				for (int i = 0; i < size; i++) {
					var entidade = repositorioPJ.get(i);
					if (entidade.getId() == id) {
						repositorioPJ.remove(i);
						repositorioPJ.add((PessoaJuridica) cliente, i);
						pessoaJuridicaBD.alterar(repositorioPJ);
					}
				}	
			}
			size = repositorioEndereco.size();
			for(int i = 0; i < size; i++) {
				if(repositorioEndereco.get(i).getCodigo() == id) {
					repositorioEndereco.remove(i);
					repositorioEndereco.add(cliente.getEndereco(), i);
					enderecoBD.alterar(repositorioEndereco);
				}
			}
		} catch (Exception e) {
			throw new Exception("Ocorreu um erro durante a edição!");
		}
	}
	
	private Endereco encontrarEndereco(int idCliente) throws Exception {
		int size = repositorioEndereco.size();
		for(int i = 0; i < size; i++) {
			var endereco = repositorioEndereco.get(i);
			if(endereco.getCodigo() == idCliente) {
				return endereco;
			}
		}
		throw new Exception("Endereço não encontrado!");
	}
	
	private void validarDados(Cliente cliente) throws Exception {
		if(cliente == null) {
			throw new Exception("O cliente não pode ser nulo!");	
		}
		if(cliente.getNome() == null || cliente.getNome().isBlank()) {
			throw new Exception("Nome inválido!");
		}
		var endereco = cliente.getEndereco();
		if(endereco == null) {
			throw new Exception("O endereço não pode ser nulo!");
		}
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
		return s == null || s.isBlank() || s.contains(",");
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
