package com.roamer.arithmetic;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SolutionTest {

    @Test
    public void getSum() {
        assertEquals(12, Solution.getSum(5, 7));
    }
}