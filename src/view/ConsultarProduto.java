package view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import controller.ControladorProduto;
import model.entities.Produto;

public class ConsultarProduto extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	public ConsultarProduto(ControladorProduto controlador, Produto produto) {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 573, 511);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 537, 450);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblConsultaProduto = new JLabel("Adicionar Produto");
		lblConsultaProduto.setHorizontalAlignment(SwingConstants.CENTER);
		lblConsultaProduto.setFont(new Font("Cambria", Font.PLAIN, 24));
		lblConsultaProduto.setBounds(163, 11, 231, 47);
		panel.add(lblConsultaProduto);
		
		JLabel lblCodigoProduto = new JLabel("Código do Produto:");
		lblCodigoProduto.setHorizontalAlignment(SwingConstants.CENTER);
		lblCodigoProduto.setFont(new Font("Cambria", Font.PLAIN, 18));
		lblCodigoProduto.setBounds(83, 74, 156, 32);
		panel.add(lblCodigoProduto);
		
		JLabel lblNomeProduto = new JLabel("Nome do Produto:");
		lblNomeProduto.setHorizontalAlignment(SwingConstants.CENTER);
		lblNomeProduto.setFont(new Font("Cambria", Font.PLAIN, 18));
		lblNomeProduto.setBounds(83, 117, 156, 32);
		panel.add(lblNomeProduto);
		
		JLabel lblValorProduto = new JLabel("Valor do Produto:");
		lblValorProduto.setHorizontalAlignment(SwingConstants.CENTER);
		lblValorProduto.setFont(new Font("Cambria", Font.PLAIN, 18));
		lblValorProduto.setBounds(83, 160, 156, 32);
		panel.add(lblValorProduto);
		
		JLabel lblQuantidade = new JLabel("Quantidade:");
		lblQuantidade.setHorizontalAlignment(SwingConstants.CENTER);
		lblQuantidade.setFont(new Font("Cambria", Font.PLAIN, 18));
		lblQuantidade.setBounds(83, 203, 156, 32);
		panel.add(lblQuantidade);
		
		JLabel lblTipoProduto = new JLabel("Tipo do Produto:");
		lblTipoProduto.setHorizontalAlignment(SwingConstants.CENTER);
		lblTipoProduto.setFont(new Font("Cambria", Font.PLAIN, 18));
		lblTipoProduto.setBounds(83, 249, 156, 32);
		panel.add(lblTipoProduto);
		
		JLabel lblDescricao = new JLabel("Descrição");
		lblDescricao.setHorizontalAlignment(SwingConstants.CENTER);
		lblDescricao.setFont(new Font("Cambria", Font.PLAIN, 18));
		lblDescricao.setBounds(83, 299, 156, 32);
		panel.add(lblDescricao);
		
		JLabel lblConsultaCodigoProduto = new JLabel(String.valueOf(produto.getCodigo()));
		lblConsultaCodigoProduto.setHorizontalAlignment(SwingConstants.CENTER);
		lblConsultaCodigoProduto.setFont(new Font("Cambria", Font.PLAIN, 18));
		lblConsultaCodigoProduto.setBounds(254, 74, 156, 32);
		panel.add(lblConsultaCodigoProduto);
		
		JLabel lblConsultaNomeProduto = new JLabel(produto.getNome());
		lblConsultaNomeProduto.setHorizontalAlignment(SwingConstants.CENTER);
		lblConsultaNomeProduto.setFont(new Font("Cambria", Font.PLAIN, 18));
		lblConsultaNomeProduto.setBounds(249, 117, 156, 32);
		panel.add(lblConsultaNomeProduto);
		
		JLabel lblConsultaValorProduto = new JLabel(String.valueOf(produto.getValor()));
		lblConsultaValorProduto.setHorizontalAlignment(SwingConstants.CENTER);
		lblConsultaValorProduto.setFont(new Font("Cambria", Font.PLAIN, 18));
		lblConsultaValorProduto.setBounds(254, 160, 156, 32);
		panel.add(lblConsultaValorProduto);
		
		JLabel lblConsultaQuantidade = new JLabel(String.valueOf(produto.getQtdEmEstoque()));
		lblConsultaQuantidade.setHorizontalAlignment(SwingConstants.CENTER);
		lblConsultaQuantidade.setFont(new Font("Cambria", Font.PLAIN, 18));
		lblConsultaQuantidade.setBounds(222, 203, 156, 32);
		panel.add(lblConsultaQuantidade);
		
		JLabel lblConsultaTipoProduto = new JLabel(produto.getTipo().getNome());
		lblConsultaTipoProduto.setHorizontalAlignment(SwingConstants.CENTER);
		lblConsultaTipoProduto.setFont(new Font("Cambria", Font.PLAIN, 18));
		lblConsultaTipoProduto.setBounds(254, 249, 156, 32);
		panel.add(lblConsultaTipoProduto);
		
		JLabel lblConsultaDescricao = new JLabel(produto.getDescricao());
		lblConsultaDescricao.setHorizontalAlignment(SwingConstants.CENTER);
		lblConsultaDescricao.setFont(new Font("Cambria", Font.PLAIN, 18));
		lblConsultaDescricao.setBounds(249, 299, 259, 98);
		panel.add(lblConsultaDescricao);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				GerenciarProduto gP = new GerenciarProduto();
				gP.setVisible(true);
			}
		});
		btnVoltar.setFont(new Font("Cambria", Font.PLAIN, 18));
		btnVoltar.setBounds(399, 408, 96, 32);
		panel.add(btnVoltar);
		
		JButton btnAtualizarEstoque = new JButton("Atualizar Estoque");
		btnAtualizarEstoque.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AtualizarEstoque aE = new AtualizarEstoque(controlador, produto);
				aE.setVisible(true);
			}
		});
		btnAtualizarEstoque.setFont(new Font("Cambria", Font.PLAIN, 18));
		btnAtualizarEstoque.setBounds(185, 408, 182, 32);
		panel.add(btnAtualizarEstoque);
		
		JButton btnRemover = new JButton("Remover");
		btnRemover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					controlador.removerProduto(produto.getCodigo());
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage());
				}
			}
		});
		btnRemover.setFont(new Font("Cambria", Font.PLAIN, 18));
		btnRemover.setBounds(42, 408, 108, 32);
		panel.add(btnRemover);
	}

}
