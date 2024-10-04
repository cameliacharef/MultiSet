package pobj.multiset.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import pobj.multiset.HashMultiSet;
import pobj.multiset.MultiSet;

public class HashMultiSetTest {
	
	private MultiSet<String> m;
	
	@BeforeEach
	public void before() {
		m = new HashMultiSet<>();
		m.add("a");
		m.add("a",5);
		m.add("b",3);
		//m.remove("b" ,0);
	}
	
	@Test 
	public void test1() {
		assertEquals(6, m.count("a"));
		//assertEquals(3, m.count("b"));
	}
}
