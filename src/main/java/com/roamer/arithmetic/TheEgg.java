package com.roamer.arithmetic;

import java.util.ArrayList;
import java.util.List;

/**
 * 丢鸡蛋问题
 *
 * @author roamer
 * @version V1.0
 * @date 2018/11/16 10:53
 */
public class TheEgg {

    /**
     * 最高层数
     */
    private static final int MAX_LAYER = 200;

    /**
     * 获取层数
     */
    public static List<Integer> getLayers() {
        final List<Integer> layers = new ArrayList<>();
        int layer = 0;
        int addLayer = 0;
        for (int i = 0; i < MAX_LAYER; i++) {
            // 找到第一次的层数
            if (addLayer == 0 && check(i)) {
                addLayer = i;
                i = 0;
            }
            // 可能性为0则中断
            if (addLayer - i > 0) {
                if (layer + (addLayer - i) < MAX_LAYER) {
                    layer += (addLayer - i);
                    layers.add(layer);
                } else {
                    layers.add(MAX_LAYER);
                    return layers;
                }
            }
        }
        return layers;
    }

    /**
     * 检查
     *
     * @param i
     * @return
     */
    private static boolean check(int i) {
        if (((i + 1) * i) / 2 >= MAX_LAYER) {
            return true;
        }
        return false;

    }

    /**
     * 打印
     */
    public static void printLayers() {
        getLayers().forEach(System.out::println);
    }

    public static void main(String[] args) {
        printLayers();

    }
}
