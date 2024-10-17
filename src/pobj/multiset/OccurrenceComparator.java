package pobj.multiset;

import java.util.Comparator;

/**
 * La classe OccurrenceComparator compare deux éléments d'un MultiSet en fonction de leurs occurrences.
 * @param <T> Le type des éléments comparés
 */
public class OccurrenceComparator<T> implements Comparator<T> {
	private MultiSet<T> multiSet; // Le MultiSet qui contient les éléments et leurs occurrences
	
	/**
     * Constructeur de OccurrenceComparator.
     * Initialise le MultiSet utilisé pour la comparaison.
     * 
     * @param ms Le MultiSet dont on veut comparer les éléments
     */
	public OccurrenceComparator(MultiSet<T> ms) {
        	// Vérifie si l'instance est de type HashMultiSet ou NaiveMultiSet et l'initialise en conséquence
			if(ms instanceof HashMultiSet)
				multiSet = ms;
			else
				multiSet = ms;
	}
	
	 /**
     * Compare deux éléments en fonction du nombre d'occurrences dans le MultiSet.
     * 
     * @param o1 Le premier élément à comparer
     * @param o2 Le second élément à comparer
     * @return 1 si o1 a plus d'occurrences que o2, -1 si o1 a moins d'occurrences que o2, 0 si leurs occurrences sont égales
     */
	@Override
	public int compare(T o1, T o2) {
		 // Récupère le nombre d'occurrences des deux éléments
		int c1 = multiSet.count(o1);
		int c2 = multiSet.count(o2);
		
		// Compare les occurrences des deux éléments
		return c1 > c2 ? 1 : c1 == c2 ? 0 : -1 ;
	}

}
