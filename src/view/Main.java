package view;

import java.awt.EventQueue;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JFrame;

import model.entitites.Compra;
import model.entitites.ItemCompra;
import model.entitites.Produto;

public class Main {

	private JFrame frame;

	/**
	 * Launch the application.
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		ItemCompra item = new ItemCompra();
		System.out.println(item.toString());
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy - HH:mm");
		String dataString = dateFormat.format(new Date());
		System.out.println(dataString);
		Date data = dateFormat.parse(dataString);
		System.out.println(dateFormat.format(data));
		
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
