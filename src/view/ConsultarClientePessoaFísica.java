package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;

public class ConsultarClientePessoaFísica extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConsultarClientePessoaFísica frame = new ConsultarClientePessoaFísica();
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
	public ConsultarClientePessoaFísica() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 581, 426);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 545, 365);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblConsultarPessoaFisica = new JLabel("Consultando Cliente Pessoa Física");
		lblConsultarPessoaFisica.setHorizontalAlignment(SwingConstants.CENTER);
		lblConsultarPessoaFisica.setFont(new Font("Cambria", Font.PLAIN, 24));
		lblConsultarPessoaFisica.setBounds(111, 11, 350, 29);
		panel.add(lblConsultarPessoaFisica);
		
		JLabel lblNomeCliente = new JLabel("Nome Cliente:");
		lblNomeCliente.setHorizontalAlignment(SwingConstants.CENTER);
		lblNomeCliente.setFont(new Font("Cambria", Font.PLAIN, 18));
		lblNomeCliente.setBounds(0, 77, 144, 32);
		panel.add(lblNomeCliente);
		
		textField = new JTextField();
		textField.setFont(new Font("Cambria", Font.PLAIN, 18));
		textField.setColumns(10);
		textField.setBounds(134, 80, 120, 25);
		panel.add(textField);
		
		JLabel lblLogradouro = new JLabel("Logradouro:");
		lblLogradouro.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogradouro.setFont(new Font("Cambria", Font.PLAIN, 18));
		lblLogradouro.setBounds(264, 77, 156, 32);
		panel.add(lblLogradouro);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Cambria", Font.PLAIN, 18));
		textField_1.setColumns(10);
		textField_1.setBounds(402, 80, 120, 25);
		panel.add(textField_1);
		
		JLabel lblCPF = new JLabel("CNPJ:");
		lblCPF.setHorizontalAlignment(SwingConstants.CENTER);
		lblCPF.setFont(new Font("Cambria", Font.PLAIN, 18));
		lblCPF.setBounds(70, 136, 74, 32);
		panel.add(lblCPF);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Cambria", Font.PLAIN, 18));
		textField_2.setColumns(10);
		textField_2.setBounds(134, 139, 120, 25);
		panel.add(textField_2);
		
		JLabel lblCelular = new JLabel("Celular:");
		lblCelular.setHorizontalAlignment(SwingConstants.CENTER);
		lblCelular.setFont(new Font("Cambria", Font.PLAIN, 18));
		lblCelular.setBounds(57, 189, 74, 32);
		panel.add(lblCelular);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Cambria", Font.PLAIN, 18));
		textField_3.setColumns(10);
		textField_3.setBounds(134, 192, 120, 25);
		panel.add(textField_3);
		
		JLabel lblNumero = new JLabel("Número:");
		lblNumero.setHorizontalAlignment(SwingConstants.CENTER);
		lblNumero.setFont(new Font("Cambria", Font.PLAIN, 18));
		lblNumero.setBounds(300, 189, 113, 32);
		panel.add(lblNumero);
		
		textField_4 = new JTextField();
		textField_4.setFont(new Font("Cambria", Font.PLAIN, 18));
		textField_4.setColumns(10);
		textField_4.setBounds(402, 192, 120, 25);
		panel.add(textField_4);
		
		JLabel lblComplemento = new JLabel("Complemento:");
		lblComplemento.setHorizontalAlignment(SwingConstants.CENTER);
		lblComplemento.setFont(new Font("Cambria", Font.PLAIN, 18));
		lblComplemento.setBounds(264, 239, 144, 32);
		panel.add(lblComplemento);
		
		textField_5 = new JTextField();
		textField_5.setFont(new Font("Cambria", Font.PLAIN, 18));
		textField_5.setColumns(10);
		textField_5.setBounds(402, 242, 120, 25);
		panel.add(textField_5);
		
		JLabel lblCEP = new JLabel("CEP:");
		lblCEP.setHorizontalAlignment(SwingConstants.CENTER);
		lblCEP.setFont(new Font("Cambria", Font.PLAIN, 18));
		lblCEP.setBounds(320, 136, 100, 32);
		panel.add(lblCEP);
		
		textField_6 = new JTextField();
		textField_6.setFont(new Font("Cambria", Font.PLAIN, 18));
		textField_6.setColumns(10);
		textField_6.setBounds(402, 139, 120, 25);
		panel.add(textField_6);
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.setFont(new Font("Cambria", Font.PLAIN, 18));
		btnExcluir.setBounds(27, 311, 138, 32);
		panel.add(btnExcluir);
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.setFont(new Font("Cambria", Font.PLAIN, 18));
		btnEditar.setBounds(208, 311, 138, 32);
		panel.add(btnEditar);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setFont(new Font("Cambria", Font.PLAIN, 18));
		btnSalvar.setBounds(384, 311, 138, 32);
		panel.add(btnSalvar);
	}

}
