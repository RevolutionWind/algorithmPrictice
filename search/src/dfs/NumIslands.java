package dfs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 200. 岛屿数量
 * <p>
 * 给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
 * 岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。
 * 此外，你可以假设该网格的四条边均被水包围。
 * <p>
 * 示例 1：
 * <p>
 * 输入：grid = [
 * ["1","1","1","1","0"],
 * ["1","1","0","1","0"],
 * ["1","1","0","0","0"],
 * ["0","0","0","0","0"]
 * ]
 * 输出：1
 * <p>
 * 示例 2：
 * <p>
 * 输入：grid = [
 * ["1","1","0","0","0"],
 * ["1","1","0","0","0"],
 * ["0","0","1","0","0"],
 * ["0","0","0","1","1"]
 * ]
 * 输出：3
 *
 * @author sunxy
 * @date 2020/12/6 11:41
 */
@SuppressWarnings("unused")
public class NumIslands {

    public int numIslands(char[][] grid) {
        int count = 0;
        int rowLen = grid.length;
        int colLen = grid[0].length;
        for (int i = 0; i < rowLen; i++) {
            for (int j = 0; j < colLen; j++) {
                if (grid[i][j] == '1') {
                    bfs(grid, i, j, rowLen, colLen);
                    count++;
                }
            }
        }
        return count;
    }

    /*
        广度优先遍历删除同岛屿的'1'
     */
    private void bfs(char[][] grid, int i, int j, int rowLen, int colLen) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{i, j});
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            i = cur[0];
            j = cur[1];
            if (i >= 0 && j >= 0 && i < rowLen && j < colLen && grid[i][j] == '1') {
                grid[i][j] = '0';
                queue.add(new int[]{i + 1, j});
                queue.add(new int[]{i - 1, j});
                queue.add(new int[]{i, j + 1});
                queue.add(new int[]{i, j - 1});
            }
        }
    }

    /*
        深度优先遍历删除同岛屿的'1'
     */
    private void dfs(char[][] grid, int i, int j, int rowLen, int colLen) {
        if (i < 0 || j < 0 || i >= rowLen || j >= colLen || grid[i][j] == '0') {
            return;
        }
        grid[i][j] = '0';
        dfs(grid, i + 1, j, rowLen, colLen);
        dfs(grid, i - 1, j, rowLen, colLen);
        dfs(grid, i, j + 1, rowLen, colLen);
        dfs(grid, i, j - 1, rowLen, colLen);
    }

}
