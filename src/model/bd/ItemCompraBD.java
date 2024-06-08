package model.bd;

import br.edu.fateczl.list.List;
import model.entitites.Compra;
import model.entitites.ItemCompra;
import model.entitites.Produto;

public class ItemCompraBD implements IDatabaseAccess<ItemCompra>{

	@Override
	public List<ItemCompra> consultar() {
		return carregarItensCompra();
	}

	@Override
	public void adicionar(ItemCompra objeto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void alterar(List<ItemCompra> objetosAtualizados) {
		// TODO Auto-generated method stub
		
	}
	
	private List<ItemCompra> carregarItensCompra(){
		List<ItemCompra> listaItens = new List<ItemCompra>();
		List<List<String>> listaRetorno = new List<List<String>>();
		List<Produto> listaProdutos = new ProdutoBD().consultar();
		List<Compra> listaCompra = new CompraBD().consultar();
		
		try {
			int qtdItens = listaRetorno.size();
			for (int i = 0; i < qtdItens; i++) {
				List<String> dados = listaRetorno.get(i);
				ItemCompra item = new ItemCompra();
				item.setId(Integer.parseInt(dados.get(0)));
				item.setProduto(null);
				item.setQuantidade(Integer.parseInt(dados.get(2)));
				item.setCompra(null);
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return listaItens;
	}

}
