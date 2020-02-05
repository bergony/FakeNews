package br.ufrn.imd.modelo;

public class NoticiaCsv extends Noticia {
	
	
	
	public NoticiaCsv() {
		super();
		// TODO Auto-generated constructor stub
	}
//
	@Override
	public void Formatar() {	
		// TODO Auto-generated method stub
		String palavra = super.getConteudo();
		palavra = removePalavraMenor(palavra, 3);
//		System.out.println(palavra);
		palavra = palavraMinuscula(palavra);
//		System.out.println(palavra);
		palavra = palavrasOrdenarRepitidas(palavra);
//		System.out.println(palavra);
		super.setFormatado(palavra);
	}

//
}
