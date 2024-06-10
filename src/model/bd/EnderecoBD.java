package model.bd;

import br.edu.fateczl.list.List;
import model.entities.Endereco;

public class EnderecoBD implements IDatabaseAccess<Endereco>{
	
	private String filename = "endereco.csv";
	private DatabaseAccess database;
	
	public EnderecoBD() {
		database = new DatabaseAccess();
	}

	@Override
	public List<Endereco> consultar() {
		return carregarListaEndereco();
	}

	@Override
	public void adicionar(Endereco endereco) {
		database.gravarNoArquivo(filename, endereco);
	}

	@Override
	public void alterar(List<Endereco> enderecosAtualizados) {
		database.alterarArquivo(filename, enderecosAtualizados);
	}
	
	private List<Endereco> carregarListaEndereco(){
		List<List<String>> listaRetorno = database.lerArquivo(filename);
		List<Endereco> listaEnderecos = new List<Endereco>();
		int qtdEndereco = listaRetorno.size();
		
		try {			
			for (int i = 1; i < qtdEndereco; i++) {
				List<String> dados = listaRetorno.get(i);
				Endereco endereco = new Endereco();
				
				endereco.setCodigo(Integer.parseInt(dados.get(0)));
				endereco.setLogradouro(dados.get(1));
				endereco.setNumero(Integer.parseInt(dados.get(2)));
				endereco.setComplemento(dados.get(3));
				endereco.setCep(dados.get(4));
				
				listaEnderecos.addLast(endereco);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listaEnderecos;
	}

}
