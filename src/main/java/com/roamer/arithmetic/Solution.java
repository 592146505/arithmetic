package com.roamer.arithmetic;

/**
 * 不使用+ -进行加法运算
 *
 * @author roamer
 * @version V1.0
 * @date 2018/12/6
 */
public class Solution {

    public static int getSum(int a, int b) {
        // &为0说明无需进位
        if ((a & b) == 0) {
            return a | b;
        }
        // ^ 取原位，& << 取进位
        return getSum(a ^ b, (a & b) << 1);
    }
}
