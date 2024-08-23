package LeetCode;

/**
 * @author yangrunze
 * LeetCode19: 移除倒数第n个节点形成新链表，并返回
 */
public class _5RemoveNthFromEnd19 {
    public static void main(String[] args) {}

    // 快慢指针解法
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // 1. 设置虚拟头节点
        ListNode dummyNode = new ListNode(0);
        dummyNode.next = head;
        ListNode fastPointer = dummyNode;
        ListNode slowPointer = dummyNode;

        // 2. 快指针先开始移动到第n+1个节点，也就是index值为n的位置
        // 只要快慢指针相差 n 个结点即可
        for (int i = 0; i <= n; i++) {
            fastPointer = fastPointer.next;
        }

        // 3. 再将慢指针与快指针同时移动，直到快指针指向null
        while (fastPointer != null) {
            fastPointer = fastPointer.next;
            slowPointer = slowPointer.next;
        }

        // 4. 慢指针进行操作移除慢指针的下一个节点
        // 此时 slowIndex 的位置就是待删除元素的前一个位置。
        // 具体情况可自己画一个链表长度为 3 的图来模拟代码来理解
        // 检查 slowIndex.next 是否为 null，以避免空指针异常
        if (slowPointer.next != null) {
            slowPointer.next = slowPointer.next.next;
        }

        return dummyNode.next;
    }
}
