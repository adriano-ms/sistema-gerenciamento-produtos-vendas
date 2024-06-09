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
