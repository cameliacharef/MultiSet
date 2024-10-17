package pobj.multiset;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class MultiSetParser {
	public static MultiSet<String> parse(String fileName) throws InvalidMultiSetFormat{
		BufferedReader br = new BufferedReader(new FileReader(fileName)); // Lecteur pour lire le fichier ligne par ligne
		String line; // Pour stocker chaque ligne du fichier
		MultiSet<String> multiset = new HashMultiSet<>();
		while ((line = br.readLine()) != null) { // Tant qu'il reste des lignes à lire
			String[] ligne = line.split(":"); // Découpe la ligne par : 
			
			String cle = ligne[0];
			String Val = ligne[1];
			int count = Integer.parseInt(Val);
			
		}
		br.close(); // Ferme le lecteur de fichier
		
		
		
		
		
		return multiset;
	}
}
