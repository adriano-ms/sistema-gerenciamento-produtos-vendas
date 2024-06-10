package view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import controller.ControladorTipoProduto;
import model.entities.TipoProduto;

public class AdicionarTipo extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtNomeTipo;

	public AdicionarTipo(ControladorTipoProduto controlador) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 581, 393);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(10, 11, 545, 332);
		contentPane.add(panel);

		JLabel lblAdicionarTipo = new JLabel("Adicionar Tipo");
		lblAdicionarTipo.setHorizontalAlignment(SwingConstants.CENTER);
		lblAdicionarTipo.setFont(new Font("Cambria", Font.PLAIN, 24));
		lblAdicionarTipo.setBounds(160, 11, 231, 47);
		panel.add(lblAdicionarTipo);

		JLabel lblNomeDoTipo = new JLabel("Nome do Tipo:");
		lblNomeDoTipo.setHorizontalAlignment(SwingConstants.CENTER);
		lblNomeDoTipo.setFont(new Font("Cambria", Font.PLAIN, 18));
		lblNomeDoTipo.setBounds(82, 129, 156, 32);
		panel.add(lblNomeDoTipo);

		txtNomeTipo = new JTextField();
		txtNomeTipo.setFont(new Font("Cambria", Font.PLAIN, 18));
		txtNomeTipo.setColumns(10);
		txtNomeTipo.setBounds(257, 132, 224, 25);
		panel.add(txtNomeTipo);

		JButton btnAdicionarTipo = new JButton("Adicionar Tipo +");
		btnAdicionarTipo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					TipoProduto tipoProduto = new TipoProduto();

					tipoProduto.setNome(txtNomeTipo.getText());
					controlador.adicionarTipoProduto(tipoProduto);
					JOptionPane.showMessageDialog(null, "Inserção feita com sucesso!");

					dispose();
					new GerenciarTipoProduto().setVisible(true);

				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, e1);
				}

			}
		});
		btnAdicionarTipo.setFont(new Font("Cambria", Font.PLAIN, 18));
		btnAdicionarTipo.setBounds(70, 247, 201, 32);
		panel.add(btnAdicionarTipo);

		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new GerenciarTipoProduto().setVisible(true);
			}
		});
		btnVoltar.setFont(new Font("Cambria", Font.PLAIN, 18));
		btnVoltar.setBounds(312, 247, 189, 32);
		panel.add(btnVoltar);
	}

}
