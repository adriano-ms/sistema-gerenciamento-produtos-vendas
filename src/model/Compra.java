package model;

import java.util.Date;

public class Compra {
	private Date data;
	private Cliente cliente;
	
	public Compra() {
		// TODO Auto-generated constructor stub
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
}
