package priv.zzy.explore.medium.c01;

import priv.zzy.Solution;

/**
 * 给定一个 m x n 的矩阵，
 * 如果一个元素为 0，
 * 则将其所在行和列的所有元素都设为 0。
 *
 * 请使用原地算法
 *
 *
 * 进阶:
 *
 * 一个直接的解决方案是使用 O(mn) 的额外空间，但这并不是一个好的解决方案。
 * 一个简单的改进方案是使用 O(m + n) 的额外空间，但这仍然不是最好的解决方案。
 * 你能想出一个常数空间的解决方案吗？
 */
public class C01T02 extends Solution {

    /**
     * 简单的方案
     * 使用 O(m + n) 的额外空间
     * @param matrix
     */
    public void solution1(int[][] matrix) {
        boolean[] rowMark = new boolean[matrix.length];
        boolean[] columnMark = new boolean[matrix[0].length];

        // mark zero position
        for (int i = 0; i < matrix.length; ++i) {
            for (int j = 0; j < matrix[i].length; ++j) {
                if (matrix[i][j] == 0) {
                    rowMark[i] = true;
                    columnMark[j] = true;
                }
            }
        }

        for (int i = 0; i < rowMark.length; ++i) {
            if (rowMark[i]) {
                matrix[i] = new int[matrix[i].length];
            }
        }
        for (int i = 0; i < columnMark.length; ++i) {
            if (columnMark[i]) {
                for (int j = 0; j < matrix.length; ++j) {
                    matrix[j][i] = 0;
                }
            }
        }
    }

    public void setZeroes(int[][] matrix) {
        solution1(matrix);
    }

    @Override
    public void run() {
        int[][] matrix = {
                {0,1,2,0},
                {3,4,5,2},
                {1,3,1,5}
        };
        setZeroes(matrix);

        for (int i = 0; i < matrix.length; ++i) {
            for (int j = 0; j < matrix[i].length; ++j) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
