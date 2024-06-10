package view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractCellEditor;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;

public class Carrinho extends JDialog {

	private static final long serialVersionUID = 1L;
	private JTable tblCarrinho;
	private JLabel totalLabel;
	private double total = 0.0;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Carrinho dialog = new Carrinho();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	 
	
	public class TableModel extends AbstractTableModel {
		
        private final String[] columnNames = { "Name", "Value", "Quantity"};
        private Object[][] data = { { "Item 1", 0.0, 1} };
	   	    	    
	    @Override
	    public int getRowCount() {
	        return data.length;
	    }
	    
	    @Override
		public int getColumnCount() {
			// TODO Auto-generated method stub
	    	return columnNames.length;
		}

		@Override
		public Object getValueAt(int rowIndex, int columnIndex) {
			// TODO Auto-generated method stub
			return data[rowIndex][columnIndex];
		}
		
		 @Override
		    public String getColumnName(int column) {
		        return columnNames[column];
		    }
		 
		 @Override
		 public Class<?> getColumnClass(int columnIndex) {
		     Object value = getValueAt(0, columnIndex);
		     if (value != null) {
		         return value.getClass();
		     } else {
		         // Se o valor for nulo, retorne Object.class
		         return Object.class;
		     }
		 }
		 
		 @Override
		    public boolean isCellEditable(int rowIndex, int columnIndex) {
			 return  columnIndex == 2; // Apenas a coluna "Value" é editável
		    }
		 
		 @Override
		    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
			 data[rowIndex][columnIndex] = aValue;
	            fireTableCellUpdated(rowIndex, columnIndex); // Notifica a tabela de que os dados mudaram
	            updateTotalLabel(); // Atualiza o total no label
		   
		        }

		 public void addRow(Object[] rowData) {
	            Object[][] newData = new Object[data.length + 1][getColumnCount()];
	            for (int i = 0; i < data.length; i++) {
	                newData[i] = data[i];
	            }
	            newData[data.length] = rowData;
	            data = newData;

	            fireTableRowsInserted(data.length - 1, data.length - 1);
	            updateTotalLabel();
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
	                updateTotalLabel(); // Atualiza o total no label
	       
	            }
	        }
		 
	}
		   
		
	
	 
    public class SpinnerEditor extends AbstractCellEditor implements TableCellEditor {
        private final JSpinner spinner;

        public SpinnerEditor() {
            spinner = new JSpinner(new SpinnerNumberModel(0, 0, 100, 1));
            spinner.addChangeListener(new ChangeListener() {
                public void stateChanged(ChangeEvent e) {
                    stopCellEditing(); // Finaliza a edição quando o valor é alterado
                }
            });
        }

        @Override
        public Object getCellEditorValue() {
            return spinner.getValue();
        }

        @Override
        public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
            spinner.setValue(value);
            return spinner;
        }
    }
    
    public class SpinnerRenderer extends JSpinner implements TableCellRenderer {
        public SpinnerRenderer() {
            super(new SpinnerNumberModel(0, 0, 100, 1));
        }

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            setValue(value);
            return this;
        }
    }
    
	  

	/**
	 * Create the dialog.
	 */
	public Carrinho() {
		setResizable(false);
		setBounds(100, 100, 377, 274);
		getContentPane().setLayout(null);
		{
				
		   
			
			JPanel panel = new JPanel();
			panel.setBounds(10, 11, 341, 213);
			getContentPane().add(panel);
			panel.setLayout(null);
			
			JButton btnRemover = new JButton("Remover");
			btnRemover.addActionListener(new ActionListener() {
			    public void actionPerformed(ActionEvent e) {
			        TableModel model = (TableModel) tblCarrinho.getModel(); // Obtém o modelo de tabela da tabela
			        int lastRow = model.getRowCount() - 1; // Obtém o índice da última linha
			        model.removeRow(lastRow); // Remove a última linha do modelo de tabela
			    }
			});
			btnRemover.setFont(new Font("Cambria", Font.PLAIN, 14));
			btnRemover.setBounds(81, 177, 109, 23);
			panel.add(btnRemover);
			
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(0, 29, 341, 133);
			panel.add(scrollPane);
			
			
			TableModel model = new TableModel();  
		
			setTblCarrinho(new JTable());
			getTblCarrinho().setModel(model); // Defina o modelo para a tabela
			scrollPane.setViewportView(getTblCarrinho());
			SpinnerEditor spinnerEditor = new SpinnerEditor();
			getTblCarrinho().getColumnModel().getColumn(2).setCellEditor(spinnerEditor);
			getTblCarrinho().getColumnModel().getColumn(2).setCellRenderer(new SpinnerRenderer());
			
					
	        
			JPanel panel_1 = new JPanel();
			panel_1.setBackground(new Color(192, 192, 192));
			panel_1.setBounds(0, 0, 341, 30);
			panel.add(panel_1);
			panel_1.setLayout(null);
			
			JLabel lblCarrinho = new JLabel("Carrinho");
			lblCarrinho.setFont(new Font("Cambria", Font.PLAIN, 14));
			lblCarrinho.setBounds(10, 7, 78, 14);
			panel_1.add(lblCarrinho);
			
			
			totalLabel = new JLabel("Total: 0");
		        totalLabel.setBounds(10, 173, 109, 30);
		        panel.add(totalLabel);
		        
		        JButton btnFecharCompra = new JButton("Fechar Compra");
		        btnFecharCompra.setFont(new Font("Cambria", Font.PLAIN, 14));
		        btnFecharCompra.setBounds(206, 177, 125, 23);
		        panel.add(btnFecharCompra);

			
           
			
			
		}
		
		
	}
	
	  
	
	  private void updateTotalLabel() {
	      	total = 0;
	        TableModel model = (TableModel) getTblCarrinho().getModel();
	        for (int i = 0; i < model.getRowCount(); i++) {
	            total += (double) model.getValueAt(i, 1) * (int) model.getValueAt(i, 2);
	        }
	        totalLabel.setText("Total: " + total);
	    }

	public JTable getTblCarrinho() {
		return tblCarrinho;
	}

	public void setTblCarrinho(JTable tblCarrinho) {
		this.tblCarrinho = tblCarrinho;
	}

	
}
