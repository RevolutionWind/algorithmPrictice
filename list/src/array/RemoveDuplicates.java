package array;

/**
 * 移除数组中重复的元素
 *
 * @author walker
 * @date 2020-07-31
 */
@SuppressWarnings("unused")
public class RemoveDuplicates {

    public int removeDuplicates(int[] nums) {
        int j = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[j]) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[++j] = temp;
            }
        }
        return j + 1;
    }

}