package com.roamer.arithmetic;

import org.junit.Test;

import static org.junit.Assert.*;

public class Queen8Test {

    @Test
    public void settleQueen() {
        Queen8 queen8 = new Queen8();
        queen8.settleQueen(0);
        System.out.println(queen8);
        System.out.println(queen8.count);
    }
}