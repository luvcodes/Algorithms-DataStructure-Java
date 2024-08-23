package LeetCode;

/**
 * @author yangrunze
 * LeetCode24
 */
public class _4SwapPairs24 {
    public static void main(String[] args) {

        /*SwapPairs solution = new SwapPairs();

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
        solution.printList(swappedHead);*/

    }

    // 方法一：递归法
    /*public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode next = head.next;
        ListNode newNode = swapPairs(next.next);
        next.next = head;
        head.next = newNode;

        return next;
    }*/

    // 两两交换链表中的节点使用非递归法
    public ListNode swapPairs(ListNode head) {
        // 1. 设置虚拟头节点
        ListNode dummyNode = new ListNode(-1);
        // 2. 连接头节点与第一个节点
        dummyNode.next = head;
        // 3. 设置当前指针
        ListNode currentNode = dummyNode;
        ListNode temp; // 临时节点，保存两个节点后面的那个节点
        ListNode firstnode; // 临时节点，保存两个节点之中的第一个节点
        ListNode secondnode; // 临时节点，保存两个节点之中的第二个节点

        // 4. 判断条件
        while (currentNode.next != null && currentNode.next.next != null) {
            temp = currentNode.next.next.next;
            firstnode = currentNode.next;
            secondnode = currentNode.next.next;
            currentNode.next = secondnode;
            secondnode.next = firstnode;
            firstnode.next = temp;
            // 这个步骤是为了相当于把firstNode就当做了新的虚拟头节点
            currentNode = firstnode;
        }

        // 返回虚拟头节点的下一个节点，这就是更新过后的链表的头节点
        return dummyNode.next;
    }

    // 辅助方法：打印链表
    /*
    public void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.value + " ");
            current = current.next;
        }
        System.out.println();
    }*/
}

class ListNode {
    int value;
    ListNode next;
    ListNode() {}
    ListNode(int value) {
        this.value = value;
        this.next = null;
    }
    ListNode(int value, ListNode next) {
        this.value = value;
        this.next = next;
    }
}
