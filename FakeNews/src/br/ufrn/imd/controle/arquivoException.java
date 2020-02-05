package br.ufrn.imd.controle;

import java.io.FileNotFoundException;

public class arquivoException extends FileNotFoundException {

	private static final long serialVersionUID = 1L;

	public arquivoException(Exception e) {
		super(e.getMessage());
		// TODO Auto-generated constructor stub
	}
	public arquivoException(String e) {
		super(e);		
		// TODO Auto-generated constructor stub
	}
//
}

