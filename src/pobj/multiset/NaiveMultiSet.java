package pobj.multiset;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 * La classe NaiveMultiSet représente une collection qui permet de stocker des éléments avec
 * des occurrences multiples. Elle utilise une liste pour gérer les éléments.
 * 
 * @param <T> Le type des éléments du MultiSet
 */
public class NaiveMultiSet<T> implements MultiSet<T>{
	private List<T> liste = new ArrayList<T>(); // Liste pour stocker les éléments
	
	/**
     * Vérifie si le MultiSet est vide.
     * 
     * @return true si le MultiSet est vide, false sinon
     */
	@Override
	public boolean isEmpty() {
		return liste.isEmpty();
	}
	
	/**
     * Vérifie si un élément est présent dans le MultiSet.
     * @param o L'élément à rechercher
     * @return true si l'élément est présent, false sinon
     */
	@Override
	public boolean contains(Object o) {
		return liste.contains(o);
	}
	
	/**
     * Renvoie un itérateur sur les éléments du MultiSet.
     * @return Un itérateur sur la liste des éléments
     */
	@Override
	public Iterator<T> iterator() {
		return liste.iterator();
	}
	
	/**
     * Renvoie un tableau contenant tous les éléments du MultiSet.
     * @return Un tableau d'objets contenant les éléments
     */
	@Override
	public Object[] toArray() {
		return liste.toArray();
	}
	
	/**
     * Renvoie un tableau contenant tous les éléments du MultiSet, en utilisant le tableau spécifié
     * si possible.
     * @param a Le tableau dans lequel les éléments seront stockés
     * @return Un tableau contenant les éléments du MultiSet
     */
	@SuppressWarnings("hiding")
	@Override
	public <T> T[] toArray(T[] a) {
		return liste.toArray(a);
	}
	
	 /**
     * Vérifie si tous les éléments d'une collection donnée sont présents dans le MultiSet.
     * @param c La collection d'éléments à vérifier
     * @return true si tous les éléments sont présents, false sinon
     */
	@Override
	public boolean containsAll(Collection<?> c) {
		return liste.containsAll(c);
	}
	
	/**
     * Ajoute tous les éléments d'une collection au MultiSet.
     * @param c La collection d'éléments à ajouter
     * @return true si le MultiSet a changé, false sinon
     */
	@Override
	public boolean addAll(Collection<? extends T> c) {
		return liste.addAll(c);
	}
	
	/**
     * Supprime tous les éléments d'une collection du MultiSet.
     * @param c La collection d'éléments à supprimer
     * @return true si le MultiSet a changé, false sinon
     */
	@Override
	public boolean removeAll(Collection<?> c) {
		return liste.removeAll(c);
	}
	
	/**
     * Conserve uniquement les éléments présents dans une collection donnée.
     * @param c La collection d'éléments à conserver
     * @return true si le MultiSet a changé, false sinon
     */
	@Override
	public boolean retainAll(Collection<?> c) {
		return liste.retainAll(c);
	}
	
	/**
     * Ajoute un élément avec un certain nombre d'occurrences au MultiSet.
     * @param e L'élément à ajouter
     * @param count Le nombre d'occurrences à ajouter
     * @return true si l'élément a été ajouté, false sinon
     */
	@Override
	public boolean add(T e, int count) {
		if (count <= 0) return false;  // Vérifie que le count est positif
		boolean res = false;
		for(int i = 0; i < count; i++)
			res = liste.add(e); // Ajoute l'élément count fois
		return res;
	}
	
	/**
     * Ajoute un élément au MultiSet.
     * 
     * @param e L'élément à ajouter
     * @return true si l'élément a été ajouté, false sinon
     */
	@Override
	public boolean add(T e) {
		return liste.add(e);
	}
	
	/**
     * Supprime un élément du MultiSet.
     * 
     * @param e L'élément à supprimer
     * @return true si l'élément a été supprimé, false sinon
     */
	@Override
	public boolean remove(Object e) {
		return liste.remove(e);
	}
	
	/**
     * Supprime un élément avec un certain nombre d'occurrences du MultiSet.
     * 
     * @param e L'élément à supprimer
     * @param count Le nombre d'occurrences à supprimer
     * @return true si l'élément a été supprimé, false sinon
     */
	@Override
	public boolean remove(Object e, int count) {
		if (count <= 0) return false; // Vérifie que le count est positif
		boolean res = false;
		for(int i = 0; i < count; i++)
			res = liste.remove(e); // Supprime l'élément count fois
		return res;
	}
	
	/**
     * Compte le nombre d'occurrences d'un élément dans le MultiSet.
     * 
     * @param o L'élément dont on veut connaître le nombre d'occurrences
     * @return Le nombre d'occurrences de l'élément
     */
	@Override
	public int count(T o) {
		return Collections.frequency(liste, o); // Utilise la méthode de fréquence de Collections
	}
	
	/**
     * Supprime tous les éléments du MultiSet.
     */
	@Override
	public void clear() {
		liste.clear();
	}
	
	/**
     * Renvoie le nombre total d'éléments dans le MultiSet.
     * @return Le nombre d'éléments
     */
	@Override
	public int size() {
		return liste.size();
	}
	
	 /**
     * Renvoie une liste des éléments uniques présents dans le MultiSet.
     * @return Une liste d'éléments uniques
     */
	@Override
	public List<T> elements() {
		List<T> res = new ArrayList<T>();
		for(T elem : liste)
			if(!res.contains(elem))
				res.add(elem); // Ajoute seulement les éléments uniques
		return res;
	}

}
