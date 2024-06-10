package view;

import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

public class ExibirPedido extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	public ExibirPedido(String itens) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 298, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		getContentPane().setLayout(null);
		
		JTextArea pedido = new JTextArea(itens);
		pedido.setLineWrap(true);
		pedido.setWrapStyleWord(true);
		pedido.setFont(new Font("Cambria", Font.PLAIN, 15));
		pedido.setEditable(false);
		pedido.setBounds(0, 0, 282, 261);
		contentPane.add(pedido);
	}

}
