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


    private int[][] cache;

    private int m;

    private int n;

    public Eggs(int m, int n) {
        this.m = m;
        this.n = n;
    }

    /**
     * 扔鸡蛋
     *
     * @return 最少的最大尝试次数
     */
    public int throwEggs() {
        init();
        // 小于2直接返回
        if (n < 2 || m < 2) {
            return cache[n][m];
        }

        for (int i = 2; i <= n; i++) {
            for (int j = 2; j <= m; j++) {
                for (int x = 1; x <= j; x++) {
                    // 自底而上
                    cache[i][j] = min(cache[i][j], max(cache[i][j - x] + 1, cache[i - 1][x - 1] + 1));
                }
            }
        }
        return cache[n][m];

    }

    /**
     * 初始化数据
     */
    private void init() {
        // 0层0鸡蛋为0
        this.cache = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                // m层最大尝试次数为m
                cache[i][j] = j;
            }
        }
    }

    public static void main(String[] args) {
        int count = new Eggs(500, 5).throwEggs();
        System.out.print(count);
    }

}
