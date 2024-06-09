package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JRadioButton;
import javax.swing.JButton;

public class AdicionarCliente extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdicionarCliente frame = new AdicionarCliente();
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
		lblAdicionarCliente.setBounds(134, 11, 231, 47);
		panel.add(lblAdicionarCliente);
		
		JRadioButton rdbtnPessoaFsica = new JRadioButton("Pessoa Física");
		rdbtnPessoaFsica.setFont(new Font("Cambria", Font.PLAIN, 14));
		rdbtnPessoaFsica.setBounds(76, 127, 134, 33);
		panel.add(rdbtnPessoaFsica);
		
		JRadioButton rdbtnPessoaJurdica = new JRadioButton("Pessoa Jurídica");
		rdbtnPessoaJurdica.setFont(new Font("Cambria", Font.PLAIN, 14));
		rdbtnPessoaJurdica.setBounds(76, 163, 134, 23);
		panel.add(rdbtnPessoaJurdica);
		
		JLabel lblQualAClassificao = new JLabel("Qual a classificação do cliente?");
		lblQualAClassificao.setHorizontalAlignment(SwingConstants.CENTER);
		lblQualAClassificao.setFont(new Font("Cambria", Font.PLAIN, 20));
		lblQualAClassificao.setBounds(63, 73, 359, 47);
		panel.add(lblQualAClassificao);
		
		JButton btnAvancar = new JButton("Avançar");
		btnAvancar.setFont(new Font("Cambria", Font.PLAIN, 18));
		btnAvancar.setBounds(163, 217, 152, 23);
		panel.add(btnAvancar);
	}
}
