package com.roamer.arithmetic;

import lombok.AllArgsConstructor;

import java.util.Arrays;

/**
 * 快速排序
 *
 * @author roamer
 * @version V1.0
 * @date 2018/12/25 14:59
 */
@AllArgsConstructor
public class QuickSort {

    public static final int MIN_LENGTH = 2;

    private int[] array;

    public void sort() {
        // 两个以下的直接返回
        if (array.length < MIN_LENGTH) {
            return;
        }
        sort(array, 0, array.length - 1);
    }

    private void sort(int[] array, int left, int right) {
        int i = left;
        int j = right;
        // 获取基准,这里取分区的第一个元素
        int pivot = array[i];
        // 下标重叠结束
        if (left >= right) {
            return;
        }
        // 根据基准，进行左右分区
        while (i != j) {
            // 右分区对比，对比到不大于等于为止，***不大于等于就是小于***
            while (i < j && array[j] >= pivot) {
                j--;
            }
            // 左分区对比，对比到不小于等于为止，***不小于等于就是大于***
            while (i < j && array[i] <= pivot) {
                i++;
            }
            // 调换位置
            if (i < j) {
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }
        array[left] = array[i];
        array[i] = pivot;
        // 左分区递归
        sort(array, left, i - 1);
        // 右分区递归
        sort(array, i + 1, right);
    }


    @Override
    public String toString() {
        return "QuickSort{" + "array=" + Arrays.toString(array) + '}';
    }
}
