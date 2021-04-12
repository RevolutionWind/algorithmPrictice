package compare.exchange;

/**
 * @author sunxy
 * @date 2021/3/8 16:18
 */
public class Exchange {

    public static void exchange(int idx1, int idx2, int[] nums) {
        if (idx1 == idx2) return;
        int temp = nums[idx1];
        nums[idx1] = nums[idx2];
        nums[idx2] = temp;
    }
}
