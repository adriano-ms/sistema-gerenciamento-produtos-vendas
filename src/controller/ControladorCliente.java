package controller;

import br.edu.fateczl.list.List;
import model.Cliente;
import model.db.ClienteBD;

public class ControladorCliente {

	private ClienteBD clienteBD;
	
	public ControladorCliente() {
		super();
	}
	
	public void setClienteBD(ClienteBD clienteBD) {
		this.clienteBD = clienteBD;
	}

	public void cadastrar(Cliente cliente) {
		
	}
	
	public Cliente consultar(int id) throws Exception {
		List<Cliente> lista = clienteBD.carregarDados();
		int size = lista.size();
		for(int i = 0; i < size; i++) {
			try {
				if(lista.get(i).getId().equals(id)) {
					return lista.get(i);
				}
			} catch (Exception e) {
				throw new Exception("Ocorreu um erro em sua busca, tente novamente!");
			}
		}
		throw new Exception("Cliente com ID " + id + " não existe!");
	}
	
	public Cliente editar(Cliente cliente) {
		return cliente;
	}
	
	public Cliente remover(int id) throws Exception {
		List<Cliente> lista = clienteBD.carregarDados();
		int size = lista.size();
		for(int i = 0; i < size; i++) {
			try {
				if(lista.get(i).getId().equals(id)) {
					Cliente aux = lista.get(i);
					lista.remove(i);
					return aux;
				}
			} catch (Exception e) {
				throw new Exception("Ocorreu um erro na remoção, tente novamente!");
			}
		}
		throw new Exception("Cliente com ID " + id + " não existe!");
		
	}
	
	private boolean validarDados(Cliente cliente) {
		return false;
	}

}
