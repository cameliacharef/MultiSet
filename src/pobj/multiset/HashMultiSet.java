package pobj.multiset;

import java.util.*;

public class HashMultiSet<T> implements MultiSet<T> {
	private HashMap<T,Integer> map; // elem , nb occ
	private int size; // taille multi ensbl 
	
	public HashMultiSet(){
		
	}
	public HashMultiSet(Collection<T> collection){
		
	}
	
	
	
	public boolean add(T e, int count) {}
	public boolean add(T e) {}
	public boolean remove(Object e) {}
	public boolean remove(Object e, int count) {}
	public int count(T o) {}
	public void clear() {}
	public int size() {}
}
