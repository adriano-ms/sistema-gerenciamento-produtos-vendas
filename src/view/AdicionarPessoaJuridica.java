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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AdicionarPessoaJuridica extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtNomeCliente;
	private JTextField txtLogradouro;
	private JTextField txtCNPJ;
	private JTextField txtCelular;
	private JTextField txtNumero;
	private JTextField txtComplemento;
	private JTextField txtCEP;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdicionarPessoaJuridica frame = new AdicionarPessoaJuridica();
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
	public AdicionarPessoaJuridica() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 581, 426);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 550, 365);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblAdicionarPessoa = new JLabel("Adicionar Cliente Pessoa Física");
		lblAdicionarPessoa.setHorizontalAlignment(SwingConstants.CENTER);
		lblAdicionarPessoa.setFont(new Font("Cambria", Font.PLAIN, 24));
		lblAdicionarPessoa.setBounds(111, 11, 350, 29);
		panel.add(lblAdicionarPessoa);
		
		JLabel lblNomeCliente = new JLabel("Nome Cliente:");
		lblNomeCliente.setHorizontalAlignment(SwingConstants.CENTER);
		lblNomeCliente.setFont(new Font("Cambria", Font.PLAIN, 18));
		lblNomeCliente.setBounds(0, 77, 144, 32);
		panel.add(lblNomeCliente);
		
		txtNomeCliente = new JTextField();
		txtNomeCliente.setFont(new Font("Cambria", Font.PLAIN, 18));
		txtNomeCliente.setColumns(10);
		txtNomeCliente.setBounds(134, 80, 120, 25);
		panel.add(txtNomeCliente);
		
		JLabel lblLogradouro = new JLabel("Logradouro:");
		lblLogradouro.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogradouro.setFont(new Font("Cambria", Font.PLAIN, 18));
		lblLogradouro.setBounds(264, 77, 156, 32);
		panel.add(lblLogradouro);
		
		txtLogradouro = new JTextField();
		txtLogradouro.setFont(new Font("Cambria", Font.PLAIN, 18));
		txtLogradouro.setColumns(10);
		txtLogradouro.setBounds(402, 80, 120, 25);
		panel.add(txtLogradouro);
		
		JLabel lblCnpj = new JLabel("CNPJ:");
		lblCnpj.setHorizontalAlignment(SwingConstants.CENTER);
		lblCnpj.setFont(new Font("Cambria", Font.PLAIN, 18));
		lblCnpj.setBounds(70, 136, 74, 32);
		panel.add(lblCnpj);
		
		txtCNPJ = new JTextField();
		txtCNPJ.setFont(new Font("Cambria", Font.PLAIN, 18));
		txtCNPJ.setColumns(10);
		txtCNPJ.setBounds(134, 139, 120, 25);
		panel.add(txtCNPJ);
		
		JLabel lblTelefone = new JLabel("Telefone");
		lblTelefone.setHorizontalAlignment(SwingConstants.CENTER);
		lblTelefone.setFont(new Font("Cambria", Font.PLAIN, 18));
		lblTelefone.setBounds(57, 189, 74, 32);
		panel.add(lblTelefone);
		
		txtCelular = new JTextField();
		txtCelular.setFont(new Font("Cambria", Font.PLAIN, 18));
		txtCelular.setColumns(10);
		txtCelular.setBounds(134, 192, 120, 25);
		panel.add(txtCelular);
		
		JLabel lblNumero = new JLabel("Número:");
		lblNumero.setHorizontalAlignment(SwingConstants.CENTER);
		lblNumero.setFont(new Font("Cambria", Font.PLAIN, 18));
		lblNumero.setBounds(300, 189, 113, 32);
		panel.add(lblNumero);
		
		txtNumero = new JTextField();
		txtNumero.setFont(new Font("Cambria", Font.PLAIN, 18));
		txtNumero.setColumns(10);
		txtNumero.setBounds(402, 192, 120, 25);
		panel.add(txtNumero);
		
		JLabel lblComplemento = new JLabel("Complemento:");
		lblComplemento.setHorizontalAlignment(SwingConstants.CENTER);
		lblComplemento.setFont(new Font("Cambria", Font.PLAIN, 18));
		lblComplemento.setBounds(264, 239, 144, 32);
		panel.add(lblComplemento);
		
		txtComplemento = new JTextField();
		txtComplemento.setFont(new Font("Cambria", Font.PLAIN, 18));
		txtComplemento.setColumns(10);
		txtComplemento.setBounds(402, 242, 120, 25);
		panel.add(txtComplemento);
		
		JLabel lblCEP = new JLabel("CEP:");
		lblCEP.setHorizontalAlignment(SwingConstants.CENTER);
		lblCEP.setFont(new Font("Cambria", Font.PLAIN, 18));
		lblCEP.setBounds(320, 136, 100, 32);
		panel.add(lblCEP);
		
		txtCEP = new JTextField();
		txtCEP.setFont(new Font("Cambria", Font.PLAIN, 18));
		txtCEP.setColumns(10);
		txtCEP.setBounds(402, 139, 120, 25);
		panel.add(txtCEP);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setFont(new Font("Cambria", Font.PLAIN, 18));
		btnCadastrar.setBounds(321, 310, 201, 32);
		panel.add(btnCadastrar);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new AdicionarCliente().setVisible(true);
				dispose();
			}
		});
		btnVoltar.setFont(new Font("Cambria", Font.PLAIN, 18));
		btnVoltar.setBounds(49, 310, 201, 32);
		panel.add(btnVoltar);
	}

}
