package model;

public abstract class Cliente {
	
	private Integer id;
	
	public Cliente(int id) {
		this.id = id;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

}
