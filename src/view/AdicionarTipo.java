package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AdicionarTipo extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtCodigoTipo;
	private JTextField txtNomeTipo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdicionarTipo frame = new AdicionarTipo();
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
	public AdicionarTipo() {
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
		
		JLabel lblCodigoDoTipo = new JLabel("Código do Tipo:");
		lblCodigoDoTipo.setHorizontalAlignment(SwingConstants.CENTER);
		lblCodigoDoTipo.setFont(new Font("Cambria", Font.PLAIN, 18));
		lblCodigoDoTipo.setBounds(82, 84, 156, 32);
		panel.add(lblCodigoDoTipo);
		
		txtCodigoTipo = new JTextField();
		txtCodigoTipo.setFont(new Font("Cambria", Font.PLAIN, 18));
		txtCodigoTipo.setColumns(10);
		txtCodigoTipo.setBounds(257, 91, 120, 25);
		panel.add(txtCodigoTipo);
		
		JLabel lblNomeDoTipo = new JLabel("Nome do Tipo:");
		lblNomeDoTipo.setHorizontalAlignment(SwingConstants.CENTER);
		lblNomeDoTipo.setFont(new Font("Cambria", Font.PLAIN, 18));
		lblNomeDoTipo.setBounds(82, 127, 156, 32);
		panel.add(lblNomeDoTipo);
		
		txtNomeTipo = new JTextField();
		txtNomeTipo.setFont(new Font("Cambria", Font.PLAIN, 18));
		txtNomeTipo.setColumns(10);
		txtNomeTipo.setBounds(257, 130, 224, 25);
		panel.add(txtNomeTipo);
		
		JLabel lblDescricao = new JLabel("Descrição");
		lblDescricao.setHorizontalAlignment(SwingConstants.CENTER);
		lblDescricao.setFont(new Font("Cambria", Font.PLAIN, 18));
		lblDescricao.setBounds(82, 170, 156, 32);
		panel.add(lblDescricao);
		
		JTextArea txtADescricao = new JTextArea();
		txtADescricao.setBounds(257, 177, 224, 65);
		panel.add(txtADescricao);
		
		JButton btnAdicionarTipo = new JButton("Adicionar Tipo +");
		btnAdicionarTipo.setFont(new Font("Cambria", Font.PLAIN, 18));
		btnAdicionarTipo.setBounds(67, 277, 201, 32);
		panel.add(btnAdicionarTipo);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new GerenciarTipoProduto().setVisible(true);
			}
		});
		btnVoltar.setFont(new Font("Cambria", Font.PLAIN, 18));
		btnVoltar.setBounds(309, 277, 189, 32);
		panel.add(btnVoltar);
	}

}
