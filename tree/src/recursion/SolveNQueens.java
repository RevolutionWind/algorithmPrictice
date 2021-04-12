package recursion;

import java.util.*;

/**
 * 51. N 皇后
 * <p>
 * n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 * <p>
 * 输入：4
 * 输出：[
 * [".Q..",  // 解法 1
 * "...Q",
 * "Q...",
 * "..Q."],
 * <p>
 * ["..Q.",  // 解法 2
 * "Q...",
 * "...Q",
 * ".Q.."]
 * ]
 * 解释: 4 皇后问题存在两个不同的解法。
 * <p>
 * 每一行、列、对角线不能存在一个以上的皇后
 *
 * @author sunxy
 * @date 2020/11/23 12:23
 */
@SuppressWarnings("unused")
public class SolveNQueens {
    private boolean[] colArr;
    private boolean[] pieArr;
    private boolean[] naArr;

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        if (n < 1) return res;
        colArr = new boolean[n];
        pieArr = new boolean[n << 1];
        naArr = new boolean[n << 1];
        dfs(res, new ArrayList<>(), 0, n);
        return res;
    }

    private void dfs(List<List<String>> res, List<String> path, int row, int n) {
        if (row == n) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int col = 0; col < n; col++) {
            if (colArr[col] || pieArr[col - row + n] || naArr[col + row]) continue;
            char[] charArray = new char[n];
            Arrays.fill(charArray, '.');
            charArray[col] = 'Q';
            String rowString = String.valueOf(charArray);

            path.add(rowString);
            colArr[col] = true;
            pieArr[col - row + n] = true;
            naArr[col + row] = true;

            dfs(res, path, row + 1, n);

            path.remove(path.size() - 1);
            colArr[col] = false;
            pieArr[col - row + n] = false;
            naArr[col + row] = false;
        }
    }

}
