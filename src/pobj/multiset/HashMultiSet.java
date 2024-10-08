package pobj.multiset;

import java.util.*;

public class HashMultiSet<T> extends AbstractCollection<T> implements MultiSet<T> {
	private HashMap<T,Integer> map; // elem , nb occ
	private int size; // taille multi ensbl 
	
	public HashMultiSet(){
		map = new HashMap<T,Integer>();
		size = 0;
	}
	public HashMultiSet(Collection<T> collection){
		this();
		for(T c : collection) {
			add(c);
		}
	}
	
	
	public int count(T o) {
		return map.getOrDefault(o, 0);
	}
	public boolean add(T e, int count) {
		if (count < 1)
			return false;
		
		int nb_occur = count(e);
	
		map.put(e, nb_occur + count);
		
		size += count;
		return true;
	}
	
	
	public boolean add(T e) {
		return add(e, 1);
	}
	public boolean remove(Object e) {
		return remove(e,1);
	}
	// @SuppressWarnings("unchecked") // Pour retirer les warning
	public boolean remove(Object e, int count) {
		if (count < 1 || !map.containsKey(e))
			return false;
		if(count((T) e) == 1 && count >= 1) {
			map.remove((T) e);
			size--;
			return true;
		}
		
		else { 
			int nb_occur = count((T) e);
			int new_count = count;
			
			if(nb_occur < count) {
				new_count = nb_occur;
			}
			map.put((T) e, nb_occur - new_count);
			size -= new_count;
			return true;
		}
		
	}
	
	public void clear() {
		map.clear();
		size = 0;
	}
	
	public int size() {
		return size;
	}
	
	@Override
	public Iterator<T> iterator(){
		return new HashMultiSetIterator();
	}
	
	private class HashMultiSetIterator implements Iterator<T>{
		private Map.Entry<T,Integer> current; // elem , nb occ
		private Iterator<Map.Entry<T,Integer>> iterator = map.entrySet().iterator();
		private int occur;
		
		
		@Override public boolean hasNext() {
			return occur > 0 || iterator.hasNext(); //occ
		}
		@Override public T next() {
			if(!hasNext()) {
				throw new NoSuchElementException();
			}
			
			if(occur == 0) {
				current = iterator.next();
				occur = current.getValue();
			}

			occur--;
			T elem = current.getKey();
			return elem;
			
		}
	}
	
	@Override public String toString() {
		Iterator<Map.Entry<T, Integer>> iterator = map.entrySet().iterator();
		String s = "";
		while (iterator.hasNext()) {
			Map.Entry<T, Integer> entry = iterator.next();
			s+= entry.getKey() + ":" + entry.getValue()+"\n";
		}
		return s;
	}
	@Override
	public boolean removeAll(Collection<?> c) {
	   boolean res = false; 
	   //for(T elem : c) { // Faire avec  l'itérateur pour type -> ?
		   if(map.containsKey(elem)) {
			   map.remove(elem);
			   res = true;
		   }
	   }
	   return res;
	}
	
	@Override
	public boolean retainAll(Collection<?> c) {
		boolean res = false; 
		   for(T elem : c) {
			   if(map.containsKey(elem)) {
				   map.remove(elem);
				   res = true;
			   }
		   }
		   return res;
	}


}
