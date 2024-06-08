package model.bd;

import br.edu.fateczl.list.List;
import model.entitites.Produto;
import model.entitites.TipoProduto;

public class ProdutoBD implements IDatabaseAccess<Produto> {
	
	private String filename = "produto.csv";
	private DatabaseAccess database;
	
	public ProdutoBD() {
		database = new DatabaseAccess();
	}


	@Override
	public void adicionar(Produto produto) {
		database.gravarNoArquivo(filename, produto);
	}


	@Override
	public List<Produto> consultar() {
		List<Produto> lista = carregarListaDeProdutos();
		return lista;
	}


	@Override
	public void alterar(List<Produto> produtosAtualizados) {
		database.alterarArquivo(filename, produtosAtualizados);
	}
	
	private List<Produto> carregarListaDeProdutos(){
		List<List<String>> listaRetorno = database.lerArquivo("produto.csv");
		List<Produto> listaProdutos = new List<Produto>();
		TipoProdutoBD tipoBD = new TipoProdutoBD();
		List<TipoProduto> listaTipos = tipoBD.consultar();
		int qtdItens = listaRetorno.size();			
		
		try {
			for (int i = 1; i < qtdItens; i++) {
				List<String> dados = listaRetorno.get(i);
				Produto prod = new Produto();
				
				prod.setCodigo(Integer.parseInt(dados.get(0)));
				prod.setNome(dados.get(1));
				prod.setValor(Double.parseDouble(dados.get(2)));
				prod.setDescricao(dados.get(3));
				prod.setQtdEmEstoque(Integer.parseInt(dados.get(4)));
				prod.setTipo(null);
				int codTipo = Integer.parseInt(dados.get(5));
				int qtdTipos = listaTipos.size();
				for (int j = 0; j < qtdTipos; j++) {
					if(codTipo == listaTipos.get(i).getCodigo()) {
						prod.setTipo(listaTipos.get(i));
					}
				}
				listaProdutos.addLast(prod);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return listaProdutos;
	}
	
}
