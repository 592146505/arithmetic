package com.roamer.arithmetic;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class LRUCacheTest {

    LRUCache<String, Integer> cache;


    @Before
    public void setUp() throws Exception {
        cache = new LRUCache<>(5);
        cache.put("A", 1);
        cache.put("B", 2);
        cache.put("C", 3);
        cache.put("D", 4);
        cache.put("E", 5);
    }

    @After
    public void tearDown() throws Exception {
        cache = null;
    }

    @Test
    public void get() {
        Integer num = cache.get("C");
        assertEquals(num.intValue(), 3);
        num = cache.get("F");
        assertEquals(num, null);
    }

    @Test
    public void put() {
        cache.put("A", 2);
        cache.print();
    }

    @Test
    public void remove() {
        String key = cache.remove("A");
        assertEquals("A", key);
        key = cache.remove("A");
        assertEquals(null, key);
    }
}