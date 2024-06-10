package controller;

import br.edu.fateczl.list.List;
import model.bd.ProdutoBD;
import model.bd.TipoProdutoBD;
import model.entities.Produto;
import model.entities.TipoProduto;

public class ControladorProduto {
	
	private ProdutoBD produtoBD;
	private TipoProdutoBD tipoBD;
	private List<Produto>[] repositorioProduto;
	private List<TipoProduto> repositorioTipo;

	public ControladorProduto() throws Exception {
		this.produtoBD = new ProdutoBD();
		this.tipoBD = new TipoProdutoBD();
		this.repositorioTipo = tipoBD.consultar();
		gerarTabela();
	}

	public void adicionarProduto(Produto produto) throws Exception {
		validarDados(produto);

		
		for(List<Produto> produtos : repositorioProduto) {
			
			int size = produtos.size();
			
			for(int i = 0; i < size; i++) {
				if(produto.getCodigo() == produtos.get(i).getCodigo()) {
					throw new Exception("Já existe um produto com esse código!");
				}
			}
		}
		produtoBD.adicionar(produto);
		gerarTabela();
	}

	public void removerProduto(int codigo) throws Exception {
		int tamanhoTabela = repositorioProduto.length;
		for(int i = 0; i < tamanhoTabela; i++) {
			int size = repositorioProduto[i].size();
			for(int j = 0; j < size; j++) {
				var produto = repositorioProduto[i].get(j);
				if(produto.getCodigo() == codigo) {
					repositorioProduto[i].remove(j);
				}
			}	
		}
		produtoBD.alterar(tabelaParaLista());
	}
	
	public Produto consultarProduto(int codigo) throws Exception {
		try {
			for(List<Produto> produtos : repositorioProduto) {
				if (!produtos.isEmpty()) {
					int size = produtos.size();
					for (int i = 0; i < size; i++) {
						var produto = produtos.get(i);
						if (produto.getCodigo() == codigo) {
							return produto;
						}
					} 
				}	
			}
		} catch (Exception e) {
			throw new Exception("Ocorreu um erro na consulta do produto!");
		}
		throw new Exception("Produto não encontrado!");
	}
	
	public Produto consultarProduto(String nome) throws Exception {
		try {
			for(List<Produto> produtos : repositorioProduto) {
				if (!produtos.isEmpty()) {
					System.out.println("Aqui");
					int size = produtos.size();
					for (int i = 0; i < size; i++) {
						var produto = produtos.get(i);
						if (produto.getNome().contains(nome)) {
							return produto;
						}
					} 
				}	
			}
		} catch (Exception e) {
			throw new Exception("Ocorreu um erro na consulta do produto!");
		}
		throw new Exception("Produto não encontrado!");
	}
	
	public void atualizarEstoque(Produto produto, int qtde) throws Exception {
		validarDados(produto);
		try {
			int tipo = produto.getTipo().getCodigo();
			int size = repositorioProduto[tipo].size();
			for(int i = 0; i < size; i++) {
				var entidade = repositorioProduto[tipo].get(i);
				if(entidade.getCodigo() == produto.getCodigo()) {
					repositorioProduto[tipo].get(i).setQtdEmEstoque(qtde);
				}
			}
			produtoBD.alterar(tabelaParaLista());
		} catch (Exception e) {
			throw new Exception("Ocorreu um erro ao atualizar o estoque!");
		}
	}
	
	public List<TipoProduto> listarTipos() throws Exception {
		return this.repositorioTipo;
	}
	
	private Boolean validarCampo(String s) {
		return s == null || s.isBlank() || s.contains(",");
	}
	
	private void validarDados(Produto produto) throws Exception {
		if(produto == null) {
			throw new Exception("O produto não poder ser nulo!");
		}
		if(validarCampo(produto.getNome())) {
			throw new Exception("Nome inválido!");
		}
		if(validarCampo(produto.getDescricao())) {
			throw new Exception("Descrição inválida!");
		}
		if(produto.getValor() <= 0.0) {
			throw new Exception("Preço inválido!");
		}
		if(produto.getQtdEmEstoque() <= 0) {
			throw new Exception("Estoque inválido!");
		}
	}
	
	@SuppressWarnings("unchecked")
	private void gerarTabela() throws Exception{
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
	}
	
	private List<Produto> tabelaParaLista() throws Exception{
		List<Produto> lista = new List<Produto>();
		int tamanhoTabela = repositorioProduto.length;
		for(int i = 0; i < tamanhoTabela; i++) {
			if (repositorioProduto[i] != null) {
				int size = repositorioProduto[i].size();
				for (int j = 0; j < size; j++) {
					lista.addLast(repositorioProduto[i].get(j));
				} 
			}	
		}
		return lista;
	}
}
