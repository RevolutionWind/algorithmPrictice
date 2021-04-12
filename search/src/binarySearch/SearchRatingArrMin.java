package binarySearch;

/**
 * 剑指 Offer 11. 旋转数组的最小数字
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 * 输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素。
 * 例如，数组 [3,4,5,1,2] 为 [1,2,3,4,5] 的一个旋转，该数组的最小值为1。  
 *
 * @author walker
 * @date 2020/8/23
 */
@SuppressWarnings("unused")
public class SearchRatingArrMin {

    /*
    遍历循环数组，找到第一个比前一个数小的元素
        时间复杂度O(n),因为最坏情况要把整个数组遍历一遍
        空间复杂度O(1)
     */
    public int minArray1(int[] numbers) {
        for (int i = 0; i < numbers.length - 1; i++) {
            if (numbers[i + 1] < numbers[i]) {
                return numbers[i + 1];
            }
        }
        return numbers[0];
    }

    /*
    二分法查找：
        如果mid的值大于right说明最小值在右侧，移动左指针置mid + 1
        如果mid的值小于right说明最小值在左侧，并且可能为mid，所以右指针置mid
     */
    public int minArray2(int[] numbers) {
        int len = numbers.length;
        int left = 0, right = numbers.length - 1;
        while (left < right) {
            int mid = left + ((right - left) >> 1);
            if (numbers[mid] > numbers[right]) {
                left = mid + 1;
            } else if (numbers[mid] < numbers[right]) {
                right = mid;
            } else {
                // 如果中间等于右边，则找出左右区间内最小的数
                int minIdx = left;
                for (int i = left + 1; i < right; i++) {
                    if (numbers[i] < numbers[minIdx]) minIdx = i;
                }
                return numbers[minIdx];
            }
        }
        return numbers[left];
    }

}
