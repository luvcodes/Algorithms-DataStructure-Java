package LeetCode;

/**
 * @author ryanw
 */
@SuppressWarnings("all")
public class _3ReverseLinkedList206 {
    public static void main(String[] args) {
        // 原链表
        // 1 -> 2 -> 3 -> 4 -> 5
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        System.out.println("原链表:");
        printList(head);

        // 递归法反转链表
        ListNode reversedHeadRecursive = reverseListRecursive(head);
        System.out.println("递归法反转后的链表:");
        printList(reversedHeadRecursive);

        /*_3ReverseLinkedList206 solution = new _3ReverseLinkedList206();

        // 迭代法反转链表
        ListNode reversedHeadIterative = solution.reverseListIterative(head);
        System.out.println("迭代法反转后的链表:");
        solution.printList(reversedHeadIterative);

        // 为了演示递归法，我们需要重新创建链表，因为之前的链表已经被反转
        head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        */

    }

    /**
     * 三种方法实现翻转链表
     * 1. 双指针法
     * 2. 递归法
     * 3. 反向递归法
     * */
    // 1. 双指针法
    public ListNode reverseListDoublePointers(ListNode head) {
        ListNode prev = null;
        ListNode current = head;
        ListNode temp = null;

        // 判断当前节点不为null
        while (current != null) {
            temp = current.next;
            current.next = prev;
            prev = current;
            current = temp;
        }

        // 返回最右边的节点，这个节点是pre指针指向的, 因为current已经指向了null
        return prev;
    }


    // 2. 正向递归反转链表
    public ListNode reverseList(ListNode head) {
        return reverse(null, head);
    }

    private ListNode reverse(ListNode prev, ListNode cur) {
        if (cur == null) {
            return prev;
        }

        ListNode temp = null;

        // 先保存下一个节点
        temp = cur.next;
        cur.next = prev;

        // 反转
        // 更新prev、cur位置
        // prev = cur;
        // cur = temp;

        return reverse(cur, temp);
    }


    // 3. 从后向前递归反转链表
    public static ListNode reverseListRecursive(ListNode head) {
        if (head == null) return null;
        if (head.next == null) return head;

        ListNode newHead = reverseListRecursive(head.next);

        // 反转当前节点与其后继节点的指针
        head.next.next = head;
        // 断开当前节点的 next 指针
        head.next = null;

        return newHead;
    }

    // 辅助方法：打印链表
    public static void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.value + " ");
            current = current.next;
        }
        System.out.println();
    }

}