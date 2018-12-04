package com.roamer.arithmetic;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BigNumberAddTest {

    @Test
    public void add() {
        String result = BigNumberAdd.add("123456", "12345");
        assertEquals(result, "135801");
    }
}