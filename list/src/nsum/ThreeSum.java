package nsum;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 15.三数之和
 * <p>
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

    /**
     * threeSum通用模板
     *
     * @return res
     */
    public List<List<Integer>> threeSumCommon(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length;
        List<List<Integer>> res = new ArrayList<>(len);
        for (int i = 0; i < len - 1; i++) {
            List<List<Integer>> temp = twoSum(nums, i + 1, len - 1, -nums[i]);
            for (List<Integer> t : temp) {
                t.add(nums[i]);
                res.add(t);
            }
            // 跳过重复的元素
            while (i < len - 1 && nums[i] == nums[i + 1]) i++;
        }
        return res;
    }

    public List<List<Integer>> twoSum(int[] nums, int left, int right, int target) {
        if (right - left < 1) return new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>(right - left + 1);
        while (left < right) {
            int sum = nums[left] + nums[right];
            int lVal = nums[left], rVal = nums[right];
            if (sum == target) {
                res.add(new ArrayList<>(Arrays.asList(lVal, rVal)));
                while (left < right && nums[left] == lVal) left++;
                while (left < right && nums[right] == rVal) right--;
            } else if (sum < target) {
                while (left < right && nums[left] == lVal) left++;
            } else {
                while (left < right && nums[right] == rVal) right--;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        ThreeSum t = new ThreeSum();
        int[] arr = {-2, 0, 1, 1, 2};
        List<List<Integer>> list = t.threeSumCommon(arr);
        list.forEach(l -> System.out.println(l.stream().map(Objects::toString).collect(Collectors.joining(","))));
    }
}
