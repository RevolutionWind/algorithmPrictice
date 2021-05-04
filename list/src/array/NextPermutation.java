package array;

import java.util.Arrays;

/**
 * 31. 下一个排列
 * <p>
 * 本题要求我们实现一个算法，将给定数字序列重新排列成字典序中下一个更大的排列。
 * 以数字序列 [1,2,3][1,2,3][1,2,3] 为例，其排列按照字典序依次为：
 * [1,2,3]
 * [1,3,2]
 * [2,1,3]
 * [2,3,1]
 * [3,1,2]
 * [3,2,1]
 * [1,2,3]
 * <p>
 * 这样，排列 [2,3,1] 的下一个排列即为 [3,1,2]。特别的，最大的排列 [3,2,1] 的下一个排列为最小的排列 [1,2,3]。
 *
 * @author sunxy
 * @date 2021/5/4 11:57
 */
@SuppressWarnings("unused")
public class NextPermutation {


    public void nextPermutation(int[] nums) {
        int len = nums.length;
        if (len < 1) {
            return;
        }
        // 找到 左侧 尽可能小的那个数
        int i = len - 2;
        while (i >= 0 && nums[i + 1] <= nums[i]) {
            i--;
        }
        // 找到 右侧 尽可能大的那个数
        if (i >= 0) {
            int j = len - 1;
            while (j >= 0 && nums[j] <= nums[i]) {
                j--;
            }
            // 交换两个数
            swap(nums, i, j);
        }

        reverse(nums, i + 1, len - 1);
    }

    private void reverse(int[] nums, int i, int j) {
        while (i < j) {
            swap(nums, i++, j--);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        NextPermutation obj = new NextPermutation();
        int[] arr = {1, 2, 3};
        obj.nextPermutation(arr);
        System.out.println(Arrays.toString(arr));
    }

}
