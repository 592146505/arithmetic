package com.roamer.arithmetic;

import org.junit.Test;

import static org.junit.Assert.*;

public class KmpMatchTest {

    @Test
    public void match() {
        String str = "wgserfsefsers";
        {
            int index = KmpMatch.match(str, "serss");
            assertEquals(-1, index);
        }
        {
            int index = KmpMatch.match(str, "serf");
            assertEquals(2, index);
        }
        {
            int index = KmpMatch.match(str, "sers");
            assertEquals(9, index);
        }
    }
}