package model.entitites;

import br.edu.fateczl.list.List;

public class Carrinho {
	
	private List<ItemCompra> lista;
	
	public Carrinho() {
		lista = new List();
	}
	
	public double calcularTotal() {
		int tamanho = lista.size();
		double total = 0;
		for (int i = 0; i < tamanho; i++) {
			try {
				ItemCompra item = lista.get(i);
				total += item.getQuantidade() * item.getProduto().getValor();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return total;
	}
	
	public void adicionarProduto(Integer codigo, Integer qtde) {
		
		
	}
	
	public void removerProduto(Integer codigo, Integer qtde) {
		
	}
	
	private boolean isEmpty() {
		return lista.isEmpty();
	}
}
