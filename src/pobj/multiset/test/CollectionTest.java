package pobj.multiset.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import pobj.multiset.HashMultiSet;

public class CollectionTest {

    private HashMultiSet<String> multiSet ;

    @BeforeEach
    public void setup() {
        multiSet = new HashMultiSet<>();
    }

    @Test
    public void testImplementsCollection() {
        assertTrue(multiSet instanceof Collection);
    }

    @Test
    public void testAddSingleElement() {
        assertTrue(multiSet.add("a"));
        assertEquals(1, multiSet.size());
        assertEquals(1, multiSet.count("a"));
    }

    @Test
    public void testAddMultipleOccurrences() {
        assertTrue(multiSet.add("a", 3));
        assertEquals(3, multiSet.count("a"));
        assertEquals(3, multiSet.size());
    }

    @Test
    public void testRemoveSingleElement() {
        multiSet.add("a");
        assertTrue(multiSet.remove("a"));
        assertEquals(0, multiSet.count("a"));
        assertEquals(0, multiSet.size());
        // System.out.println("AAA : " + multiSet);
    }

    @Test
    public void testRemoveMultipleOccurrences() {
        multiSet.add("a", 3);
        assertTrue(multiSet.remove("a", 2));
        assertEquals(1, multiSet.count("a"));
        assertEquals(1, multiSet.size());
    }

    @Test
    public void testRemoveNonExistentElement() {
        assertFalse(multiSet.remove("non-existent"));
        assertEquals(0, multiSet.size());
    }

    @Test
    public void testContainsElement() {
        multiSet.add("a");
        assertTrue(multiSet.contains("a"));
        assertFalse(multiSet.contains("b"));
    }

    @Test
    public void testIsEmpty() {
        assertTrue(multiSet.isEmpty());
        multiSet.add("a");
        assertFalse(multiSet.isEmpty());
    }

    @Test
    public void testClear() {
        multiSet.add("a", 3);
        multiSet.add("b", 2);
        assertEquals(5, multiSet.size());
        multiSet.clear();
        assertEquals(0, multiSet.size());
        assertTrue(multiSet.isEmpty());
    }

    @Test
    public void testAddAll() {
        List<String> elements = new ArrayList<>();
        elements.add("a");
        elements.add("b");
        elements.add("c");elements.add("a");

        multiSet.addAll(elements);
        assertEquals(4, multiSet.size());
        assertTrue(multiSet.contains("a"));
        assertTrue(multiSet.contains("b"));
        assertTrue(multiSet.contains("c"));
    }

    @Test
    public void testContainsAll() {
        multiSet.add("a");
        multiSet.add("b");
        multiSet.add("a");

        List<String> elements = new ArrayList<>();
        elements.add("a");
        elements.add("b");
        elements.add("a");

        assertTrue(multiSet.containsAll(elements));

        elements.add("c");
        assertFalse(multiSet.containsAll(elements));
    }

    @Test
    public void testRemoveAll() {
        multiSet.add("a");
        multiSet.add("b");
        multiSet.add("c");

        List<String> elements = new ArrayList<>();
        elements.add("a");
        elements.add("b");

        multiSet.removeAll(elements);
        // System.out.println("AAA : " + multiSet);

        assertEquals(1, multiSet.size());
        assertFalse(multiSet.contains("a"));
        assertFalse(multiSet.contains("b"));
        assertTrue(multiSet.contains("c"));
    }

    @Test
    public void testRetainAll() {
        multiSet.add("a");
        multiSet.add("b");
        multiSet.add("c");

        List<String> elements = new ArrayList<>();
        elements.add("a");
        elements.add("b");

        multiSet.retainAll(elements);
        assertEquals(2, multiSet.size());
        assertTrue(multiSet.contains("a"));
        assertTrue(multiSet.contains("b"));
        assertFalse(multiSet.contains("c"));
    }

    @Test
    public void testToArray() {
        multiSet.add("a");
        multiSet.add("b");

        Object[] array = multiSet.toArray();
        assertEquals(2, array.length);
        assertTrue(array[0].equals("a") || array[0].equals("b"));
        assertTrue(array[1].equals("a") || array[1].equals("b"));
    }

    @Test
    public void testToArrayWithTypedArray() {
        multiSet.add("a");
        multiSet.add("b");

        String[] array = multiSet.toArray(new String[0]);
        assertEquals(2, array.length);
        assertTrue(array[0].equals("a") || array[0].equals("b"));
        assertTrue(array[1].equals("a") || array[1].equals("b"));
    }
}
