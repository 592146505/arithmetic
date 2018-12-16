package com.roamer.arithmetic;

import com.sun.istack.internal.NotNull;

/**
 * KMP进阶算法
 *
 * @author roamer
 * @version V1.0
 * @date 2018/12/16 9:33
 */
public class KmpMatchPro {


    /**
     * 匹配子字符串
     *
     * @param ts 主字符串
     * @param ps 子字符串
     * @return 主字符串中匹配到的第一个字符下标
     */
    public static int match(@NotNull String ts, @NotNull String ps) {
        if (ts.length() < ps.length()) {
            return -1;
        }
        char[] tsArray = ts.toCharArray();
        char[] psArray = ps.toCharArray();
        int next[] = getNext(psArray);
        int i = 0, j = 0;
        while (i < tsArray.length && j < psArray.length) {
            // 匹配就比较下一个
            if (j == -1 || tsArray[i] == psArray[j]) {
                i++;
                j++;
            }
            // 不匹配，则取j下标
            else {
                j = next[j];
            }
            // 子字符串到头则说明匹配完毕
            if (j == psArray.length) {
                return i - j;
            }
        }
        return -1;
    }


    private static int[] getNext(char[] psArray) {

        int[] next = new int[psArray.length];

        next[0] = -1;

        int j = 0;

        int k = -1;

        while (j < psArray.length - 1) {

            if (k == -1 || psArray[j] == psArray[k]) {
                if (next[++j] == next[++k]) {
                    next[j] = next[k];
                } else {
                    next[j] = k;
                }
            } else {

                k = next[k];

            }

        }

        return next;

    }

}
