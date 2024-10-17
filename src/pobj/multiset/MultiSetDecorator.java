package pobj.multiset;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class MultiSetDecorator<T> implements MultiSet<T> {
	private MultiSet<T> decorated;
	
	public MultiSetDecorator(MultiSet<T> decorated) {
		this.decorated = decorated;
	}

	@Override
	public boolean isEmpty() {
		return decorated.isEmpty();
	}

	@Override
	public boolean contains(Object o) {
		return decorated.contains(o);
	}

	@Override
	public Iterator<T> iterator() {
		return decorated.iterator();
	}

	@Override
	public Object[] toArray() {
		return decorated.toArray();
	}

	@Override
	public <T> T[] toArray(T[] a) {
		return decorated.toArray(a);
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		return decorated.contains(c);
	}

	@Override
	public boolean addAll(Collection<? extends T> c) {
		return decorated.addAll(c);
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		return decorated.removeAll(c);
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		return decorated.retainAll(c);
	}

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

	@Override
	public boolean add(T e) {
		return decorated.add(e, 1);
	}

	@Override
	public boolean remove(Object e) {
		return remove(e, 1);
	}

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

	@Override
	public int count(T o) {
		return decorated.count(o);
	}

	@Override
	public void clear() {
		decorated.clear();
	}

	@Override
	public int size() {
		return decorated.size();
	}

	@Override
	public List<T> elements() {
		return decorated.elements();
	}

	@Override
	public boolean isConsistent() {
		return decorated.isConsistent();
	}

}
