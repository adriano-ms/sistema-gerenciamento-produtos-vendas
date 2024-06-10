package model.entities;

import java.util.Date;

import br.edu.fateczl.queue.Queue;
import model.bd.CompraBD;
import model.bd.ItemCompraBD;

public class Carrinho {
	
	private Queue<ItemCompra> pilha;
	
	public Carrinho() {
		pilha = new Queue<ItemCompra>();
	}
	
	public Queue<ItemCompra> getPilha() {
		return pilha;
	}

	public double calcularTotal() {
		//Queue<ItemCompra> pilhaAux = pilha;
		double total = 0;
		for (ItemCompra item : pilha) {
			total += item.subTotal();
		}
//		int tamanho = pilha.size();
//		double total = 0;
//		for (int i = 0; i < tamanho; i++) {
//			try {
//				pilha.
//				total += lista.get(i).subTotal();
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//		}
		return total;
	}
	
	public void adicionarProduto(Produto produto, int qtde, int idItemCompra) {
		ItemCompra item = new ItemCompra();
		item.setProduto(produto);
		item.setQuantidade(qtde);
		item.setId(idItemCompra);
		try {
			pilha.insert(item);
//			lista.addLast(item);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void alterarQuantidadeProduto(int codProduto, int qtde) {
		for (ItemCompra item : pilha) {
			if(item.getProduto().getCodigo() == codProduto) {
				if(qtde <= 0) {
					removerProduto(codProduto);
				}else {
					item.setQuantidade(qtde);
				}
			}
		}
	}
	
	public void removerProduto(int codProduto) {
		Queue<ItemCompra> pilhaAux = new Queue<ItemCompra>();
		try {			
			for (ItemCompra item : pilha) {
				pilha.remove();
				if(item.getProduto().getCodigo() != codProduto) {
					pilhaAux.insert(item);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		pilha = pilhaAux;
	}

	public boolean finalizarCompra(int idCompra, String tipoPessoa, Cliente cliente) {
		try {
			Compra compra = new Compra(idCompra, new Date(), tipoPessoa, cliente, this.calcularTotal());
			CompraBD registrarCompra = new CompraBD();
			registrarCompra.adicionar(compra);
			
			ItemCompraBD registrarItens = new ItemCompraBD();
			for (ItemCompra item : pilha) {
				item.setCompra(compra);
				registrarItens.adicionar(item);
			}
		} catch (Exception e) {
			return false;
		}
		return true;
	}
	
	public boolean isEmpty() {
		return pilha.isEmpty();
	}
}
