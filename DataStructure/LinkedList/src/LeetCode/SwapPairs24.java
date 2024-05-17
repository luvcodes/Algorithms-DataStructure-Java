package LeetCode;

/**
 * @author yangrunze
 * LeetCode24: https://leetcode.cn/problems/swap-nodes-in-pairs/description/
 */
public class SwapPairs24 {
    public static void main(String[] args) {

    }

    // 方法一：递归法
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode next = head.next;
        ListNode newNode = swapPairs(next.next);
        next.next = head;
        head.next = newNode;

        return next;
    }
}

// 定义链表节点类
class ListNode {
    int value;
    ListNode next;

    // 构造函数
    ListNode(int value) {
        this.value = value;
        this.next = null;
    }
}


/*// 定义链表节点类
class ListNode {
    int value;
    ListNode next;

    // 构造函数
    ListNode(int value) {
        this.value = value;
        this.next = null;
    }
}

public class SwapPairs {

    // 两两交换链表中的节点
    public ListNode swapPairs(ListNode head) {
        // 创建一个哑节点
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode current = dummy;

        while (current.next != null && current.next.next != null) {
            // 定义要交换的两个节点
            ListNode first = current.next;
            ListNode second = current.next.next;

            // 交换节点
            first.next = second.next;
            second.next = first;
            current.next = second;

            // 移动到下一个节点对
            current = first;
        }
        return dummy.next;
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

    public static void main(String[] args) {
        SwapPairs solution = new SwapPairs();

        // 创建链表 1 -> 2 -> 3 -> 4
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);

        System.out.println("原链表:");
        solution.printList(head);

        // 两两交换链表中的节点
        ListNode swappedHead = solution.swapPairs(head);
        System.out.println("两两交换后的链表:");
        solution.printList(swappedHead);
    }
}*/
