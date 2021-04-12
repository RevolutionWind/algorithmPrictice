package dfs;

import java.util.*;

/**
 * 433. 最小基因变化
 * <p>
 * 一条基因序列由一个带有8个字符的字符串表示，其中每个字符都属于 "A", "C", "G", "T"中的任意一个。
 * 假设我们要调查一个基因序列的变化。一次基因变化意味着这个基因序列中的一个字符发生了变化。
 * 例如，基因序列由"AACCGGTT" 变化至 "AACCGGTA" 即发生了一次基因变化。
 * 与此同时，每一次基因变化的结果，都需要是一个合法的基因串，即该结果属于一个基因库。
 * 现在给定3个参数 — start, end, bank，分别代表起始基因序列，目标基因序列及基因库，请找出能够使起始基因序列变化为目标基因序列所需的最少变化次数。如果无法实现目标变化，请返回 -1。
 * <p>
 * 注意:
 * <p>
 * 起始基因序列默认是合法的，但是它并不一定会出现在基因库中。
 * 所有的目标基因序列必须是合法的。
 * 假定起始基因序列与目标基因序列是不一样的。
 * <p>
 * 示例 1:
 * <p>
 * start: "AACCGGTT"
 * end:   "AACCGGTA"
 * bank: ["AACCGGTA"]
 * <p>
 * 返回值: 1
 * <p>
 * 示例 2:
 * <p>
 * start: "AACCGGTT"
 * end:   "AAACGGTA"
 * bank: ["AACCGGTA", "AACCGCTA", "AAACGGTA"]
 * <p>
 * 返回值: 2
 * <p>
 * 示例 3:
 * <p>
 * start: "AAAAACCC"
 * end:   "AACCCCCC"
 * bank: ["AAAACCCC", "AAACCCCC", "AACCCCCC"]
 * <p>
 * 返回值: 3
 *
 * @author sunxy
 * @date 2020/12/6 10:58
 */
@SuppressWarnings("unused")
public class MinMutation {

    public int minMutation(String start, String end, String[] bank) {
        int len = bank.length;
        Set<String> bankSet = new HashSet<>(len);
        bankSet.addAll(Arrays.asList(bank));
        if (!bankSet.contains(end)) return -1;
        // BFS
        Queue<String> queue = new LinkedList<>();
        queue.add(start);
        Set<String> visited = new HashSet<>(len);
        visited.add(end);

        int step = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String cur = queue.poll();
                if (isValid(cur, end, bankSet, visited, queue)) {
                    return step + 1;
                }
            }
            step += 1;
        }
        return -1;
    }

    private boolean isValid(String cur, String end, Set<String> bankSet, Set<String> visited, Queue<String> queue) {
        if (cur == null || "".equals(cur)) return false;
        char[] arr = cur.toCharArray();
        char[] rule = new char[]{'A', 'C', 'G', 'T'};
        for (int i = 0; i < cur.length(); i++) {
            char memory = arr[i];
            for (char c : rule) {
                arr[i] = c;
                String next = String.valueOf(arr);
                if (!bankSet.contains(next)) continue;
                if (next.equals(end)) return true;
                if (!visited.contains(next)) {
                    queue.add(next);
                    visited.add(next);
                }
            }
            arr[i] = memory;
        }
        return false;
    }

    public static void main(String[] args) {
        MinMutation m = new MinMutation();
        int i = m.minMutation("AAAAACCC", "AACCCCCC", new String[]{"AAAACCCC", "AAACCCCC", "AACCCCCC"});
        System.out.println(i);
    }

}
