package br.ufrn.imd.modelo;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import com.opencsv.CSVReader;

import br.ufrn.imd.controle.arquivoException;

public class ArqCsv implements Arquivo {

	private String destino = "boatos.csv";
	CSVReader leitor;
	
	public ArqCsv() throws FileNotFoundException {
		
		try {			
			this.leitor = new CSVReader(new FileReader(destino));
		} catch (arquivoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

//	@Override
	public void abrir() throws arquivoException {

		try {
			this.leitor = new CSVReader(new FileReader(destino));
		} catch (FileNotFoundException e) {
			throw new arquivoException("Arquivo nao Encontrado");
		}
	}

	@Override
	public void fechar() throws arquivoException {
		// TODO Auto-generated method stub
		try {
			leitor.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			throw new arquivoException(e);
		}
	}

	@Override
	public String ler(int linha, int coluna ) throws IOException {
		// TODO Auto-generated method stub
		int count = 0;
		abrir();
		String[] s;
	
		while((s = leitor.readNext()) != null) {
			
			if(count == linha || linha < 0) {
				return s[coluna];
			}
			count++;
			
		}
		fechar();
		return " Valor fora ";

	}
	
	public int tamanhaCsv( ) throws IOException {
		// TODO Auto-generated method stub
		int count = 0;
		abrir();
		leitor.readNext();
		
		while((leitor.readNext()) != null) {
			count++;
		}
		fechar();
		return count;

	}
}
