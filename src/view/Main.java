package view;

import java.awt.EventQueue;

import javax.swing.JFrame;

import controller.ControladorCliente;
import model.entitites.Endereco;
import model.entitites.PessoaFisica;
import model.entitites.PessoaJuridica;

public class Main {

	private JFrame frame;

	/**
	 * Launch the application.
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		
		ControladorCliente controladorCliente = new ControladorCliente();
		for(int i = 0; i < 10; i++) {
			Endereco end = new Endereco();
			end.setLogradouro("Rua " + i);
			end.setCep(i + "");
			end.setComplemento("Complemento " + i);
			end.setCep(i + "");
			end.setNumero(i);
			if(i % 2 == 0) {
				PessoaJuridica cliente = new PessoaJuridica();
				cliente.setNome("Nome " + i);
				cliente.setCnpj(i + "");
				cliente.setEmail("email" + i + "@email.com");
				cliente.setTelefone(i + "");
				cliente.setEndereco(end);
				controladorCliente.cadastrar(cliente);
			} else {
				PessoaFisica cliente = new PessoaFisica();
				cliente.setNome("Nome " + i);
				cliente.setCpf(i + "");
				cliente.setCelular(i + "");
				controladorCliente.cadastrar(cliente);
			}
		}
		
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Main() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
