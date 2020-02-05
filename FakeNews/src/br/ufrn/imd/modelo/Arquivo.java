package br.ufrn.imd.modelo;

import java.io.IOException;

import br.ufrn.imd.controle.arquivoException;

public interface Arquivo {
	
	public void abrir() throws arquivoException;
	public void fechar() throws arquivoException;
	public String ler(int linha, int coluna) throws IOException;
	
}
