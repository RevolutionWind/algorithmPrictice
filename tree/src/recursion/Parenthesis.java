package recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * 括号生成
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的括号组合。
 * 例：n = 3
 * 输出 [
 * "((()))",
 * "(()())",
 * "(())()",
 * "()(())",
 * "()()()"
 * ]
 *
 * @author walker
 * @date 2020-08-12
 */
@SuppressWarnings("unused")
public class Parenthesis {


    private List<String> res = new ArrayList<>();

    /*
       方法一、递归
        1. 递归可以理解成树的不同分支，对树进行适当的剪枝，可以提高递归效率
        2. 剪枝尽量在递归终结条件中进行（即第一步）
    */
    public List<String> recursion(int n) {
        generateStr(n, 0, 0, "");
        return res;
    }

    private void generateStr(int n, int left, int right, String str) {
        // 终结条件
        if (left > n || right > n || right > left) return;
        // 处理当前层逻辑
        if (left == n && right == n) {
            res.add(str);
            return;
        }
        // 下探到下一层
        generateStr(n, left + 1, right, str + "(");
        generateStr(n, left, right + 1, str + ")");
    }

    public static void main(String[] args) {
        Parenthesis p = new Parenthesis();
        List<String> recursion = p.recursion(3);
        recursion.forEach(System.out::println);
    }

}