package com.roamer.arithmetic;

import com.sun.istack.internal.NotNull;

/**
 * KMP算法
 *
 * @author roamer
 * @version V1.0
 * @date 2018/12/14
 */
public class KmpMatch {

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
        int i = 0, j = 0;
        while (i < tsArray.length && j < psArray.length) {
            // 匹配就比较下一个
            if (tsArray[i] == psArray[j]) {
                i++;
                j++;
            }
            // 不匹配，则i回退,j归零
            else {
                i = i - j + 1;
                j = 0;
            }
            // 子字符串到头则说明匹配完毕
            if (j == psArray.length) {
                return i - j;
            }
        }
        return -1;
    }

}
