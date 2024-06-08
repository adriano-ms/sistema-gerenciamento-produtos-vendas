package model.entitites;

public class ItemCompra {

	private int id;
	private Produto produto;
	private int quantidade;
	private Compra compra;
	
	public ItemCompra() {
		super();
	}

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
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

	public Compra getCompra() {
		return compra;
	}

	public void setCompra(Compra compra) {
		this.compra = compra;
	}
	
	@Override
	public String toString() {
		return id + ","
				+ (produto != null ? String.valueOf(produto.getCodigo()) : "-1") + ","
				+ quantidade + ","
				+ (compra != null ? String.valueOf(compra.getId()) : "-1");
	}
	
}
