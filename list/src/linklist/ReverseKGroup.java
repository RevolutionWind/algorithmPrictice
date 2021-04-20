package linklist;

/**
 * 25. K 个一组翻转链表
 * <p>
 * 给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。
 * k 是一个正整数，它的值小于或等于链表的长度。
 * 如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
 * <p>
 * 进阶：
 * 你可以设计一个只使用常数额外空间的算法来解决此问题吗？
 * 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。
 *
 * @author sunxy
 * @date 2021/4/19 21:55
 */
@SuppressWarnings("unused")
public class ReverseKGroup {

    /*
        翻转[start, end)区间的链表，左闭右开
     */
    private ListNode reverse(ListNode start, ListNode end) {
        ListNode slow = null, fast = start;
        while (fast != end) {
            ListNode temp = fast.next;
            fast.next = slow;
            slow = fast;
            fast = temp;
        }
        return slow;
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode end = head;
        for (int i = 0; i < k; i++) {
            // 如果不足k个，不需要翻转
            if (end == null) return head;
            end = end.next;
        }
        // 翻转前k个元素
        ListNode newHead = reverse(head, end);
        // 递归翻转后序链表拼接起来
        head.next = reverseKGroup(end, k);
        return newHead;
    }

}
