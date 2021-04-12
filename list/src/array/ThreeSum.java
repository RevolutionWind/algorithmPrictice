package array;

import java.util.*;
import java.util.stream.Collectors;

/**
 * leetcode15.三数之和
 * 计算三数之和是否为0，并返回所有符合条件的结果集，
 * 并且不能有重复的三个数
 * <p>
 * 1. 为了不使返回结果出现重复的三个数：
 * （1）循环前对数组进行排序为递增数组，这样产生重复三个数的时候，就可以保证增序，放进set中就可以直接去重
 * （2）或者存入set之前，对集合进行排序
 *
 * @author walker
 * @date 2020/8/10
 */
@SuppressWarnings("unused")
public class ThreeSum {
    /*
    暴力破解
     */
    public List<List<Integer>> threeSum1(int[] nums) {
        Arrays.sort(nums);
        Set<List<Integer>> listList = new HashSet<>();
        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        listList.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    }
                }
            }
        }
        return new ArrayList<>(listList);
    }

    /*
    hash表存储: 将三数之和问题简化成两数之和
    即在一个for循环里查找目标数
     */
    public List<List<Integer>> threeSum2(int[] nums) {
        Set<List<Integer>> lists = new HashSet<>();
        for (int i = 0; i < nums.length - 1; i++) {
            int target = -nums[i];
            HashMap<Integer, Integer> map = new HashMap<>();
            for (int j = i + 1; j < nums.length; j++) {
                int temp = target - nums[j];
                if (map.containsKey(temp)) {
                    List<Integer> list = Arrays.asList(temp, nums[i], nums[j]);
                    list.sort(Comparator.naturalOrder());
                    lists.add(list);
                    map.remove(temp);
                } else {
                    map.put(nums[j], nums[j]);
                }
            }
        }
        return new ArrayList<>(lists);
    }

    /*
    夹逼法:
        1. 先对数组进行排序，由于元素只有小于0时，才会有相加等于0的情况。当元素大于0时，则跳出循环
        2. 设定两个指针，在指定元素的后面进行夹逼查找，直至找到目标元素
         （1）元素如果已经查找过，直接continue
         （2）夹逼时，如果元素已经计算过，则直接跳过该元素
     */
    public List<List<Integer>> threeSum3(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length;
        List<List<Integer>> result = new ArrayList<>(len << 1);
        for (int i = 0; i < len - 2; i++) {
            if (nums[i] > 0)
                return result;
            if (i > 0 && nums[i] == nums[i - 1])
                continue;
            int head = i + 1, tail = len - 1;
            while (head < tail) {
                if (nums[head] + nums[tail] == -nums[i]) {
                    result.add(Arrays.asList(nums[i], nums[head], nums[tail]));
                    while (head < tail && nums[head] == nums[head + 1])
                        head++;
                    while (head < tail && nums[tail] == nums[tail - 1])
                        tail--;
                }
                if (nums[head] + nums[tail] >= -nums[i])
                    tail--;
                else head++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        ThreeSum t = new ThreeSum();
        int[] arr = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> list = t.threeSum3(arr);
        list.forEach(l -> System.out.println(l.stream().map(Objects::toString).collect(Collectors.joining(","))));
    }
}
