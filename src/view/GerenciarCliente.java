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

import controller.ControladorCliente;
import model.entities.PessoaFisica;
import model.entities.PessoaJuridica;

public class GerenciarCliente extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtCodigoCliente;
	private ControladorCliente controlador;

	public GerenciarCliente() {
		try {
			this.controlador = new ControladorCliente();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e);
		}
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 570, 407);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(10, 11, 534, 376);
		contentPane.add(panel);

		JLabel lblGerenciarCliente = new JLabel("Gerenciar Cliente");
		lblGerenciarCliente.setHorizontalAlignment(SwingConstants.CENTER);
		lblGerenciarCliente.setFont(new Font("Cambria", Font.PLAIN, 24));
		lblGerenciarCliente.setBounds(110, 22, 273, 63);
		panel.add(lblGerenciarCliente);

		JLabel lblCodigoCliente = new JLabel("Código do Cliente");
		lblCodigoCliente.setHorizontalAlignment(SwingConstants.CENTER);
		lblCodigoCliente.setFont(new Font("Cambria", Font.PLAIN, 18));
		lblCodigoCliente.setBounds(68, 124, 156, 32);
		panel.add(lblCodigoCliente);

		txtCodigoCliente = new JTextField();
		txtCodigoCliente.setFont(new Font("Cambria", Font.PLAIN, 18));
		txtCodigoCliente.setColumns(10);
		txtCodigoCliente.setBounds(236, 127, 120, 25);
		panel.add(txtCodigoCliente);

		JButton btnAdicionarCliente = new JButton("Adicionar Cliente +");
		btnAdicionarCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new AdicionarCliente(controlador).setVisible(true);
				dispose();
			}
		});
		btnAdicionarCliente.setFont(new Font("Cambria", Font.PLAIN, 18));
		btnAdicionarCliente.setBounds(35, 232, 204, 25);
		panel.add(btnAdicionarCliente);

		JButton btnConsultarCliente = new JButton("Consultar Cliente");
		btnConsultarCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					if (!txtCodigoCliente.getText().isEmpty()) {
						var cliente = controlador.consultar(Integer.valueOf(txtCodigoCliente.getText()));

						if (cliente instanceof PessoaJuridica) {
							ConsultarPessoaJuridica CPJ = new ConsultarPessoaJuridica(controlador, (PessoaJuridica) cliente);
							dispose();
							CPJ.setVisible(true);

						} else if (cliente instanceof PessoaFisica) {
							ConsultarPessoaFisica CPF = new ConsultarPessoaFisica(controlador, (PessoaFisica) cliente);
							dispose();
							CPF.setVisible(true);

						}
					} else {
						throw new Exception("Campo deve ser preenchido");
					}

				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, e1);
				}

			}
		});
		btnConsultarCliente.setFont(new Font("Cambria", Font.PLAIN, 18));
		btnConsultarCliente.setBounds(297, 232, 204, 25);
		panel.add(btnConsultarCliente);

		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Main().setVisible(true);
				dispose();
			}
		});
		btnVoltar.setFont(new Font("Cambria", Font.PLAIN, 18));
		btnVoltar.setBounds(172, 298, 204, 25);
		panel.add(btnVoltar);
	}
}
