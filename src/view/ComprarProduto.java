package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableModel;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.AbstractCellEditor;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JTable;
import view.Carrinho;

public class ComprarProduto extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtCodigoProduto;
	private JTable tblProduto;
	private JTable tblCarrinho;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Carrinho carrinho = new Carrinho();
					ComprarProduto frame = new ComprarProduto(carrinho.getTblCarrinho(), carrinho);
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
	public ComprarProduto(JTable tblCarrinho, Carrinho carrinho) {
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
			}
		});
		btnSair.setBounds(10, 22, 70, 23);
		pnlComprarProduto.add(btnSair);
		
		JLabel lblComprarProdutos = new JLabel("Comprar Produtos");
		lblComprarProdutos.setHorizontalAlignment(SwingConstants.CENTER);
		lblComprarProdutos.setFont(new Font("Cambria", Font.PLAIN, 24));
		lblComprarProdutos.setBounds(175, 11, 219, 41);
		pnlComprarProduto.add(lblComprarProdutos);
		
		JButton btnCarrinho = new JButton("New button");
		btnCarrinho.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				carrinho.setVisible(true);;
			}
		});
		btnCarrinho.setIcon(new ImageIcon("C:\\Users\\kln\\eclipse-workspace\\sistema-gerencimaneto-vendas\\icons\\trolley.png"));
		btnCarrinho.setBounds(470, 18, 56, 36);
		pnlComprarProduto.add(btnCarrinho);
		
		  JComboBox<String> cbxCliente = new JComboBox<String>();
	        cbxCliente.addFocusListener(new FocusListener() {
	            @Override
	            public void focusGained(FocusEvent e) {
	                cbxCliente.removeItem("Cliente");
	            }

	            @Override
	            public void focusLost(FocusEvent e) {
	                if (cbxCliente.getSelectedIndex() == -1) {
	                    cbxCliente.addItem("Cliente");
	                    cbxCliente.setForeground(Color.GRAY); // Altera a cor do texto para cinza
	                    cbxCliente.setSelectedIndex(0);
	                }
	            }
	        });
	        cbxCliente.setBounds(0, 65, 536, 22);
	        panel.add(cbxCliente);
		
	        txtCodigoProduto = new PlaceholderTextField("Código Produto");
	        txtCodigoProduto.setBounds(0, 85, 536, 22);
	        panel.add(txtCodigoProduto);
	        txtCodigoProduto.setColumns(10);
	        
	        // Criando a tabela com um modelo de tabela personalizado
	        ProdutoTableModel model = new ProdutoTableModel();
	        tblProduto = new JTable(model);
	        tblProduto.getColumnModel().getColumn(5).setCellRenderer(new ButtonRenderer());
	        tblProduto.getColumnModel().getColumn(5).setCellEditor(new ButtonEditor());
	        JScrollPane scrollPane = new JScrollPane(tblProduto); // Adicionando a tabela em um JScrollPane
	        scrollPane.setBounds(0, 107, 536, 222);
	        panel.add(scrollPane);
	}
	
	
	
	// Modelo de tabela personalizado
    class ProdutoTableModel extends AbstractTableModel {
        private static final long serialVersionUID = 1L;
        private String[] columnNames = {"Código", "Nome", "Tipo de Produto", "Qtd em Estoque", "Valor", "Adicionar"};
        private Object[][] data = {
                {"123", "Produto 1", "Tipo 1", 10, 20.00, null},
                {"456", "Produto 2", "Tipo 2", 20, 30.00, null},
                {"789", "Produto 3", "Tipo 3", 30, 40.00, null}
        };

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
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            if (isSelected) {
                setForeground(table.getSelectionForeground());
                setBackground(table.getSelectionBackground());
            } else {
                setForeground(table.getForeground());
                setBackground(UIManager.getColor("Button.background"));
            }
            setText((value == null) ? "" : value.toString());
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
                  int quantidade = (int) model.getValueAt(row, 3); // Supondo que a quantidade esteja na quarta coluna
                  
                  Object[] rowData = {nome, valor, quantidade, null};
                  
                  
                  
                  ((Carrinho.TableModel) tblCarrinho.getModel()).addRow(rowData);

            	
                fireEditingStopped();
            });
        }

        @Override
        public Object getCellEditorValue() {
            return button.getText();
        }

        @Override
        public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
            return button;
        }
    }
}
