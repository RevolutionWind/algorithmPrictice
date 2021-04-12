package dp;

/**
 * 152. 乘积最大子数组
 * <p>
 * 给你一个整数数组 nums ，请你找出数组中乘积最大的连续子数组（该子数组中至少包含一个数字），
 * 并返回该子数组所对应的乘积。
 * <p>
 * 输入: [2,3,-2,4]
 * 输出: 6
 * 解释: 子数组 [2,3] 有最大乘积 6。
 *
 * @author sunxy
 * @date 2020/10/7
 */
@SuppressWarnings("unused")
public class MaxProduct {

    /*
      一个数组中可能会有负数。最大数*负数会变小，如果再遇到一个负数，会变大。
      所以需要临时变量来存储最大值和最小值。
      这里，我们还需要注意元素为0的情况，如果A[i]为0，那么maxDP和minDP都为0，我们需要从A[i + 1]重新开始。
     */
    public int maxProduct(int[] nums) {
        // 定义max、最大值、最小值
        int max = Integer.MIN_VALUE, iMax = 1, iMin = 1;
        for (int num : nums) {
            // 如果num为负数，交换最大值、最小值
            if (num < 0) {
                int temp = iMax;
                iMax = iMin;
                iMin = temp;
            }
            // iMax * num,iMin * num, 如果num = 0, 重新计数更新iMax = 0
            iMax = Math.max(iMax * num, num);
            iMin = Math.min(iMin * num, num);
            max = Math.max(iMax, max);
        }
        return max;
    }

}
