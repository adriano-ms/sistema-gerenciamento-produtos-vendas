package model.entitites;

public class TipoProduto {
	private int codigo;
	private String nome;
	
	public TipoProduto() {
		super();
	}

	public TipoProduto(int codigo, String nome) {
		this.codigo = codigo;
		this.nome = nome;
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
	
	@Override
	public String toString() {
		return codigo + "," + nome;
	}

}
