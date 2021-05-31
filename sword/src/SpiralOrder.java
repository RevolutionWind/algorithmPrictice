import java.util.ArrayList;
import java.util.Arrays;

/**
 * 剑指 Offer 29. 顺时针打印矩阵
 * <p>
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。
 * <p>
 * 示例 1：
 * 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * 输出：[1,2,3,6,9,8,7,4,5]
 * <p>
 * 示例 2：
 * 输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
 * 输出：[1,2,3,4,8,12,11,10,9,5,6,7]
 *
 * @author sunxy
 * @date 2021/5/30 11:34
 */
@SuppressWarnings("unused")
public class SpiralOrder {

    /*
        模拟
     */
    public int[] spiralOrder(int[][] matrix) {
        // 边界
        if (matrix == null || matrix.length < 1 || matrix[0].length < 1) {
            return new int[]{};
        }
        int rowLen = matrix.length, colLen = matrix[0].length;
        // 遍历过的元素
        boolean[][] seen = new boolean[rowLen][colLen];
        int total = rowLen * colLen;
        int[] res = new int[total];
        // 方向
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int directIdx = 0, row = 0, col = 0;
        for (int i = 0; i < total; i++) {
            res[i] = matrix[row][col];
            seen[row][col] = true;
            int nextRow = row + directions[directIdx][0], nextCol = col + directions[directIdx][1];
            if (nextRow < 0 || nextRow >= rowLen || nextCol < 0 || nextCol >= colLen || seen[row][col]) {
                directIdx = (directIdx + 1) % 4;
            }
            row += directions[directIdx][0];
            col += directions[directIdx][1];
        }
        ArrayList<?> list = new ArrayList<>();
        list.toArray();
        return res;
    }

    /*
        按层模拟
     */
    public int[] spiralOrder1(int[][] matrix) {
        // 边界
        if (matrix == null || matrix.length < 1 || matrix[0].length < 1) {
            return new int[]{};
        }
        int rowLen = matrix.length, colLen = matrix[0].length;
        int[] res = new int[rowLen * colLen];
        int idx = 0;
        int left = 0, right = colLen - 1, top = 0, bottom = rowLen - 1;
        while (left <= right && top <= bottom) {
            // 左到右
            for (int col = left; col <= right; col++) {
                res[idx++] = matrix[top][col];
            }
            // 上到下
            for (int row = top + 1; row <= bottom; row++) {
                res[idx++] = matrix[row][bottom];
            }
            if (left < right && top < bottom) {
                // 右到左
                for (int col = right - 1; col > left; col--) {
                    res[idx++] = matrix[bottom][col];
                }
                // 下到上
                for (int row = bottom; row > top; row--) {
                    res[idx++] = matrix[row][left];
                }
            }
            left++;
            right--;
            top++;
            bottom--;
        }
        return res;
    }

    public static void main(String[] args) {
        SpiralOrder s = new SpiralOrder();
        int[] res = s.spiralOrder1(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}});
        System.out.println(Arrays.toString(res));

    }

}
