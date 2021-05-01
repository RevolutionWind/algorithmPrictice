package array.topk;

import java.util.*;

/**
 * 347. 前 K 个高频元素
 * <p>
 * 给你一个整数数组 nums 和一个整数 k ，请你返回其中出现频率前 k 高的元素。你可以按 任意顺序 返回答案。
 * <p>
 * 示例 1:
 * 输入: nums = [1,1,1,2,2,3], k = 2
 * 输出: [1,2]
 * <p>
 * 示例 2:
 * 输入: nums = [1], k = 1
 * 输出: [1]
 *
 * @author sunxy
 * @date 2021/5/1 13:57
 */
@SuppressWarnings("unused")
public class TopKFrequent {

    /*
        小顶堆
     */
    public int[] topKFrequent1(int[] nums, int k) {
        // key num value 数量
        Map<Integer, Integer> map = new HashMap<>(nums.length);
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        // 小顶堆
        Queue<Integer> queue = new PriorityQueue<>(Comparator.comparingInt(map::get));
        for (Integer key : map.keySet()) {
            if (queue.size() < k) {
                queue.add(key);
            } else if (map.get(queue.peek()) < map.get(key)) {
                queue.poll();
                queue.add(key);
            }
        }
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = queue.poll();
        }
        return res;
    }

    public static void main(String[] args) {
        TopKFrequent obj = new TopKFrequent();
        System.out.println(Arrays.toString(obj.topKFrequent1(new int[]{4, 1, -1, 2, -1, 2, 3}, 2)));
    }

}
