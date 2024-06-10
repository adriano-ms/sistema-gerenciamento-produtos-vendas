package model.bd;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

import br.edu.fateczl.list.List;

public class DatabaseAccess {
	
	private Path defaultFolder = Paths.get("/database");
	private char caracSeparacao = ',';
	
	public DatabaseAccess() {
		try {
			Files.createDirectories(defaultFolder);
		} catch (IOException e) {
			System.err.println("Falha na Criação da base de dados " + e.getMessage());
		}
	}
	
	public List<List<String>> lerArquivo(String filename) {
		filename = filename.toLowerCase();
		Path file = Paths.get(defaultFolder.toString(), filename);
		List<List<String>> linhas = new List<List<String>>();
		
		if(Files.notExists(file)) {
			return linhas;
		}
		
		try {
			if(Files.size(file)<=0) {
				System.out.println("LOG - Arquivo não tem tamanho minimo");
				return linhas;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			System.out.println("LOG - Prestes a ler");
			BufferedReader br = Files.newBufferedReader(file);
			int numCarac, caracFimDeLinha = 10;
			StringBuilder palavra = new StringBuilder();
			
			List<String> linha = new List<String>();
			while((numCarac = br.read()) != -1) {
				if(numCarac == (int)caracSeparacao) {
					linha.addLast(palavra.toString().trim());
					palavra = new StringBuilder();
				}else if(numCarac == caracFimDeLinha) {
					linha.addLast(palavra.toString().trim());
					palavra = new StringBuilder();
					linhas.addLast(linha);
					linha = new List<String>();
				}else {
					palavra.append((char)numCarac);
				}
			}
			br.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return linhas;
		
	}
	
	public void gravarNoArquivo(String filename, Object objeto) {
		filename = filename.toLowerCase();
		Path file = Paths.get(defaultFolder.toString(), filename);
				
		try {			
			if(Files.notExists(file)) {
				System.out.println("LOG - Arquivo não existe");
				criarArquivo(file, objeto);
			}else if(Files.size(file)<=0) {
				escreverCabecalho(file, objeto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try {
			BufferedWriter bw = Files.newBufferedWriter(file, StandardOpenOption.APPEND, StandardOpenOption.WRITE);
			String objetoSeparado = objeto.toString();
			bw.write(objetoSeparado);
			bw.newLine();
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	/*
	 * Usado pelas classes de BD para alterar os arquivos. Passando como parâmetro o nome do arquivo
	 * e a lista com os novos objetos a serem armazenados. O metódo considera que o toString() retorna
	 * o objeto da forma como deve ser armazenado.
	 * */
	public void alterarArquivo(String filename, List<?> lista) {
		filename = filename.toLowerCase();
		Path file = Paths.get(defaultFolder.toString(), filename);
		
		if(lista.isEmpty()) {
			limparArquivo(file);
			return;
		}
		
		if(Files.notExists(file)) {
			try {
				criarArquivo(file, lista.get(0));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else {
			limparArquivo(file);
		}
		
		try {
			escreverCabecalho(file, lista.get(0));
			BufferedWriter bw = Files.newBufferedWriter(file, StandardOpenOption.WRITE, StandardOpenOption.APPEND);
			
			int tamanho = lista.size();
			for (int i = 0; i < tamanho; i++) {
				Object obj = lista.get(i);
				String objetoSeparado = obj.toString();
				bw.write(objetoSeparado);
				bw.newLine();
			}
			bw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void limparArquivo(Path file) {
		try {
			Files.deleteIfExists(file);
			Files.createFile(file);
		} catch (IOException e) {
			System.err.println("Falha ao limpar o arquivo - "+e.getMessage());
			e.printStackTrace();
		}
	}

	private void criarArquivo(Path file, Object objeto) {
		try {
			Files.createFile(file);
			escreverCabecalho(file, objeto);
		} catch (IOException e) {
			System.err.println("Falha na criação do arquivo "+file.getFileName()+" - "+e.getMessage());
			e.printStackTrace();
		}
	}
	
	private void escreverCabecalho(Path file, Object objeto) {
		Field[] fields = objeto.getClass().getDeclaredFields();
		Field[] superClassFields = objeto.getClass().getSuperclass().getDeclaredFields();
		String cabecalho ="";
		for (Field field : superClassFields) {
			cabecalho+=field.getName()+caracSeparacao;
		}
		for (Field field : fields) {
			cabecalho+=field.getName()+caracSeparacao;
		}
		cabecalho = cabecalho.substring(0, cabecalho.length()-1);
		try {
			BufferedWriter bw = Files.newBufferedWriter(file, StandardOpenOption.WRITE);
			bw.write(cabecalho);
			bw.newLine();
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
