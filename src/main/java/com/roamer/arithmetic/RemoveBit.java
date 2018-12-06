package com.roamer.arithmetic;

import com.sun.istack.internal.NotNull;

/**
 * 一个数字删除一位得到最小数
 *
 * @author roamer
 * @version V1.0
 * @date 2018/12/5
 */
public class RemoveBit {

    public static String getMinNumber(@NotNull String numberStr, int k) {
        if (k > numberStr.length()) {
            throw new IllegalArgumentException("The length of the deletion cannot be greater than the character length");
        }
        int[] num = convertToIntArray(numberStr);
        for (int i = 0, j = num.length - 1, x = 0; i < j - x && x < k; i++) {
            if (num[i] > num[i + 1] || num[i] == num[i + 1]) {
                // 删除
                int numMoved = j - i - x;
                System.arraycopy(num, i + 1, num, i, numMoved);
                i -= i > 0 ? 2 : 1;
                // 计数
                x++;
            }
        }
        // 变为新数组
        int[] newArray = new int[num.length - k];
        System.arraycopy(num, 0, newArray, 0, newArray.length);
        return convertToString(newArray);
    }

    /**
     * 将number字符串转换为int类型数组
     *
     * @param numberStr "12345"
     * @return [1, 2, 3, 4, 5]
     */
    private static int[] convertToIntArray(String numberStr) {
        char[] chars = numberStr.toCharArray();
        int[] numberArray = new int[chars.length];
        for (int i = 0, j = chars.length; i < j; i++) {
            numberArray[i] = chars[i] - '0';
        }
        return numberArray;
    }

    /**
     * 转换int[]为字符串
     *
     * @param num [1,2,3]
     * @return "123"
     */
    private static String convertToString(int[] num) {
        StringBuffer bf = new StringBuffer();
        for (int i = 0; i < num.length; i++) {
            bf.append(num[i]);
        }
        return bf.toString();
    }
}
