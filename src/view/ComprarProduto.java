package view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.AbstractCellEditor;
import javax.swing.DefaultComboBoxModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableModel;

import br.edu.fateczl.list.List;
import controller.ControladorCompra;
import controller.ControladorProduto;
import model.entities.Cliente;
import model.entities.Produto;

public class ComprarProduto extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtCodigoProduto;
	private JTable tblProduto;
	private JTable tblCarrinho;
	protected int clientId;

	public ComprarProduto(JTable tblCarrinho, Carrinho carrinho) {

		this.clientId = 1;

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 572, 390);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		this.tblCarrinho = tblCarrinho;

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 536, 329);
		contentPane.add(panel);
		panel.setLayout(null);

		JPanel pnlComprarProduto = new JPanel();
		pnlComprarProduto.setBorder(new LineBorder(new Color(0, 0, 0)));
		pnlComprarProduto.setBounds(0, 0, 536, 64);
		panel.add(pnlComprarProduto);
		pnlComprarProduto.setLayout(null);

		JButton btnSair = new JButton("Sair");
		btnSair.setFont(new Font("Cambria", Font.PLAIN, 14));
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new Main().setVisible(true);
			}
		});
		btnSair.setBounds(10, 22, 70, 23);
		pnlComprarProduto.add(btnSair);

		JLabel lblComprarProdutos = new JLabel("Comprar Produtos");
		lblComprarProdutos.setHorizontalAlignment(SwingConstants.CENTER);
		lblComprarProdutos.setFont(new Font("Cambria", Font.PLAIN, 24));
		lblComprarProdutos.setBounds(175, 11, 219, 41);
		pnlComprarProduto.add(lblComprarProdutos);

		Icon icone = new ImageIcon(
				new ImageIcon("img/carrinho.png").getImage().getScaledInstance(35, 35, EXIT_ON_CLOSE));
		JButton btnCarrinho = new JButton(icone);
		btnCarrinho.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				carrinho.setVisible(true);
				;
			}
		});
		btnCarrinho.setBounds(470, 18, 56, 36);
		pnlComprarProduto.add(btnCarrinho);

		String[] items = null;
		try {
			var clientes = new ControladorCompra().listarClientes();
			items = new String[clientes.size()];
			for (int i = 0; i < items.length; i++) {
				Cliente cliente = clientes.get(i);
				items[i] = cliente.getId() + " - " + "(" + cliente.getClass().getSimpleName() + ")" + " - "
						+ cliente.getNome();
			}
			clientId = clientes.get(0).getId();
		} catch (Exception e) {
			System.err.println("Não foi possivel carregar os Clientes!");
			e.printStackTrace();
		}

		DefaultComboBoxModel<String> modelCliente = new DefaultComboBoxModel<>(items);
		JComboBox<String> cbxCliente = new JComboBox<>(modelCliente);
		
		cbxCliente.addFocusListener(new FocusListener() {
			@Override
			public void focusGained(FocusEvent e) {
				cbxCliente.removeItem("Cliente");
			}

			@Override
			public void focusLost(FocusEvent e) {
				clientId = Integer.parseInt((cbxCliente.getSelectedItem().toString().split("-"))[0].trim());
				System.out.println(clientId);
				if (cbxCliente.getSelectedIndex() == -1) {
					cbxCliente.addItem("Cliente");
					cbxCliente.setForeground(Color.GRAY); // Altera a cor do texto para cinza
					cbxCliente.setSelectedIndex(0);
				}
			}
		});

		cbxCliente.setBounds(0, 65, 536, 22);
		panel.add(cbxCliente);

		// Criando a tabela com um modelo de tabela personalizado
		ProdutoTableModel model = new ProdutoTableModel();
		tblProduto = new JTable(model);
		tblProduto.getColumnModel().getColumn(5).setCellRenderer(new ButtonRenderer());
		tblProduto.getColumnModel().getColumn(5).setCellEditor(new ButtonEditor());
		JScrollPane scrollPane = new JScrollPane(tblProduto); // Adicionando a tabela em um JScrollPane
		scrollPane.setBounds(0, 107, 536, 222);
		panel.add(scrollPane);

		txtCodigoProduto = new PlaceholderTextField("Código Produto");
		txtCodigoProduto.setBounds(0, 85, 536, 22);
		txtCodigoProduto.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				char caractere = e.getKeyChar();
				if (!Character.isDigit(caractere) && ((int) caractere) != 8) {
					String text = txtCodigoProduto.getText();
					txtCodigoProduto.setText(text.substring(0, text.length() - 1));
					model.setData(model.loadData());
				} else {
					try {
						ControladorProduto ctrlProduto = new ControladorProduto();
						Produto produto = ctrlProduto.consultarProduto(Integer.parseInt(txtCodigoProduto.getText()));
						model.clearTable();
						Object[] linha = new Object[model.getColumnCount()];
						linha[0] = produto.getCodigo();
						linha[1] = produto.getNome();
						linha[2] = produto.getTipo().getNome();
						linha[3] = produto.getQtdEmEstoque();
						linha[4] = produto.getValor();
						linha[5] = null;
						model.addRow(linha);
					} catch (Exception e1) {
						System.err.println("Produto digitado não foi encontrado");
					}
				}

			}

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub

			}
		});
		panel.add(txtCodigoProduto);
		txtCodigoProduto.setColumns(10);

	}

	public int getClientId() {
		return clientId;
	}

	public void setClientId(int clientId) {
		this.clientId = clientId;
	}

	// Modelo de tabela personalizado
	class ProdutoTableModel extends AbstractTableModel {
		private static final long serialVersionUID = 1L;
		private String[] columnNames = { "Código", "Nome", "Tipo de Produto", "Qtd em Estoque", "Valor", "Adicionar" };
		private Object[][] data;
//        {
//                {"123", "Produto 1", "Tipo 1", 10, 20.00, null}
////                {"456", "Produto 2", "Tipo 2", 20, 30.00, null},
////                {"789", "Produto 3", "Tipo 3", 30, 40.00, null}
//        };

		public ProdutoTableModel() {
			data = loadData();
		}

		public Object[][] loadData() {
			System.out.println("CHAMOU");
			Object[][] dataCliente = null;
			try {
				System.out.println("Entrou");
				ControladorCompra ctrlCompra = new ControladorCompra();
				List<Produto> list = ctrlCompra.listarProdutos();
				dataCliente = new Object[list.size()][6];
				int size = list.size();
				for (int i = 0; i < size; i++) {
					Produto prod = list.get(i);
					dataCliente[i][0] = prod.getCodigo();
					dataCliente[i][1] = prod.getNome();
					dataCliente[i][2] = prod.getTipo().getNome();
					dataCliente[i][3] = prod.getQtdEmEstoque();
					dataCliente[i][4] = prod.getValor();
					dataCliente[i][5] = null;
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return dataCliente;
		}

		public void clearTable() {
			try {
				int size = getRowCount();
				for (int i = size; i >= 0; i--) {
					removeRow(i);
				}

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		public void removeRow(int rowIndex) {
			if (rowIndex >= 0 && rowIndex < data.length) {
				Object[][] newData = new Object[data.length - 1][getColumnCount()];
				for (int i = 0, j = 0; i < data.length; i++) {
					if (i != rowIndex) {
						newData[j++] = data[i];
					}
				}
				data = newData;
				fireTableDataChanged(); // Notifica a tabela de que os dados foram alterados
			}
		}

		public void addRow(Object[] rowData) {
			int qtRow = getRowCount();
			for (int i = 0; i < qtRow; i++) {
				if (data[i][0].equals(rowData[0])) {
					data[i][2] = (Integer.parseInt(String.valueOf(data[i][2]))) + 1;
					fireTableCellUpdated(i, 2);
					return;
				}
			}
			Object[][] newData = new Object[data.length + 1][getColumnCount()];
			for (int i = 0; i < data.length; i++) {
				newData[i] = data[i];
			}
			newData[data.length] = rowData;
			data = newData;

			fireTableRowsInserted(data.length - 1, data.length - 1);
		}

		public void setData(Object[][] obj) {
			this.data = obj;
			fireTableDataChanged();
		}

		public int getColumnCount() {
			return columnNames.length;
		}

		public int getRowCount() {
			return data.length;
		}

		public String getColumnName(int col) {
			return columnNames[col];
		}

		public Object getValueAt(int row, int col) {
			return data[row][col];
		}

		// Permite edição apenas na última coluna
		public boolean isCellEditable(int row, int col) {
			return col == getColumnCount() - 1;
		}

		// Define o tipo de dados para cada coluna
		public Class<?> getColumnClass(int c) {
			return getValueAt(0, c).getClass();
		}

		// Atualiza o valor na célula quando editado
		public void setValueAt(Object value, int row, int col) {
			data[row][col] = value;
			fireTableCellUpdated(row, col);
		}
	}

	class PlaceholderTextField extends JTextField {
		private static final long serialVersionUID = 1L;
		private String placeholder;

		public PlaceholderTextField(String placeholder) {
			this.placeholder = placeholder;
		}

		@Override
		protected void paintComponent(java.awt.Graphics g) {
			super.paintComponent(g);

			if (placeholder == null || placeholder.length() == 0 || getText().length() > 0) {
				return;
			}

			java.awt.Graphics2D g2 = (java.awt.Graphics2D) g.create();
			g2.setFont(getFont().deriveFont(Font.ITALIC));
			g2.setColor(Color.GRAY);
			g2.drawString(placeholder, getInsets().left, g.getFontMetrics().getMaxAscent() + getInsets().top);
			g2.dispose();
		}
	}

	// Classe para renderizar o botão na coluna "Adicionar"
	class ButtonRenderer extends JButton implements TableCellRenderer {
		private static final long serialVersionUID = 1L;

		public ButtonRenderer() {
			setOpaque(true);
		}

		@Override
		public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
				int row, int column) {
			if (isSelected) {
				setForeground(table.getSelectionForeground());
				setBackground(table.getSelectionBackground());
			} else {
				setForeground(table.getForeground());
				setBackground(UIManager.getColor("Button.background"));
			}
			setText((value == null) ? "+" : value.toString());
			return this;
		}
	}

	public class ButtonEditor extends AbstractCellEditor implements TableCellEditor {
		private static final long serialVersionUID = 1L;
		private JButton button;

		public ButtonEditor() {
			button = new JButton("+");
			button.addActionListener(e -> {
				// Ação ao clicar no botão

				int row = tblProduto.convertRowIndexToModel(tblProduto.getEditingRow());
				TableModel model = tblProduto.getModel();
				// Obtém os valores da linha clicada
				String nome = (String) model.getValueAt(row, 1); // Supondo que o nome esteja na segunda coluna
				Double valor = (Double) model.getValueAt(row, 4); // Supondo que o valor esteja na quinta coluna
				int quantidade = 1; // Supondo que a quantidade esteja na quarta coluna

				Object[] rowData = { nome, valor, quantidade, null };

				((Carrinho.TableModel) tblCarrinho.getModel()).addRow(rowData);

				fireEditingStopped();
			});
		}

		@Override
		public Object getCellEditorValue() {
			return button.getText();
		}

		@Override
		public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row,
				int column) {
			return button;
		}
	}
}
