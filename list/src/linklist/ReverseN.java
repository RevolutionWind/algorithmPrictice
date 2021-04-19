package linklist;

/**
 * 返回一个链表的前n个元素的反转
 * <p>
 * 例： 1 -> 2 -> 3 -> 4 -> 5 -> 6
 * n = 3
 * 返回：3 -> 2 -> 1 -> 4 -> 5 -> 6
 *
 * @author sunxy
 * @date 2021/4/19 20:27
 */
@SuppressWarnings("unused")
public class ReverseN {

    ListNode backHead = null;

    public ListNode reverseN(ListNode head, int k) {
        // 终止
        if (k == 1) {
            // 记录后面的节点
            backHead = head.next;
            return head;
        }
        ListNode newHead = reverseN(head.next, k - 1);
        head.next.next = head;
        head.next = backHead;
        return newHead;
    }

}
