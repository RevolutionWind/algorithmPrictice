package dfs;

import java.util.*;

/**
 * 127. 单词接龙
 * <p>
 * 给定两个单词（beginWord 和 endWord）和一个字典，找到从 beginWord 到 endWord 的最短转换序列的长度。转换需遵循如下规则：
 * <p>
 * 每次转换只能改变一个字母。
 * 转换过程中的中间单词必须是字典中的单词。
 * 说明:
 * <p>
 * 如果不存在这样的转换序列，返回 0。
 * 所有单词具有相同的长度。
 * 所有单词只由小写字母组成。
 * 字典中不存在重复的单词。
 * 你可以假设 beginWord 和 endWord 是非空的，且二者不相同。
 * <p>
 * 输入:
 * beginWord = "hit",
 * endWord = "cog",
 * wordList = ["hot","dot","dog","lot","log","cog"]
 * <p>
 * 输出: 5
 * <p>
 * 解释: 一个最短转换序列是 "hit" -> "hot" -> "dot" -> "dog" -> "cog",
 * 返回它的长度 5。
 *
 * @author walker
 * @date 2020/9/14
 */
@SuppressWarnings("unused")
public class LadderLength {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        // 初始化单词
        Set<String> wordSet = new HashSet<>(wordList);
        if (wordSet.isEmpty() || !wordSet.contains(endWord)) return 0;

        // 初始化队列进行广度优先遍历
        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        // 已经访问过的单词
        Set<String> visited = new HashSet<>(wordSet.size());
        visited.add(beginWord);

        // 开始广度优先遍历
        int step = 1;
        while (!queue.isEmpty()) {
            int curSize = queue.size();
            for (int i = 0; i < curSize; i++) {
                String curWord = queue.poll();
                if (change(curWord, endWord, wordSet, queue, visited)) return step + 1;
            }
            step += 1;
        }
        return 0;
    }

    private boolean change(String curWord, String endWord, Set<String> wordSet, Queue<String> queue, Set<String> visited) {
        if (curWord == null || "".equals(curWord)) {
            return false;
        }
        char[] charArray = curWord.toCharArray();
        for (int i = 0; i < curWord.length(); i++) {
            // 先保存后恢复
            char memory = charArray[i];
            for (char c = 'a'; c <= 'z'; c++) {
                if (c == memory) continue;
                charArray[i] = c;
                String changedStr = String.valueOf(charArray);
                if (wordSet.contains(changedStr)) {
                    if (changedStr.equals(endWord)) return true;
                    if (!visited.contains(changedStr)) {
                        queue.add(changedStr);
                        // 添加队列后必须要在visited中
                        visited.add(changedStr);
                    }
                }
            }
            // 恢复
            charArray[i] = memory;
        }
        return false;
    }

    /*
     * 双向BFS
     */
    public int ladderLength2(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        if (!wordSet.contains(endWord)) {
            return 0;
        }
        Set<String> beginSet = new HashSet<>(beginWord.length() * 26),
                endSet = new HashSet<>(endWord.length() * 26);
        int step = 1;
        HashSet<String> seen = new HashSet<>(wordList.size());

        beginSet.add(beginWord);
        endSet.add(endWord);
        // BFS start
        while (!beginSet.isEmpty() && !endSet.isEmpty()) {
            // 优先选择小的set扩散
            if (beginSet.size() > endSet.size()) {
                // 交换开始和结束的hash
                Set<String> temp = beginSet;
                beginSet = endSet;
                endSet = temp;
            }
            // 和queue一样，把当前set里的元素遍历完
            Set<String> newBegin = new HashSet<>();
            for (String word : beginSet) {
                char[] chs = word.toCharArray();

                for (int i = 0; i < word.length(); i++) {
                    for (char c = 'a'; c <= 'z'; c++) {
                        char memo = chs[i];
                        chs[i] = c;
                        String now = String.valueOf(chs);
                        if (endSet.contains(now)) {
                            return step + 1;
                        }
                        if (wordSet.contains(now) && !seen.contains(now)) {
                            newBegin.add(now);
                            seen.add(now);
                        }
                        chs[i] = memo;
                    }
                }
            }

            beginSet = newBegin;
            step++;
        }
        return 0;
    }

}
