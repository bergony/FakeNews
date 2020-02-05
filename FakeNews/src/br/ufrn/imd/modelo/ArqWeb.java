package br.ufrn.imd.modelo;

import com.jaunt.UserAgent;
import com.jaunt.*;
import com.jaunt.component.*;
import java.io.*;
import java.util.List;

public class ArqWeb implements Arquivo {

	private String destino = "https://www.boatos.org/politica/reporter-patricia-mello-folha-haddad.html";
	private UserAgent userAgent;

	public ArqWeb() {
		
		userAgent = new UserAgent();
	}
	
	@Override
	public void abrir() {
//		// TODO Auto-generated method stub
	    try{
	        userAgent.visit("destino");
	        //open HTML from a String.
	        userAgent.openContent(userAgent.doc.innerHTML());
	        Element body = userAgent.doc.findFirst("<body>");
	        Element div = body.findFirst("<div>");

	        System.out.println("div's child text: " + div.getChildText());   //join child of div element
	        System.out.println("-----------");
	        System.out.println("all div's text: " + div.getTextContent());   //join all text within the div element 
	      }
	      catch(JauntException e){
	        System.err.println(e);
	      }

	}
//
	@Override
	public void fechar() {
		// TODO Auto-generated method stub
	 }
	

	@Override
	public String ler(int linha, int coluna) {
		return url;
		// TODO Auto-generated method stub
	}

}
