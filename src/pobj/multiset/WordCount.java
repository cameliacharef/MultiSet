package pobj.multiset;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import pobj.util.Chrono;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
/**
 * La classe WordCount compte les occurrences des mots dans un fichier texte et affiche 
 * les 10 mots les plus fréquents. Elle compare également les performances entre deux 
 * implémentations de MultiSet : HashMultiSet et NaiveMultiSet.
 */
public class WordCount {
	/**
     * Compte les mots dans un fichier texte et trie les mots en fonction de leurs occurrences.
     * Affiche les 10 mots les plus fréquents.
     *
     * @param ms une implémentation de MultiSet utilisée pour stocker les mots
     * @throws IOException si une erreur d'IO survient lors de la lecture du fichier
     */
	public static void wordcount(MultiSet<String> ms) throws IOException{
		String file = "data/Monfichier2.txt"; 
		//String file = "data/WarAndPeace.txt";  // Le fichier texte à analyser 
		BufferedReader br = new BufferedReader(new FileReader(file)); // Lecteur pour lire le fichier ligne par ligne
		String line; // Pour stocker chaque ligne du fichier
		List<String> liste = new ArrayList<String>(); // Liste pour stocker les mots triés
		while ((line = br.readLine())!=null) { // Tant qu'il reste des lignes à lire
			for (String word : line.split("\\P{L}+")) {  // Découpe la ligne en mots, ignore les caractères non alphabétiques
				if (word.equals("")) continue; // ignore les mots vides 
				// TODO: traitement à faire pour le mot word 
				ms.add(word);  // Ajoute le mot dans le multiset
				// ms.add(word, -1); -> Exception in thread "main" java.lang.IllegalArgumentException: count negatif
			} 
			liste = ms.elements(); // Récupère les éléments du multiset
			Comparator<String> comparator = null; // Initialisation du comparateur
			if(ms instanceof HashMultiSet<String>) { 
				comparator = new OccurrenceComparator<String>(ms); // Utilise le comparateur adapté pour HashMultiSet
			}
			else {
				comparator = new OccurrenceComparator<String>(ms); // Utilise le comparateur adapté pour NaiveMultiSet
			}
			Collections.sort(liste, comparator); // Trie la liste des mots en fonction de leurs occurrences
			Collections.reverse(liste); // Inverse la liste pour que les mots les plus fréquents soient en premier
		}
		br.close(); // Ferme le lecteur de fichier

        // Affiche les 10 mots les plus fréquents
		for(int i = 0; i < 10; i++)
			System.out.println(i + " : " + liste.get(i));
		System.out.println(ms);
	}
	 /**
     * Point d'entrée du programme. Teste la méthode wordcount avec deux implémentations de MultiSet
     * (HashMultiSet et NaiveMultiSet) et mesure le temps d'exécution de chaque implémentation.
     * 
     * @param args les arguments de la ligne de commande (non utilisés ici)
     * @throws IOException si une erreur d'IO survient lors de la lecture du fichier
     */
	public static void main(String args[]) throws IOException {
		// Mesure du temps d'exécution pour HashMultiSet
		Chrono chrono1 = new Chrono();
		wordcount(new MultiSetDecorator<>(new HashMultiSet<String>())); // Appelle wordcount avec HashMultiSet (MultiSetDecorator)
		System.out.println("Temps wordcount HMS : ");
		chrono1.stop(); // Arrête le chrono et affiche le temps écoulé
		
		 // Mesure du temps d'exécution pour NaiveMultiSet
		Chrono chrono2 = new Chrono();
		wordcount(new MultiSetDecorator<>(new NaiveMultiSet<String>())); // Appelle wordcount avec NaiveMultiSet (MultiSetDecorator)
		System.out.println("\nTemps wordcount NMS :");
		chrono2.stop(); // Arrête le chrono et affiche le temps écoulé
	}
}
