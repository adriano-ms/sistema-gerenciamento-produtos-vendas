package model.bd;

import java.text.SimpleDateFormat;

import br.edu.fateczl.list.List;
import model.entitites.Compra;
import model.entitites.PessoaFisica;
import model.entitites.PessoaJuridica;

public class CompraBD implements IDatabaseAccess<Compra>{

	DatabaseAccess database;
	String filename = "compra.csv";
	
	public CompraBD() {
		database = new DatabaseAccess();
	}
	
	@Override
	public List<Compra> consultar() {
		return carregarCompras();
	}

	@Override
	public void adicionar(Compra compra) {
		database.gravarNoArquivo(filename, compra);
	}

	@Override
	public void alterar(List<Compra> comprasAtualizadas) {
		database.alterarArquivo(filename, comprasAtualizadas);
	}
	
	private List<Compra> carregarCompras(){
		List<Compra> listaCompras = new List<Compra>();
		List<List<String>> listaRetorno = database.lerArquivo(filename);
		List<PessoaFisica> listaPessoaF = new PessoaFisicaBD().consultar();
		List<PessoaJuridica> listaPessoaJ = new PessoaJuridicaBD().consultar();
		int qtdClientesPF = listaPessoaF.size();
		int qtdClientesPJ = listaPessoaJ.size();
		
		try {
			int qtdCompras = listaRetorno.size();
			for (int i = 1; i < qtdCompras; i++) {
				List<String> dados = listaRetorno.get(i);
				Compra compra = new Compra();
				
				compra.setId(Integer.parseInt(dados.get(0)));
				compra.setData(new SimpleDateFormat("dd/MM/yyyy - HH:mm").parse(dados.get(1)));
				compra.setTipoPessoa(dados.get(2));
				int idCliente = Integer.parseInt(dados.get(3));
				compra.setTotal(Double.parseDouble(dados.get(4)));
				
				if(compra.getTipoPessoa().contains("fisica")) {
					for (int j = 0; j < qtdClientesPF; j++) {
						if(idCliente == listaPessoaF.get(i).getId()) {
							compra.setCliente(listaPessoaF.get(i));
							break;
						}
					}
				}else {
					for (int j = 0; j < qtdClientesPJ; j++) {
						if(idCliente == listaPessoaJ.get(i).getId()) {
							compra.setCliente(listaPessoaJ.get(i));
							break;
						}
					}
				}
				listaCompras.addLast(compra);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return listaCompras;
	}
	
}
