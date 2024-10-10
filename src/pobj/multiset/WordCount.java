package pobj.multiset;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import pobj.util.Chrono;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class WordCount {
	public static void wordcount(MultiSet<String> ms) throws IOException{
		String file = "data/WarAndPeace.txt"; 
		BufferedReader br = new BufferedReader(new FileReader(file));
		String line;
		List<String> liste = new ArrayList<String>();
		while ((line = br.readLine())!=null) { 
			for (String word : line.split("\\P{L}+")) { 
				if (word.equals("")) continue; // ignore les mots vides 
				// TODO: traitement à faire pour le mot word 
				ms.add(word);
			} 
			liste = ms.elements();
			Comparator<String> comparator = null;
			if(ms instanceof HashMultiSet<String>) {
				comparator = new OccurrenceComparator<String>((HashMultiSet<String>) ms);
			}
			else {
				comparator = new OccurrenceComparator<String>((NaiveMultiSet<String>) ms);
			}
			Collections.sort(liste, comparator);
		}
		br.close();
		for(int i = 0; i < 10; i++)
			System.out.println(i + " : " + liste.get(i));
		// System.out.println(ms);
	}
	public static void main(String args[]) throws IOException {
		Chrono chrono1 = new Chrono();
		wordcount(new HashMultiSet<String>());
		System.out.println("Temps wordcount HMS : ");
		chrono1.stop();
		Chrono chrono2 = new Chrono();
		wordcount(new NaiveMultiSet<String>());
		System.out.println("\nTemps wordcount NMS :");
		chrono2.stop();
	}
}
