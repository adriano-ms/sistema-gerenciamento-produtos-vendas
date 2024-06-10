package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ButtonGroup;

public class AdicionarCliente extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	
	public AdicionarCliente() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 536, 316);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 500, 255);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblAdicionarCliente = new JLabel("Adicionar Cliente");
		lblAdicionarCliente.setHorizontalAlignment(SwingConstants.CENTER);
		lblAdicionarCliente.setFont(new Font("Cambria", Font.PLAIN, 24));
		lblAdicionarCliente.setBounds(136, 11, 231, 47);
		panel.add(lblAdicionarCliente);
		
		JRadioButton rdbtnPessoaFisica = new JRadioButton("Pessoa Física");
		buttonGroup.add(rdbtnPessoaFisica);
		rdbtnPessoaFisica.setFont(new Font("Cambria", Font.PLAIN, 14));
		rdbtnPessoaFisica.setBounds(78, 127, 134, 33);
		panel.add(rdbtnPessoaFisica);
		
		JRadioButton rdbtnPessoaJuridica = new JRadioButton("Pessoa Jurídica");
		buttonGroup.add(rdbtnPessoaJuridica);
		rdbtnPessoaJuridica.setFont(new Font("Cambria", Font.PLAIN, 14));
		rdbtnPessoaJuridica.setBounds(78, 163, 134, 23);
		panel.add(rdbtnPessoaJuridica);
		
		JLabel lblQualAClassificao = new JLabel("Qual a classificação do cliente?");
		lblQualAClassificao.setHorizontalAlignment(SwingConstants.CENTER);
		lblQualAClassificao.setFont(new Font("Cambria", Font.PLAIN, 20));
		lblQualAClassificao.setBounds(65, 73, 359, 47);
		panel.add(lblQualAClassificao);
		
		JButton btnAvancar = new JButton("Avançar");
		btnAvancar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (rdbtnPessoaFisica.isSelected()) {
					new AdicionarPessoaFisica().setVisible(true);
					dispose();
				}
				else if (rdbtnPessoaJuridica.isSelected()) {
					new AdicionarPessoaJuridica().setVisible(true);
					dispose();
				}
				else {
					JOptionPane.showMessageDialog(null,"Nenhuma opção selecionada");
				}
			
				
			}
		});
		btnAvancar.setFont(new Font("Cambria", Font.PLAIN, 18));
		btnAvancar.setBounds(305, 220, 152, 23);
		panel.add(btnAvancar);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new GerenciarCliente().setVisible(true);
				dispose();
			}
		});
		btnVoltar.setFont(new Font("Cambria", Font.PLAIN, 18));
		btnVoltar.setBounds(82, 220, 152, 23);
		panel.add(btnVoltar);
	}
}
