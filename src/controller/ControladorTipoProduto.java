package controller;

import br.edu.fateczl.list.List;
import model.bd.TipoProdutoBD;
import model.entities.TipoProduto;

public class ControladorTipoProduto {
	
	private TipoProdutoBD tipoBD;
	private List<TipoProduto> repositorioTipo;
	
	public ControladorTipoProduto() {
		this.tipoBD = new TipoProdutoBD();
		this.repositorioTipo = tipoBD.consultar();
	}
	
	public void adicionarTipoProduto(TipoProduto tipo) throws Exception {
		validarDados(tipo);
		int size = repositorioTipo.size();
		for(int i = 0; i < size; i++) {
			if(tipo.getCodigo() == repositorioTipo.get(i).getCodigo()) {
				throw new Exception("Já existe um tipo com esse código!");
			}
		}
		tipoBD.adicionar(tipo);
		repositorioTipo = tipoBD.consultar();
	}
	
	public TipoProduto consultarTipoProduto(int codigo) throws Exception {
		try {
			int size = repositorioTipo.size();
			for(int i = 0; i < size; i++) {
				var entidade = repositorioTipo.get(i);
				if(codigo == entidade.getCodigo()) {
					return entidade;
				}
			}
		} catch (Exception e) {
			throw new Exception("Ocorreu um erro na consulta do tipo!");
		}
		throw new Exception("Tipo de produto não encontrado!");
	}
	
	public TipoProduto consultarTipoProduto(String nome) throws Exception {
		try {
			int size = repositorioTipo.size();
			for(int i = 0; i < size; i++) {
				var entidade = repositorioTipo.get(i);
				if(entidade.getNome().contains(nome)) {
					return entidade;
				}
			}
		} catch (Exception e) {
			throw new Exception("Ocorreu um erro na consulta do tipo!");
		}
		throw new Exception("Tipo de produto não encontrado!");
	}
	
	public TipoProduto removerTipoProduto(int id) throws Exception {
		try {
			int size = repositorioTipo.size();
			for (int i = 0; i < size; i++) {
				var tipo = repositorioTipo.get(i);
				if(tipo.getCodigo() == id) {
					repositorioTipo.remove(i);
					tipoBD.alterar(repositorioTipo);
					return tipo;
				}
			}
		} catch (Exception e) {
			throw new Exception("Ocorreu um erro na exclusão do tipo!");
		}
		throw new Exception("Tipo de produto não encontrado!");
	}
	
	private Boolean validarCampo(String s) {
		return s == null || s.isBlank() || s.contains(",");
	}
	
	private void validarDados(TipoProduto tipo) throws Exception {
		if(tipo == null) {
			throw new Exception("O tipo não poder ser nulo!");
		}
		if(validarCampo(tipo.getNome())) {
			throw new Exception("Nome inválido!");
		}
	}
}
