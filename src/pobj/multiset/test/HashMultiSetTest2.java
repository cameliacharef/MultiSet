package pobj.multiset.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import org.junit.jupiter.api.Test;

import pobj.multiset.*;

public class HashMultiSetTest2 {
	@Test
	public void testAdd1() {
		MultiSet<String> m = new HashMultiSet<>();
		m.add("a");
		m.add("a",5);
		assertEquals(m.count("a"), 6);
	}
	
	@Test
	public void testAdd2() {
		MultiSet<String> m = new HashMultiSet<>();
		m.add("a");
		assertThrows(IllegalArgumentException.class,
				() -> { m.add("a",-1); }
		);
	}
	
	@Test
	public void testremove1() {
		MultiSet<String> m = new HashMultiSet<>();
		m.add("b",5);
		m.remove("b",2);
		assertEquals(m.count("b"), 3);
	}
	
	@Test
	public void testremove2() {
		MultiSet<String> m = new HashMultiSet<>();
		m.add("b",2);
		m.add("b",2);
		assertThrows(IllegalArgumentException.class,
				() -> { m.remove("b",-1); }
		);
	}
	
	@Test
	public void testSize() {
		MultiSet<String> m = new HashMultiSet<>();
		m.add("b",5);
		assertEquals(m.size(), 5);
	}
	
	
	@Test
	public void testClear() {
		MultiSet<String> m = new HashMultiSet<>();
		m.add("b",5);

		m.clear();
		assertEquals(m.size(), 0);
	}
	
	@Test
	public void testToString() {
		MultiSet<String> m = new HashMultiSet<>();
		m.add("b",5);
		m.add("c",5);
		m.add("a",5);
		assertEquals(m.toString(), "[a:5; b:5; c:5; ]");
	}
	
	@Test
	public void testComplexSequence() {
	    MultiSet<String> m = new HashMultiSet<>();

	    // Adding different elements
	    m.add("x", 3);  // Add 3 of "x"
	    m.add("y", 5);  // Add 5 of "y"
	    m.add("z", 2);  // Add 2 of "z"
	    
	    // Check initial counts
	    assertEquals(m.count("x"), 3);
	    assertEquals(m.count("y"), 5);
	    assertEquals(m.count("z"), 2);

	    // Remove some elements
	    m.remove("x", 1); // Remove 1 of "x"
	    m.remove("y", 3); // Remove 3 of "y"
	    m.remove("z", 2); // Remove all of "z"

	    // Check counts after removal
	    assertEquals(m.count("x"), 2); // 3 - 1 = 2
	    assertEquals(m.count("y"), 2); // 5 - 3 = 2
	    assertEquals(m.count("z"), 0); // Removed all

	    // Add more of "y" and "x"
	    m.add("y", 4); // Add 4 more "y"
	    m.add("x", 5); // Add 5 more "x"

	    // Final checks
	    assertEquals(m.count("x"), 7); // 2 + 5 = 7
	    assertEquals(m.count("y"), 6); // 2 + 4 = 6
	}
	
	@Test
	public void testEdgeCases() {
	    MultiSet<String> m = new HashMultiSet<>();

	    
	    m.add("a", 0); 
	    assertEquals(m.count("a"), 0); 

	    m.remove("a", 0);
	    assertEquals(m.count("a"), 0);

	    
	    m.add("b", 5);
	    assertEquals(m.count("b"), 5); 
	    m.remove("b", 5); 
	    assertEquals(m.count("b"), 0); 

	    
	    assertEquals(m.count("c"), 0); 
	}

	
	
}
