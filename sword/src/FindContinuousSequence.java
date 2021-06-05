import java.util.LinkedList;
import java.util.List;

/**
 * 剑指 Offer 57 - II. 和为s的连续正数序列
 *
 * 输入一个正整数 target ，输出所有和为 target 的连续正整数序列（至少含有两个数）。
 *
 * 序列内的数字由小到大排列，不同序列按照首个数字从小到大排列。
 *
 *
 * 示例 1：
 *
 * 输入：target = 9
 * 输出：[[2,3,4],[4,5]]
 *
 * 示例 2：
 *
 * 输入：target = 15
 * 输出：[[1,2,3,4,5],[4,5,6],[7,8]]
 *
 * @author sunxy
 * @date 2021/6/5 15:49
 */
@SuppressWarnings("unused")
public class FindContinuousSequence {
    public int[][] findContinuousSequence(int target) {
        List<int[]> res = new LinkedList<>();
        int left = 1, right = 1, sum = 0, end = target / 2;
        while (right <= end) {
            sum += right;
            right++;
            while (sum > target) {
                sum -= left;
                left--;
            }
            if (sum == target) {
                int[] temp = new int[right - left];
                for (int i = 0; i < temp.length; i++) {
                    temp[i] = left + i;
                }
                res.add(temp);
            }
        }
        return res.toArray(new int[0][0]);
    }

    public static void main(String[] args) {
        FindContinuousSequence obj = new FindContinuousSequence();
        obj.findContinuousSequence(9);
        System.out.println();
    }

}
