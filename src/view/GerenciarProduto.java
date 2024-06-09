package view;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.text.ParseException;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GerenciarProduto extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtCodigoProduto;
	private JTextField txtNomeProduto;

	/**
	 * Launch the application.
	 */
	/*
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GerenciarProduto frame = new GerenciarProduto();
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
		txtCodigoProduto.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				txtCodigoProduto.setText("");
				txtCodigoProduto.setSelectedTextColor(null);
			}
			@Override
			public void focusLost(FocusEvent e) {
				txtCodigoProduto.setText("00001...");
				txtCodigoProduto.setSelectedTextColor(Color.LIGHT_GRAY);
			}
		});
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
		txtNomeProduto.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				txtNomeProduto.setText("");
				txtNomeProduto.setSelectedTextColor(null);
			}
			@Override
			public void focusLost(FocusEvent e) {
				txtNomeProduto.setText("Nome aqui");
				txtNomeProduto.setSelectedTextColor(Color.LIGHT_GRAY);
			}
		});
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
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
			
			}
		});
		btnAdicionarProduto.setFont(new Font("Cambria", Font.PLAIN, 18));
		btnAdicionarProduto.setBounds(18, 250, 204, 25);
		panel.add(btnAdicionarProduto);
		
		JButton btnConsultarProduto = new JButton("Consultar Produto");
		btnConsultarProduto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ConsultarProduto cP = new ConsultarProduto();
				dispose();
				cP.setVisible(true);
				
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
