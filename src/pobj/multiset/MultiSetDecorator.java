package pobj.multiset;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/**
 * Classe qui permet de vérifier la cohérence des MultiSet avec des assertations
 * @param <T>
 */

public class MultiSetDecorator<T> implements MultiSet<T> {
	/** Le MultiSet décoré */
	private MultiSet<T> decorated;
	
	/**
	 * Instancie un décorateur
	 * @param decorated
	 */
	public MultiSetDecorator(MultiSet<T> decorated) {
		this.decorated = decorated;
	}
	/**
	 * Teste si le MultiSet est Vide
	 * @return true si vide, flase sinon
	 */
	@Override
	public boolean isEmpty() {
		return decorated.isEmpty();
	}
	
	/**
	 * @return true si o est dans le MultiSet, false sinon
	 */
	@Override
	public boolean contains(Object o) {
		return decorated.contains(o);
	}
	
	/**
	 * @return un itérateur sur le MultiSet
	 */
	@Override
	public Iterator<T> iterator() {
		return decorated.iterator();
	}

	/**
	 * @return le MultiSet sous forme de liste d'objets
	 */
	@Override
	public Object[] toArray() {
		return decorated.toArray();
	}

	/**
	 * @return le MultiSet sous forme de liste de T objets
	 */
	@Override
	public <T> T[] toArray(T[] a) {
		return decorated.toArray(a);
	}

	/**
	 * @return true si tous les éléments de c sont dans le Multiset, false sinon
	 */
	@Override
	public boolean containsAll(Collection<?> c) {
		return decorated.contains(c);
	}
	
	/**
	 * @return true si au moins uné élément de c est ajouté dans le MultiSet, false sinon
	 */

	@Override
	public boolean addAll(Collection<? extends T> c) {
		return decorated.addAll(c);
	}

	/**
	 * @return true si au moins uné élément de c est retiré du le MultiSet, false sinon
	 */
	@Override
	public boolean removeAll(Collection<?> c) {
		return decorated.removeAll(c);
	}

	/**
	 * @return true si l'intersection de c et le MultiSet est non-vide, false sinon
	 */
	@Override
	public boolean retainAll(Collection<?> c) {
		return decorated.retainAll(c);
	}

	/**
	 * @return true si l'élément est ajouté au moins une fois dans le MultiSet, false sinon
	 */
	@Override
	public boolean add(T e, int count) {
		try{
			assert decorated.isConsistent();
			return decorated.add(e,count);
		
		}
		catch(Exception ex) {
			throw new RuntimeException("InternalError");
		}
	}
	/**
	 * @return true si l'élément e est ajouté dans le MultiSet, false sinon
	 */
	@Override
	public boolean add(T e) {
		return decorated.add(e, 1);
	}

	/**
	 * @return true si l'élément e est retiré du MultiSet, false sinon
	 */
	@Override
	public boolean remove(Object e) {
		return remove(e, 1);
	}

	/**
	 * @return true si l'élément est retiré au moins une fois dans le MultiSet, false sinon
	 */
	@Override
	public boolean remove(Object e, int count) {
		try{
			assert decorated.isConsistent();
			return decorated.remove(e,count);
		
		}
		catch(Exception ex) {
			throw new RuntimeException("InternalError");
		}
	}
	
	/**
	 * @return le nombre d'occurrences de o dans le MultiSet
	 */
	@Override
	public int count(T o) {
		return decorated.count(o);
	}
	
	/**
	 * Vide le MultiSet
	 */

	@Override
	public void clear() {
		decorated.clear();
	}

	/**
	 * @return la taille totale du MultiSet
	 */
	@Override
	public int size() {
		return decorated.size();
	}
	
	/**
	 * @return la liste de chaque élément, comptabilisé une seule fois
	 */
	@Override
	public List<T> elements() {
		return decorated.elements();
	}

	/**
	 * @return true si le MultiSet est cohérent, false sinon
	 */
	@Override
	public boolean isConsistent() {
		return decorated.isConsistent();
	}
	
	/**
	 * @return l'affiche du MultiSet
	 */
	@Override
	public String toString() {
		return decorated.toString();
	}

}
