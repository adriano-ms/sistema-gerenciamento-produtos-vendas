package controller;

import br.edu.fateczl.list.List;
import model.bd.CompraBD;
import model.bd.PessoaFisicaBD;
import model.bd.PessoaJuridicaBD;
import model.bd.ProdutoBD;
import model.entities.Carrinho;
import model.entities.Cliente;
import model.entities.Compra;
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
	/*
	public Double checkout(Carrinho carrinho, Cliente cliente) {
		carrinho.finalizarCompra(proxId, cliente.getClass(), null)
	}
	*/
	
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
}
