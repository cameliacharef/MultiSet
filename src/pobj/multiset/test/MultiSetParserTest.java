package pobj.multiset.test;

import pobj.multiset.InvalidMultiSetFormat;
import pobj.multiset.MultiSet;
import pobj.multiset.MultiSetParser;

public class MultiSetParserTest {
	public static void main (String[] args) {
		String fichier1 = "data/parse.txt";
		String fichier2 = "data/parse2.txt";
		String fichier3 = "data/parse3.txt";
		String fichier4 = "data/parse4.txt";
		String fichier5 = "data/parse5.txt";
		
		try {
			MultiSet<String> multiSet1 = MultiSetParser.parse(fichier1);
			System.out.println(multiSet1);
		}
		catch(InvalidMultiSetFormat e) {
			System.out.println(e.getMessage());
		}
		try {
			MultiSet<String> multiSet2 = MultiSetParser.parse(fichier2);
			System.out.println(multiSet2);
		}
		catch(InvalidMultiSetFormat e) {
				System.out.println(e.getMessage());
		}
		try {
			MultiSet<String> multiSet3 = MultiSetParser.parse(fichier3);
			System.out.println(multiSet3);
		}
		catch(InvalidMultiSetFormat e) {
			System.out.println(e.getMessage());
		}
		try {
			MultiSet<String> multiSet4 = MultiSetParser.parse(fichier4);
			System.out.println(multiSet4);
		}
		catch(InvalidMultiSetFormat e) {
			System.out.println(e.getMessage());
		}
		try {
			MultiSet<String> multiSet5 = MultiSetParser.parse(fichier5);
			System.out.println(multiSet5);
		}
		catch(InvalidMultiSetFormat e) {
			System.out.println(e.getMessage());
			
		}
		
	}
}
