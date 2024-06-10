package view;

import java.awt.EventQueue;

import javax.swing.JFrame;

import br.edu.fateczl.list.List;
import model.bd.PessoaFisicaBD;
import model.entities.Carrinho;
import model.entities.Endereco;
import model.entities.PessoaFisica;
import model.entities.Produto;

public class Main {

	private JFrame frame;

	/**
	 * Launch the application.
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		
		PessoaFisica pf = new PessoaFisica();
		pf.setId(1);
		pf.setNome("Leudinho");
		pf.setCpf("512313980123");
		Endereco end = new Endereco();
		end.setCodigo(0);
		pf.setEndereco(end);
		pf.setCelular("1192342325");
		PessoaFisicaBD pfBD = new PessoaFisicaBD();
		List<PessoaFisica> lista = new List<PessoaFisica>();
		//lista.add(pf, 0);
		pfBD.alterar(lista);
		
		Produto prod = new Produto();
		prod.setCodigo(1);
		prod.setNome("OPA");
		prod.setDescricao("LEROLERO");
		prod.setValor(10);
		Carrinho carrinho = new Carrinho();
		
		carrinho.adicionarProduto(prod, 4, 1);
		
		carrinho.alterarQuantidadeProduto(1, 8);
		
		carrinho.finalizarCompra(1, "fisica", pf);
		
		System.out.println(carrinho.calcularTotal());
		
//		Date teste = dateFormat.parse(dat);
//		System.out.println(teste.toString());
//		ProdutoBD prodBD = new ProdutoBD();
//		List<Produto> linhas = prodBD.consultar();
//		System.out.println(linhas.get(0).toString());
//		Produto produto = new Produto();
//		produto.setCodigo(01);
//		produto.setNome("NomeProduto");
//		produto.setDescricao("Descrição do produto aqui");
//		produto.setQtdEmEstoque(10);
//		produto.setValor(29.1);
//		TipoProduto tipo = new TipoProduto();
//		tipo.setCodigo(2);
//		produto.setTipo(tipo);
//		
//		Produto produto2 = new Produto();
//		produto2.setCodigo(02);
//		produto2.setNome("NomeProduto2");
//		produto2.setDescricao("Descrição do produto aqui");
//		produto2.setQtdEmEstoque(11);
//		produto2.setValor(11.1);
//		produto2.setTipo(tipo);
//		
//		List<Produto> lista = new List();
//		lista.addFirst(produto);
//		lista.addLast(produto2);

		//DatabaseAccess database = new DatabaseAccess();
		//database.criarArquivo(Paths.get("/database/teste.txt"), new PessoaFisica());
		
//		prodBD.alterar(lista);
//		prodBD.adicionar(produto);
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Main() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
