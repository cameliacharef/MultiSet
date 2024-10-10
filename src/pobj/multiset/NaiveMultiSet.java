package pobj.multiset;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class NaiveMultiSet<T> implements MultiSet<T>{
	private List<T> liste = new ArrayList<T>();
	@Override
	public boolean isEmpty() {
		return liste.isEmpty();
	}

	@Override
	public boolean contains(Object o) {
		return liste.contains(o);
	}

	@Override
	public Iterator<T> iterator() {
		return liste.iterator();
	}

	@Override
	public Object[] toArray() {
		return liste.toArray();
	}

	@SuppressWarnings("hiding")
	@Override
	public <T> T[] toArray(T[] a) {
		return liste.toArray(a);
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		return liste.containsAll(c);
	}

	@Override
	public boolean addAll(Collection<? extends T> c) {
		return liste.addAll(c);
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		return liste.removeAll(c);
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		return liste.retainAll(c);
	}

	@Override
	public boolean add(T e, int count) {
		if (count <= 0) return false; 
		boolean res = false;
		for(int i = 0; i < count; i++)
			res = liste.add(e);
		return res;
	}

	@Override
	public boolean add(T e) {
		return liste.add(e);
	}

	@Override
	public boolean remove(Object e) {
		return liste.remove(e);
	}

	@Override
	public boolean remove(Object e, int count) {
		if (count <= 0) return false; 
		boolean res = false;
		for(int i = 0; i < count; i++)
			res = liste.remove(e);
		return res;
	}

	@Override
	public int count(T o) {
		return Collections.frequency(liste, o);
	}

	@Override
	public void clear() {
		liste.clear();
	}

	@Override
	public int size() {
		return liste.size();
	}

	@Override
	public List<T> elements() {
		List<T> res = new ArrayList<T>();
		for(T elem : liste)
			if(!res.contains(elem))
				res.add(elem);
		return res;
	}

}
