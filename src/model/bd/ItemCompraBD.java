package model.bd;

import br.edu.fateczl.list.List;
import model.entities.Compra;
import model.entities.ItemCompra;
import model.entities.Produto;

public class ItemCompraBD implements IDatabaseAccess<ItemCompra>{

	DatabaseAccess database;
	String filename = "itemcompra.csv";
	
	public ItemCompraBD() {
		database = new DatabaseAccess();
	}
	
	@Override
	public List<ItemCompra> consultar() {
		return carregarItensCompra();
	}

	@Override
	public void adicionar(ItemCompra item) {
		database.gravarNoArquivo(filename, item);
	}

	@Override
	public void alterar(List<ItemCompra> itensAtualizados) {
		database.alterarArquivo(filename, itensAtualizados);
	}
	
	private List<ItemCompra> carregarItensCompra(){
		List<ItemCompra> listaItens = new List<ItemCompra>();
		List<List<String>> listaRetorno = new List<List<String>>();
		List<Produto> listaProdutos = new ProdutoBD().consultar();
		List<Compra> listaCompras = new CompraBD().consultar();
		int qtdProdutos = listaProdutos.size();
		int qtdCompras = listaCompras.size();
		
		try {
			int qtdItens = listaRetorno.size();
			for (int i = 0; i < qtdItens; i++) {
				List<String> dados = listaRetorno.get(i);
				ItemCompra item = new ItemCompra();
				item.setId(Integer.parseInt(dados.get(0)));
				int idProduto = Integer.parseInt(dados.get(1));
				item.setQuantidade(Integer.parseInt(dados.get(2)));
				int idCompra = Integer.parseInt(dados.get(3));
				
				for (int j = 0; j < qtdProdutos; j++) {
					if(idProduto == listaProdutos.get(i).getCodigo()) {
						item.setProduto(listaProdutos.get(i));
						break;
					}
				}
				for (int j = 0; j < qtdCompras; j++) {
					if(idCompra == listaCompras.get(i).getId()) {
						item.setCompra(listaCompras.get(i));
						break;
					}
				}
				listaItens.addLast(item);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return listaItens;
	}

}
