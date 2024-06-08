package model.bd;

import br.edu.fateczl.list.List;
import model.entitites.Endereco;
import model.entitites.PessoaJuridica;

public class PessoaJuridicaBD implements IDatabaseAccess<PessoaJuridica>{

	DatabaseAccess database;
	String filename = "pessoaJuridica.csv";
	
	public PessoaJuridicaBD() {
		database = new DatabaseAccess();
	}
	
	@Override
	public List<PessoaJuridica> consultar() {
		return carregarPessoasJuridicas();
	}

	@Override
	public void adicionar(PessoaJuridica pessoaJ) {
		database.gravarNoArquivo(filename, pessoaJ);
	}

	@Override
	public void alterar(List<PessoaJuridica> pessoasAtualizados) {
		database.alterarArquivo(filename, pessoasAtualizados);
	}
	
	private List<PessoaJuridica> carregarPessoasJuridicas() {
		List<List<String>> listaRetorno = database.lerArquivo(filename);
		List<PessoaJuridica> listaPJ = new List<PessoaJuridica>();
		List<Endereco> listaEndereco = (new EnderecoBD()).consultar();
		int qtdEnderecos = listaEndereco.size();
		
		try {			
			int qtdPJ = listaRetorno.size();
			for (int i = 1; i < qtdPJ; i++) {
				List<String> dados = listaRetorno.get(i);
				PessoaJuridica pessoaJ = new PessoaJuridica();
				pessoaJ.setId(Integer.parseInt(dados.get(0)));
				pessoaJ.setNome(dados.get(1));
				pessoaJ.setEndereco(null);
				pessoaJ.setCnpj(dados.get(3));
				pessoaJ.setTelefone(dados.get(4));
				pessoaJ.setEmail(dados.get(5));
				
				int codEndereco = Integer.parseInt(dados.get(2));
				Endereco endereco;
				for (int j = 0; j < qtdEnderecos; j++) {
					if(codEndereco == listaEndereco.get(i).getCodigo()) {
						endereco = listaEndereco.get(i);
						pessoaJ.setEndereco(endereco);
						break;
					}
				}
				listaPJ.addLast(pessoaJ);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return listaPJ;
	}
}	
