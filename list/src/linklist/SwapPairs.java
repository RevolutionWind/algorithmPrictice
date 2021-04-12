package linklist;

/**
 * 两两交换链表
 *
 * @author walker
 * @date 2020-07-29
 */
@SuppressWarnings("unused")
public class SwapPairs {
    static ListNode n1 = new ListNode(1);
    static ListNode n2 = new ListNode(2);
    static ListNode n3 = new ListNode(3);
    static ListNode n4 = new ListNode(4);

    static {
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
    }

    public static ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(-1);
        ListNode pre = dummy;
        while (head != null && head.next != null) {
            // 确定交换的节点
            ListNode first = head;
            ListNode second = head.next;
            // 交换节点
            pre.next = second;
            first.next = second.next;
            second.next = first;
            // 为下一次循环做准备
            pre = first;
            head = first.next;
        }
        return dummy.next;
    }


    public static void main(String[] args) {
        ListNode listNode = swapPairs(n1);
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }
}