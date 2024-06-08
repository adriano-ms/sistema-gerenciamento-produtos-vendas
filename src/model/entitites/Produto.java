package model.entitites;

public class Produto {
	private int codigo;
	private String nome;
	private double valor;
	private String descricao;
	private int qtdEmEstoque;
	private TipoProduto tipo;
	
	public Produto() {
		tipo = new TipoProduto();
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public int getQtdEmEstoque() {
		return qtdEmEstoque;
	}

	public void setQtdEmEstoque(int qtdEmEstoque) {
		this.qtdEmEstoque = qtdEmEstoque;
	}

	public TipoProduto getTipo() {
		return tipo;
	}

	public void setTipo(TipoProduto tipo) {
		this.tipo = tipo;
	}
	
	public String toString() {
		return codigo + ","
				+ nome + ","
				+ valor + ","
				+ descricao + ","
				+ qtdEmEstoque + ","
				+ (tipo == null ? "-1" : String.valueOf(tipo.getCodigo()));
	}
	
}
