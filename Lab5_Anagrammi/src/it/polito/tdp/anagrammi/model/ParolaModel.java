package it.polito.tdp.anagrammi.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import it.polito.tdp.anagrammi.db.ParolaDAO;

public class ParolaModel {
	
	public Set<String> getAnagrammi(String text) {
		// TODO Auto-generated method stub
		
		Set<String> result = new HashSet<String>();
		
		this.calcolaAnagramma(text, "", 0,result);
		
		return result;
	}
	
	public void calcolaAnagramma(String input, String parziale, int level,Set<String> result ) {
		
		char[] c = input.toCharArray();
		
		if(level == input.length()) {
			
			result.add(parziale);
			return;
			
		}
		
		for(int i = 0; i< input.length(); i++) {
			
			if(this.count(parziale, c[i]) < this.count(input, c[i])) {
			
				parziale += c[i];
				calcolaAnagramma(input,parziale,level+1,result);
				parziale = parziale.substring(0, parziale.length()-1);
			
			}
		}
	}

	public boolean esattezza(String parola) {
		// TODO Auto-generated method stub
		ParolaDAO dao = new ParolaDAO();
		
		return dao.getEsattezza(parola);
	}	
	
	public int count(String parola, char a) {
		
		
		int valore = 0;
		for(int i = 0; i<parola.length(); i++) {
			
			if(parola.charAt(i) == a)
				valore++;
		}
		
		return valore;
		
	}
}
