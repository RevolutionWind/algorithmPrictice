package array;

import java.util.*;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * 数组手动分页
 * <p>
 * 实现这个方法，传入一个int数组，要分割成size份。多余的剩下就行
 * 如：传入arr:[1,2,3,4,5,]size2那么返回的list应该是：{[1,2],[3,4],5}
 *
 * @author sunxy
 * @date 2021/2/24 13:54
 */
@SuppressWarnings("unused")
public class SubArr {

    /**
     * 阻塞队列
     *
     * @param array array
     * @param size  size
     * @return list
     */
    private static List<Integer[]> subArrayQueue(int[] array, int size) {
        if (array == null || array.length == 0 || size <= 0) {
            // int[] -> Integer[]
            return array == null ? Collections.emptyList() :
                    new ArrayList<>(Collections.singleton(Arrays.stream(array).boxed().toArray(Integer[]::new)));
        }
        List<Integer[]> result = new ArrayList<>();
        Queue<Integer> queue = new LinkedBlockingQueue<>(size);
        for (int value : array) {
            // 队列满了
            if (!queue.offer(value)) {
                List<Integer> list = new ArrayList<>();
                Integer val;
                // 出队
                while ((val = queue.poll()) != null) {
                    list.add(val);
                }
                // 放进去
                queue.offer(value);
                result.add(list.toArray(new Integer[0]));
            }
        }
        result.add(queue.toArray(new Integer[0]));
        return result;
    }

    public static List<Integer[]> subArray(int[] array, int size) {
        int length = array.length;
        if (length < 1) return new ArrayList<>(1);
        // 分组剩余数量
        int leftSize = length % size;
        // 组数
        int groupNum = (length - leftSize) / size;
        groupNum = leftSize > 0 ? groupNum + 1 : groupNum;
        List<Integer[]> res = new ArrayList<>(groupNum);
        int idx = 0;
        for (int i = 0; i < groupNum; i++) {
            int len = size;
            if (i == groupNum - 1 && leftSize > 0) {
                len = leftSize;
            }
            Integer[] group = new Integer[len];
            for (int j = 0; j < size; j++) {
                if (idx < length) {
                    group[j] = array[idx++];
                }
            }
            res.add(group);
        }
        return res;
    }

    public static void main(String[] args) {
        // 每组几个
        int size = 11;

        HashSet<Integer> randomSet = new HashSet<>();

        // 生成不重复随机数组，最大值，多少个
        randomSet(900, 230, randomSet);
        // set 转 数组
        int[] array = randomSet.stream().mapToInt(value -> value).toArray();
        System.out.println("生成 length 为【" + array.length + "】的随机数组：" + Arrays.toString(array));
        // 分隔
        List<Integer[]> result = subArrayQueue(array, size);
        System.out.println("每份【" + size + "】个，分隔后数组长度：" + result.size());
        for (Integer[] arr : result) {
            System.out.println(Arrays.toString(arr));
        }
    }


    /**
     * 随机指定范围内N个不重复的数
     * 利用HashSet的特征，只能存放不同的值
     *
     * @param max 指定范围最大值
     * @param n   随机数个数
     * @param set 随机数结果集
     */
    private static void randomSet(int max, int n, HashSet<Integer> set) {
        while (set.size() < n) {
            // 调用Math.random()方法
            int num = (int) (Math.random() * max);
            set.add(num);// 将不同的数存入HashSet中
        }
    }

}
