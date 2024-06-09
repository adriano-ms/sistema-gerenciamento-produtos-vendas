package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ConsultarTipo extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private JLabel lblCodigoDoTipo;
	private JLabel lblNomeDoTipo;
	private JLabel lblDescricao;
	private JButton btnRemover;
	private JButton btnVoltar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConsultarTipo frame = new ConsultarTipo();
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
	public ConsultarTipo() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 685, 480);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 649, 419);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblConsultaDoTipo = new JLabel("Consulta de Tipo");
		lblConsultaDoTipo.setHorizontalAlignment(SwingConstants.CENTER);
		lblConsultaDoTipo.setFont(new Font("Cambria", Font.PLAIN, 24));
		lblConsultaDoTipo.setBounds(126, 11, 231, 47);
		panel.add(lblConsultaDoTipo);
		
		
		lblCodigoDoTipo = new JLabel("Código do Tipo:");
		lblCodigoDoTipo.setHorizontalAlignment(SwingConstants.CENTER);
		lblCodigoDoTipo.setFont(new Font("Cambria", Font.PLAIN, 18));
		lblCodigoDoTipo.setBounds(392, 92, 156, 32);
		panel.add(lblCodigoDoTipo);
		
		lblNomeDoTipo = new JLabel("Nome do Tipo:");
		lblNomeDoTipo.setHorizontalAlignment(SwingConstants.CENTER);
		lblNomeDoTipo.setFont(new Font("Cambria", Font.PLAIN, 18));
		lblNomeDoTipo.setBounds(392, 135, 156, 32);
		panel.add(lblNomeDoTipo);
		
		lblDescricao = new JLabel("Descrição");
		lblDescricao.setHorizontalAlignment(SwingConstants.CENTER);
		lblDescricao.setFont(new Font("Cambria", Font.PLAIN, 18));
		lblDescricao.setBounds(405, 178, 156, 32);
		panel.add(lblDescricao);
		
		JLabel lblConsultaCodigoTipo = new JLabel("");
		lblConsultaCodigoTipo.setHorizontalAlignment(SwingConstants.CENTER);
		lblConsultaCodigoTipo.setFont(new Font("Cambria", Font.PLAIN, 18));
		lblConsultaCodigoTipo.setBounds(547, 92, 156, 32);
		panel.add(lblConsultaCodigoTipo);
		
		btnRemover = new JButton("Remover");
		btnRemover.setFont(new Font("Cambria", Font.PLAIN, 18));
		btnRemover.setBounds(359, 270, 109, 23);
		panel.add(btnRemover);
		
		btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new GerenciarTipoProduto().setVisible(true);
			}
		});
		btnVoltar.setFont(new Font("Cambria", Font.PLAIN, 18));
		btnVoltar.setBounds(494, 270, 95, 23);
		panel.add(btnVoltar);
	}
}
