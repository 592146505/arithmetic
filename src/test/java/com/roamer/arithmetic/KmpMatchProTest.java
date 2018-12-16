package com.roamer.arithmetic;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class KmpMatchProTest {

    @Test
    public void match() {
        String str = "wgserfsefsers";
        {
            int index = KmpMatchPro.match(str, "serss");
            assertEquals(-1, index);
        }
        {
            int index = KmpMatchPro.match(str, "serf");
            assertEquals(2, index);
        }
        {
            int index = KmpMatchPro.match(str, "sers");
            assertEquals(9, index);
        }
    }
}