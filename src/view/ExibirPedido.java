package view;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class ExibirPedido extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	public ExibirPedido(String itens) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		setLayout(null);
		
		JLabel pedido = new JLabel(itens);
		pedido.setHorizontalAlignment(SwingConstants.CENTER);
		pedido.setFont(new Font("Cambria", Font.PLAIN, 24));
		pedido.setBounds(210, 36, 161, 77);
		add(pedido);
	}

}
