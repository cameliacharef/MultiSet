package pobj.multiset.test;

import pobj.multiset.InvalidMultiSetFormat;
import pobj.multiset.MultiSet;
import pobj.multiset.MultiSetParser;

public class MultiSetParserTest {
	public static void main (String[] args) {
		String fichier = "data/parse.txt";
		try {
			MultiSet<String> multiSet = MultiSetParser.parse(fichier);
			System.out.println(multiSet);
		}
		catch(InvalidMultiSetFormat e) {
			System.out.println(e.getMessage());
		}
		
	}
}
