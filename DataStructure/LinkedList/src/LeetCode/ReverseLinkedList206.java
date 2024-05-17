package LeetCode;

/**
 * @author yangrunze
 */
public class ReverseLinkedList206 {
    public static void main(String[] args) {
        ReverseLinkedList206 solution = new ReverseLinkedList206();

        // 创建链表 1 -> 2 -> 3 -> 4 -> 5
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        System.out.println("原链表:");
        solution.printList(head);

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

        // 递归法反转链表
        ListNode reversedHeadRecursive = solution.reverseListRecursive(head);
        System.out.println("递归法反转后的链表:");
        solution.printList(reversedHeadRecursive);
    }

    // 迭代法反转链表
    public ListNode reverseListIterative(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            // 保存下一个节点
            ListNode next = curr.next;
            // 反转当前节点的指针
            curr.next = prev;
            // 前移 prev
            prev = curr;
            // 前移 curr
            curr = next;
        }
        return prev;
    }

    // 递归法反转链表
    public ListNode reverseListRecursive(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = reverseListRecursive(head.next);
        // 反转当前节点与其后继节点的指针
        head.next.next = head;
        // 断开当前节点的 next 指针
        head.next = null;
        return newHead;
    }

    // 辅助方法：打印链表
    public void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.value + " ");
            current = current.next;
        }
        System.out.println();
    }


}


// 定义链表节点类
/*class ListNode {
    int value;
    ListNode next;

    // 构造函数
    ListNode(int value) {
        this.value = value;
        this.next = null;
    }
}*/
