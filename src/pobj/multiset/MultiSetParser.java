package pobj.multiset;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class MultiSetParser {
	public static MultiSet<String> parse(String fileName) throws InvalidMultiSetFormat{
		MultiSet<String> multiset = new HashMultiSet<>();
		
		try {
			BufferedReader br = new BufferedReader(new FileReader(fileName)); // Lecteur pour lire le fichier ligne par ligne
			String line; // Pour stocker chaque ligne du fichier
			
			while ((line = br.readLine()) != null) { // Tant qu'il reste des lignes à lire
				String[] ligne = line.split(":"); // Découpe la ligne par : 
				if(ligne.length != 2) {
					throw new InvalidMultiSetFormat("Ligne contient pas un seul ':' " + ligne);
				}
				String cle = ligne[0];
				String Val = ligne[1];
				int count;
				try {
					count = Integer.decode(Val);
					if(count <= 0) {
						throw new InvalidMultiSetFormat("la val doit etre positive");
					}
				}
				catch (NumberFormatException ne) {
					throw new InvalidMultiSetFormat("Erreur la chaine pas un entier", ne);
				}
				
				multiset.add(cle,count);
				
			}
			br.close(); // Ferme le lecteur de fichier
		}
		catch (IOException e){ // fichier non trouve et io ereur
			throw new InvalidMultiSetFormat("Erreur d'IO lors de lecture", e);
		}
		

		
		return multiset;
	}
}
