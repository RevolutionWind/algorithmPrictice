package stack;

import java.util.Stack;

/**
 * leetcode155.最小栈
 *
 * @author walker
 * @date 2020-08-04
 */
@SuppressWarnings("unused")
public class MinStack {
    Stack<Integer> mainStack;
    int min;

    /**
     * 初始化
     */
    public MinStack() {
        mainStack = new Stack<>();
        min = Integer.MAX_VALUE;
    }

    /*
    存入栈
     */
    public void push(int x) {
        if (x <= min) {
            mainStack.push(min);
            min = x;
        }
        mainStack.push(x);
    }

    public void pop() {
        if (mainStack.pop() == min) {
            min = mainStack.pop();
        }
    }

    public int top() {
        return mainStack.peek();
    }

    public int getMin() {
        return min;
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.top());
        System.out.println(minStack.getMin());
    }

}
