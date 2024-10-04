package pobj.multiset;

import java.util.*;

public class HashMultiSet<T> implements MultiSet<T> {
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
	public boolean remove(Object e, int count) {
		if (count < 1 || !map.containsKey(e))
			return false;
		if(count((T) e) == 1 && count >= 1) {
			map.remove((T) e);
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
}
