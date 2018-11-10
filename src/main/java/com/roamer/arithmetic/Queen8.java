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
    public static final int MAX_NUM = 8;

    /**
     * 棋盘8*8
     */
    private boolean[][] chessBoard;

    /**
     * 所有摆放方式
     */
    final List<boolean[][]> chessBoards = Collections.emptyList();

    /**
     * 检查坐标，判断是否可以放置
     *
     * @param x 列
     * @param y 行
     * @return
     */
    private boolean check(int x, int y) {
        // 循环y-n行
        for (int i = 0; i < y; i++) {
            // 纵列
            if (chessBoard[x][i]) {
                return false;
            }
            // 左斜
            if (x - 1 - i >= 0 && chessBoard[x - 1 - i][y - 1 - i]) {
                return false;
            }
            // 右斜
            if (x + 1 + i < MAX_NUM && chessBoard[x + 1 + i][y - 1 - i]) {
                return false;
            }
        }
        return true;
    }

    public boolean settleQueenAll() {
        for (int x = 0; x < MAX_NUM; x++) {
            chessBoard = new boolean[MAX_NUM][MAX_NUM];
            // 成功则放入集合
            if (settleQueen(x, 0)) {
                chessBoards.add(chessBoard);
            }
        }
        return chessBoards.isEmpty();
    }

    /**
     * 递归回溯
     *
     * @param x 列
     * @param y 行
     * @return
     */
    public boolean settleQueen(int x, int y) {
        // 超出最大行，说明已经满足
        if (y == MAX_NUM) {
            return true;
        }
        for (x = (y == 0) ? x : 0; x < MAX_NUM; x++) {
            // 清空当前行
            clearRow(y);
            // 检查当前坐标是否可放置
            if (check(x, y)) {
                chessBoard[x][y] = true;
                // 递归下一行进行放置
                if (settleQueen(x, y + 1)) {
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
