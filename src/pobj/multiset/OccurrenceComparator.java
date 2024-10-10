package pobj.multiset;

import java.util.Comparator;

public class OccurrenceComparator<T> implements Comparator<T> {
	private MultiSet<T> multiSet;
	
	public OccurrenceComparator(MultiSet<T> ms) {
			if(ms instanceof HashMultiSet)
				multiSet = (HashMultiSet<T>)ms;
			else
				multiSet = (NaiveMultiSet<T>)ms;
	}
	
	@Override
	public int compare(T o1, T o2) {
		int c1 = multiSet.count(o1);
		int c2 = multiSet.count(o2);
		return c1 > c2 ? 1 : c1 == c2 ? 0 : -1 ;
	}

}
