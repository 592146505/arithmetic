package com.roamer.arithmetic;

import static java.lang.Math.max;
import static java.lang.Math.min;

/**
 * 扔鸡蛋问题（优化版本）
 *
 * @author roamer
 * @version V1.0
 * @date 2018/11/25 8:45
 */
public class EggsPro {


    /**
     * 层数
     */
    private int floorNum;

    /**
     * 鸡蛋数
     */
    private int eggNum;

    /**
     * 上一层备忘录
     */
    private int[] upperCache;

    /**
     * 当前层备忘录
     */
    private int[] currCache;

    public EggsPro(int floorNum, int eggNum) {
        this.floorNum = floorNum;
        this.eggNum = eggNum;
    }

    /**
     * 扔鸡蛋
     *
     * @return 最少的最大尝试次数
     */
    public int throwEggs() {
        init();

        for (int n = 2; n <= eggNum; n++) {
            // 每次只需要记录上一层的即可，利用上一层推导
            upperCache = currCache.clone();
            for (int i = 1; i <= floorNum; i++) {
                // 最大尝试次数为
                currCache[i] = i;
            }

            for (int m = 2; m <= floorNum; m++) {
                for (int x = 1; x <= m; x++) {
                    // 自底而上
                    currCache[m] = min(currCache[m], max(currCache[x - 1] + 1, upperCache[m - x] + 1));
                    System.out.println(String.format("eggNum = %d, floorNum = %d, x = %d, count = %d", n, m, x, currCache[m]));
                }
                System.out.println();
            }
        }
        return currCache[floorNum];

    }

    /**
     * 初始化数据
     */
    private void init() {
        upperCache = null;
        // 0层0鸡蛋为0
        this.currCache = new int[floorNum + 1];
        for (int i = 1; i <= floorNum; i++) {
            // 每层最大尝试次数
            currCache[i] = i;
        }
    }

    public static void main(String[] args) {
        int count = new EggsPro(10, 2).throwEggs();
        System.out.print(count);
    }

}
