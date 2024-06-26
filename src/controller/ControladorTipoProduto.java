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
	private Integer proxId;
	
	public ControladorTipoProduto() throws Exception {
		this.tipoBD = new TipoProdutoBD();
		this.repositorioTipo = tipoBD.consultar();
		this.produtoBD = new ProdutoBD();
		this.proxId = gerarTabela();
	}
	
	public void adicionarTipoProduto(TipoProduto tipo) throws Exception {
		validarDados(tipo);
		int size = repositorioTipo.size();
		for(int i = 0; i < size; i++) {
			if(tipo.getNome().equals(repositorioTipo.get(i).getNome())) {
				throw new Exception("Já existe um tipo com esse nome!");
			}
		}
		tipo.setCodigo(proxId);
		proxId++;
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
	
	public void removerTipoProduto(int id) throws Exception {
		try {
			int size = repositorioTipo.size();
			for (int i = 0; i < size; i++) {
				var tipo = repositorioTipo.get(i);
				if(tipo.getCodigo() == id) {
					if (consultaPorTipo(tipo).isEmpty()) {
						repositorioTipo.remove(i);
						tipoBD.alterar(repositorioTipo);
					} else {
						throw new Exception("Não é possível excluír um tipo com produtos cadastrados!!");
					}
					break;
				}
				if(i == size - 1) {
					throw new Exception("Tipo de produto não encontrado!");
				}
			}
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
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
	private Integer gerarTabela() throws Exception{
		int size = repositorioTipo.size();
		int maior = 0;
		for(int i = 0; i < size; i++) {
			var tipo = repositorioTipo.get(i);
			if(tipo.getCodigo() > maior) {
				maior = tipo.getCodigo();
			}
		}
		this.repositorioProduto = new List[maior + 1];
		for(int i = 0; i < maior + 1; i++) {
			this.repositorioProduto[i] = new List<Produto>();
		}
		List<Produto> lista = produtoBD.consultar();
		size = lista.size();
		for(int i = 0; i < size; i++) {
			try {
				var produto = lista.get(i);
				this.repositorioProduto[produto.hashCode()].addLast(produto);
			} catch (Exception e) {
				throw new Exception("Ocorreu um erro ao carregar os produtos!");
			}
		}
		return maior + 1;
	}

	public List<Produto> consultaPorTipo(TipoProduto tipo){
		return repositorioProduto[tipo.getCodigo()];
	}
}
