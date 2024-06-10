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
import model.entities.PessoaFisica;

public class ConsultarPessoaFisica extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtNomeCliente;
	private JTextField txtLogradouro;
	private JTextField txtCPF;
	private JTextField txtCelular;
	private JTextField txtNumero;
	private JTextField txtComplemento;
	private JTextField txtCEP;

	
	public ConsultarPessoaFisica(PessoaFisica pf) {
		
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
		
		txtNomeCliente = new JTextField(pf.getNome());
		txtNomeCliente.setFont(new Font("Cambria", Font.PLAIN, 18));
		txtNomeCliente.setColumns(10);
		txtNomeCliente.setBounds(134, 80, 120, 25);
		panel.add(txtNomeCliente);
		
		JLabel lblLogradouro = new JLabel("Logradouro:");
		lblLogradouro.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogradouro.setFont(new Font("Cambria", Font.PLAIN, 18));
		lblLogradouro.setBounds(264, 77, 156, 32);
		panel.add(lblLogradouro);
		
		txtLogradouro = new JTextField(pf.getEndereco().getLogradouro());
		txtLogradouro.setFont(new Font("Cambria", Font.PLAIN, 18));
		txtLogradouro.setColumns(10);
		txtLogradouro.setBounds(402, 80, 120, 25);
		panel.add(txtLogradouro);
		
		JLabel lblCPF = new JLabel("CPF:");
		lblCPF.setHorizontalAlignment(SwingConstants.CENTER);
		lblCPF.setFont(new Font("Cambria", Font.PLAIN, 18));
		lblCPF.setBounds(70, 136, 74, 32);
		panel.add(lblCPF);
		
		txtCPF = new JTextField(pf.getCpf());
		txtCPF.setFont(new Font("Cambria", Font.PLAIN, 18));
		txtCPF.setColumns(10);
		txtCPF.setBounds(134, 139, 120, 25);
		panel.add(txtCPF);
		
		JLabel lblCelular = new JLabel("Celular:");
		lblCelular.setHorizontalAlignment(SwingConstants.CENTER);
		lblCelular.setFont(new Font("Cambria", Font.PLAIN, 18));
		lblCelular.setBounds(57, 189, 74, 32);
		panel.add(lblCelular);
		
		txtCelular = new JTextField(pf.getCelular());
		txtCelular.setFont(new Font("Cambria", Font.PLAIN, 18));
		txtCelular.setColumns(10);
		txtCelular.setBounds(134, 192, 120, 25);
		panel.add(txtCelular);
		
		JLabel lblNumero = new JLabel("Número:");
		lblNumero.setHorizontalAlignment(SwingConstants.CENTER);
		lblNumero.setFont(new Font("Cambria", Font.PLAIN, 18));
		lblNumero.setBounds(300, 189, 113, 32);
		panel.add(lblNumero);
		
		txtNumero = new JTextField(Integer.valueOf(pf.getEndereco().getNumero()));
		txtNumero.setFont(new Font("Cambria", Font.PLAIN, 18));
		txtNumero.setColumns(10);
		txtNumero.setBounds(402, 192, 120, 25);
		panel.add(txtNumero);
		
		JLabel lblComplemento = new JLabel("Complemento:");
		lblComplemento.setHorizontalAlignment(SwingConstants.CENTER);
		lblComplemento.setFont(new Font("Cambria", Font.PLAIN, 18));
		lblComplemento.setBounds(264, 239, 144, 32);
		panel.add(lblComplemento);
		
		txtComplemento = new JTextField(pf.getEndereco().getComplemento());
		txtComplemento.setFont(new Font("Cambria", Font.PLAIN, 18));
		txtComplemento.setColumns(10);
		txtComplemento.setBounds(402, 242, 120, 25);
		panel.add(txtComplemento);
		
		JLabel lblCEP = new JLabel("CEP:");
		lblCEP.setHorizontalAlignment(SwingConstants.CENTER);
		lblCEP.setFont(new Font("Cambria", Font.PLAIN, 18));
		lblCEP.setBounds(320, 136, 100, 32);
		panel.add(lblCEP);
		
		txtCEP = new JTextField(pf.getEndereco().getCep());
		txtCEP.setFont(new Font("Cambria", Font.PLAIN, 18));
		txtCEP.setColumns(10);
		txtCEP.setBounds(402, 139, 120, 25);
		panel.add(txtCEP);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					//Método de salvar
					ControladorCliente CC = new ControladorCliente();
					
					txtNomeCliente.setEnabled(false);
					txtCPF.setEnabled(false);
					txtCelular.setEnabled(false);
					txtLogradouro.setEnabled(false);
					txtCEP.setEnabled(false);
					txtNumero.setEnabled(false);
					txtComplemento.setEnabled(false);
					
					pf.setNome(txtNomeCliente.getText());
					pf.getEndereco().setCep(txtCEP.getText());
					pf.getEndereco().setComplemento(txtComplemento.getText());
					pf.getEndereco().setLogradouro(txtLogradouro.getText());
					pf.getEndereco().setNumero(Integer.valueOf(txtNumero.getText()));
					pf.setCelular(txtCelular.getText());
					pf.setCpf(txtCPF.getText());
					
					
					CC.editar(pf);
					
					
					JOptionPane.showMessageDialog(null, "Cliente Salvo com sucesso");
					new GerenciarCliente().setVisible(true);
					dispose();
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, e1);
				}
			}
		});
		btnSalvar.setFont(new Font("Cambria", Font.PLAIN, 18));
		btnSalvar.setBounds(414, 311, 108, 32);
		panel.add(btnSalvar);
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnSalvar.setEnabled(true);
				txtNomeCliente.setEnabled(true);
				txtCPF.setEnabled(true);
				txtCelular.setEnabled(true);
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
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					ControladorCliente CC = new ControladorCliente();
					
					CC.remover(pf.getId());
					
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, e1);
				}
				
			}
			
		});
		btnExcluir.setFont(new Font("Cambria", Font.PLAIN, 18));
		btnExcluir.setBounds(146, 311, 108, 32);
		panel.add(btnExcluir);
		
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
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent e) {
				btnSalvar.setEnabled(false);
				txtNomeCliente.setEnabled(false);
				txtCPF.setEnabled(false);
				txtCelular.setEnabled(false);
				txtLogradouro.setEnabled(false);
				txtCEP.setEnabled(false);
				txtNumero.setEnabled(false);
				txtComplemento.setEnabled(false);
			}
		});
	}


	

}
