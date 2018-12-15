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

    private String longStr;
    private char[] ls;

    public KmpMatch(@NotNull String longStr) {
        this.longStr = longStr;
        this.ls = longStr.toCharArray();
    }

    public void match(String str) {
        if (null == str || longStr.length() < str.length()) {
            System.out.println("子字符串长度必须<=父字符串长度");
            return;
        }
        char[] ms = str.toCharArray();
        int start = 0;
        int end;
        for (int i = 0; i < ls.length; i++) {
            end = -1;
            for (int j = 0; j < ms.length && i + j < ls.length; j++) {
                // 不匹配跳出内层循环
                if (ms[j] != ls[i + j]) {
                    break;
                }
                // 相等，则标记开始和结束下标
                if (ms[j] == ls[i + j]) {
                    if (j == 0) {
                        start = i;
                    }
                    if (j == ms.length - 1) {
                        end = i + j;
                        System.out.printf("%d:%d", start, end);
                        return;
                    }
                }
            }
        }
        System.out.println("未找到");
    }

    public static void main(String[] args) {
        KmpMatch kmpMatch = new KmpMatch("asdffewasc");
        kmpMatch.match("asc");
    }
}
