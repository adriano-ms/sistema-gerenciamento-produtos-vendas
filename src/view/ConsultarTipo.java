package view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.AbstractTableModel;

import br.edu.fateczl.list.List;
import controller.ControladorTipoProduto;
import model.entities.Produto;
import model.entities.TipoProduto;

public class ConsultarTipo extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private JLabel lblCodigoDoTipo;
	private JLabel lblNomeDoTipo;
	private JButton btnRemover;
	private JButton btnVoltar;

	public ConsultarTipo(ControladorTipoProduto controlador, TipoProduto tipoProduto) throws Exception {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 801, 492);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 765, 431);
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

		JLabel lblConsultaCodigoTipo = new JLabel(String.valueOf(tipoProduto.getCodigo()));
		lblConsultaCodigoTipo.setHorizontalAlignment(SwingConstants.CENTER);
		lblConsultaCodigoTipo.setFont(new Font("Cambria", Font.PLAIN, 18));
		lblConsultaCodigoTipo.setBounds(550, 92, 89, 32);
		panel.add(lblConsultaCodigoTipo);

		ProdutoTableModel model = new ProdutoTableModel(controlador, tipoProduto);
		
		btnRemover = new JButton("Remover");
		btnRemover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					controlador.removerTipoProduto(tipoProduto.getCodigo());
					JOptionPane.showMessageDialog(null, "Remoção feita com sucesso!");
					dispose();
					new GerenciarTipoProduto().setVisible(true);

				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage());
				}
			}
		});
		btnRemover.setFont(new Font("Cambria", Font.PLAIN, 18));
		btnRemover.setBounds(525, 397, 109, 23);
		panel.add(btnRemover);

		btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new GerenciarTipoProduto().setVisible(true);
			}
		});
		btnVoltar.setFont(new Font("Cambria", Font.PLAIN, 18));
		btnVoltar.setBounds(660, 397, 95, 23);
		panel.add(btnVoltar);

		JLabel lblNomeTipo = new JLabel(tipoProduto.getNome());
		lblNomeTipo.setHorizontalAlignment(SwingConstants.CENTER);
		lblNomeTipo.setFont(new Font("Cambria", Font.PLAIN, 18));
		lblNomeTipo.setBounds(550, 135, 89, 32);
		panel.add(lblNomeTipo);
		table = new JTable(model);
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(35, 80, 347, 317);
		panel.add(scrollPane);
	}
	
	class ProdutoTableModel extends AbstractTableModel {
        private static final long serialVersionUID = 1L;
        private String[] columnNames = {"Código", "Nome", "Qtd em Estoque", "Valor"};
        private Object[][] data;
        private ControladorTipoProduto controlador;
        private TipoProduto tipo;
        
        public ProdutoTableModel(ControladorTipoProduto controlador, TipoProduto tipo) {
        	this.controlador = controlador;
        	this.tipo = tipo;
        	data = loadData();
        }

        public Object[][] loadData() {
        	Object[][] dataCliente=null;
			try {
				List<Produto> list = controlador.consultaPorTipo(tipo);
				dataCliente = new Object[list.size()][4];
				int size = list.size();
				for (int i = 0; i < size; i++) {
					Produto prod = list.get(i);
					dataCliente[i][0] = prod.getCodigo();
					dataCliente[i][1] = prod.getNome();
					dataCliente[i][2] = prod.getQtdEmEstoque();
					dataCliente[i][3] = String.format("R$ %.2f", prod.getValor());
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			return dataCliente;
		}
        
        public void clearTable() {
			try {
				for (int i = 0; i < data.length; i++) {
						for (int j = 0; j < columnNames.length; j++) {
							this.setValueAt(null, i, j);
						}
					}
			
			}catch (Exception e) {
				e.printStackTrace();
			}
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
        
        public boolean isCellEditable(int row, int col) {
            return col == getColumnCount() - 1;
        }
        
        public Class<?> getColumnClass(int c) {
            return getValueAt(0, c).getClass();
        }
        
        public void setValueAt(Object value, int row, int col) {
            data[row][col] = value;
            fireTableCellUpdated(row, col);
        }
    }
}
