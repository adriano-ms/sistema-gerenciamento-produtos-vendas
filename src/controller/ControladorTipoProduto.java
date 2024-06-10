package controller;

import br.edu.fateczl.list.List;
import model.bd.ProdutoBD;
import model.bd.TipoProdutoBD;
import model.entities.Produto;
import model.entities.TipoProduto;

public class ControladorTipoProduto {
	
	private ProdutoBD produtoBD;
	private TipoProdutoBD tipoBD;
	private List<TipoProduto> repositorioTipo;
	private List<Produto>[] repositorioProduto;
	
	public ControladorTipoProduto() throws Exception {
		this.tipoBD = new TipoProdutoBD();
		this.repositorioTipo = tipoBD.consultar();
		this.produtoBD = new ProdutoBD();
		gerarTabela();
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
	
	
	@SuppressWarnings("unchecked")
	private void gerarTabela() throws Exception{
		int size = repositorioTipo.size();
		this.repositorioProduto = new List[size];
		for(int i = 0; i < size; i++) {
			this.repositorioProduto[i] = new List<Produto>();
		}
		List<Produto> lista = produtoBD.consultar();
		size = lista.size();
		for(int i = 0; i < size; i++) {
			try {
				this.repositorioProduto[lista.get(i).getTipo().getCodigo()].addLast(lista.get(i));
			} catch (Exception e) {
				//throw new Exception("Ocorreu um erro ao carregar os produtos!");
				e.printStackTrace();
			}
		}
	}

	public List<Produto> consultaPorTipo(TipoProduto tipo){
		return repositorioProduto[tipo.getCodigo()];
	}
}
