package array;

import java.util.Arrays;

/**
 *
 * leetcode283: 移动零
 *
 * @author walker
 * @date 2020-07-30
 */
@SuppressWarnings("unused")
public class MoveZero {

    /*
    双指针
     */
    public void moveZeroes(int[] nums) {
        for(int i = 0, j = 0; i < nums.length; i++){
            if(nums[i] != 0){
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j++] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{0,1,0,3,12};
        MoveZero moveZero = new MoveZero();
        moveZero.moveZeroes(nums);
        Arrays.stream(nums).forEach(System.out::println);
    }
}