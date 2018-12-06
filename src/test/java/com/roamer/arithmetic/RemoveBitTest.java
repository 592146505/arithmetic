package com.roamer.arithmetic;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RemoveBitTest {

    @Test
    public void getMinNumber() {
        String number = RemoveBit.getMinNumber("1234543", 1);
        assertEquals("123443", number);
        String number1 = RemoveBit.getMinNumber("1212", 2);
        assertEquals("11", number1);
    }
}