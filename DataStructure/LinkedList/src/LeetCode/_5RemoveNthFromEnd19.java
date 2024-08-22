package LeetCode;

/**
 * @author yangrunze
 */
public class _5RemoveNthFromEnd19 {
    public static void main(String[] args) {

    }
}

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // 核心代码逻辑是快慢指针。快指针直接移动n + 1个位置，
        // 然后慢指针和快指针同样速度向后移动，直到快指针指向的是链表最后一个节点的后面

        // 设置虚拟头节点
        ListNode dummyNode = new ListNode(0);

        // 设置快慢指针
        ListNode fastIndex = dummyNode;
        ListNode slowIndex = dummyNode;

        // 核心逻辑从这里开始：
        // 快指针先向后移动n个位置
        for (int i = 0; i <= n; i++) {
            fastIndex = fastIndex.next;
        }

        // 快慢指针开始同步移动
        while (fastIndex != null) {
            slowIndex = slowIndex.next;
            fastIndex = fastIndex.next;
        }

        // 此时 slowIndex 的位置就是待删除元素的前一个位置。
        // 具体情况可自己画一个链表长度为 3 的图来模拟代码来理解
        // 检查 slowIndex.next 是否为 null，以避免空指针异常
        if (slowIndex.next != null) {
            slowIndex.next = slowIndex.next.next;
        }

        return dummyNode.next;
    }
}
