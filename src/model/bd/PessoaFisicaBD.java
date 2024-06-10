package model.bd;

import br.edu.fateczl.list.List;
import model.entities.Endereco;
import model.entities.PessoaFisica;

public class PessoaFisicaBD implements IDatabaseAccess<PessoaFisica>{

	private DatabaseAccess database;
	private String filename = "pessoaFisica.csv";
	
	public PessoaFisicaBD() {
		database = new DatabaseAccess();
	}
	
	@Override
	public List<PessoaFisica> consultar() {
		return carregarPessoasFisicas();
	}

	@Override
	public void adicionar(PessoaFisica pessoaF) {
		database.gravarNoArquivo(filename, pessoaF);
	}

	@Override
	public void alterar(List<PessoaFisica> pessoasAtualizados) {
		database.alterarArquivo(filename, pessoasAtualizados);
	}
	
	private List<PessoaFisica> carregarPessoasFisicas() {
		List<List<String>> listaRetorno = database.lerArquivo(filename);
		List<PessoaFisica> listaPF = new List<PessoaFisica>();
		List<Endereco> listaEndereco = (new EnderecoBD()).consultar();
		int qtdEnderecos = listaEndereco.size();
		
		try {			
			int qtdPF = listaRetorno.size();
			for (int i = 1; i < qtdPF; i++) {
				List<String> dados = listaRetorno.get(i);
				PessoaFisica pessoaF = new PessoaFisica();
				pessoaF.setId(Integer.parseInt(dados.get(0)));
				pessoaF.setNome(dados.get(1));
				pessoaF.setEndereco(null);
				pessoaF.setCpf(dados.get(3));
				pessoaF.setCelular(dados.get(4));
				
				int codEndereco = Integer.parseInt(dados.get(2));
				Endereco endereco;
				for (int j = 0; j < qtdEnderecos; j++) {
					if(codEndereco == listaEndereco.get(i).getCodigo()) {
						endereco = listaEndereco.get(i);
						pessoaF.setEndereco(endereco);
						break;
					}
				}
				listaPF.addLast(pessoaF);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return listaPF;
	}
	
}
