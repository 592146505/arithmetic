package com.roamer.arithmetic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 8皇后算法
 *
 * @author roamer
 * @version V1.0
 * @date 2018/11/10 0:25
 */
public class Queen8 {

    /**
     * 棋盘格子的范围，以及皇后的数量
     */
    private static final int MAX_NUM = 4;

    /**
     * 棋盘8*8
     */
    private boolean[][] chessBoard = new boolean[MAX_NUM][MAX_NUM];

    /**
     * 所有摆放方式
     */
    private final List<boolean[][]> chessBoards = new ArrayList<>();

    /**
     * 检查坐标，判断是否可以放置
     *
     * @param x 列
     * @param y 行
     * @return
     */
    private boolean check(int x, int y) {
        // 循环y-n行
        for (int i = 0; i < MAX_NUM; i++) {
            // 纵列
            if (chessBoard[x][i]) {
                return false;
            }
            // 左上斜
            if (x - 1 - i >= 0 && y - 1 - i >= 0 && chessBoard[x - 1 - i][y - 1 - i]) {
                return false;
            }
            // 右上斜
            if (x + 1 + i < MAX_NUM && y - 1 - i >= 0 && chessBoard[x + 1 + i][y - 1 - i]) {
                return false;
            }
            // 左下斜
            if (x - 1 - i >= 0 && y + 1 + i < MAX_NUM && chessBoard[x - 1 - i][y + 1 + i]) {
                return false;
            }
            // 右下斜
            if (x + 1 + i < MAX_NUM && y + 1 + i < MAX_NUM && chessBoard[x + 1 + i][y + 1 + i]) {
                return false;
            }
        }
        return true;
    }

    public boolean settleQueenAll() {
        for (int y = 0; y < MAX_NUM; y++) {
            // 设置偏移量
            int s = y;
            for (int x = 0; x < MAX_NUM; x++) {
                chessBoard = new boolean[MAX_NUM][MAX_NUM];
                // 成功则放入集合
                if (settleQueen(x, y, s, true)) {
                    chessBoards.add(chessBoard);
                }
            }
        }
        return !chessBoards.isEmpty();
    }

    /**
     * 递归回溯
     *
     * @param x    列
     * @param y    行
     * @param s    偏移量
     * @param flag 首行标识
     * @return
     */
    public boolean settleQueen(int x, int y, int s, boolean flag) {
        // 有偏移时，等于max时，要换首行
        y = s != 0 ? (y == MAX_NUM ? 0 : y) : y;
        // 无偏移量时，溢出即满足
        if (s == 0 && y == MAX_NUM) {
            return true;
        }
        // 有偏移量时，到达偏移量即满足
        if (!flag && s != 0 && y == s) {
            return true;
        }
        // 非首行的需要清零，从行首开始
        for (x = (y != s && !flag ? 0 : x); x < MAX_NUM; x++) {
            // 清空当前行
            clearRow(y);
            // 检查当前坐标是否可放置
            if (check(x, y)) {
                chessBoard[x][y] = true;
                // 递归下一行进行放置
                if (settleQueen(x, y + 1, s, (flag && y == s))) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 打印所有组合方式
     *
     * @return
     */
    public String printChessBoards() {
        StringBuffer sb = new StringBuffer();
        System.out.println(chessBoards.size());
        chessBoards.stream().forEach(action -> {
            for (int x = 0; x < MAX_NUM; x++) {
                for (int y = 0; y < MAX_NUM; y++) {
                    sb.append(action[y][x] ? "1" : "0");
                }
                sb.append(System.getProperty("line.separator"));
            }
            sb.append(System.getProperty("line.separator"));
        });
        return sb.toString();
    }

    /**
     * 递归回溯
     *
     * @param y 行
     * @return
     */
    public boolean settleQueen(int y) {
        // 超出最大行，说明已经满足
        if (y == MAX_NUM) {
            return true;
        }
        for (int x = 0; x < MAX_NUM; x++) {
            // 清空当前行
            clearRow(y);

            // 检查当前坐标是否可放置
            if (check(x, y)) {
                chessBoard[x][y] = true;
                // 递归下一行进行放置
                if (settleQueen(y + 1)) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 清空当前行
     *
     * @param y 行
     */
    private void clearRow(int y) {
        for (int x = 0; x < MAX_NUM; x++) {
            chessBoard[x][y] = false;
        }
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        for (int x = 0; x < MAX_NUM; x++) {
            for (int y = 0; y < MAX_NUM; y++) {
                sb.append(chessBoard[y][x] ? "1" : "0");
            }
            sb.append(System.getProperty("line.separator"));
        }
        return sb.toString();
    }
}
