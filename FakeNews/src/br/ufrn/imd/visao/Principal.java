package br.ufrn.imd.visao;

import java.io.IOException;
import br.ufrn.imd.controle.ControladorArquivo;
import br.ufrn.imd.modelo.ArqCsv;
import br.ufrn.imd.modelo.ArqWeb;
import br.ufrn.imd.modelo.Noticia;
import br.ufrn.imd.modelo.NoticiaCsv;

public class Principal {

	public static void main(String[] args) throws IOException {
	
		ControladorArquivo ca = new ControladorArquivo();
		ArqCsv ac = new ArqCsv();
		ArqWeb aw = new ArqWeb();
		NoticiaCsv nc = new NoticiaCsv();
//		
		aw.fechar();
//		
//		for(int x = 1; x < 1171; x++)
//		{
//			nc.setConteudo(ac.ler(x, 1));
//			System.out.println(x+" Original = "+nc.getConteudo());
//			nc.Formatar();
//			System.out.println(x+" Formatada = "+nc.getFormatado());
//		}
		
//		System.out.println();
//		System.out.println( nc.getConteudo());
//		System.out.println( nc.getFormatado());
//		System.out.println( nc.getLink());
//		System.out.println( nc.getTime());
//		System.out.println( nc.SHA());
		
//		
//		ca.armazenarCsv();
//		nc = ca.getMapCsv().get( nc.SHA( ) );
////		System.out.println();
//		
//		System.out.println( nc.getConteudo());
//		System.out.println( nc.getFormatado());
//		System.out.println( nc.getLink());
//		System.out.println( nc.getTime());
//		System.out.println( nc.SHA());
//		
//		System.out.println("FAKE "+ nc.getLink() );

//        for (String key : ca.getMapCsv().keySet()) {
//            
//            //Capturamos o valor a partir da chave
//            NoticiaCsv value = ca.getMapCsv().get(key);
//            System.out.println(key + " = " + value.getLink());
//        }

	}

}
