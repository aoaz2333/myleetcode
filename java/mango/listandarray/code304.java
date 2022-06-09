package mango.listandarray;

/**
 * code304
 * 给定一个二维矩阵 matrix，以下类型的多个请求
 * 1.计算其子矩阵内元素总和，改子矩阵的左上角为(row1, col1)，右下角为(row2, col2)
 * 实现 NumMatrix 类:
 * 1.NumMatrix(int[][] matrix) 给定整数矩阵 matrix 进行初始化
 * 2.int sumRegion(int row1, int col1, int row2, int col2) 返回 左上角 (row1, col1) 、右下角 (row2, col2) 所描述的子矩阵的元素 总和 。
 *
 *
 * 要点: 理清思路，在生成前缀和数组的时候，和生成前缀和结果的时候，使用的是同一个算法，左边 + 上边 - 左上
 */
public class code304 {
    private final int[][] preSum;

    public code304(int[][] matrix) {
        int colCount = matrix.length;
        int rowCount = matrix[0].length;

        preSum = new int[colCount + 1][rowCount + 1];

        for (int x = 1; x <= colCount; x++) {
            for (int y = 1; y <= rowCount; y++) {
                preSum[x][y] = matrix[x - 1][y - 1] + preSum[x][y - 1] + preSum[x - 1][y] - preSum[x - 1][y - 1];
            }
        }

    }

    public int sumRegion(int x1, int y1, int x2, int y2) {
        return preSum[x2 + 1][y2 + 1] - preSum[x2 + 1][y1] - preSum[x1][y2 + 1] + preSum[x1][y1];
    }
}
