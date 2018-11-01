package priv.zzy.explore.medium.c06;

import priv.zzy.Solution;

/**
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
 *
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
 *
 * 问总共有多少条不同的路径？
 */
public class C06T02 extends Solution {

    boolean rangeCheck(int m, int n, int x, int y) {
        return x >= 0 && x < m && y >= 0 && y <= n;
    }

    public int uniquePaths(int m, int n) {
        int[][] ways = new int[m][n];

        ways[0][0] = 1;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (rangeCheck(m, n, i - 1, j)) {
                    ways[i][j] += ways[i - 1][j];
                }
                if (rangeCheck(m, n, i, j - 1)) {
                    ways[i][j] += ways[i][j - 1];
                }
            }
        }


        return ways[m - 1][n - 1];
    }

    @Override
    public void run() {
        System.out.println(uniquePaths(7, 3));
        System.out.println("Right answer: 28");
    }
}
