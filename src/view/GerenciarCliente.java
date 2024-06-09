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

public class GerenciarCliente extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtCodigoCliente;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GerenciarCliente frame = new GerenciarCliente();
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
	public GerenciarCliente() {
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
		btnAdicionarCliente.setFont(new Font("Cambria", Font.PLAIN, 18));
		btnAdicionarCliente.setBounds(35, 232, 204, 25);
		panel.add(btnAdicionarCliente);
		
		JButton btnConsultarCliente = new JButton("Consultar Cliente");
		btnConsultarCliente.setFont(new Font("Cambria", Font.PLAIN, 18));
		btnConsultarCliente.setBounds(297, 232, 204, 25);
		panel.add(btnConsultarCliente);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setFont(new Font("Cambria", Font.PLAIN, 18));
		btnVoltar.setBounds(172, 298, 204, 25);
		panel.add(btnVoltar);
	}
}
