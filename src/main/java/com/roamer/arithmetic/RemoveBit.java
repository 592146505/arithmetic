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
        if (k == numberStr.length()) {
            return "0";
        }
        if (k > numberStr.length()) {
            throw new IllegalArgumentException("The length of the deletion cannot be greater than the character length");
        }
        // 新字符长度
        int newLength = numberStr.length() - k;
        char[] stack = new char[numberStr.length()];
        int top = 0;
        // 删除
        for (int i = 0, j = numberStr.length(); i < j; i++) {
            char c = numberStr.charAt(i);
            // 栈顶元素比当前元素大，则弹出
            while (top > 0 && stack[top - 1] > c && k > 0) {
                top--;
                k--;
            }
            stack[top++] = c;
        }
        // 偏移量，从非0处开始
        int offset = 0;
        while (offset < newLength && stack[offset] == '0') {
            offset++;
        }
        return offset == newLength ? "0" : new String(stack, offset, newLength - offset);
    }

}
