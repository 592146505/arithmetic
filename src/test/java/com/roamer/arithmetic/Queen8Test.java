package com.roamer.arithmetic;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class Queen8Test {

    @Test
    public void settleQueen() {
        Queen8 queen8 = new Queen8();
        if (queen8.settleQueen(0)) {
            System.out.println(queen8);
        } else {
            Assert.fail();
        }
    }

    @Test
    public void settleQueen2() {
        Queen8 queen8 = new Queen8();
        if (queen8.settleQueenAll()) {
            System.out.println(queen8.printChessBoards());
        } else {
            Assert.fail();
        }
    }


}