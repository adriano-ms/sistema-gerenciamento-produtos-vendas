package view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import controller.ControladorCliente;
import model.entities.PessoaJuridica;

public class ConsultarPessoaJuridica extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtNomeCliente;
	private JTextField txtLogradouro;
	private JTextField txtCNPJ;
	private JTextField txtTelefone;
	private JTextField txtNumero;
	private JTextField txtComplemento;
	private JTextField txtCEP;
	private JTextField txtEmail;

	
	public ConsultarPessoaJuridica(PessoaJuridica pj) {
		
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
		
		JLabel lblConsultarPessoaJuridica = new JLabel("Consultando Cliente Pessoa Jurídica");
		lblConsultarPessoaJuridica.setHorizontalAlignment(SwingConstants.CENTER);
		lblConsultarPessoaJuridica.setFont(new Font("Cambria", Font.PLAIN, 24));
		lblConsultarPessoaJuridica.setBounds(70, 11, 411, 29);
		panel.add(lblConsultarPessoaJuridica);
		
		JLabel lblNomeCliente = new JLabel("Nome Cliente:");
		lblNomeCliente.setHorizontalAlignment(SwingConstants.CENTER);
		lblNomeCliente.setFont(new Font("Cambria", Font.PLAIN, 18));
		lblNomeCliente.setBounds(0, 77, 144, 32);
		panel.add(lblNomeCliente);
		
		txtNomeCliente = new JTextField(pj.getNome());
		txtNomeCliente.setFont(new Font("Cambria", Font.PLAIN, 18));
		txtNomeCliente.setColumns(10);
		txtNomeCliente.setBounds(134, 80, 120, 25);
		panel.add(txtNomeCliente);
		
		JLabel lblLogradouro = new JLabel("Logradouro:");
		lblLogradouro.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogradouro.setFont(new Font("Cambria", Font.PLAIN, 18));
		lblLogradouro.setBounds(264, 77, 156, 32);
		panel.add(lblLogradouro);
		
		txtLogradouro = new JTextField(pj.getEndereco().getLogradouro());
		txtLogradouro.setFont(new Font("Cambria", Font.PLAIN, 18));
		txtLogradouro.setColumns(10);
		txtLogradouro.setBounds(402, 80, 120, 25);
		panel.add(txtLogradouro);
		
		JLabel lblCnpj = new JLabel("CNPJ:");
		lblCnpj.setHorizontalAlignment(SwingConstants.CENTER);
		lblCnpj.setFont(new Font("Cambria", Font.PLAIN, 18));
		lblCnpj.setBounds(70, 136, 74, 32);
		panel.add(lblCnpj);
		
		txtCNPJ = new JTextField(pj.getCnpj());
		txtCNPJ.setFont(new Font("Cambria", Font.PLAIN, 18));
		txtCNPJ.setColumns(10);
		txtCNPJ.setBounds(134, 139, 120, 25);
		panel.add(txtCNPJ);
		
		JLabel lblTelefone = new JLabel("Telefone");
		lblTelefone.setHorizontalAlignment(SwingConstants.CENTER);
		lblTelefone.setFont(new Font("Cambria", Font.PLAIN, 18));
		lblTelefone.setBounds(57, 189, 74, 32);
		panel.add(lblTelefone);
		
		txtTelefone = new JTextField(pj.getTelefone());
		txtTelefone.setFont(new Font("Cambria", Font.PLAIN, 18));
		txtTelefone.setColumns(10);
		txtTelefone.setBounds(134, 192, 120, 25);
		panel.add(txtTelefone);
		
		JLabel lblNumero = new JLabel("Número:");
		lblNumero.setHorizontalAlignment(SwingConstants.CENTER);
		lblNumero.setFont(new Font("Cambria", Font.PLAIN, 18));
		lblNumero.setBounds(300, 189, 113, 32);
		panel.add(lblNumero);
		
		txtNumero = new JTextField(pj.getEndereco().getNumero());
		txtNumero.setFont(new Font("Cambria", Font.PLAIN, 18));
		txtNumero.setColumns(10);
		txtNumero.setBounds(402, 192, 120, 25);
		panel.add(txtNumero);
		
		JLabel lblComplemento = new JLabel("Complemento:");
		lblComplemento.setHorizontalAlignment(SwingConstants.CENTER);
		lblComplemento.setFont(new Font("Cambria", Font.PLAIN, 18));
		lblComplemento.setBounds(264, 239, 144, 32);
		panel.add(lblComplemento);
		
		txtComplemento = new JTextField(pj.getEndereco().getComplemento());
		txtComplemento.setFont(new Font("Cambria", Font.PLAIN, 18));
		txtComplemento.setColumns(10);
		txtComplemento.setBounds(402, 242, 120, 25);
		panel.add(txtComplemento);
		
		JLabel lblCEP = new JLabel("CEP:");
		lblCEP.setHorizontalAlignment(SwingConstants.CENTER);
		lblCEP.setFont(new Font("Cambria", Font.PLAIN, 18));
		lblCEP.setBounds(320, 136, 100, 32);
		panel.add(lblCEP);
		
		txtCEP = new JTextField(pj.getEndereco().getCep());
		txtCEP.setFont(new Font("Cambria", Font.PLAIN, 18));
		txtCEP.setColumns(10);
		txtCEP.setBounds(402, 139, 120, 25);
		panel.add(txtCEP);
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					ControladorCliente CC = new ControladorCliente();
					
					CC.remover(pj.getId());
					
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, e1);
				}
				
			}
		});
		btnExcluir.setFont(new Font("Cambria", Font.PLAIN, 18));
		btnExcluir.setBounds(146, 311, 108, 32);
		panel.add(btnExcluir);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					ControladorCliente CC = new ControladorCliente();
					//Método de salvar
					txtNomeCliente.setEnabled(false);
					txtCNPJ.setEnabled(false);
					txtTelefone.setEnabled(false);
					txtLogradouro.setEnabled(false);
					txtCEP.setEnabled(false);
					txtNumero.setEnabled(false);
					txtComplemento.setEnabled(false);
					
					
					pj.setNome(txtNomeCliente.getText());
					pj.getEndereco().setCep(txtCEP.getText());
					pj.getEndereco().setComplemento(txtComplemento.getText());
					pj.getEndereco().setLogradouro(txtLogradouro.getText());
					pj.getEndereco().setNumero(Integer.valueOf(txtNumero.getText()));
					pj.setTelefone(txtTelefone.getText());
					pj.setCnpj(txtCNPJ.getText());
					pj.setEmail(txtEmail.getText());
					
					CC.editar(pj);
									
					
					JOptionPane.showMessageDialog(null, "Cliente Salvo com sucesso");
					new GerenciarCliente().setVisible(true);
					dispose();
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, e1);
				}
				
			}
		});
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnSalvar.setEnabled(true);
				txtNomeCliente.setEnabled(true);
				txtCNPJ.setEnabled(true);
				txtTelefone.setEnabled(true);
				txtLogradouro.setEnabled(true);
				txtCEP.setEnabled(true);
				txtNumero.setEnabled(true);
				txtComplemento.setEnabled(true);
				btnEditar.setEnabled(false);
			}
		});
		btnEditar.setFont(new Font("Cambria", Font.PLAIN, 18));
		btnEditar.setBounds(283, 311, 108, 32);
		panel.add(btnEditar);
		
		
		btnSalvar.setFont(new Font("Cambria", Font.PLAIN, 18));
		btnSalvar.setBounds(414, 311, 108, 32);
		panel.add(btnSalvar);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GerenciarCliente GC = new GerenciarCliente();
				
				dispose();
				GC.setVisible(true);
			}
		});
		btnVoltar.setFont(new Font("Cambria", Font.PLAIN, 18));
		btnVoltar.setBounds(10, 311, 108, 32);
		panel.add(btnVoltar);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setHorizontalAlignment(SwingConstants.CENTER);
		lblEmail.setFont(new Font("Cambria", Font.PLAIN, 18));
		lblEmail.setBounds(57, 239, 74, 32);
		panel.add(lblEmail);
		
		txtEmail = new JTextField(pj.getEmail());
		txtEmail.setFont(new Font("Cambria", Font.PLAIN, 18));
		txtEmail.setColumns(10);
		txtEmail.setBounds(134, 242, 120, 25);
		panel.add(txtEmail);
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent e) {
				btnSalvar.setEnabled(false);
				txtNomeCliente.setEnabled(false);
				txtCNPJ.setEnabled(false);
				txtTelefone.setEnabled(false);
				txtLogradouro.setEnabled(false);
				txtCEP.setEnabled(false);
				txtNumero.setEnabled(false);
				txtComplemento.setEnabled(false);
			}
		});
	}
}
