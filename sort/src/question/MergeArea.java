package question;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 56. 合并区间
 *
 * 以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。
 * 请你合并所有重叠的区间，并返回一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间。
 *
 * 示例 1：
 *
 * 输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
 * 输出：[[1,6],[8,10],[15,18]]
 * 解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 *
 * 示例 2：
 *
 * 输入：intervals = [[1,4],[4,5]]
 * 输出：[[1,5]]
 * 解释：区间 [1,4] 和 [4,5] 可被视为重叠区间。
 *
 * @author sunxy
 * @date 2021/6/19 18:04
 */
@SuppressWarnings("unused")
public class MergeArea {

    public int[][] merge(int[][] intervals) {
        // 根据区间首元素排序
        Arrays.sort(intervals, (a1, a2) -> a1[0] - a2[0]);
        int len = intervals.length;
        List<int[]> res = new ArrayList<>(len);
        for (int i = 0; i < len - 1; i++) {
            int left = intervals[i][0], right = intervals[i][1];
            if (res.isEmpty() || res.get(res.size() - 1)[1] < left) {
                res.add(intervals[i]);
            } else {
                res.get(i - 1)[1] = Math.max(right, res.get(res.size() - 1)[1]);
            }
        }
        return res.toArray(new int[0][0]);
    }

    public static void main(String[] args) {
        MergeArea obj = new MergeArea();
        String s = Arrays.toString(obj.merge(new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}}));
        System.out.println(s);
    }

}
