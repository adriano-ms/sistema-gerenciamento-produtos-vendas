package controller;

import br.edu.fateczl.list.List;
import br.edu.fateczl.queue.Queue;
import model.bd.CompraBD;
import model.bd.PessoaFisicaBD;
import model.bd.PessoaJuridicaBD;
import model.bd.ProdutoBD;
import model.entities.Carrinho;
import model.entities.Cliente;
import model.entities.Compra;
import model.entities.ItemCompra;
import model.entities.PessoaFisica;
import model.entities.PessoaJuridica;
import model.entities.Produto;

public class ControladorCompra {

	private CompraBD compraBD;
	private PessoaFisicaBD pessoaFisicaBD;
	private PessoaJuridicaBD pessoaJuridicaBD;
	private ProdutoBD produtoBD;
	private List<Produto> repositorioProduto;
	private List<Cliente> repositorioCliente;
	private Integer proxId;

	public ControladorCompra() throws Exception {
		this.compraBD = new CompraBD();
		this.produtoBD = new ProdutoBD();
		this.pessoaFisicaBD = new PessoaFisicaBD();
		this.pessoaJuridicaBD = new PessoaJuridicaBD();
		this.repositorioProduto = produtoBD.consultar();
		this.repositorioCliente = mesclarClientes();
		this.proxId = definirProxId();
	}

	public List<Produto> listarProdutos(){
		return this.repositorioProduto;
	}

	public String checkout(Object[][] itens, Cliente cliente) throws Exception {
		Carrinho carrinho = new Carrinho();
		int linhas = itens.length;
		for(int i = 0; i < linhas; i++) {
			carrinho.adicionarProduto(buscarProduto((String)itens[i][0]), Integer.parseInt((String)itens[i][2]), proxId);
		}
		carrinho.finalizarCompra(proxId, null, cliente);
		proxId++;
		Queue<ItemCompra> fila = new Queue<>();
		for(ItemCompra item : carrinho.getPilha()) {
			fila.insert(item);
		}
		StringBuffer buffer = new StringBuffer();
		double total = 0;
		buffer.append("RESUMO DA COMPRA:\n");
		buffer.append("NOME\tVALOR\tQTDE.");
		for(int i = 0; i < linhas; i++) {
			var ent = fila.remove();
			buffer.append(ent.getProduto().getNome() + "\t" + String.format("R$.2f", ent.getProduto().getValor()) +  "\t" + ent.getQuantidade() + "\n");
			total += ent.getProduto().getValor() + ent.getQuantidade();
		}
		buffer.append("TOTAL = " + String.format("R$.2f", total));
		return buffer.toString();
	}
	
	public List<Cliente> listarClientes(){
		return this.repositorioCliente;
	}

	private Integer definirProxId() throws Exception {
		List<Compra> repositorioCompra = compraBD.consultar();

		int size = repositorioCompra.size();
		if (size == 0) {
			return 0;
		}
		int maior = 0;
		for (int i = 0; i < size; i++) {
			int atual = repositorioCompra.get(i).getId();
			if (atual > maior) {
				maior = atual;
			}
		}
		return maior + 1;
	}
	
	private List<Cliente> mesclarClientes() throws Exception{
		List<Cliente> clientes = new List<>();
		List<PessoaFisica> pfs = pessoaFisicaBD.consultar();
		List<PessoaJuridica> pjs = pessoaJuridicaBD.consultar();
		int size = pfs.size();
		for(int i = 0; i < size; i++) {
			clientes.addLast(pfs.get(i));
		}
		size = pjs.size();
		for(int i = 0; i < size; i++) {
			clientes.addLast(pjs.get(i));
		}
		return clientes;
	}
	
	private Produto buscarProduto(String nome) throws Exception {
		int size = repositorioProduto.size();
		for(int i = 0; i < size; i++) {
			var produto = repositorioProduto.get(i);
			if(produto.getNome().equals(nome)) {
				return produto;
			}
		}
		throw new Exception("Produto não encontrado!");
	}
}
