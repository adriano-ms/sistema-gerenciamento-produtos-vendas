<<<<<<< HEAD
package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTabbedPane;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Main extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Main() {
		setResizable(false);
		setTitle("Menu Inicial");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 577, 439);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 584, 379);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblBemVindo = new JLabel("Bem Vindo!");
		lblBemVindo.setHorizontalAlignment(SwingConstants.CENTER);
		lblBemVindo.setFont(new Font("Cambria", Font.PLAIN, 24));
		lblBemVindo.setBounds(210, 36, 161, 77);
		panel.add(lblBemVindo);
		
		JButton btnGerenciarProdutos = new JButton("Gerenciar Produtos");
		btnGerenciarProdutos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GerenciarProduto GP = new GerenciarProduto(); 
				setVisible(false);
				GP.setVisible(true);
				
			}
		});
		btnGerenciarProdutos.setBounds(10, 157, 161, 49);
		panel.add(btnGerenciarProdutos);
		
		JButton btn = new JButton("Gerenciar Tipo Produtos");
		btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new GerenciarTipoProduto().setVisible(true);
				setVisible(false);
				
			}
		});
		btn.setBounds(188, 157, 195, 49);
		panel.add(btn);
		
		JButton btnGerenciarClientes = new JButton("Gerenciar Clientes");
		btnGerenciarClientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new GerenciarCliente().setVisible(true);
				setVisible(false);
			}
		});
		btnGerenciarClientes.setBounds(401, 157, 140, 49);
		panel.add(btnGerenciarClientes);
		
		JButton btnComprar = new JButton("Comprar");
		btnComprar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Carrinho carrinho = new Carrinho();
				new ComprarProduto(carrinho.getTblCarrinho(), carrinho).setVisible(true);;
				dispose();
			}
		});
		btnComprar.setBounds(216, 235, 140, 49);
		panel.add(btnComprar);
	}

}
=======
package view;

import java.awt.EventQueue;

import javax.swing.JFrame;

public class Main {

	private JFrame frame;

	/**
	 * Launch the application.
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		/*
		ControladorCliente controladorCliente = new ControladorCliente();
		for(int i = 0; i < 10; i++) {
			Endereco end = new Endereco();
			end.setLogradouro("Rua " + i);
			end.setCep(i + "");
			end.setComplemento("Complemento " + i);
			end.setCep(i + "");
			end.setNumero(i);
			if(i % 2 == 0) {
				PessoaJuridica cliente = new PessoaJuridica();
				cliente.setNome("Nome " + i);
				cliente.setCnpj(i + "");
				cliente.setEmail("email" + i + "@email.com");
				cliente.setTelefone(i + "");
				cliente.setEndereco(end);
				controladorCliente.cadastrar(cliente);
			} else {
				PessoaFisica cliente = new PessoaFisica();
				cliente.setNome("Nome " + i);
				cliente.setCpf(i + "");
				cliente.setCelular(i + "");
				cliente.setEndereco(end);
				controladorCliente.cadastrar(cliente);
			}
		}
		*/
		
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
>>>>>>> 0519e9f57eba0526b698f3d6c2c4aec50bdfda6e
