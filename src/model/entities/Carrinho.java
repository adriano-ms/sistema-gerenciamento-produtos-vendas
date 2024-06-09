package model.entities;

import java.util.Date;
import br.edu.fateczl.list.List;
import model.bd.CompraBD;

public class Carrinho {
	
	private List<ItemCompra> lista;
	
	public Carrinho() {
		lista = new List<ItemCompra>();
	}
	
	public double calcularTotal() {
		int tamanho = lista.size();
		double total = 0;
		for (int i = 0; i < tamanho; i++) {
			try {
				total += lista.get(i).subTotal();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return total;
	}
	
	public void adicionarProduto(Produto produto, Integer qtde, int id) {
		ItemCompra item = new ItemCompra();
		item.setProduto(produto);
		item.setQuantidade(qtde);
		item.setId(id);
		try {
			lista.addLast(item);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void removerProduto(int codProduto, Integer qtde) {
		try {			
			int tamanho = lista.size();
			for (int i = 0; i < tamanho; i++) {
				if(lista.get(i).getProduto().getCodigo() == codProduto) {
					int qtd = lista.get(i).getQuantidade();
					if(qtde >= qtd)
						lista.remove(i);
					else
						lista.get(i).setQuantidade(qtd-qtde);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public boolean finalizarCompra(int idCompra, String tipoPessoa, Cliente cliente) {
		try {
			Compra compra = new Compra(idCompra, new Date(), tipoPessoa, cliente, this.calcularTotal());
			CompraBD registrarCompra = new CompraBD();
			registrarCompra.adicionar(compra);
		} catch (Exception e) {
			return false;
		}
		return true;
	}
	
	public boolean isEmpty() {
		return lista.isEmpty();
	}
}
