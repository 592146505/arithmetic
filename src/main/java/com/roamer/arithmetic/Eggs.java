package com.roamer.arithmetic;

import static java.lang.Math.*;

/**
 * 动态规划扔鸡蛋
 *
 * @author roamer
 * @version V1.0
 * @date 2018/11/17 21:20
 */
public class Eggs {

    /**
     * 扔鸡蛋
     *
     * @param m 楼层数
     * @param n 鸡蛋数
     * @param x 当前层
     * @return 最少次数
     */
    public static int throwEggs(int m, int n, int x) {
        // 鸡蛋数和楼层数不可以小于1
        if (m < 1 || n < 1) {
            return 0;
        }
        // 鸡蛋数为1只能逐层比较
        if (n == 1) {
            return m;
        }
        // TODO 有bug（当次数大于Integer.MAX_VALUE时）
        if (x < 1) {
            return Integer.MAX_VALUE;
        }
        // 计算当前层所需最大次数
        int count = max(min(m - x, n) + 1, min(x - 1, n - 1) + 1);
        System.out.println(String.format("x = %d,count = %d", x, count));

        // 进行下一层
        return min(count, throwEggs(m, n, --x));
    }

    public static void main(String[] args) {
        int count = throwEggs(3, 1, 3);
        System.out.print(count);
    }

}
