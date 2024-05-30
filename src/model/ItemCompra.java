package model;

public class ItemCompra {
	private Produto produto;
	private int quantidade;
	private Carrinho carrinho;
	
	public ItemCompra() {
		// TODO Auto-generated constructor stub
	}
	
	private double subTotal() {
		return 0;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public Carrinho getCarrinho() {
		return carrinho;
	}

	public void setCarrinho(Carrinho carrinho) {
		this.carrinho = carrinho;
	}
	
}
