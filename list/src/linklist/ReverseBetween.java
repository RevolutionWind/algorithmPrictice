package linklist;

/**
 * 给你单链表的头指针 head 和两个整数 left 和 right ，其中 left <= right 。
 * 请你反转从位置 left 到位置 right 的链表节点，返回 反转后的链表 。
 *
 * 例： 1 -> 2 -> 3 -> 4 -> 5 -> 6
 * m = 3, n = 5
 * 返回：1 -> 2 -> 5 -> 4 -> 3 -> 6
 *
 * @author sunxy
 * @date 2021/4/19 20:58
 */
@SuppressWarnings("unused")
public class ReverseBetween {

    ListNode backHead = null;

    ListNode reverseN(ListNode head, int n) {
        if (n == 1) {
            backHead = head.next;
            return head;
        }
        ListNode newHead = reverseN(head.next, n - 1);
        head.next.next = head;
        head.next = backHead;
        return newHead;
    }
    ListNode reverseBetween(ListNode head, int left, int right) {
        if (left == 1) {
            return reverseN(head, right);
        }
        head.next = reverseBetween(head.next, left - 1, right - 1);
        return head;
    }

}
