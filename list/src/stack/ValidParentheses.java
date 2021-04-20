package stack;

import java.util.Stack;

/**
 * leetcode20.有效的括号
 *
 * @author walker
 * @date 2020-08-04
 */
@SuppressWarnings("unused")
public class ValidParentheses {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            switch (c) {
                case '(':
                    stack.add(')');
                    break;
                case '{':
                    stack.add('}');
                    break;
                case '[':
                    stack.add(']');
                    break;
                default:
                    if (stack.isEmpty() || c != stack.pop()) return false;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String s = "()[]{}";
        ValidParentheses v = new ValidParentheses();
        System.out.println(v.isValid(s));

    }
}