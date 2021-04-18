package linklist;

/**
 * 206. 反转链表
 *
 * @author walker
 * @date 2020-07-29
 */
public class ReverseLinkList {

    public ListNode init() {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        return n1;
    }

    public ListNode double_point_reverseList(ListNode head) {
        ListNode slow = null, fast = head;
        while (fast != null) {
            ListNode temp = fast.next;
            fast.next = slow;
            slow = fast;
            fast = temp;
        }
        return slow;
    }

    public ListNode recursion_reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = recursion_reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }

    public static void main(String[] args) {
        ReverseLinkList classObject = new ReverseLinkList();
        ListNode head = classObject.init();
//        ListNode listNode = classObject.double_point_reverseList(head);
        ListNode listNode = classObject.recursion_reverseList(head);
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }

}