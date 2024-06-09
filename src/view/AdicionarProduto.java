package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;
import javax.swing.text.NumberFormatter;
import javax.swing.JLabel;
import java.awt.Font;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JFormattedTextField;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AdicionarProduto extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtCodigoProduto;
	private JTextField txtNomeProduto;
	private JTextField txtQuantidade;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdicionarProduto frame = new AdicionarProduto();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws ParseException 
	 */
	public AdicionarProduto() throws ParseException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 577, 508);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 541, 447);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblAdicionarProduto = new JLabel("Adicionar Produto");
		lblAdicionarProduto.setHorizontalAlignment(SwingConstants.CENTER);
		lblAdicionarProduto.setFont(new Font("Cambria", Font.PLAIN, 24));
		lblAdicionarProduto.setBounds(160, 11, 231, 47);
		panel.add(lblAdicionarProduto);
		
		JLabel lblCodigoProduto = new JLabel("Código do Produto:");
		lblCodigoProduto.setHorizontalAlignment(SwingConstants.CENTER);
		lblCodigoProduto.setFont(new Font("Cambria", Font.PLAIN, 18));
		lblCodigoProduto.setBounds(82, 69, 156, 32);
		panel.add(lblCodigoProduto);
		
		txtCodigoProduto = new JTextField();
		txtCodigoProduto.setFont(new Font("Cambria", Font.PLAIN, 18));
		txtCodigoProduto.setColumns(10);
		txtCodigoProduto.setBounds(257, 76, 120, 25);
		panel.add(txtCodigoProduto);
		
		JLabel lblNomeProduto = new JLabel("Nome do Produto:");
		lblNomeProduto.setHorizontalAlignment(SwingConstants.CENTER);
		lblNomeProduto.setFont(new Font("Cambria", Font.PLAIN, 18));
		lblNomeProduto.setBounds(82, 112, 156, 32);
		panel.add(lblNomeProduto);
		
		txtNomeProduto = new JTextField();
		txtNomeProduto.setFont(new Font("Cambria", Font.PLAIN, 18));
		txtNomeProduto.setColumns(10);
		txtNomeProduto.setBounds(257, 115, 224, 25);
		panel.add(txtNomeProduto);
		
		JLabel lblValorProduto = new JLabel("Valor do Produto:");
		lblValorProduto.setHorizontalAlignment(SwingConstants.CENTER);
		lblValorProduto.setFont(new Font("Cambria", Font.PLAIN, 18));
		lblValorProduto.setBounds(82, 155, 156, 32);
		panel.add(lblValorProduto);
		
		JLabel lblQuantidade = new JLabel("Quantidade:");
		lblQuantidade.setHorizontalAlignment(SwingConstants.CENTER);
		lblQuantidade.setFont(new Font("Cambria", Font.PLAIN, 18));
		lblQuantidade.setBounds(82, 198, 156, 32);
		panel.add(lblQuantidade);
		
		txtQuantidade = new JTextField();
		txtQuantidade.setFont(new Font("Cambria", Font.PLAIN, 18));
		txtQuantidade.setColumns(10);
		txtQuantidade.setBounds(257, 201, 52, 25);
		panel.add(txtQuantidade);
		
		//MaskFormatter mascaraValor = new MaskFormatter("R$#,#");
	
		NumberFormat currencyFormat = NumberFormat.getCurrencyInstance(new Locale("pt","BR"));
		currencyFormat.setMaximumFractionDigits(2);
		
		NumberFormatter currencyFormatter = new NumberFormatter(currencyFormat);
		currencyFormatter.setValueClass(Double.class);
		currencyFormatter.setAllowsInvalid(false);
		currencyFormatter.setMinimum(0.0);
		currencyFormatter.setMaximum(Double.MAX_VALUE);
		
		
		JFormattedTextField ftfValorProduto = new JFormattedTextField(currencyFormatter);
		ftfValorProduto.setColumns(10);
		ftfValorProduto.setBounds(257, 164, 74, 20);
		panel.add(ftfValorProduto);
		
		JLabel lblTipoProduto = new JLabel("Tipo do Produto:");
		lblTipoProduto.setHorizontalAlignment(SwingConstants.CENTER);
		lblTipoProduto.setFont(new Font("Cambria", Font.PLAIN, 18));
		lblTipoProduto.setBounds(82, 244, 156, 32);
		panel.add(lblTipoProduto);
		
		JComboBox cbxTipoProduto = new JComboBox();
		cbxTipoProduto.setBounds(257, 247, 156, 32);
		panel.add(cbxTipoProduto);
		
		JLabel lblDescricao = new JLabel("Descrição");
		lblDescricao.setHorizontalAlignment(SwingConstants.CENTER);
		lblDescricao.setFont(new Font("Cambria", Font.PLAIN, 18));
		lblDescricao.setBounds(82, 294, 156, 32);
		panel.add(lblDescricao);
		
		JTextArea txtADescricao = new JTextArea();
		txtADescricao.setBounds(257, 290, 224, 65);
		panel.add(txtADescricao);
		
		JButton btnAdicionarProduto = new JButton("Adicionar Produto +");
		btnAdicionarProduto.setFont(new Font("Cambria", Font.PLAIN, 18));
		btnAdicionarProduto.setBounds(50, 390, 201, 32);
		panel.add(btnAdicionarProduto);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				GerenciarProduto gP = new GerenciarProduto();
				gP.setVisible(true);
			}
		});
		btnVoltar.setFont(new Font("Cambria", Font.PLAIN, 18));
		btnVoltar.setBounds(291, 390, 189, 32);
		panel.add(btnVoltar);
		
	}
}
