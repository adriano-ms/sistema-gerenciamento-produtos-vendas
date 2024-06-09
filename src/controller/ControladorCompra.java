package controller;

import br.edu.fateczl.list.List;
import model.bd.PessoaFisicaBD;
import model.bd.PessoaJuridicaBD;
import model.bd.ProdutoBD;
import model.bd.TipoProdutoBD;
import model.entities.Carrinho;
import model.entities.Cliente;
import model.entities.Produto;
import model.entities.TipoProduto;

public class ControladorCompra {
	
	private CompraBD compraBD;
	private PessoaFisicaBD pessoaFisicaBD;
	private PessoaJuridicaBD pessoaJuridicaBD;
	private ProdutoBD produtoBD;
	private TipoProdutoBD tipoBD;
	private List<Compra> compra;
	private List<Produto>[] repositorioProduto;
	private List<TipoProduto> repositorioTipo;
	private List<Cliente> repositorioCliente;
	private Integer proxId;
	
	public ControladorCompra() {
		this.produtoBD = new ProdutoBD();
		this.tipoBD = new TipoProdutoBD();
		this.repositorioTipo = tipoBD.consultar();
		this.pessoaFisicaBD = new PessoaFisicaBD();
		this.pessoaJuridicaBD = new PessoaJuridicaBD();
		this.proxId = definirProxId();
		gerarTabela();
	}

	public void pesquisarProduto(String texto) {
		
	}

	public void adicionarProduto(int codigo, int qtde) {

	}

	public void removerProduto(int codigo, int qtde) {

	}

	public void checkout(Carrinho carrinho) {

	}

	public int verificarEstoque(int codigo) {
		return 0;
	}

	private void atualizarEstoque() {
		
	}

	private void registrarCompra() {
		
	}
	
	@SuppressWarnings("unchecked")
	private void gerarTabela() throws Exception{
		int size = repositorioTipo.size();
		this.repositorioProduto = new List[size];
		List<Produto> lista = produtoBD.consultar();
		size = lista.size();
		for(int i = 0; i < size; i++) {
			try {
				this.repositorioProduto[i] = new List<Produto>();
				this.repositorioProduto[lista.get(i).getTipo().getCodigo()].addLast(lista.get(i));
			} catch (Exception e) {
				throw new Exception("Ocorreu um erro ao carregar os produtos!");
			}
		}
	}
	
	private List<Produto> tabelaParaLista() throws Exception{
		List<Produto> lista = new List<Produto>();
		int tamanhoTabela = repositorioProduto.length;
		for(int i = 0; i < tamanhoTabela; i++) {
			int size = repositorioProduto[i].size();
			for(int j = 0; j < size; j++) {
				lista.addLast(repositorioProduto[i].get(j));
			}	
		}
		return lista;
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

}
