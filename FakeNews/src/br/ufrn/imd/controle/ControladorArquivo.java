package br.ufrn.imd.controle;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;

import br.ufrn.imd.modelo.ArqCsv;
import br.ufrn.imd.modelo.ArqWeb;
import br.ufrn.imd.modelo.Noticia;
import br.ufrn.imd.modelo.NoticiaCsv;
import br.ufrn.imd.modelo.NoticiaWeb;

public class ControladorArquivo {
	
	private ArqCsv arqCsv;
	private ArqWeb arqWeb;
	private HashMap<String , NoticiaCsv> mapCsv;
	private HashMap<String , NoticiaWeb> mapWeb;

	public ControladorArquivo() throws FileNotFoundException  {
		mapCsv = new HashMap<String, NoticiaCsv>();
		mapWeb = new HashMap<String, NoticiaWeb>();
		arqCsv = new ArqCsv();
		arqWeb = new ArqWeb();
	}
//	
	public ArqCsv getArqCsv() {
		return arqCsv;
	}

	public void setArqCsv(ArqCsv arqCsv) {
		this.arqCsv = arqCsv;
	}

	public ArqWeb getArqWeb() {
		return arqWeb;
	}

	public void setArqWeb(ArqWeb arqWeb) {
		this.arqWeb = arqWeb;
	}

	public HashMap<String, NoticiaCsv> getMapCsv() {
		return mapCsv;
	}

	public void setMapCsv(HashMap<String, NoticiaCsv> mapCsv) {
		this.mapCsv = mapCsv;
	}

	public HashMap<String, NoticiaWeb> getMapWeb() {
		return mapWeb;
	}

	public void setMapWeb(HashMap<String, NoticiaWeb> mapWeb) {
		this.mapWeb = mapWeb;
	}

	public void armazenarCsv() throws IOException {
		
		
		int linha = 1;
		int tamanho = arqCsv.tamanhaCsv();
		int load = tamanho/100;
		int percent = 1;
		while(linha <=  1) {
			
			if( linha > load) {
				if(percent < 100) {
					System.out.println("["+percent+"%]");
					percent++;
					load += (tamanho/100);
				}
			}
			NoticiaCsv newCsv = new NoticiaCsv();

			newCsv.setConteudo( arqCsv.ler(linha, 1) );
			
//			System.out.println("Linha "+ linha + " Total "+ arqCsv.tamanhaCsv()+ "Cont" + arqCsv.ler(linha, 1));
			newCsv.Formatar();
			newCsv.setLink(arqCsv.ler(linha, 2));
			newCsv.setTime(arqCsv.ler(linha, 3));
//			System.out.println();
//			
//			System.out.println(newCsv.getConteudo());
//			System.out.println(newCsv.getFormatado());
//			System.out.println(newCsv.getLink());
//			System.out.println(newCsv.getTime());
//			System.out.println(newCsv.SHA());
//			System.out.println();
			
			mapCsv.put( newCsv.SHA() , newCsv ) ;

			linha++;				
		}
		System.out.println("["+percent+"%]");

	}
}
