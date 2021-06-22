import java.util.Arrays;

/**
 * 剑指 Offer 61. 扑克牌中的顺子
 * <p>
 * 从扑克牌中随机抽5张牌，判断是不是一个顺子，即这5张牌是不是连续的。
 * 2～10为数字本身，A为1，J为11，Q为12，K为13，而大、小王为 0 ，可以看成任意数字。
 * A 不能视为 14。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,2,3,4,5]
 * 输出: True
 * <p>
 * 示例 2:
 * <p>
 * 输入: [0,0,1,2,5]
 * 输出: True
 *
 * @author sunxy
 * @date 2021/6/6 19:18
 */
@SuppressWarnings("unused")
public class IsStraight {

    public boolean isStraight(int[] nums) {
        Arrays.sort(nums);
        int king = 0, differ = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == 0) {
                king++;
                continue;
            }
            if (nums[i] == nums[i + 1]) return false;
            if (nums[i + 1] - nums[i] > 1) {
                differ += nums[i + 1] - nums[i] - 1;
            }
        }
        return king >= differ;
    }

    public static void main(String[] args) {
        System.out.println(getValue(12));
    }

    private static int getValue(int num) {
        if (num <= 9) return num;
        int res = 0;
        while (num > 9) {
            res += (num - ((num / 10) * 10));
            res += (num / 10);
            num /= 10;
        }
        return res;
    }


}
