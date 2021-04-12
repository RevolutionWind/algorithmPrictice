package deque;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Deque的API操作实例
 *
 * @author walker
 * @date 2020-07-29
 */
public class DequeTest {

    public static void main(String[] args) {
        Deque<String> deque = new LinkedList<>();
        deque.addLast("a");
        deque.addLast("b");
        deque.addLast("c");
        System.out.println(deque);
        String str = deque.peekFirst();
        System.out.println(str);
        System.out.println(deque);
        while (deque.size() > 0) {
            String s = deque.pollFirst();
            System.out.print(s);
            System.out.println();
        }
        System.out.println(deque);
    }

}
