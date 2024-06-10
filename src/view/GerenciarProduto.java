package view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import controller.ControladorProduto;


public class GerenciarProduto extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtCodigoProduto;
	private JTextField txtNomeProduto;

	
	public GerenciarProduto() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 521, 398);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 485, 337);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblGerenciarProdutos = new JLabel("Gerenciar Produtos");
		lblGerenciarProdutos.setHorizontalAlignment(SwingConstants.CENTER);
		lblGerenciarProdutos.setFont(new Font("Cambria", Font.PLAIN, 24));
		lblGerenciarProdutos.setBounds(110, 22, 273, 63);
		panel.add(lblGerenciarProdutos);
		
		JLabel lblCodigoProduto = new JLabel("Código do Produto:");
		lblCodigoProduto.setFont(new Font("Cambria", Font.PLAIN, 18));
		lblCodigoProduto.setHorizontalAlignment(SwingConstants.CENTER);
		lblCodigoProduto.setBounds(66, 109, 156, 32);
		panel.add(lblCodigoProduto);
		
		txtCodigoProduto = new JTextField();
		txtCodigoProduto.setFont(new Font("Cambria", Font.PLAIN, 18));
		
		txtCodigoProduto.setBounds(241, 116, 120, 25);
		panel.add(txtCodigoProduto);
		txtCodigoProduto.setColumns(10);
		
		JLabel lblNomeProduto = new JLabel("Nome do Produto:");
		lblNomeProduto.setHorizontalAlignment(SwingConstants.CENTER);
		lblNomeProduto.setFont(new Font("Cambria", Font.PLAIN, 18));
		lblNomeProduto.setBounds(66, 172, 156, 32);
		panel.add(lblNomeProduto);
		
		txtNomeProduto = new JTextField();
		txtNomeProduto.setFont(new Font("Cambria", Font.PLAIN, 18));
	
		txtNomeProduto.setColumns(10);
		txtNomeProduto.setBounds(241, 172, 120, 25);
		panel.add(txtNomeProduto);
		
		JButton btnAdicionarProduto = new JButton("Adicionar Produto +");
		btnAdicionarProduto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					AdicionarProduto aP = new AdicionarProduto();
					
					dispose();
					aP.setVisible(true);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, e1.getMessage());
				}
				
				
			
			}
		});
		btnAdicionarProduto.setFont(new Font("Cambria", Font.PLAIN, 18));
		btnAdicionarProduto.setBounds(18, 250, 204, 25);
		panel.add(btnAdicionarProduto);
		
		JButton btnConsultarProduto = new JButton("Consultar Produto");
		btnConsultarProduto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					ControladorProduto ctrlProd = new ControladorProduto();
					
					if (!txtCodigoProduto.getText().trim().isEmpty()) {
						var produto = ctrlProd.consultarProduto(Integer.valueOf(txtCodigoProduto.getText()));
						
						ConsultarProduto cP = new ConsultarProduto(produto);
						
						dispose();
						cP.setVisible(true);
						
					} else if (!txtNomeProduto.getText().trim().isEmpty()) {
						var produto = ctrlProd.consultarProduto(txtNomeProduto.getText());
						
						ConsultarProduto cP = new ConsultarProduto(produto);
						
						dispose();
						cP.setVisible(true);
					} else {
						throw new Exception("Preencha ao menos um campo!");
					}
						
				
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, e1.getMessage());
				}
				
				
				
											
			}
		});
		btnConsultarProduto.setFont(new Font("Cambria", Font.PLAIN, 18));
		btnConsultarProduto.setBounds(253, 250, 204, 25);
		panel.add(btnConsultarProduto);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new Main().setVisible(true);
				
			}
		});
		btnVoltar.setFont(new Font("Cambria", Font.PLAIN, 18));
		btnVoltar.setBounds(142, 301, 204, 25);
		panel.add(btnVoltar);
	}

}
