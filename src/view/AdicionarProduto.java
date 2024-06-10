package view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.util.Locale;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.text.NumberFormatter;

import controller.ControladorProduto;
import model.entities.Produto;
import model.entities.TipoProduto;

public class AdicionarProduto extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtCodigoProduto;
	private JTextField txtNomeProduto;
	private JTextField txtQuantidade;
	private JTextField txtValor;
	private JTextField txtDescricao;


	

	
	public AdicionarProduto() throws Exception {	
		
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
		txtQuantidade.setBounds(257, 201, 63, 25);
		panel.add(txtQuantidade);
		
		//MaskFormatter mascaraValor = new MaskFormatter("R$#,#");
	
		NumberFormat currencyFormat = NumberFormat.getCurrencyInstance(new Locale("pt","BR"));
		currencyFormat.setMaximumFractionDigits(2);
		
		NumberFormatter currencyFormatter = new NumberFormatter(currencyFormat);
		currencyFormatter.setValueClass(Double.class);
		currencyFormatter.setAllowsInvalid(false);
		currencyFormatter.setMinimum(0.0);
		currencyFormatter.setMaximum(Double.MAX_VALUE);
		
		JLabel lblTipoProduto = new JLabel("Tipo do Produto:");
		lblTipoProduto.setHorizontalAlignment(SwingConstants.CENTER);
		lblTipoProduto.setFont(new Font("Cambria", Font.PLAIN, 18));
		lblTipoProduto.setBounds(82, 244, 156, 32);
		panel.add(lblTipoProduto);
		
		
		ControladorProduto ctrlProd = new ControladorProduto();
		
		var tipoProduto = ctrlProd.listarTipos();
		
		
		String[] items = new String[tipoProduto.size()];
		
		for(int i = 0; i < items.length; i++) {
			items[i] = tipoProduto.get(i).getCodigo() + " - " + tipoProduto.get(i).getNome();
		}
		
		DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>(items);
		
		
		
		JComboBox<String> cbxTipoProduto = new JComboBox<>(model);
		cbxTipoProduto.setBounds(257, 247, 156, 32);
		panel.add(cbxTipoProduto);
			
		
		JLabel lblDescricao = new JLabel("Descrição");
		lblDescricao.setHorizontalAlignment(SwingConstants.CENTER);
		lblDescricao.setFont(new Font("Cambria", Font.PLAIN, 18));
		lblDescricao.setBounds(82, 294, 156, 32);
		panel.add(lblDescricao);
		
		JButton btnAdicionarProduto = new JButton("Adicionar Produto +");
		btnAdicionarProduto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					try {
					Produto produto = new Produto();
					produto.setCodigo(Integer.valueOf(txtCodigoProduto.getText()));
					produto.setNome(txtNomeProduto.getText());
					produto.setDescricao(txtDescricao.getText());
					produto.setQtdEmEstoque(Integer.valueOf(txtQuantidade.getText()));
					produto.setValor(Double.valueOf(txtValor.getText()));
					
					int codTipo = Integer.parseInt(String.valueOf(((String)cbxTipoProduto.getSelectedItem()).charAt(0)));
					int size = tipoProduto.size();
					for(int i = 0; i < size; i++) {
						var tipo = tipoProduto.get(i);
						if(tipo.getCodigo() == codTipo) {
							produto.setTipo(tipo);
						}
					}
					
						ctrlProd.adicionarProduto(produto);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, e1.getMessage());
				}
			}
		});
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
		
		txtValor = new JTextField();
		txtValor.setFont(new Font("Cambria", Font.PLAIN, 18));
		txtValor.setColumns(10);
		txtValor.setBounds(257, 158, 63, 25);
		panel.add(txtValor);
		
		txtDescricao = new JTextField();
		txtDescricao.setFont(new Font("Cambria", Font.PLAIN, 18));
		txtDescricao.setColumns(10);
		txtDescricao.setBounds(257, 297, 231, 70);
		panel.add(txtDescricao);
		
	}
}
