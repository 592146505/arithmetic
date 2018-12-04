package com.roamer.arithmetic;

import java.util.Arrays;

/**
 * 大数相加
 *
 * @author roamer
 * @version V1.0
 * @date 2018/11/22
 */
public class BigNumberAdd {

    public static String add(String number1, String number2) {
        // 获取最大数和最小数
        int[][] arrays = compare(disassemble(number1), disassemble(number2));
        int[] min = arrays[0];
        int[] max = arrays[1];
        int[] sum = new int[max.length + 1];
        // 进位标识
        int carry = 0;
        // 先循环小的数
        int i = 0;
        while (i < min.length) {
            int temp = min[i] + max[i] + carry;
            // 进位
            sum[i++] = temp > 9 ? temp - 10 : temp;
            carry = temp > 9 ? 1 : 0;
        }
        // 再循环大的数
        while (i < max.length) {
            int temp = max[i] + carry;
            sum[i++] = temp > 9 ? temp - 10 : temp;
            carry = temp > 9 ? 1 : 0;
        }
        // 最后一位无进位则截取
        if (carry == 0) {
            sum = Arrays.copyOf(sum, sum.length - 1);
        } else {
            sum[i] = carry;
        }
        StringBuffer bf = new StringBuffer();
        for (int j = sum.length - 1; j >= 0; j--) {
            bf.append(sum[j]);
        }
        return bf.toString();
    }

    /**
     * 获取最大数和最小数
     *
     * @param num1
     * @param num2
     * @return [[min], [max]]
     */
    private static int[][] compare(int[] num1, int[] num2) {
        int[][] arrays = new int[2][];
        if (num1.length > num2.length) {
            arrays[0] = num2;
            arrays[1] = num1;
        } else {
            arrays[0] = num1;
            arrays[1] = num2;
        }
        return arrays;
    }

    /**
     * 将number字符串转换为倒序的int类型数组
     *
     * @param numberStr "12345"
     * @return [5, 4, 3, 2, 1]
     */
    private static int[] disassemble(String numberStr) {
        char[] chars = numberStr.toCharArray();
        int[] numberArray = new int[chars.length];
        for (int i = 0, j = chars.length - 1; i < chars.length; i++) {
            numberArray[i] = chars[j - i] - '0';
        }
        return numberArray;
    }

}
