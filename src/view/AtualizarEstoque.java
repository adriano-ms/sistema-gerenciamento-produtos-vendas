package view;

import java.awt.BorderLayout;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AtualizarEstoque extends JDialog {

	private static final long serialVersionUID = 1L;
	private JTextField textField;

	
	/**
	 * Create the dialog.
	 */
	public AtualizarEstoque() {
		setModal(true);
		setBounds(100, 100, 547, 300);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 511, 241);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblAtualizarProduto = new JLabel("Atualização do Produto");
		lblAtualizarProduto.setHorizontalAlignment(SwingConstants.CENTER);
		lblAtualizarProduto.setFont(new Font("Cambria", Font.PLAIN, 24));
		lblAtualizarProduto.setBounds(121, 11, 286, 47);
		panel.add(lblAtualizarProduto);
		
		JLabel lblNomeProduto = new JLabel("Nome do Produto:");
		lblNomeProduto.setHorizontalAlignment(SwingConstants.CENTER);
		lblNomeProduto.setFont(new Font("Cambria", Font.PLAIN, 18));
		lblNomeProduto.setBounds(77, 69, 156, 32);
		panel.add(lblNomeProduto);
		
		JLabel lblQuantidadeEstoque = new JLabel("Quantidade em Estoque:");
		lblQuantidadeEstoque.setHorizontalAlignment(SwingConstants.CENTER);
		lblQuantidadeEstoque.setFont(new Font("Cambria", Font.PLAIN, 18));
		lblQuantidadeEstoque.setBounds(48, 112, 195, 32);
		panel.add(lblQuantidadeEstoque);
		
		JLabel lblConsultaNomeProduto = new JLabel("");
		lblConsultaNomeProduto.setHorizontalAlignment(SwingConstants.CENTER);
		lblConsultaNomeProduto.setFont(new Font("Cambria", Font.PLAIN, 18));
		lblConsultaNomeProduto.setBounds(251, 69, 156, 32);
		panel.add(lblConsultaNomeProduto);
		
		JLabel lblConsultaQuantidadeEstoque = new JLabel("");
		lblConsultaQuantidadeEstoque.setHorizontalAlignment(SwingConstants.CENTER);
		lblConsultaQuantidadeEstoque.setFont(new Font("Cambria", Font.PLAIN, 18));
		lblConsultaQuantidadeEstoque.setBounds(253, 112, 156, 32);
		panel.add(lblConsultaQuantidadeEstoque);
		
		JLabel lblNovaQuantidade = new JLabel("Nova Quantidade:");
		lblNovaQuantidade.setHorizontalAlignment(SwingConstants.CENTER);
		lblNovaQuantidade.setFont(new Font("Cambria", Font.PLAIN, 18));
		lblNovaQuantidade.setBounds(48, 155, 195, 32);
		panel.add(lblNovaQuantidade);
		
		textField = new JTextField();
		textField.setBounds(230, 164, 86, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		JButton btnFechar = new JButton("Fechar");
		btnFechar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnFechar.setFont(new Font("Cambria", Font.PLAIN, 18));
		btnFechar.setBounds(310, 210, 97, 20);
		panel.add(btnFechar);
		
		JButton btnAtualizar = new JButton("Atualizar");
		btnAtualizar.setFont(new Font("Cambria", Font.PLAIN, 18));
		btnAtualizar.setBounds(154, 210, 108, 20);
		panel.add(btnAtualizar);
	}

}
