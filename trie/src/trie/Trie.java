package trie;

/**
 * leetcode208. 实现 Trie (前缀树)
 * 实现一个 Trie (前缀树)，包含 insert, search, 和 startsWith 这三个操作。
 *
 * @author walker
 * @date 2020/9/8
 */
public class Trie {

    private final TrieNode root;

    /**
     * 构造方法
     */
    public Trie() {
        root = new TrieNode(' ');
    }

    /**
     * @param str 要插入的字符串
     */
    public void insert(String str) {
        TrieNode node = root;
        char[] chars = str.toCharArray();
        for (char c : chars) {
            if (node.children[c - 'a'] == null) {
                node.children[c - 'a'] = new TrieNode(c);
            }
            node = node.children[c - 'a'];
        }
        node.isWord = true;
    }

    /**
     * 查找字典树中是否有这个值
     *
     * @param word 要查找的值
     * @return 是否存在
     */
    public boolean search(String word) {
        TrieNode node = root;
        char[] chars = word.toCharArray();
        for (char c : chars) {
            if (node.children[c - 'a'] == null) {
                return false;
            }
            node = node.children[c - 'a'];
        }
        return node.isWord;
    }

    /**
     * 是否存在以目标字符串为前缀的字符串
     *
     * @param prefix 前缀
     * @return 是否存在
     */
    public boolean startWith(String prefix) {
        TrieNode node = root;
        char[] chars = prefix.toCharArray();
        for (char c : chars) {
            if (node.children[c - 'a'] == null) {
                return false;
            }
            node = node.children[c - 'a'];
        }
        return true;
    }
}

class TrieNode {
    char val;
    boolean isWord;
    TrieNode[] children = new TrieNode[26];

    TrieNode() {
    }

    TrieNode(char c) {
        TrieNode node = new TrieNode();
        node.val = c;
    }
}