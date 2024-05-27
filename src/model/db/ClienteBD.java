package model.db;

import br.edu.fateczl.list.List;
import model.Cliente;
import model.PessoaFisica;
import model.PessoaJuridica;

public class ClienteBD {
	
	public ClienteBD() {
		super();
	}
	
	public List<Cliente> carregarDados() throws Exception {
		List<Cliente> lista = new List<>();
		for(int i = 0; i < 10; i++) {
			Cliente aux;
			if(i % 2 == 0) {
				aux = new PessoaJuridica(i);
			} else {
				aux = new PessoaFisica(i);
			}
			lista.addLast(aux);
		}
		return lista;
	}
}
