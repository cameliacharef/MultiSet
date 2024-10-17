package pobj.multiset;

import java.util.*;

/**
 * Un HashMultiSet est une structure de données qui permet de stocker plusieurs occurrences d'éléments.
 * Il utilise une HashMap pour suivre le nombre d'occurrences (multiplicité) de chaque élément.
 * 
 * @param <T> le type des éléments dans cet ensemble multiset
 */
public class HashMultiSet<T> extends AbstractCollection<T> implements MultiSet<T> {
	private HashMap<T,Integer> map; // elem , nb occ
	private int size; // taille multi ensbl 
	
	/**
     * Constructeur par défaut. Initialise un multiset vide.
     */
	public HashMultiSet(){
		map = new HashMap<T,Integer>();
		size = 0;
	}
	
	 /**
     * Constructeur qui initialise le multiset avec les éléments d'une collection donnée.
     * @param collection la collection d'éléments à ajouter dans le multiset
     */
	public HashMultiSet(Collection<T> collection){
		this();
		for(T c : collection) {
			add(c);
		}
	}
	
	/**
     * Retourne le nombre d'occurrences d'un élément donné dans le multiset.
     * 
     * @param o l'élément dont on veut connaître le nombre d'occurrences
     * @return le nombre d'occurrences de l'élément, ou 0 s'il n'existe pas dans le multiset
     */
	public int count(T o) {
		return map.getOrDefault(o, 0);
	}
	
	/**
     * Ajoute un élément au multiset avec un nombre d'occurrences spécifié.
     * 
     * @param e l'élément à ajouter
     * @param count le nombre d'occurrences à ajouter
     * @return true si l'ajout a réussi, false si le nombre d'occurrences est inférieur à 1
     */
	public boolean add(T e, int count) throws IllegalArgumentException{
		if (count < 0) throw new IllegalArgumentException("count negatif");
 		if (count < 1) {
 			assert isConsistent();
			return false;
 		}
		
		int nb_occur = count(e); // Nombre actuel d'occurrences de l'élément
	
		map.put(e, nb_occur + count); // Met à jour le nombre d'occurrences
		
		size += count; // Met à jour la taille totale
		assert isConsistent();
		return true;
	}
	
	/**
     * Ajoute un élément avec une seule occurrence au multiset.
     * 
     * @param e l'élément à ajouter
     * @return true si l'ajout a réussi
     */
	public boolean add(T e) {
		return add(e, 1);
	}
	
	/**
     * Supprime une seule occurrence d'un élément du multiset.
     * 
     * @param e l'élément à supprimer
     * @return true si la suppression a réussi
     */
	public boolean remove(Object e) {
		return remove(e,1);
	}
	
	 /**
     * Supprime un nombre spécifié d'occurrences d'un élément du multiset.
     * Si le nombre à supprimer est supérieur aux occurrences présentes, toutes les occurrences sont supprimées.
     * 
     * @param e l'élément dont il faut supprimer les occurrences
     * @param count le nombre d'occurrences à supprimer
     * @return true si la suppression a réussi, false si l'élément n'est pas présent ou si le nombre est incorrect
     */
	@SuppressWarnings("unchecked") // Pour retirer les warning
	public boolean remove(Object e, int count) throws IllegalArgumentException {
		if (count < 0) throw new IllegalArgumentException("count negatif");
		if (count < 1 || !map.containsKey(e))
			return false;
		if(count((T) e) <= count) {
			size -= count((T) e);
			map.remove((T) e);
			assert isConsistent();
			return true;
		}

		else { 
			int nb_occur = count((T) e); // Nombre actuel d'occurrences de l'élément
			int new_count = count;
			
			if(nb_occur < count) {
				new_count = nb_occur;
			}
			map.put((T) e, nb_occur - new_count); // Met à jour le nombre d'occurrences restantes
			size -= new_count; // Ajuste la taille totale du multiset
			assert isConsistent();
			return true;
		}
	}
	
	/**
     * Vide complètement le multiset.
     */
	public void clear() {
		map.clear();
		size = 0;
	}
	
	 /**
     * Retourne la taille totale du multiset, c'est-à-dire le nombre total d'occurrences de tous les éléments.
     * @return la taille totale du multiset
     */
	public int size() {
		return size;
	}
	
	/**
     * Retourne un itérateur qui parcourt tous les éléments du multiset.
     * Chaque élément est retourné autant de fois qu'il apparaît dans le multiset.
     * @return un itérateur sur les éléments du multiset
     */
	@Override
	public Iterator<T> iterator(){
		return new HashMultiSetIterator();
	}
	
	 /**
     * Classe interne pour l'itérateur du HashMultiSet.
     */
	private class HashMultiSetIterator implements Iterator<T>{
		private Map.Entry<T,Integer> current; // Élément courant et son nombre d'occurrences
		private Iterator<Map.Entry<T,Integer>> iterator = map.entrySet().iterator();
		private int occur; // Nombre d'occurrences restantes pour l'élément courant
		
		
		@Override public boolean hasNext() {
			return occur > 0 || iterator.hasNext();  // Vérifie s'il reste des éléments à parcourir
		}
		@Override public T next() {
			if(!hasNext()) {
				throw new NoSuchElementException();
			}
			
			if(occur == 0) {
				current = iterator.next();
				occur = current.getValue(); // Initialise le nombre d'occurrences pour le prochain élément
			}

			occur--; // Diminue le nombre d'occurrences restant
			T elem = current.getKey();
			return elem;
			
		}
	}
	
	/**
     * Retourne une représentation sous forme de chaîne du multiset.
     * @return une chaîne décrivant chaque élément avec son nombre d'occurrences
     */
	@Override public String toString() {
		Iterator<Map.Entry<T, Integer>> iterator = map.entrySet().iterator();
		StringBuilder b = new StringBuilder();
		b.append("[");
		while (iterator.hasNext()) {
			Map.Entry<T, Integer> entry = iterator.next();
			b.append(entry.getKey() + ":" + entry.getValue()+"; ");
		}
		b.append("]");
		return b.toString();
		
	}
	
	/**
     * Supprime tous les éléments présents dans une collection donnée du multiset.
     * @param c la collection des éléments à supprimer
     * @return true si au moins un élément a été supprimé
     */
	@Override
	public boolean removeAll(Collection<?> c) {
	   boolean res = false; 
	   for(Object elem : c) { 
		   if(map.containsKey(elem)) {
			   remove(elem);
			   res = true;
		   }
	   }
	   return res;
	  
	}
	
	 /**
     * Ne conserve que les éléments présents dans une collection donnée.
     * Supprime tous les autres éléments du multiset.
     * 
     * @param c la collection des éléments à conserver
     * @return true si des éléments ont été supprimés
     */
	@Override
	public boolean retainAll(Collection<?> c) {
		boolean res = false;
	    Iterator<Map.Entry<T, Integer>> it = map.entrySet().iterator();
	    
	    while (it.hasNext()) {
	        Map.Entry<T, Integer> entry = it.next();
	        if (!c.contains(entry.getKey())) {
	            size -= entry.getValue(); // Ajuste la taille
	            it.remove(); // Retire complètement l'élément
	            res = true;
	        }
	    }
	    return res;
	}
	
	 /**
     * Retourne une liste contenant tous les éléments distincts du multiset (sans leurs occurrences).
     * @return une liste des éléments distincts
     */
	public List<T> elements(){
		List<T> res = new ArrayList<T>();
		for(T elem : map.keySet())
			res.add(elem);
		return res;
	}
	public boolean isConsistent() {
		int nbOccurences = 0;
		
		for(Integer count: map.values()) {
			if(count <= 0) {
				return false;
			}
			nbOccurences += count;
		}
		
		return nbOccurences == size;
	}


}
