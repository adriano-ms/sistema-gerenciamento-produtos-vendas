package view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

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
				Carrinho carrinho = new Carrinho(new ComprarProduto(null, null));
				new ComprarProduto(carrinho.getTblCarrinho(), carrinho).setVisible(true);
				dispose();
			}
		});
		btnComprar.setBounds(216, 235, 140, 49);
		panel.add(btnComprar);
		
		JButton consultarCompra = new JButton("Consultar Compras");
		consultarCompra.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ConsultaCompra consultaCompra = new ConsultaCompra();
				consultaCompra.setVisible(true);
			}
		});
		consultarCompra.setBounds(10, 235, 161, 49);
		panel.add(consultarCompra);
	}
}
