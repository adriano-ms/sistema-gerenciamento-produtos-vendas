package model.entitites;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Compra {
	private int id;
	private Date data;
	private String tipoPessoa;
	private Cliente cliente;
	private double total;
	
	public Compra(int id, Date data, Cliente cliente, double total) {
		this.id = id;
		this.data = data;
		this.cliente = cliente;
		this.total = total;
	}

	public Compra() {
		super();
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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}
	
	public String getTipoPessoa() {
		return tipoPessoa;
	}
	
	public void setTipoPessoa(String tipoPessoa) {
		this.tipoPessoa = tipoPessoa;
	}
	
	@Override
	public String toString() {
		return id + ","
				+ new SimpleDateFormat("dd/MM/yyyy - HH:mm").format(data) + ","
				+ tipoPessoa + ","
				+ this.getCliente().getId() + ","
				+ total;
	}

}
