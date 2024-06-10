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

import controller.ControladorTipoProduto;

public class GerenciarTipoProduto extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtCodigoTipo;
	private JTextField txtNomeTipo;

	
	public GerenciarTipoProduto() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 548, 404);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(10, 11, 512, 343);
		contentPane.add(panel);
		
		JLabel lblGerenciarTipoProdutos = new JLabel("Gerenciar Tipo Produtos");
		lblGerenciarTipoProdutos.setHorizontalAlignment(SwingConstants.CENTER);
		lblGerenciarTipoProdutos.setFont(new Font("Cambria", Font.PLAIN, 24));
		lblGerenciarTipoProdutos.setBounds(110, 22, 273, 63);
		panel.add(lblGerenciarTipoProdutos);
		
		JLabel lblCodigoTipo = new JLabel("Código do Tipo:");
		lblCodigoTipo.setHorizontalAlignment(SwingConstants.CENTER);
		lblCodigoTipo.setFont(new Font("Cambria", Font.PLAIN, 18));
		lblCodigoTipo.setBounds(66, 109, 156, 32);
		panel.add(lblCodigoTipo);
		
		txtCodigoTipo = new JTextField();
		txtCodigoTipo.setFont(new Font("Cambria", Font.PLAIN, 18));
		txtCodigoTipo.setColumns(10);
		txtCodigoTipo.setBounds(241, 116, 120, 25);
		panel.add(txtCodigoTipo);
		
		JLabel lblNomeTipo = new JLabel("Nome do Tipo:");
		lblNomeTipo.setHorizontalAlignment(SwingConstants.CENTER);
		lblNomeTipo.setFont(new Font("Cambria", Font.PLAIN, 18));
		lblNomeTipo.setBounds(66, 172, 156, 32);
		panel.add(lblNomeTipo);
		
		txtNomeTipo = new JTextField();
		txtNomeTipo.setFont(new Font("Cambria", Font.PLAIN, 18));
		txtNomeTipo.setColumns(10);
		txtNomeTipo.setBounds(241, 172, 120, 25);
		panel.add(txtNomeTipo);
		
		JButton btnAdicionarTipo = new JButton("Adicionar Novo Tipo +");
		btnAdicionarTipo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				dispose();
				new AdicionarTipo().setVisible(true);
			}
		});
		btnAdicionarTipo.setFont(new Font("Cambria", Font.PLAIN, 18));
		btnAdicionarTipo.setBounds(18, 250, 214, 25);
		panel.add(btnAdicionarTipo);
		
		JButton btnConsultarTipo = new JButton("Consultar Tipo");
		btnConsultarTipo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					ControladorTipoProduto ctrlTpProd = new ControladorTipoProduto();
					
					if (!txtCodigoTipo.getText().trim().isEmpty()) {
						var tipoProduto = ctrlTpProd.consultarTipoProduto(Integer.valueOf(txtCodigoTipo.getText()));
						
						ConsultarTipo cTp = new ConsultarTipo(tipoProduto);
						
						dispose();
						cTp.setVisible(true);
						
					} else if (!txtNomeTipo.getText().trim().isEmpty()) {
						var tipoProduto = ctrlTpProd.consultarTipoProduto(txtNomeTipo.getText());
						
						ConsultarTipo cTp = new ConsultarTipo(tipoProduto);
						
						dispose();
						cTp.setVisible(true);
					} else {
						throw new Exception("Preencha ao menos um campo!");
					}
						
				
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, e1.getMessage());
				}
			}
		});
		btnConsultarTipo.setFont(new Font("Cambria", Font.PLAIN, 18));
		btnConsultarTipo.setBounds(253, 250, 204, 25);
		panel.add(btnConsultarTipo);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new Main().setVisible(true);
			}
		});
		btnVoltar.setFont(new Font("Cambria", Font.PLAIN, 18));
		btnVoltar.setBounds(142, 301, 204, 25);
		panel.add(btnVoltar);
	}

}
