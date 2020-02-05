package br.ufrn.imd.modelo;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


public abstract class Noticia {
//	
	
	private String conteudo = "";
	private String formatado = "";
	private String link = "";
	private String time;

	public Noticia() {
		// TODO Auto-generated constructor stub
	}

	public String getConteudo() {
		return conteudo;
	}

	public void setConteudo(String conteudo) {
		this.conteudo = conteudo;
	}

	public String getFormatado() {
		return formatado;
	}

	public void setFormatado(String formatado) {
		this.formatado = formatado;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}
	public abstract void Formatar();
	
	public static String removePalavraMenor(String palavra, int tamanho) {
		
		String[] s = palavra.split(" ");
		String out = "";
		int count = 0;
			
		while(s.length > count) {
			
			if(s[count].length() > tamanho) {
				out += s[count];
				out += " ";
			}
			
			count++;
		}
		return out;
	}
	

	public static String palavraMinuscula( String palavra ) {
		
		palavra.toLowerCase().replaceAll("[^\\p{ASCII} [,-.]]", "");
		
		return palavra.toLowerCase().replaceAll("[^a-z ]", "");
	}
	
	public static String palavrasOrdenarRepitidas(String frase) {
		
		String[] s = frase.split(" ");
		String aux = "";
		String out = "";
		int count = 0;
		int index = 0;
		int charAt = 0;
	

		while(s.length-1 > index) {
			
			if( s.length-1 == count)
			{
//				System.out.println("SAIU");
//				System.out.println();
				out += s[index];
				out += " ";
				index++;
				count = index;
				continue;
			}
//			
//			System.out.println(s.length-1 + " > " +index+"count"+count);
//			System.out.println(s[index] + " > " + s[count] + " NO "+ charAt );
			

			if( (s[index].length()-1 >= charAt && s[count].length()-1 >= charAt)) {
			
				if( s[index].charAt(charAt) > s[count].charAt(charAt))  {
//					System.out.println(s[index].charAt(charAt) + " E MAIOR "+ s[count].charAt(charAt));
//					System.out.println();
					aux = s[index];
					s[index] = s[count];
					s[count] = aux;
					charAt = 0;
					count = index;
					continue;
				}
		
				if(s[index].charAt(charAt) == s[count].charAt(charAt) ){
//					System.out.println(s[count].charAt(charAt)  +" E igual"+s[count].charAt(charAt)  );
//					System.out.println();
					charAt++;
					continue;
				}
//					System.out.println("Não igual");	
//					System.out.println();
					charAt = 0;
					count++;

				continue;
						
			}
			charAt = 0;
			count++;
		}
		return palavrasRepetidas(out);
	}
	
	private static String palavrasRepetidas(String palavra) {
		
		String[] s = palavra.split(" ");
		String out = "";
		
		int count = 0;
		
		while(s.length-1 > count) {
			if(s[count].equals(s[count+1])) {
				
			}else{
				out += s[count];
				out += " ";
			}
			count++;
		}
		if(s[count-1].equals(s[count])) {
			
		}else{
			out += s[count];
			out += " ";
		}
		return out;
	}
	
	//Fonte https://www.geeksforgeeks.org/sha-1-hash-in-java/
	public String SHA() 
    { 
		String hashtext;
        try { 
            // getInstance() method is called with algorithm SHA-1 
            MessageDigest md = MessageDigest.getInstance("SHA-1"); 
  
            // digest() method is called 
            // to calculate message digest of the input string 
            // returned as array of byte 
            byte[] messageDigest = md.digest(formatado.getBytes()); 
  
            // Convert byte array into signum representation 
            BigInteger no = new BigInteger(1, messageDigest); 
  
            // Convert message digest into hex value 
            hashtext = no.toString(16); 
  
            // Add preceding 0s to make it 32 bit 
            while (hashtext.length() < 32) { 
                hashtext = "0" + hashtext; 
            } 
  
            // return the HashText 
            return hashtext; 
        } 
  
        // For specifying wrong message digest algorithms 
        catch (NoSuchAlgorithmException e) { 
            throw new RuntimeException(e); 
        } 
    }
}
