package model.bd;

import br.edu.fateczl.list.List;
import model.entitites.TipoProduto;

public class TipoProdutoBD implements IDatabaseAccess<TipoProduto>{

	private String filename = "tipoProduto.csv";
	private DatabaseAccess database;
	
	public TipoProdutoBD() {
		database = new DatabaseAccess();
	}
	
	@Override
	public List<TipoProduto> consultar() {
		return carregarTipoProduto();
	}

	@Override
	public void adicionar(TipoProduto tipo) {
		database.gravarNoArquivo(filename, tipo);
	}

	@Override
	public void alterar(List<TipoProduto> tiposAtualizados) {
		database.alterarArquivo(filename, tiposAtualizados);
	}
	
	private List<TipoProduto> carregarTipoProduto() {
		List<List<String>> listaRetorno = database.lerArquivo(filename);
		List<TipoProduto> listaTipos = new List<TipoProduto>();
		try {			
			int qtdTipos = listaRetorno.size();
			for (int i = 1; i < qtdTipos; i++) {
				int codigo = Integer.parseInt(listaRetorno.get(i).get(0));
				String nome = listaRetorno.get(i).get(1);
				TipoProduto tipo = new TipoProduto(codigo,nome);
				listaTipos.addLast(tipo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listaTipos;
	}


}
