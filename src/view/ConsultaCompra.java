package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import model.bd.CompraBD;

public class ConsultaCompra extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;

	public ConsultaCompra() {
		setTitle("Informe o ID da compra");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 293, 92);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		textField = new JTextField();
		textField.setBounds(10, 10, 10, 10);
		contentPane.add(textField);
		textField.setColumns(10);
		
		
		JButton consultarCompra = new JButton("Consultar Compra");
		consultarCompra.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int id = Integer.parseInt(textField.getText());
					var compras = new CompraBD().consultar();
					int size = compras.size();
					StringBuffer buffer = new StringBuffer();
					for (int i = 0; i < size; i++) {
						var compra = compras.get(i);
						if (compra.getId() == id) {
							buffer.append("COMPRA - " + compra.getData() + "\n");
							buffer.append("TOTAL = " + String.format("R$%.2f", compra.getTotal()) + "\n");
						}
					}
					ExibirPedido exibir = new ExibirPedido(buffer.toString());
					dispose();
					exibir.setVisible(true);
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, e2.getMessage());
				}
			}
		});

		consultarCompra.setBounds(10, 235, 161, 49);
		contentPane.add(consultarCompra);
	}

}
